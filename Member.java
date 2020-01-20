import java.time.LocalDate;
public class Member extends Person{

	private String memberID;
	private String memberType;
	private static int memberCount = 0;

	//Constructor with LocalDate
	public Member(String name,LocalDate birthDate, int gender, int memberType){
    	super(name, birthDate, gender);
    	generateID();
    	assignMembership(memberType);
    	memberCount++;
    }
    

    //Accessor & Mutator
	public static void setMemberCount(int memberCount) {
		Member.memberCount = memberCount;
	}
	
	public String getMemberID() {
		return memberID;
	}

	public void setMemberID(String memberID) {
		this.memberID = memberID;
	}

	public String getMemberType() {
		return memberType;
	}

	public void setMemberType(String memberType) {
		this.memberType = memberType;
	}

	public static int getMemberCount() {
		return memberCount;
	}

	public String toString() {
		String fullGender;
		if (gender == 'M')
			fullGender = "Male";
		else
			fullGender = "Female";
		return "Member ID    : " + memberID
				+ "\nMember Type  : " + memberType
				+ "\nMember Name  : " + name
				+ "\nBirth Date   : " + birthDate
				+ "\nGender       : " + fullGender + "\n";
	}

	//Method
	public void generateID() {
		char firstLetter = Character.toUpperCase(name.charAt(0));
		String threeDigit = String.format("%03d", Member.memberCount);
		memberID = firstLetter + threeDigit;
	}
	
	public boolean matchId(String ID) {
		if(memberID.equals(ID)) {
			return true;
		}
		else
			return false;
	}

	public boolean matchType(int type) {
		switch(type) {
		case 1:
			if(memberType.equals("Normal"))
				return true;
			break;
		case 2:
			if(memberType.equals("Silver"))
				return true;
			break;
		case 3:
			if(memberType.equals("Gold"))
				return true;
			break;
		case 4:
			if(memberType.equals("Diamond"))
				return true;
			break;
		default:
			return false;
		}
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
	
	public void editType(){
		int type = 0;
		while(type < 1 || type > 4) {
			System.out.print("1.Normal" + "\n2.Silver" + "\n3.Gold" + "\n4.Diamond"
						+ "\nSelect the membership type > ");type = input.nextInt();
			if(type < 1 || type > 4)
				System.out.println("Invalid input. Please enter again.");
		}
		assignMembership(type);
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
	
	public void assignMembership(int memberType) {
		switch(memberType) {
    	case 1:
    		this.memberType = "Normal";
    		break;
    	case 2:
    		this.memberType = "Silver";
    		break;
    	case 3:
    		this.memberType = "Gold";
    		break;
    	case 4:
    		this.memberType = "Diamond";
    		break;
    	default:
    		this.memberType = "None";
    	}
	}
	
	
	
}