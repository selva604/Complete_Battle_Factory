package com.example.complelte_battle_factory;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private EditText editText;
    private Button button;
    private TextView textView,search,damage;
    private ListView listView;

    //relation POKEMON
    public ArrayList<Detail_POKE> list = new ArrayList<Detail_POKE>();
    public ArrayList<Detail_POKE> target;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // pick XML on layout
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        button = findViewById(R.id.button);
        textView = findViewById(R.id.text_view);
        search = findViewById(R.id.select);
        damage = findViewById(R.id.Damage);

        search.setText("ポケモン検索");
        damage.setText("ダメージ計算");
        damage.setLinksClickable(true);

        //read Data set
        readCSV();

        //Searching Pokemon func
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                target = new ArrayList<Detail_POKE>();
                //get Text
                String text = editText.getText().toString();

                if(!text.equals("")){
                    textView.setText(text);
                    editText.setText("");

                    //Search Pokemon
                    Search_POKE(text);

                    if(target.size()!=0){
                        Toast.makeText(view.getContext(), text, Toast.LENGTH_LONG).show();

                        //go to Searching Pokemon Activity
                        Intent intent = new Intent(getApplication(), SubActivity.class);
                        intent.putExtra("Search", (Serializable) target);
                        startActivity(intent);
                        }
                    //Not found
                    else {
                        Toast.makeText(view.getContext(), "Nothing", Toast.LENGTH_SHORT).show();
                    }
                }
                else{
                    Toast.makeText(view.getContext(), "入力してください", Toast.LENGTH_SHORT).show();
                }
            }
        });

        //Calculating Damage func
        damage.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(getApplication(),Calc_main.class);
                startActivity(intent);
            }
        });
    }

    // Read CSV
    public void readCSV(){
        try{
            //load File
            InputStream inputStream = getResources().getAssets().open("2/res.csv");

            InputStreamReader inputStreamReader = new InputStreamReader(inputStream,"SHIFT-JIS");
            BufferedReader bufferReader = new BufferedReader(inputStreamReader);

            String line = bufferReader.readLine();
            //read line
            while((line = bufferReader.readLine())!= null){
                    //save Pokemon Detail
                    Detail_POKE poke = new Detail_POKE(line);
                    list.add(poke);
            }
            bufferReader.close();
        }catch (IOException e){
            System.out.println("ERROR");
        }

    }
    //Search Pokemon data
    public void Search_POKE(String name){
        for(int i = 0; i < list.size(); i++){
            if(name.equals(list.get(i).name)) {
                target.add(list.get(i));
            }
        }
    }
}