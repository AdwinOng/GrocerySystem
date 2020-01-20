import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Person {
	
	Scanner input = new Scanner(System.in);
	
	//Data Member
	protected String name;
	protected LocalDate birthDate;
	protected char gender;

	//Constructor
    public Person(String name, LocalDate birthDate, int gender) {
    	this.name = name;
    	this.birthDate = birthDate;
    	if(gender == 1)
    		this.gender = 'M';
    	else
    		this.gender = 'F';
    }

    //Accessor & Mutator
    public String getName(){
    	return name;
    }

    public char getGender(){
    	return gender;
    }

    public void setName(String name){
    	this.name = name;
    }

    public void setGender(char gender){
    	this.gender = gender;
    }
    
    //Method
	public static LocalDate stringToDate(String date) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		return LocalDate.parse(date, formatter);
	}
	
	public boolean containName(String name) {
		if(this.name.toLowerCase().contains(name.toLowerCase())) {
			return true;
		}
		else
			return false;
	}
	
	public boolean compareDate(LocalDate date) {
		if (birthDate.isBefore(date))
			return true;
		else
			return false;
	}
	
}