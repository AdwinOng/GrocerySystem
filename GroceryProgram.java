
import java.time.LocalDate;
import java.util.Scanner;

public class GroceryProgram {

	static Scanner input = new Scanner(System.in);
	static Product[] prodList = new Product[100];
	static Member[] memberList = new Member[100];
	static SalesPerson[] salesPList = new SalesPerson[100];
	static Order[] orderList = new Order[100];
	static Payment[] paymentList =  new Payment[100];
	public static void main(String[] args) {	
		prodList[0] = new Product("Butter Biscuit", 500, 5); 
		prodList[1] = new Product("Premium Ice-Cream",100, 12.80); 
		prodList[2] = new Product("Diary Milk", 200, 7.20); 
		prodList[3] = new Product("Lettuce", 50, 3.50); 
		prodList[4] = new Product("Cabbage", 50, 3.70); 
		prodList[5] = new Product("Whole Salmon", 25, 32.50); 
		memberList[0] = new Member("Adwin Ong Kok Quan", LocalDate.of(2000, 4, 16), 1, 1);
		memberList[1] = new Member("Ooi Zhi Jie", LocalDate.of(1989, 8, 31), 1, 4);
		memberList[2] = new Member("Tan Ze Hao", LocalDate.of(2005, 4, 1), 2, 3);
		memberList[3] = new Member("Nikey Ng Yee Chuin", LocalDate.of(2007, 12, 27), 1, 2);
		memberList[4] = new Member("Nikola Tesla", LocalDate.of(1983, 1, 7), 1, 2);
		memberList[5] = new Member("Elon Musk", LocalDate.of(1971, 6, 28), 2, 4);
		salesPList[0] = new SalesPerson("Edwin Ong Kok Wong", LocalDate.of(1999, 5, 13), 1, 1);
		salesPList[1] = new SalesPerson("Gooi Jie Zhi", LocalDate.of(1998, 12, 13), 1, 4000);
		salesPList[2] = new SalesPerson("Hao Ze Tan", LocalDate.of(2000, 7, 22), 2, 3000);
		salesPList[3] = new SalesPerson("Nickey Minaj", LocalDate.of(1996, 2, 1), 1, 2800);
		salesPList[4] = new SalesPerson("Albert Edison", LocalDate.of(1988, 3, 17), 1, 2590);
		salesPList[5] = new SalesPerson("Felix Rosenberg", LocalDate.of(1991, 11, 8), 2, 4000);
		orderList[0] = new Order(prodList[0], 5);
		orderList[1] = new Order(prodList[1], 2);
		paymentList[0] = new Payment(salesPList[1], memberList[0] , orderList); 

		int modulesSelection = 0;
		while(modulesSelection != 9) {
			System.out.println("Choose modules: ");
			System.out.print("1.Product\n2.Member\n3.Sales Person\n4.Payment\n"
					+ "5.Report\n9.Exit"
					+ "\nEnter your selection > ");
			modulesSelection = input.nextInt();
			//Switch for determine which menu to call
			switch(modulesSelection) {
			case 1:
				productMenu();
				break;
			case 2:
				memberMenu();
				break;
			case 3:
				salesPersonMenu();
				break;
			case 4:
				payment();
				break;
			case 5:
					reportMenu();
					break;
			case 9:
				//For exit
				break;
			default:
				System.out.println("Invalid input. Please enter again.");
			}
		}
		System.out.println("\n\nClient program ended.");
	}
	
	
	
	//Product
	public static void productMenu() {
		int functionSelection = 0;
		while(functionSelection != 9) {
			System.out.print(
					  "\n1.Display Product"
					+ "\n2.Search Product"
					+ "\n3.Add New Product"
					+ "\n4.Edit Product Info"
					+ "\n9.Exit"
					+ "\nEnter your selection > ");
			functionSelection = input.nextInt();
			switch(functionSelection) {
			case 1:
				displayProd();
				break;
			case 2:
				searchProd();
				break;
			case 3:
				addProd();
				break;
			case 4:
				editProd();
				break;
			case 9:
				//for exit
				break;
			default:
				System.out.println("Invalid input. Please enter again.");
			}
		}
	}
	
	public static void addProd() {
		
		input.nextLine();//Skip previous input
		
		int amt = Product.getProdAmt();
		
		System.out.print("Enter the product name > ");
		String prodName = input.nextLine();
		
		System.out.print("Enter the stock amount > ");
		int qty = input.nextInt();
		
		System.out.print("Enter the product price > ");
		double price = input.nextDouble();
		
		prodList[amt] = new Product(prodName, qty, price);
		
		System.out.print("Generated ID : " + prodList[amt].getProductId());
				
		
		System.out.println("\nProduct added successfully!");
		
	}
	
	public static void searchProd() {
		int searchSelection = 0;
		while(searchSelection !=9) {
			System.out.print("\n1.ID\n2.Name\n3.Stock Quantity\n9.Exit"
				+ "\nSearch by which field? > ");
			searchSelection = input.nextInt();
			
			switch(searchSelection) {
			case 1:
				prodSearchById();
				break;
			case 2:
				prodSearchByName();
				break;
			case 3:
				prodSearchByStock();
				break;
			case 9:
				//for exit
				break;
			default:
				System.out.print("Invalid input. Please enter again.");
			
			}
		}
	}
	
	public static void displayProd() {
		
		for(int i = 0; i<Product.getProdAmt(); i++) {
			System.out.println("Product #" + (i+1) + "\n===========");
			System.out.println(prodList[i]);
		}
	}
	
	public static void editProd() {
		//Find ID to edit
		input.nextLine();
		System.out.print("\nWhich product to edit? Enter ID > ");
		String editProdID = input.nextLine();
		
		boolean foundID = false;
		int listNo = 0;
		
		for(int i = 0; i<Product.getProdAmt(); i++) {
			foundID = prodList[i].matchId(editProdID);
			if(foundID) {
				System.out.print("Product found!\n======================\n" + prodList[i]);
				listNo = i;
				break;
			}
		}
		//Exit if ID not found
		if(!foundID) {
			System.out.println("Product ID not found!");
			return;
		}else {
			int editSelection = 0;
			while(editSelection != 9) {
				//Which field to edit
				System.out.print(
						"\n1.Product Name" + "\n2.Product Price" + "\n3.Product Stock Amount"
						+ "\n9.Exit"
						+ "\nWhich field to edit? >");
				editSelection = input.nextInt();
				switch(editSelection) {
				case 1:
					prodList[listNo].editName();
					break;
				case 2:
					prodList[listNo].editPrice();
					break;
				case 3:
					prodList[listNo].editStock();
					break;
				case 9:
					//for exit
					break;
				default:
					System.out.print("Invalid input. Please enter again");
				}
			}
		}
	}

	public static void stockReturn() {
		input.nextLine();
		System.out.print("\nProduct ID > ");
		String returnedProdID = input.nextLine();
		
		if(!validateProductID(returnedProdID))
			return;
		System.out.print("Returned Quantity > ");
		int returnedQty = input.nextInt();
		
		//returnProdList[ReturnProduct.getReturnProdCount()] = new returnProduct(payment, returnProduct, int returnQty);
		
	}
	
	public static boolean validateProductID(String id) {
		for(int i = 0; i<Product.getProdAmt(); i++) {
			if(prodList[i].matchId(id)) {
				System.out.print("Product found!\n======================\n" + prodList[i]);
				return true;
			}
		}
		
			System.out.println("Product ID not found!");
			return false;
		}

	public static int prodSearchById() {
		System.out.print("\nEnter product ID > ");
		String searchProdID = input.next();
		
		boolean foundID = false;
		//Loop through list
		for(int i = 0; i<Product.getProdAmt(); i++) {
			foundID = prodList[i].matchId(searchProdID);
			//Found
			if(foundID) {
				System.out.print("Product found!\n======================\n" + prodList[i]);
				return i;
			}
			
		}
		//If not found
		if(!foundID) {
			System.out.println("Product ID not found!");
			
		}
		return -1;
	}
	
	public static void prodSearchByStock(){
		System.out.print("\n1.More than or equal to\n2.Less than or equal to"
				+ "\nWhich condition? > ");
		int condition = input.nextInt();
		System.out.print("Enter the stock quantity to be matched > ");
		int searchQty = input.nextInt();
		boolean found = false;
		int foundCount = 0;
		
		if (condition == 1) {
			//Loop through list
			
			for(int i = 0; i<Product.getProdAmt(); i++) {
				
				//Found
				if(prodList[i].getStockQty() >= searchQty) {
					found = true;
					System.out.println("Product #" + ++foundCount + "\n======================\n" + prodList[i]);
				}
				
			}
			if(found) {
				System.out.print("\n" + foundCount + " records matched.");
			}
			
			
		}
		else if(condition == 2) {
			//Loop through list
			for(int i = 0; i<Product.getProdAmt(); i++) {
				//Found
				if(prodList[i].getStockQty() <= searchQty) {
					found = true;
					System.out.println("Product #" + ++foundCount + "\n======================\n" + prodList[i]);
				}
				
			}
			if(found) {
				System.out.print("\n" + foundCount + " records matched.");
			}
		}
		else{System.out.print("Invalid input. Please enter again");}
	
	}
	
	public static void prodSearchByName(){
		input.nextLine();
		System.out.print("\nEnter name to be searched> ");
		String searchName = input.nextLine();
		
		int foundCount = 0;
		//Loop through list
		for(int i = 0; i<Product.getProdAmt(); i++) {
			//Found
			if(prodList[i].containName(searchName)) {
				System.out.print("Product #" + ++foundCount + "\n======================\n" + prodList[i]);
			}
		}
		//Show record or not found
		if(foundCount == 0)
			System.out.println("This name have no match.");
		else
			System.out.println(foundCount + " records matched.");
	}
	
	//Member
	public static void memberMenu() {
	int functionSelection = 0;
	while(functionSelection != 9) {
		System.out.print(
				  "\n1.Display Member"
				+ "\n2.Search Member"
				+ "\n3.Add New Member"
				+ "\n4.Edit Member Detail"
				+ "\n9.Exit"
				+ "\nEnter your selection > ");
		functionSelection = input.nextInt();
		switch(functionSelection) {
		case 1:
			displayMember();
			break;
		case 2:
			searchMember();
			break;
		case 3:
			addMember();
			break;
		case 4:
			editMember();
			break;
		case 9:
			//for exit
			break;
		default:
			System.out.println("Invalid input. Please enter again.");
		}
	}
	
	}
	
	public static void displayMember() {
		for(int i = 0; i<Member.getMemberCount(); i++) {
			System.out.println("Member #" + (i+1) + "\n===========");
			System.out.println(memberList[i]);
		}
	}

	public static void addMember() {
		
		input.nextLine();//Skip previous input
		
		int amt = Member.getMemberCount();
	
		System.out.print("Enter the member name > ");
		String name = input.nextLine();
		
		System.out.print("Enter the member birth date (DD-MM-YYYY) > ");
		String date = input.next();
		
		int type = 0;
		while(type < 1 || type > 4) {
			System.out.print("1.Normal" + "\n2.Silver" + "\n3.Gold" + "\n4.Diamond"
						+ "\nSelect the membership type > ");
			type = input.nextInt();
			if(type < 1 || type > 4)
				System.out.println("Invalid input. Please enter again.");
		}

		int gender = 0;
		while(gender != 1 && gender != 2) {
			System.out.print("1.Male" + "\n2.Female"
						+ "\nSelect gender > ");
			gender = input.nextInt();
			if(gender != 1 && gender != 2)
				System.out.println("Invalid input. Please enter again.");
		}
		
		memberList[amt] = new Member(name, Person.stringToDate(date), gender, type);
		System.out.print("Generated ID : " + memberList[amt].getMemberID());
		System.out.println("\nMember successfully added!");
		
	}
	
	public static void editMember() {
		//Find ID to edit
		input.nextLine();
		System.out.print("\nWhich member to edit? Enter ID > ");
		String editMemberID = input.nextLine();
		
		boolean foundID = false;
		int listNo = 0;
		
		for(int i = 0; i<Member.getMemberCount(); i++) {
			foundID = memberList[i].matchId(editMemberID);
			if(foundID) {
				System.out.print("Member found!\n======================\n" + memberList[i]);
				listNo = i;
				break;
			}
		}
		//Exit if ID not found
		if(!foundID) {
			System.out.println("Member ID not found!");
			return;
		}else {
			int editSelection = 0;
			while(editSelection != 9) {
				//Which field to edit
				System.out.print(
						"\n1.Member Name" + "\n2.Member Birth Date" + "\n3.Membership Type"
						+ "\n4.Gender"
						+ "\n9.Exit"
						+ "\nWhich field to edit? >");
				editSelection = input.nextInt();
				switch(editSelection) {
				case 1:
					memberList[listNo].editName();
					break;
				case 2:
					memberList[listNo].editBirthDate();
					break;
				case 3:
					memberList[listNo].editType();
					break;
				case 4:
					memberList[listNo].editGender();
					break;
				case 9:
					//for exit
					break;
				default:
					System.out.print("Invalid input. Please enter again");
				}
			}
		}
	}

	public static void searchMember() {
		int searchSelection = 0;
		while(searchSelection !=9) {
			System.out.print("\n1.ID\n2.Name\n3.Birth Date"
					+ "\n4.Membership Type" 
					+ "\n9.Exit"
				+ "\nSearch by which field? > ");
			searchSelection = input.nextInt();
			
			switch(searchSelection) {
			case 1:
				memberSearchById();
				break;
			case 2:
				memberSearchByName();
				break;
			case 3:
				memberSearchByBirthDate();
				break;
			case 4:
				memberSearchByType();
				break;
			case 9:
				//for exit
				break;
			default:
				System.out.print("Invalid input. Please enter again.");
			
			}
		}
	}

	public static int memberSearchById() {
		System.out.print("\nEnter member ID > ");
		String searchID = input.next();
		
		boolean foundID = false;
		//Loop through list
		for(int i = 0; i<Member.getMemberCount(); i++) {
			foundID = memberList[i].matchId(searchID);
			//Found
			if(foundID) {
				System.out.print("Member found!\n======================\n" + memberList[i]);
				return i;
			}
			
		}
		//If not found
		if(!foundID) {
			System.out.println("Member ID not found!");
		}
		return -1;
	}

	public static void memberSearchByName(){
		input.nextLine();
		System.out.print("\nEnter name to be searched> ");
		String searchName = input.nextLine();
		
		int foundCount = 0;
		//Loop through list
		for(int i = 0; i<Member.getMemberCount(); i++) {
			//Found
			if(memberList[i].containName(searchName)) {
				System.out.print("Member #" + ++foundCount + "\n======================\n" + memberList[i]);
			}
		}
		//Show record or not found
		if(foundCount == 0)
			System.out.println("This name have no match.");
		else
			System.out.println(foundCount + " records matched.");
	}
	
	public static void memberSearchByType(){
		int type = 0;
		//Validate type entered
		while(type < 1 || type > 4) {
			System.out.print("1.Normal" + "\n2.Silver" + "\n3.Gold" + "\n4.Diamond"
						+ "\nSelect the membership type > ");
			type = input.nextInt();
			if(type < 1 || type > 4)
				System.out.println("Invalid input. Please enter again.");
		}
		
		int foundCount = 0;
		//Loop through list
		for(int i = 0; i<Member.getMemberCount(); i++) {
			//Found
			if(memberList[i].matchType(type)) {
				System.out.print("Member #" + ++foundCount + "\n======================\n" + memberList[i]);
			}
		}
		//Show record or not found
		if(foundCount == 0)
			System.out.println("This type have no match.");
		else
			System.out.println(foundCount + " records matched.");
	}
	
	public static void memberSearchByBirthDate() {
		System.out.print("\n1.Before\n2.After"
				+ "\nWhich condition? > ");
		int condition = input.nextInt();
		System.out.print("Enter the date to be matched (DD-MM-YYYY) > ");
		LocalDate date = Person.stringToDate(input.next());
		int foundCount = 0;
		
		if (condition == 1) {
			//Loop through list
			for(int i = 0; i<Member.getMemberCount(); i++) {
				//Found
				if(memberList[i].compareDate(date)) {
					System.out.print("Member #" + ++foundCount + "\n======================\n" + memberList[i]);
				}
			}
		}
		else if (condition == 2) {
			//Loop through list
			for(int i = 0; i<Member.getMemberCount(); i++) {
				//Found
				if(!memberList[i].compareDate(date)) {
					System.out.print("Member #" + ++foundCount + "\n======================\n" + memberList[i]);
				}
			}
		}
		else {
			System.out.println("Invalid input. Please enter again");
		}
		
		//If not found
		if(foundCount == 0) {
			System.out.println("This name have no match.");
		}
		
	}

	//Sales Person
	public static void salesPersonMenu() {
	int functionSelection = 0;
	while(functionSelection != 9) {
		System.out.print(
				  "\n1.Display Sales Person"
				+ "\n2.Search Sales Person"
				+ "\n3.Add New Sales Person"
				+ "\n4.Edit Member Sales Person"
				+ "\n9.Exit"
				+ "\nEnter your selection > ");
		functionSelection = input.nextInt();
		switch(functionSelection) {
		case 1:
			displaySalesPerson();
			break;
		case 2:
			searchSalesPerson();
			break;
		case 3:
			addSalesPerson();
			break;
		case 4:
			editSalesPerson();
			break;
		case 9:
			//for exit
			break;
		default:
			System.out.println("Invalid input. Please enter again.");
		}
	}
	
	}
	
	public static void displaySalesPerson() {
		for(int i = 0; i<SalesPerson.getSalesPersonCount(); i++) {
			System.out.println("Sales Person #" + (i+1) + "\n===========");
			System.out.println(salesPList[i]);
		}
	}

	public static void addSalesPerson() {
		
		input.nextLine();//Skip previous input
		
		int amt = SalesPerson.getSalesPersonCount();
	
		System.out.print("Enter the sales person name > ");
		String name = input.nextLine();
		
		System.out.print("Enter the sales person birth date (DD-MM-YYYY) > ");
		String date = input.next();

		int gender = 0;
		while(gender != 1 && gender != 2) {
			System.out.print("1.Male" + "\n2.Female"
						+ "\nSelect gender > ");
			gender = input.nextInt();
			if(gender != 1 && gender != 2)
				System.out.println("Invalid input. Please enter again.");
		}
		
		System.out.print("Enter the sales person's salary > ");
		double salary = input.nextDouble();
		
		salesPList[amt] = new SalesPerson(name, Person.stringToDate(date), gender, salary);
		System.out.print("Generated ID : " + salesPList[amt].getSalesPersonId());
		System.out.println("\nSales Person successfully added!");
		
	}
	
	public static void editSalesPerson() {
		//Find ID to edit
		input.nextLine();
		System.out.print("\nWhich sales person to edit? Enter ID > ");
		String editID = input.nextLine();
		
		boolean foundID= false;
		int listNo = 0;
		
		for(int i = 0; i<Member.getMemberCount(); i++) {
			foundID = salesPList[i].matchId(editID);
			if(foundID) {
				System.out.print("Sales Person found!\n======================\n" + memberList[i]);
				listNo = i;
				break;
			}
		}
		//Exit if ID not found
		if(!foundID) {
			System.out.println("Sales Person ID not found!");
			return;
		}else {
			int editSelection = 0;
			while(editSelection != 9) {
				//Which field to edit
				System.out.print(
						"\n1.Sales Person Name" + "\n2.Sales Person Birth Date" + "\n3.Salary"
						+ "\n4.Gender"
						+ "\n9.Exit"
						+ "\nWhich field to edit? >");
				editSelection = input.nextInt();
				switch(editSelection) {
				case 1:
					salesPList[listNo].editName();
					break;
				case 2:
					salesPList[listNo].editBirthDate();
					break;
				case 3:
					salesPList[listNo].editSalary();
					break;
				case 4:
					salesPList[listNo].editGender();
					break;
				case 9:
					//for exit
					break;
				default:
					System.out.print("Invalid input. Please enter again");
				}
			}
		}
	}

	public static void searchSalesPerson() {
		int searchSelection = 0;
		while(searchSelection !=9) {
			System.out.print("\n1.ID\n2.Name\n3.Birth Date"
					+ "\n4.Salary" 
					+ "\n9.Exit"
				+ "\nSearch by which field? > ");
			searchSelection = input.nextInt();
			
			switch(searchSelection) {
			case 1:
				salesPersonSearchById();
				break;
			case 2:
				salesPersonSearchByName();
				break;
			case 3:
				salesPersonSearchByBirthDate();
				break;
			case 4:
				memberSearchByType();
				break;
			case 5:
				salesPersonSearchBySalary();
				break;
			case 9:
				//for exit
				break;
			default:
				System.out.print("Invalid input. Please enter again.");
			
			}
		}
	}

	public static int salesPersonSearchById() {
		System.out.print("\nEnter sales person ID > ");
		String searchID = input.next();
		
		boolean foundID = false;
		//Loop through list
		for(int i = 0; i<SalesPerson.getSalesPersonCount(); i++) {
			foundID = salesPList[i].matchId(searchID);
			//Found
			if(foundID) {
				System.out.print("Sales Person found!\n======================\n" + salesPList[i]);
				return i;
			}
			
		}
		//If not found
		if(!foundID) {
			System.out.println("Sales Person ID not found!");
		}
		return -1;
	}
		
	public static void salesPersonSearchByName(){
		input.nextLine();
		System.out.print("\nEnter name to be searched> ");
		String searchName = input.nextLine();
		
		int foundCount = 0;
		//Loop through list
		for(int i = 0; i<SalesPerson.getSalesPersonCount(); i++) {
			//Found
			if(salesPList[i].containName(searchName)) {
				System.out.print("Sales Person #" + ++foundCount + "\n======================\n" + salesPList[i]);
			}
		}
		//Show record or not found
		if(foundCount == 0)
			System.out.println("This name have no match.");
		else
			System.out.println(foundCount + " records matched.");
	}
	
	public static void salesPersonSearchByBirthDate() {
		System.out.print("\n1.Before\n2.After"
				+ "\nWhich condition? > ");
		int condition = input.nextInt();
		System.out.print("Enter the date to be matched (DD-MM-YYYY) > ");
		LocalDate date = Person.stringToDate(input.next());
		int foundCount = 0;
		
		if (condition == 1) {
			//Loop through list
			for(int i = 0; i<SalesPerson.getSalesPersonCount(); i++) {
				//Found
				if(salesPList[i].compareDate(date)) {
					System.out.print("Sales Person #" + ++foundCount + "\n======================\n" + salesPList[i]);
				}
			}
		}
		else if (condition == 2) {
			//Loop through list
			for(int i = 0; i<SalesPerson.getSalesPersonCount(); i++) {
				//Found
				if(!salesPList[i].compareDate(date)) {
					System.out.print("Sales Person #" + ++foundCount + "\n======================\n" + salesPList[i]);
				}
			}
		}
		else {
			System.out.println("Invalid input. Please enter again");
		}
		
		//If not found
		if(foundCount == 0) {
			System.out.println("This name have no match.");
		}
		
	}

	public static void salesPersonSearchBySalary(){
		System.out.print("\n1.More than or equal to\n2.Less than or equal to"
				+ "\nWhich condition? > ");
		int condition = input.nextInt();
		System.out.print("Enter the amount of salary to be matched > ");
		int salary = input.nextInt();
		int foundCount = 0;
		
		if (condition == 1) {
			//Loop through list
			
			for(int i = 0; i<SalesPerson.getSalesPersonCount(); i++) {
				
				//Found
				if(salesPList[i].getSalary() >= salary) {
					System.out.println("Sales Person #" + ++foundCount + "\n======================\n" + salesPList[i]);
				}
				
			}

			
		}
		else if(condition == 2) {
			//Loop through list
			for(int i = 0; i<SalesPerson.getSalesPersonCount(); i++) {
				//Found
				if(salesPList[i].getSalary() <= salary) {
					System.out.println("Sales Person #" + ++foundCount + "\n======================\n" + salesPList[i]);
				}
				
			}
		}			
		else{System.out.print("Invalid input. Please enter again");}
		
		if(foundCount == 0) {
				System.out.print("\n" + foundCount + " records matched.");
			}
		else {
			System.out.println("\nNo matches");
		}
			
	
	}

	//Payment
	public static void payment() {
		displayProd();
		
		Order order[] = new Order[100];
		boolean cont = true;
		
		//Enter order list
		for(int i = 0; cont; i++) {
			int orderedProdNo = prodSearchById();
			//Return -1 if not found
			
			if(orderedProdNo != -1) {
				//Quantity must not exceed product Stock
				int orderedQty = 0;
				boolean exceed = false;
				do{
					System.out.print("Enter the quantity > ");
					orderedQty = input.nextInt();
					
					if(orderedQty > prodList[orderedProdNo].getStockQty())
						exceed = true;
					else
						exceed = false;
						
					if(exceed)
						System.out.println("Purchase quantity cannot exceed stock remain! Please enter again.");
				}while(exceed);
				
				//Add into order array
				order[i] = new Order(prodList[orderedProdNo], orderedQty);
				//Remove stock in Product Array
				prodList[orderedProdNo].setStockQty(prodList[orderedProdNo].getStockQty() - orderedQty);
			}
			System.out.print("Continue ordering? (Y=Yes) > ");
			String contOrNot = input.next();
			if (!contOrNot.toUpperCase().equals("Y"))
				cont = false;
		}
		
		//Enter sales person ID
		int orderStaffNo = -1;
		while(orderStaffNo == -1) {
			orderStaffNo = salesPersonSearchById();
			if(orderStaffNo == -1)
				System.out.println("Invalid ID. Please enter again.");
		}
		
		//Enter customer
		int orderMemberNo = -1;
		while(orderMemberNo == -1) {
			orderMemberNo = memberSearchById();
			if(orderMemberNo == -1)
				System.out.println("Invalid ID. Please enter again.");
		}
		
		//Create the Record
		paymentList[Payment.getPaymentCount()] = new Payment(salesPList[orderStaffNo], memberList[orderMemberNo], order);
		
		//Print Order List and Grand Total
		System.out.println("\nPayment\n=================================");
		paymentList[Payment.getPaymentCount()-1].displayOrderList();
		System.out.printf("\n%40s %10.2f", "Service Tax", paymentList[Payment.getPaymentCount()-1].getTotal() * Payment.getServiceTax());
		System.out.printf("\n%40s %10.2f", "Discount", paymentList[Payment.getPaymentCount()-1].getDiscount());
		System.out.printf("\n%40s %10.2f\n", "Grand Total", paymentList[Payment.getPaymentCount()-1].getGrandTotal());
		
		//Customer Payment and Validation
		double customerPayment = -1;
		while(customerPayment < paymentList[Payment.getPaymentCount()-1].getGrandTotal()){
		System.out.print("\nCustomer Payment Amount > ");
		customerPayment = input.nextDouble();
		if(customerPayment < paymentList[Payment.getPaymentCount()-1].getGrandTotal())
			System.out.println("Insufficient payment amount! Please enter again.");
		}
		
		
		
		//Find Changes
		double changes = customerPayment - paymentList[Payment.getPaymentCount()-1].getGrandTotal();
		System.out.println("Changes Amount : " + changes + "\n");
	}
	
	//Generate Report
	public static void reportMenu() {
	int functionSelection = 0;
	while(functionSelection != 9) {
		System.out.print(
				  "\n1.Generate Report based on Sales Person"
				+ "\n2.Generate Report based on Member"
				+ "\n9.Exit"
				+ "\nEnter your selection > ");
		functionSelection = input.nextInt();
		switch(functionSelection) {
		case 1:
			generateBasedOnSalesPerson();
			break;
		case 2:
			generateBasedOnMember();
			break;
		case 9:
			//for exit
			break;
		default:
			System.out.println("Invalid input. Please enter again.");
		}
	}
	
	}
	
	public static void generateBasedOnSalesPerson(){
		//Enter sales person ID
		int salesNo = -1;
		while(salesNo == -1) {
			salesNo = salesPersonSearchById();
			if(salesNo == -1)
				System.out.println("Invalid ID. Please enter again.");
		}
		
		//how many matched
		int matchedRecord = 0;
		for(int i = 0; i<Payment.getPaymentCount();i++){
			if(paymentList[0].matchSalesID(salesPList[salesNo].getSalesPersonId()))
				matchedRecord++;
		}
		
		System.out.println(salesPList[salesNo].getName() + " has make " + matchedRecord +" records.\n");
	}
	
	public static void generateBasedOnMember(){
		//Enter member ID
		int memberNo = -1;
		while(memberNo == -1) {
			memberNo = memberSearchById();
			if(memberNo == -1)
				System.out.println("Invalid ID. Please enter again.");
		}
		
		//how many matched
		int matchedRecord = 0;
		for(int i = 0; i<Payment.getPaymentCount();i++){
			if(paymentList[i].matchMemberID(memberList[memberNo].getMemberID()))
				matchedRecord++;
		}
		
		System.out.println(memberList[memberNo].getName() + " has make " + matchedRecord +" records.\n");
	}
}

