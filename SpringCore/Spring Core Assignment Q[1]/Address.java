package io.org.javaBrains;

public class Address {
	
	private int street;
	private String city;
	private int zip;
	private String country;
	
	/**
	 * for using CONSTRUCTOR INJECTION
	 */
	public Address(int street, String city, int zip, String country) {
		this.street = street;
		this.city = city;
		this.zip = zip;
		this.country = country;
	}
	public int getStreet() {return street;}
	//public void setStreet(int street) {this.street = street;}
	
	public String getCity() {return city;}
	//public void setCity(String city) {this.city = city;}
	
	public int getZip() {return zip;}
	//public void setZip(int zip) {this.zip = zip;}
	
	public String getCountry() {return country;}
	//public void setCountry(String country) {this.country = country;}
	@Override
	public String toString() {
		return "Address [street=" + street + ", city=" + city + ", zip=" + zip + ", country=" + country + "]";
}
}
