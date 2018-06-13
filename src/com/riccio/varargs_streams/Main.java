package com.riccio.varargs_streams;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Main {

    public static class Add{
        public static void add(Integer... integerList){

            IntStream.range(0, integerList.length)
                    .mapToObj(i -> {
                        if (i>0 && i<integerList.length-1){
                            return "+"+integerList[i];
                        }else if (i==integerList.length-1){
                            return "+"+integerList[i]+"=";
                        }
                        return integerList[i];
                    })
                    .forEach(System.out::print);
            System.out.print(Arrays.stream(integerList).mapToInt(i->i).sum());
        }
    }

    public static void main(String[] args) {

        Add add = new Add();
        add.add(3,4,5,6);
    }
}
