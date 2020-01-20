import java.util.Scanner;

public class Product {
	
	Scanner input = new Scanner(System.in);
	
	//Data Members
	private String productId;
	private String productName;
	private int stockQty;
	private double prodPrice;
	private static int prodAmt = 0;

	//Constructor
	public Product(String productName, int stockQty, double prodPrice) {
		this.productName = productName;
		this.stockQty = stockQty;
		this.prodPrice = prodPrice;
		generateId();
		prodAmt++;
	}
	
	//Accessor & Mutator
	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getStockQty() {
		return stockQty;
	}

	public void setStockQty(int stockQty) {
		this.stockQty = stockQty;
	}

	public double getProdPrice() {
		return prodPrice;
	}

	public void setProdPrice(double prodPrice) {
		this.prodPrice = prodPrice;
	}
		
	public static int getProdAmt() {
		return prodAmt;
	}

	public static void setProdAmt(int prodAmt) {
		Product.prodAmt = prodAmt;
	}
	
	//Method
	public void addStock(double qty) {
		stockQty += qty;
	}
	
	public void removeStock(double qty) {
		stockQty -= qty;
	}
	
	public void generateId() {
		char firstLetter = Character.toUpperCase(productName.charAt(0));
		String threeDigit = String.format("%03d", Product.prodAmt);
		productId = firstLetter + threeDigit;
	}
	
	public boolean matchId(String Id) {
		if(productId.equals(Id)) {
			return true;
		}
		else
			return false;
	}
	
	public boolean containName(String name) {
		if(productName.toLowerCase().contains(name.toLowerCase())) {
			return true;
		}
		else
			return false;
	}
	
	public void editName() {
		System.out.print("Enter the new product name > ");
		String newName = input.nextLine();
		productName = newName;
	}
	
	public void editStock() {
		System.out.print("Enter the new stock quantity > ");
		int newQty = input.nextInt();
		stockQty = newQty;
	}
	
	public void editPrice() {
		System.out.print("Enter the new price quantity > ");
		double newPrice = input.nextDouble();
		prodPrice = newPrice;
	}

	//toString
	public String toString() {
		return "Product ID        : " + productId + 
				"\nProduct Name      : " + productName + 
				"\nStock Quantity    : " + stockQty + 
				"\nPrice             : " + prodPrice + "\n";
	}


	
	
	
	
}
