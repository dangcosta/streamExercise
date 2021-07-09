package program;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import entities.Employee;

public class Program {
	
	/*
	 * Fazer um programa para ler os dados (nome, email e salário) de funcionários a partir de um arquivo em formato .csv.

Em seguida mostrar, em ordem alfabética, o email dos funcionários cujo salário seja superior a um dado valor fornecido pelo usuário.

Mostrar também a soma dos salários dos funcionários cujo nome começa com a letra 'M'.

Veja exemplo na próxima página.

https://github.com/acenelio/lambda7-java
	 */
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter path: ");
		String filePath = sc.next();
		
		try (BufferedReader file = new BufferedReader(new FileReader(filePath))) {
		  ArrayList<Employee> employees = new ArrayList<>();
		  String input;
		  
		  while ((input = file.readLine()) != null) {
			String [] temp = input.split(";");
			
			employees.add(new Employee(temp[0], temp[1], Double.parseDouble(temp[2])));
		  }
			
		  System.out.println("Enter Salary: ");
		  Double salary = sc.nextDouble();
		  
		  List<Employee> names = employees.stream()
				  .filter(x -> x.getSalary() >= salary)
				  .sorted((e1, e2) -> e1.getEmail().compareTo(e2.getEmail()))
				  .collect(Collectors.toList());
		  
		  System.out.println("Email of people whose salary is more than 2000,00: ");
		  names.forEach(x -> System.out.println(x.getEmail()));
		  
		  System.out.printf("Sum of salary of people whose name starts with 'M': %.2f%n",
				  employees.stream()
				  .filter(x -> x.getName().startsWith("M"))
				  .mapToDouble(Employee::getSalary)
				  .reduce(0, (x, y) -> x + y));
		 
		  
		} catch (IOException e) {
		    System.out.println(e);
		}
	
		sc.close();
		
	}

}
