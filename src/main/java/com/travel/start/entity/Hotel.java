package com.travel.start.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Hotel {
	@Id
	private Long id;
    private String name;
    private String address;
    private int roomsAvailable;
    private double pricePerNight;
	public Hotel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Hotel(Long id, String name, String address, int roomsAvailable, double pricePerNight) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.roomsAvailable = roomsAvailable;
		this.pricePerNight = pricePerNight;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getRoomsAvailable() {
		return roomsAvailable;
	}
	public void setRoomsAvailable(int roomsAvailable) {
		this.roomsAvailable = roomsAvailable;
	}
	public double getPricePerNight() {
		return pricePerNight;
	}
	public void setPricePerNight(double pricePerNight) {
		this.pricePerNight = pricePerNight;
	}
	@Override
	public String toString() {
		return "Hotel [id=" + id + ", name=" + name + ", address=" + address + ", roomsAvailable=" + roomsAvailable
				+ ", pricePerNight=" + pricePerNight + "]";
	}
    
    

}
