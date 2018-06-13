package com.riccio.innerclasses;

import java.util.ArrayList;

public class GearBox {
    private ArrayList<Gear> gears;
    private int maxGears;
    private int currentGear =0;
    private boolean clutchIsIn;

    public GearBox(int maxGears) {
        this.maxGears = maxGears;
        this.gears=new ArrayList<>();
        Gear netural = new Gear(0,0.0);
        this.gears.add(netural);

        for (int i=0;i<maxGears;i++){
            addGear(i,i*5.3);
        }
    }

    public void opearateClutch(boolean in){
        this.clutchIsIn=in;
    }

    public void addGear(int gearNumber,double ratio){
        if (gearNumber>0 && gearNumber<=maxGears){
            this.gears.add(new Gear(gearNumber,ratio));
        }
    }

    public void changeGear(int newGear){
        if (newGear>=0 && newGear<this.gears.size()
                && this.clutchIsIn) {
            this.currentGear = newGear;
            System.out.println("Gear " + newGear + " Selected");
        }
        else{
            System.out.println("Grind");
            this.currentGear=0;
        }
    }

    public double wheelSpeed(int revs){
        if (clutchIsIn){
            System.out.println("SCREAM");
            return 0.0;
        }else{
            return revs * gears.get(currentGear).getRatio();
        }
    }
    private class Gear{
        private int gearNumber;
        private double ratio;

        public Gear(int gearNumber, double ratio) {
            this.gearNumber = gearNumber;
            this.ratio = ratio;

        }
        public double driveSpeed(int revs){
            return revs * (this.ratio);
        }

        public double getRatio() {
            return ratio;
        }
    }
}
