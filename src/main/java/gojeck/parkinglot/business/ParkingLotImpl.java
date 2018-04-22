package gojeck.parkinglot.business;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeSet;

import gojeck.parkinglot.data.Car;

public class ParkingLotImpl{
	private int capacity;
	private int availability;
	private HashMap<Integer,Car> parkingLotMap ;
	private TreeSet<Integer> freeSlots;
	public ParkingLotImpl(int c){
		capacity =c;
		availability = c;
		parkingLotMap = new HashMap<Integer, Car>();
		freeSlots = new TreeSet<Integer>();
		for(int i=0;i<capacity;i++){
			parkingLotMap.put(i, null);
			freeSlots.add(i);
		}
	}
	
	public int parkCar(Car c){
		int nextAvail;
		if(availability == 0){
			return -1;
		}
		else{
			nextAvail = freeSlots.first();
			parkingLotMap.put(nextAvail, c);
			availability--;
			freeSlots.remove(nextAvail);
		}
		return (nextAvail+1);
	}
	
	public void leaveCar(int slotNum){
		availability++;
		freeSlots.add(slotNum);
		parkingLotMap.put(slotNum, null);
	}
	
	public void getStatus(){
		System.out.println("Slot No\tRegistration No\tColour");
		for(int i=0;i<capacity;i++){
			Car r = parkingLotMap.get(i);
			if(r != null){
				System.out.println(i+1 +"\t"+r.getRegNo()+"\t"+r.getColour());
			}
		}
	}
	
	public void getRegNumberForColor(String colour){
		List<String> res = new ArrayList<String>();
		for(int i=0;i<capacity;i++){
			Car r = parkingLotMap.get(i);
			if(r != null && colour.equals(r.getColour())){
				res.add(r.getRegNo());
			}
		}
		printStringList(res);
	}
	
	public void getSlotNumberForColor(String colour){
		List<Integer> res = new ArrayList<Integer>();
		for(int i=0;i<capacity;i++){
			Car r = parkingLotMap.get(i);
			if(r != null && colour.equals(r.getColour())){
				res.add(i+1);
			}
		}
		printIntegerList(res);
	}
	
	public int getSlotNumberForReqNumber(String regNum){
		int res=-1;
		for(int i=0;i<capacity;i++){
			Car r = parkingLotMap.get(i);
			if(r != null && regNum.equals(r.getRegNo())){
				res = i+1;
			}
		}
		return res;
	}
	
	private void printStringList(List<String> list){
		int i=0;
		for(i=0;i<list.size()-1;i++){
			System.out.print(list.get(i)+", ");
		}
		System.out.println(list.get(i));
	}
	
	private void printIntegerList(List<Integer> list){
		int i=0;
		for(i=0;i<list.size()-1;i++){
			System.out.print(list.get(i)+", ");
		}
		System.out.println(list.get(i));
	}
	
	
}