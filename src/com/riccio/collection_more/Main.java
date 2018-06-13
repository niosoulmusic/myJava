package com.riccio.collection_more;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Theatre theatre = new Theatre("Politeama", 10, 10);
        theatre.getSeats();
        //List<Theatre.Seat> copyCat = new ArrayList<>(theatre.getSeats());

        if (theatre.reserveSeat("A01")) {
            System.out.println("seat has been reserved for X fee");
        } else {
            System.out.println("sorry , seat is taken");
        }
        if (theatre.reserveSeat("B13")) {
            System.out.println("seat has been reserved for X fee");
        } else {
            System.out.println("sorry , seat is taken");
        }

        List<Theatre.Seat> priceComparedSeats = new ArrayList<>(theatre.getSeats());
        priceComparedSeats.add(theatre.new Seat("B00",12));
        priceComparedSeats.add(theatre.new Seat("A00",13));
        Collections.sort(priceComparedSeats,Theatre.PRICE_ORDER);
        printSeats(priceComparedSeats);
//        copyCat.get(1).reserve();
//        if (theatre.reserveSeat("A02")){
//            System.out.println("ok done");
//        }else {
//            System.out.println("nope, seat reserved in the copycat probably");
//        }
    }
    public static void printSeats(List<Theatre.Seat> seats){
        for (Theatre.Seat seat : seats){
            System.out.println(seat.getSeatNumber()+ " $ "+seat.getPrice());
        }
    }
//    public static void sortList(List<? extends Theatre.Seat> list) {
//        for (int i = 0; i < list.size() - 1; i++) {
//            for (int j = i + 1; j < list.size(); j++) {
//                if (list.get(i).compareTo(list.get(j)) > 0)
//                    Collections.swap(list, i, j);
//            }
//        }
//    }
}