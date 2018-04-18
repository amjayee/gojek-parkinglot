package gojeck.parkinglot.data;

public class Car{
	private String regNo;
	private String colour;
	
	public Car(String r, String c){
		this.regNo = r;
		this.colour = c;
	}

	public String getRegNo() {
		return regNo;
	}

	public String getColour() {
		return colour;
	}
}