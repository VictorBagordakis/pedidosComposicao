package entities;

import java.text.SimpleDateFormat;

public class OrderItem {
	private Integer quantity;
	private Double price;
	
	Product product;
	
	public OrderItem() {	
	}
	
	public OrderItem(Integer quantity, Double price, Product product) {
		this.quantity = quantity;
		this.price = price;
		this.product = product;
	}
		
	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Double subTotal() {
		return price * quantity;
	}
	
	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append(product.name);
		s.append(", $");
		s.append(String.format("%.2f", price));
		s.append(", Quantity: ");
		s.append(quantity);
		s.append(", Subtotal: $");
		s.append(String.format("%.2f", subTotal()));
		return s.toString();
	}
}
