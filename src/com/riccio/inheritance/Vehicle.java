package com.riccio.inheritance;

public class Vehicle {
    private String name;
    private int size;
    private int currentVelocity;
    private int currentDirection;

    public Vehicle (){
        this("default",10,0,0);
    }
    public Vehicle(String name, int size){
        this(name,size,0,0);
    }

    public Vehicle(String name, int size, int currentVelocity, int currentDirection) {
        this.name = name;
        this.size = size;
        this.currentVelocity = 0;
        this.currentDirection = 0;
    }

    /*Defaults Methods */
    public void move(int velocity, int direction){
        this.currentVelocity=velocity;
        this.currentDirection=direction;
        System.out.println("vehicle moving at speed "+currentVelocity+" at direction "+direction);
    }
    public void steer(int direction){
        this.currentDirection=direction;
        System.out.println("vehicle steering at direction "+direction );
    }

    public void stop(){
        this.currentVelocity=0;
    }
    /*Getters & Setters*/

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getCurrentVelocity() {
        return currentVelocity;
    }

    public void setCurrentVelocity(int currentVelocity) {
        this.currentVelocity = currentVelocity;
    }

    public int getCurrentDirection() {
        return currentDirection;
    }

    public void setCurrentDirection(int currentDirection) {
        this.currentDirection = currentDirection;
    }
}
