package com.riccio.lambdastreams;

public class CreatingLambas {

    interface Greeting{
        public String sayHello(String input);
    }

    public void testGreeting(String input,Greeting g){
        String result = g.sayHello(input);
        System.out.println("Result: "+result);
    }

    public static void main(String[] args) {
        new CreatingLambas().testGreeting("Eugene",(String s)->"Hello, "+s);
    }
}
