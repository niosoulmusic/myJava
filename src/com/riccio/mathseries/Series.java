package com.riccio.mathseries;

public class Series {

    public static long nSum(int n) {
        return (n*n+1/2);
    }

    public static long factorial(int n) {
        return (n>1? n * factorial(n-1) : n);
    }

    public static int fibonacci(int n) {
    return (n>1 ?(fibonacci(n-1)+fibonacci(n-2)): n);
    }
}
