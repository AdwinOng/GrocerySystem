/**
 * @(#)Payment.java
 *
 *
 * @author 
 * @version 1.00 2019/8/14
 */


public class Payment {
		
		//Data Member
		private SalesPerson salesPerson;
		private Member member;
		private Order order[];
		private String paymentId;
		private double total = 0;
		private double grandTotal = 0;
		private double discount = 0;
		private static double serviceTax = 0.05;
		private static int paymentCount = 0;
		
		//Constructor
		public Payment(SalesPerson salesPerson, Member member, Order[] order) {
			this.salesPerson = salesPerson;
			this.member = member;
			this.order = order;
			generateID();
			paymentCount++;
			calcTotal();
			calcDiscount();
			calcGrandTotal();
		}
		
		//Accessor & Mutator
		public boolean matchSalesID(String id){
			if(salesPerson.getSalesPersonId().equals(id))
				return true;
			return false;
		}
		
		public boolean matchMemberID(String id){
			if(member.getMemberID().equals(id))
				return true;
			return false;
		}

		public static int getPaymentCount(){
			return Payment.paymentCount;
		}
		
		public double getTotal(){
			return total;
		}
		
		public double getGrandTotal(){
			return grandTotal;
		}
		public double getDiscount(){
			return discount;
		}
		
		public void setDiscount(){
			this.discount = discount;
		}
		
		public static double getServiceTax(){
			return Payment.serviceTax;
		}
		//Method
		public void generateID() {
			char firstLetter = Character.toUpperCase(member.name.charAt(0));
			char secondLetter = Character.toUpperCase(salesPerson.name.charAt(0));
			String threeDigit = String.format("%03d", Payment.paymentCount);
			paymentId = firstLetter + secondLetter + threeDigit;
		}
		
		public void displayOrderList(){
				System.out.println(String.format("%-15s %-10s %-10s %-10s", "Product Name", "Qty", "Unit Price(RM)", "Sub Total"));
		 		for(int i = 0; i<order.length;i++){
		 		System.out.println(order[i]);	
		 			//Break loop if next element is empty
		 			if(order[i+1] == null)
		 				break;
		 		}
		}
		
		public void calcTotal(){
			for(int i = 0; i <= order.length; i++){
				total += order[i].calcSubTotal();
				
				//Break loop if next element is empty
				if(order[i+1] == null)
					break;	
			}
		}
		
		public void calcGrandTotal(){
			grandTotal = (total + (total * serviceTax)) - discount;
		}
		
		public void calcDiscount(){
			
			if(member.getMemberType().equals("Normal"))
				discount = 0;
			if(member.getMemberType().equals("Silver"))
				discount = (total + (total * serviceTax)) * 0.1;
			if(member.getMemberType().equals("Gold"))
				discount = (total + (total * serviceTax)) * 0.15;
			if(member.getMemberType().equals("Diamond"))
				discount = (total + (total * serviceTax)) * 0.20;	
		}
		
		//ToString
		public String toString() {
		return "Payment ID        : " + paymentId + 
				"\nSales Person      : " + salesPerson.getSalesPersonId() + 
				"\nMember               : " + member.getMemberID() + 
				"\nGrand Total         : " + grandTotal + "\n";
	}
}