package com.riccio.innerclasses;

import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static Button buttonPrint = new Button("Print");

    public static void main(String[] args) {
        GearBox ferrari = new GearBox(6);
        ferrari.opearateClutch(true);
        ferrari.changeGear(1);
        ferrari.opearateClutch(false);
        System.out.println(ferrari.wheelSpeed(1000));
        ferrari.opearateClutch(true);
        ferrari.changeGear(2);
        ferrari.opearateClutch(false);
        System.out.println(ferrari.wheelSpeed(3000));

//        class ClickListener implements Button.OnClickListener{
//            public ClickListener(){
//                System.out.println("clickListener has been attached");
//            }
//            @Override
//            public void onClick(String title) {
//                System.out.println(title + " was clicked");
//
//            }
//        }

        buttonPrint.setOncClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(String title) {
                System.out.println(title + " was clicked");

            }
        });

        //buttonPrint.setOncClickListener(new ClickListener());
        listen();
    }
    private static void listen(){
        boolean quit = false;
        while (!quit){
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch(choice){
                case 0:
                    quit=true;
                    break;
                case 1:
                    buttonPrint.onClick();
                    break;


            }
        }
    }
}
