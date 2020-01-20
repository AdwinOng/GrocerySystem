
public class ReturnProduct {
	//Data Member
	private String returnProductID;
	private Product returnProduct;
	private Payment payment;
	private int returnQty;
	private static int returnProdCount = 0;

	//Constructor
	public ReturnProduct(Payment payment, String returnProductID, Product returnProduct, int returnQty) {
		this.payment = payment;
		this.returnProductID = returnProductID;
		this.returnProduct = returnProduct;
		this.returnQty = returnQty;
		returnProdCount++;
	}
	
	//Accessor and Mutator
	public static int getReturnProdCount() {
		return returnProdCount;
	}

	public static void setReturnProdCount(int returnProdCount) {
		ReturnProduct.returnProdCount = returnProdCount;
	}
	public String getReturnProductID() {
		return returnProductID;
	}

	public void setReturnProductID(String returnProductID) {
		this.returnProductID = returnProductID;
	}

	public Product getReturnProduct() {
		return returnProduct;
	}

	public void setReturnProduct(Product returnProduct) {
		this.returnProduct = returnProduct;
	}

	public int getReturnQty() {
		return returnQty;
	}

	public void setReturnQty(int returnQty) {
		this.returnQty = returnQty;
	}

	
}
