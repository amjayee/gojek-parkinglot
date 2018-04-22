package gojeck.parkinglot.business;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import gojeck.parkinglot.data.Car;

public class ParkingLotImplTest{
	
	ParkingLotImpl parkingLotImpl;
	
	@Before
	public void property() throws Exception
	{
		
	}
	
	@Test
	public void testParkCar_availableSpace(){
		parkingLotImpl = new ParkingLotImpl(1);
		int actual = parkingLotImpl.parkCar(new Car("1234","white"));
		assertEquals(1, actual);
	}
	
	@Test
	public void testParkCar_No_availableSpace(){
		parkingLotImpl = new ParkingLotImpl(0);
		int actual = parkingLotImpl.parkCar(new Car("1234","white"));
		assertEquals(-1, actual);
	}

	
	@Test
	public void testGetSlotNumberForReqNumber_car_Present(){
		parkingLotImpl = new ParkingLotImpl(1);
		parkingLotImpl.parkCar(new Car("1234","white"));
		int actual = parkingLotImpl.getSlotNumberForReqNumber("1234");
		assertEquals(1, actual);
	}
	
	@Test
	public void testGetSlotNumberForReqNumber_car_not_Present(){
		parkingLotImpl = new ParkingLotImpl(1);
		parkingLotImpl.parkCar(new Car("1234","white"));
		int actual = parkingLotImpl.getSlotNumberForReqNumber("2345");
		assertEquals(-1, actual);
	}
	
	
}