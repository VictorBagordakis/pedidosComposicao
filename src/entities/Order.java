package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.enums.OrderStatus;

public class Order {
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	private Date moment;
	private OrderStatus status;
	
	private Client client;
	private List<OrderItem> items = new ArrayList<>();
	
	public Order() {
	}
	
	public Order(Date moment, OrderStatus status, Client client) {
		this.moment = moment;
		this.status = status;
		this.client = client;
	}
	
	public Date getMoment() {
		return moment;
	}
	
	public void setMoment(Date moment) {
		this.moment = moment;
	}
	
	public OrderStatus getStatus() {
		return status;
	}
	
	public void setStatus(OrderStatus status) {
		this.status = status;
	}
	
	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	
	public List<OrderItem> getItems(){
		return items;
	}
	
	public void addItem(OrderItem item) {
		items.add(item);
	}
	
	public void removeItem(OrderItem item) {
		items.remove(item);
	}
	
	public Double total() {
		Double ret;
		double total = 0;
		for(OrderItem i : items) {
			total += i.subTotal();
		}
		ret = total;
		return ret;
	}
	
	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append("Order moment: ");
		s.append(sdf.format(moment));
		s.append("\nOrder Status: ");
		s.append(status);
		s.append("\nClient: ");
		s.append(client);
	    s.append("\nOrder items:\n");
	    for(OrderItem i : items) {
	    	s.append(i);
	    	s.append("\n");
	    }
	    s.append("Total price: $");
	    s.append(String.format("%.2f", total()));
	    return s.toString();
	}
}
