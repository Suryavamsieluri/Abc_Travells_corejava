package com;

import java.util.HashMap;
import java.util.Map;

public class Bus {
	private String startPoint;
	private String endPoint;
	private int seats;
	private int price;
	public Map<String,Integer> dateAndSeat;
	
	
	public String getStartPoint() {
		return startPoint;
	}
	public void setStartPoint(String startPoint) {
		this.startPoint = startPoint;
	}
	public String getEndPoint() {
		return endPoint;
	}
	public void setEndPoint(String endPoint) {
		this.endPoint = endPoint;
	}
	public int getSeats() {
		return seats;
	}
	public void setSeats(int seats) {
		this.seats = seats;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Bus [startPoint=" + startPoint + ", endPoint=" + endPoint + ", seats=" + seats + ", price=" + price
				+ "]";
	}
	public Bus(String startPoint, String endPoint, int seats, int price) {
		super();
		this.startPoint = startPoint;
		this.endPoint = endPoint;
		this.seats = seats;
		this.price = price;
		dateAndSeat=new HashMap();
	}
	 
	
	
}

