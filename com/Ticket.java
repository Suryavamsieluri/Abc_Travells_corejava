package com;

import java.time.LocalDate;

public class Ticket {
	private String boarding;
	private String droping;
	private int price;
	private int seats;
	private LocalDate date;
	public int getSeats() {
		return seats;
	}
	public void setSeats(int seats) {
		this.seats = seats;
	}
	public String getBoarding() {
		return boarding;
	}
	public void setBoarding(String boarding) {
		this.boarding = boarding;
	}
	public String getDroping() {
		return droping;
	}
	public void setDroping(String droping) {
		this.droping = droping;
	}
	public int getPrice() {
		return price;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	public Ticket(String boarding, String droping, int price, int seats,LocalDate date) {
		super();
		this.seats=seats;
		this.boarding = boarding;
		this.droping = droping;
		this.price = price;
		this.date=date;
	}
	@Override
	public String toString() {
		return "Ticket [boarding=" + boarding + ", droping=" + droping + ", price=" + price + ", seats=" + seats
				+ ", date=" + date + "]";
	}

}
