package com.example.complelte_battle_factory;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Detail_POKE implements Serializable {
    public String num,name;
    public int n;
    public ArrayList<String> character = new ArrayList<String>();
    public ArrayList<String> skills = new ArrayList<String>();
    public ArrayList<String> type = new ArrayList<String>();
    public ArrayList<Integer> status = new ArrayList<Integer>();

    Detail_POKE(String line){
        String [] st = line.split(",",-1);

        this.name = st[1];
        for(int i = 2; i < 6; i++){
            this.skills.add(st[i]);
        }
        for(int i = 6; i < 9; i++){
            this.character.add(st[i]);
        }
        for(int i = 9; i < 15; i++){
            this.status.add(Integer.valueOf(st[i]));
        }
        for(int i = 15; i < 19; i++){
            this.type.add(st[i]);
        }
        // normalize number, ex: 001,010,100,...
        n = Integer.valueOf(st[19]);
        if(n < 10 ) this.num = "00"+st[19];
        else if(n < 100) this.num = "0"+st[19];
        else this.num = st[19];
    }
}

