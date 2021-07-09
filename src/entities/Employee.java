package entities;

public class Employee {
	
	String name;
	String email;
	double salary;
	
	public Employee(String name, String email, double d) {	
		this.name = name;
		this.email = email;
		this.salary = d;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	

}
