package com.riccio.lambdastreams.functions.primitives;

import com.riccio.lambdastreams.domain.Employee;

import java.util.function.*;

// Functions for primitives - "int", "long", "double"

public class PrimitiveFunctions {

	Predicate<Integer> evenNumberPredicate = x -> x%2 ==0;
	
	IntPredicate evenNumberPredicate2 =  x -> x%2 ==0;
	
	Predicate<Double> doublePredicate = x -> x >10;
	DoublePredicate doublePredicate2 =  x -> x >10;
	LongPredicate longPredicate = null;
	
	// Consumers
	
	IntConsumer intConsumer = null;
	DoubleConsumer doubleConsumer = null;
	LongConsumer longConsumer = null;
	
	//Suppliers
	
	IntSupplier intSupplier;
	DoubleSupplier doubleSupplier;
	LongSupplier longSupplier;
	
	// Functions
	
	Function<Integer, Employee> empFunction = null;
	
	IntFunction<Employee> empFunciton2 = null;
	DoubleFunction<Employee> doubleEmpFunction;
	LongFunction<Employee> longEmpFunction;
	
	// double and int
	Function<Double, Integer> doubleToIntegerFunction = null;
	DoubleFunction<Integer> doubleToIntegerFunction2;
	
	//primitive to primitive
	DoubleToIntFunction doubleToIntegerFunction3 ;

	//	DoubleToIntFunction  -- convert primitive double to primitive int  -- applyAsInt
//	DoubleToLongFunction -- convert primitive double to primitive long -- applyAsLong
//	IntToDoubleFunction  -- convert primitive int to primitive double  -- applyAsDouble
//	IntToLongFunction    -- convert primitive int to primitive long    -- applyAsLong
//	LongToDoubleFunction -- convert primitive long to primitive double -- applyAsDouble
//	LongToIntFunction 	 -- convert primitive long to primitive int    -- applyAsInt

	
	private void testPredicate(int i) {
		System.out.println("Even number?"+evenNumberPredicate2.test(i));
		
	}
	
	public static void main(String[] args) {
		int evenNum = 20;
		new PrimitiveFunctions().testPredicate(evenNum);
	}

}







