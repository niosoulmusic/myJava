package com.riccio.mathseries;

public class Main {

    public static void main(String[] args) {
        long num=10;
        num = Series.nSum(10);
        System.out.println(num);
        num = Series.factorial(5);
        System.out.println(num);
    }
}
