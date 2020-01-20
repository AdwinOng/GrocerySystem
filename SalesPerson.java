/**
 * @(#)SalesPerson.java
 *
 *
 * @author
 * @version 1.00 2019/8/8
 */

import java.time.LocalDate;
public class SalesPerson extends Person{
	//Data Member
	private String salesPersonId;
	private double salary;
	private static int salesPersonCount;

	//Constructor
	public SalesPerson(String name, LocalDate birthDate, int gender, double salary){
    	super(name, birthDate, gender);
    	this.salary = salary;
    	generateID();
    	salesPersonCount++;
    }
    
	//Accessor & Mutator
	public String getSalesPersonId() {
		return salesPersonId;
	}

	public void setSalesPersonId(String salesPersonId) {
		this.salesPersonId = salesPersonId;
	}


	public double getSalary() {
		return salary;
	}


	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	public static int getSalesPersonCount() {
		return SalesPerson.salesPersonCount;
	}



	public String toString() {
		String fullGender;
		if (gender == 'M')
			fullGender = "Male";
		else
			fullGender = "Female";
		return "Sales Person ID      : " + salesPersonId
				+ "\nSales Person Name    : " + name
				+ "\nSales Person Salary  : " + salary
				+ "\nBirth Date           : " + birthDate
				+ "\nGender               : " + fullGender + "\n";
	}
	
	//Method
	public void generateID() {
		char firstLetter = Character.toUpperCase(name.charAt(0));
		String threeDigit = String.format("%03d", SalesPerson.salesPersonCount);
		salesPersonId = firstLetter + threeDigit;
	}
	
	public boolean matchId(String ID) {
		if(salesPersonId.equals(ID)) {
			return true;
		}
		else
			return false;
	}

	public void editBirthDate() {
		System.out.print("Enter the new birth date (DD-MM-YYYY) > ");
		String date = input.next();
		birthDate = stringToDate(date);
	}
	
	public void editName() {
		System.out.print("Enter the new name > ");
		String newName = input.nextLine();
		name = newName;
	}
	
	public void editSalary(){
		System.out.print("Enter the new salary > ");
		double salary = input.nextDouble();
		this.salary = salary;
	}
	
	public void editGender() {
		int editGender = 0;
		while(editGender != 1 && editGender != 2) {
			System.out.print("1.Male" + "\n2.Female"
						+ "\nSelect gender > ");
			editGender = input.nextInt();
			if(editGender != 1 && editGender != 2)
				System.out.println("Invalid input. Please enter again.");
		}
		
    	if(editGender == 1)
    		gender = 'M';
    	else
    		gender = 'F';
	}
	

}