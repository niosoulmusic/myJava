package com.riccio.composition;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Dimension caseDimension= new Dimension(20,20,10);
        Case thecase = new Case("220b","DELL","220v",caseDimension);
        Monitor theMonitor = new Monitor("27inch beast","Acer",27,new Resolution(2540,1440));
        Motherboard theMotherboard= new Motherboard("gwt-123","Asus",4,4,"version 2.4.4");

        PC myComputer = new PC(thecase,theMonitor,theMotherboard);
//        myComputer.getMonitor().drawPixelAt(1500,1200,"red");
//        myComputer.getMotherboard().loadProgram("ciao");
//        myComputer.getTheCase().pressPowerButton();

    }
}
