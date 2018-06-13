package com.riccio.lambdastreams.functions.function;

import com.riccio.lambdastreams.domain.Address;
import com.riccio.lambdastreams.domain.Employee;
import com.riccio.lambdastreams.domain.Manager;

import java.util.function.Function;

// Composing Function functions
public class ComposingFunctions {
	
	Function<Employee, Manager> managerFinder = (emp) -> getManager(emp);
	Function<Manager, Employee> assistantFinder = (manager) -> getPersonalAssistant(manager);
	
	// andThen method
	private void testAndThen(Employee emp) {
		Function<Employee, Employee> empManagerAssistantFinder = 
				managerFinder.andThen(assistantFinder);
	}

	// compose method
	private void testCompose(Employee emp) {
		Function<Employee, Employee> empFinder = assistantFinder.compose(managerFinder);
	}

	private void testIdentity(){
		Function<String, String> id = Function.identity();
		
		String result = id.apply("ID12EFL");
		
		System.out.println("Result: "+result);
	}
	private Employee getPersonalAssistant(Manager manager) {
		return manager.getPersonalAssistant();
	}

	private Manager getManager(Employee emp) {
		return emp.getManager();
	}

	public static void main(String[] args) {
		Employee emp = new Employee(1);
		new ComposingFunctions().testAndThen(emp);
		new ComposingFunctions().testCompose(emp);
	}

	private Address getAddress(Employee employee) {
		return employee.getAddress();
	}

	private Employee getEmployee(int id) {
		return new Employee(id);
	}

}
