package com.example.complelte_battle_factory;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.Serializable;
import java.util.ArrayList;

//Display Search Pokemon
public class SubActivity extends AppCompatActivity {
    public ArrayList<Detail_POKE> list = new ArrayList<Detail_POKE>();
    private ArrayList<String> array = new ArrayList<String>();
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        int p = 1;
        String s = "";

        super.onCreate(savedInstanceState);
        setContentView(R.layout.subactivity);

        //receive MainActivity data
        list = (ArrayList<Detail_POKE>) getIntent().getSerializableExtra("Search");

        //Count Pokemon list
        for (int i = 0; i < list.size();i++){
            s = String.valueOf(p);
            array.add(s+"週目："+list.get(i).name);
            p++;
        }

        //Make a list searched Pokemon
        ArrayAdapter<String> ad = new ArrayAdapter<String>(SubActivity.this, android.R.layout.simple_list_item_1, array);
        listView = findViewById(R.id.listView);
        listView.setAdapter(ad);

        //Click list
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int index, long l) {
                //go SubActivity_Search
                //pick a Pokemon Detail
                Intent intent = new Intent(getApplication(), SubActivity_Search.class);
                intent.putExtra("Search", (Serializable) list.get(index));
                startActivity(intent);
            }
        });

        //return MainActivity
        Button returnButton = findViewById(R.id.return_button);
        returnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }
}
