package com.spallya.model;

public class Flat {
	private String street;
	private String city;
	private int zip;
	private String state;
	private int beds;
	private int baths;
	private int sqFeet;
	private String type;
	private String saleDate;
	private int price;
	private float latitude;
	private float longitude;
	String sp = "**";

	public Flat(String street, String city, int zip, String state, int beds, int baths, int sqFeet, String type,
			String saleDate, int price, float latitude, float longitude) {
		this.street = street;
		this.city = city;
		this.zip = zip;
		this.state = state;
		this.beds = beds;
		this.baths = baths;
		this.sqFeet = sqFeet;
		this.type = type;
		this.saleDate = saleDate;
		this.price = price;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getZip() {
		return zip;
	}

	public void setZip(int zip) {
		this.zip = zip;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getBeds() {
		return beds;
	}

	public void setBeds(int beds) {
		this.beds = beds;
	}

	public int getBaths() {
		return baths;
	}

	public void setBaths(int baths) {
		this.baths = baths;
	}

	public int getSqFeet() {
		return sqFeet;
	}

	public void setSqFeet(int sqFeet) {
		this.sqFeet = sqFeet;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSaleDate() {
		return saleDate;
	}

	public void setSaleDate(String saleDate) {
		this.saleDate = saleDate;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public float getLatitude() {
		return latitude;
	}

	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}

	public float getLongitude() {
		return longitude;
	}

	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}

	@Override
	public String toString() {
		return String.format("%-32s%-18s%-8s%-7s%-5s%-7s%-7s%-13s%-30s%-8s%-10s%-10s", street, city, zip, state, beds,
				baths, sqFeet, type, saleDate, price, latitude, longitude);
	}

}
