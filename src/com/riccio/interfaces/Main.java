package com.riccio.interfaces;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
    Player gege = new Player("gege",100,100);
        System.out.println(gege.toString());
        gege.setHitPoints(200);
        System.out.println(gege);
        gege.setWeapon("bazooka");
        System.out.println(gege);
        saveObject(gege);
        loadObject(gege);

    }

    public static void saveObject(ISaveable objectToSave){
        for (int i=0;i<objectToSave.write().size();i++){
            System.out.println("saving object "+objectToSave.write().get(i)+" to storage device");
        }
    }

    public static void loadObject(ISaveable objectToLoad){
        ArrayList<String> values = new ArrayList<String>();
        values.add("gege");
        values.add(""+100);
        values.add(""+100);
        values.add("bazooka");
        objectToLoad.read(values);
    }
}
