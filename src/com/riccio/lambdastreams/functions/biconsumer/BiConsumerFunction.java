package com.riccio.lambdastreams.functions.biconsumer;

import com.riccio.lambdastreams.domain.Employee;

import java.util.function.BiConsumer;

// TWO argument function - BiConsumer
public class BiConsumerFunction {

	BiConsumer<Employee, Integer> empBonusConsumer = 
			(emp, bonus) -> System.out.printf("Employee %s is set of %d pct of bonus:", emp, bonus);
			
	BiConsumer<Employee, Integer> empSalaryHikeConsumer = (emp, sal) ->
		System.out.printf("Employee %s is receiving %d hike in salary", emp, sal);
		
	BiConsumer<Employee, Integer> empBonusAndHikeConsumer = empBonusConsumer.andThen(empSalaryHikeConsumer);
	
	private void testBiConsumer(Employee emp, Integer bonus, Integer salaryHike) {
		empBonusConsumer.accept(emp, bonus);
	}

	
	
	public static void main(String[] args) {
		Employee emp = new Employee(10);
		int bonus = 5;
		int salaryHike = 15;
		new BiConsumerFunction().testBiConsumer(emp, bonus, salaryHike);
	}
}
