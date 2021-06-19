package com.example.complelte_battle_factory;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class SubActivity_Search extends AppCompatActivity {
    private Detail_POKE detail;

    private ImageView Img;
    private TextView Name,Type1,Type2;
    private TextView Skill1,Skill2,Skill3,Skill4;
    private TextView Cha1,Cha2,Cha3;
    private TextView Status,Pack;
    private TextView H,A,B,C,D,S;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.subactivity_search);
        //receive MainActivity data
        detail = (Detail_POKE) getIntent().getSerializableExtra("Search");

        Img = findViewById(R.id.imageView);
        Name = findViewById(R.id.name);
        Type1 = findViewById(R.id.type1);
        Type2 = findViewById(R.id.type2);

        Cha1 = findViewById(R.id.cha1);
        Cha2 = findViewById(R.id.cha2);
        Cha3 = findViewById(R.id.cha3);

        Skill1 = findViewById(R.id.skill1);
        Skill2 = findViewById(R.id.skill2);
        Skill3 = findViewById(R.id.skill3);
        Skill4 = findViewById(R.id.skill4);

        Pack = findViewById(R.id.pack);

        H = findViewById(R.id.h_para);
        A = findViewById(R.id.a_para);
        B = findViewById(R.id.b_para);
        C = findViewById(R.id.c_para);
        D = findViewById(R.id.d_para);
        S = findViewById(R.id.s_para);

        //load image from assets
        AssetManager assets = getResources().getAssets();
        String n = "images/"+detail.num+".png";

        try(InputStream is = assets.open(n)){
            Bitmap bitmap = BitmapFactory.decodeStream(is);
            Img.setImageBitmap(bitmap);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //set detail
        Name.setText(detail.name);
        Type1.setText(detail.type.get(0));
        Type2.setText(detail.type.get(1));
        Cha1.setText(detail.type.get(2));
        Cha3.setText(detail.type.get(3));

        Pack.setText(detail.character.get(0));
        Cha2.setText(detail.character.get(1));

        Skill1.setText(detail.skills.get(0));
        Skill2.setText(detail.skills.get(1));
        Skill3.setText(detail.skills.get(2));
        Skill4.setText(detail.skills.get(3));

        H.setText(String.valueOf(detail.status.get(0)));
        A.setText(String.valueOf(detail.status.get(1)));
        B.setText(String.valueOf(detail.status.get(2)));
        C.setText(String.valueOf(detail.status.get(3)));
        D.setText(String.valueOf(detail.status.get(4)));
        S.setText(String.valueOf(detail.status.get(5)));
    }
}
