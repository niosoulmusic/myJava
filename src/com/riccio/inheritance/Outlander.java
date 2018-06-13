package com.riccio.inheritance;

public class Outlander extends Car {

    private int roadServiceMonts;

    public Outlander( int roadServiceMonts) {
        super("Outlander", 5, 5, 5, 6, false);
        this.roadServiceMonts = roadServiceMonts;
    }

    public void accelerate (int rate){
        int newVelocity= getCurrentVelocity()+ rate;
        if (newVelocity==0) {
            stop();
            changeGear(1);
        }else if (newVelocity>0 && newVelocity<=10){
            changeGear(1);
        }
        else if (newVelocity>10 && newVelocity<=20){
            changeGear(2);
        }
        else if (newVelocity>20 && newVelocity<=30){
            changeGear(3);
        }
        else if (newVelocity>30 && newVelocity<=40){
            changeGear(4);
        }
        else if (newVelocity>40 && newVelocity<=50){
            changeGear(5);
        }

        // dunno why
        if (newVelocity>0)
            changeVelocity(newVelocity,getCurrentDirection());
    }
}
