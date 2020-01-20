/**
 * @(#)Order.java
 *
 *
 * @author 
 * @version 1.00 2019/8/14
 */


public class Order {
		private Product product;
		private double subTotal;	
		private int qty;
		
		//Constructor
		public Order(Product product, int qty) {
			this.product = product;
			this.qty = qty;
		}
		
		//Accessor & Mutator
		public Product getProduct() {
			return product;
		}

		public void setProduct(Product product) {
			this.product = product;
		}

		public double getSubTotal() {
			return subTotal;
		}

		public void setSubTotal(double subTotal) {
			this.subTotal = subTotal;
		}

		public int getQty() {
			return qty;
		}

		public void setQty(int qty) {
			this.qty = qty;
		}
		
		//ToString
		public String toString() {
			return String.format("%-15s %-10d %-9.2f %14.2f", product.getProductName(), qty, product.getProdPrice(), calcSubTotal());
		}
		
		//Method
		public double calcSubTotal() {
			return product.getProdPrice() * qty;
		}
		
		


}