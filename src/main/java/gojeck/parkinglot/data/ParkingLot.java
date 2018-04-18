package gojeck.parkinglot.data;

public class ParkingLot{
	private int slotNumber;
	private Car car;
	ParkingLot(int slotNo, Car c){
		this.slotNumber = slotNo;
		this.car = c;
	}
	public int getSlotNumber() {
		return slotNumber;
	}
	
	public Car getCar() {
		return car;
	}

	
}