package com.riccio.generics;

import com.riccio.generics.Team;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class League <T extends Team> {
    public String name;
    private ArrayList<T> league = new ArrayList<>();

    public League(String name) {
        this.name = name;
        this.league = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public boolean add(T team){
        if (team!=null && !league.contains(team)){
            System.out.println("Adding "+team.getName()+" to League");
            league.add(team);
            return true;
        }else {
            return false;
        }
    }

    public void teamChart(){
        Collections.sort(league);
        System.out.println("Raking for League : "+name);
        for (T t : league){
            System.out.println(t.getName() + ":" + t.ranking());
        }

    }


}
