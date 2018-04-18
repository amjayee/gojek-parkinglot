package gojeck.parkinglot.buisness;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import gojeck.parkinglot.data.Car;
import gojeck.parkinglot.data.Commands;

public class ParkingLotMain{
	public static void main(String[] args){
		ParkingLotImpl parkingLot;
		File f = new File("/Users/m0j00b9/Documents/workspace/gojeck.parkinglot/file_inputs.txt");
		try {
			Scanner sc = new Scanner(f);
			String line, command;
			String regNo, colour;
			int parkingres;
			int num;
			line = sc.nextLine();
			int count= Integer.parseInt(line.split(" ")[1]);
			parkingLot = new ParkingLotImpl(count);
			System.out.println("Created a parking lot with "+count+" slots");
			while(sc.hasNextLine()){
				line = sc.nextLine();
				String[] commandLine = line.split(" ");
				command = commandLine[0];
				switch(Commands.getCommand(command)){
				case LEAVE:
					num = Integer.parseInt(commandLine[1]);
					parkingLot.leaveCar(num-1);
					System.out.println("Slot number "+num+" is free");
					break;
				case PARK:
					regNo = commandLine[1];
					colour = commandLine[2];
					parkingres =parkingLot.parkCar(new Car(regNo, colour));
					if(parkingres != -1){
						System.out.println("Allocated Slot Number: "+parkingres);
					}
					else
						System.out.println("Sorry, parking lot is full");
					break;
				case REG_NUMBERS:
					colour = commandLine[1];
					parkingLot.getRegNumberForColor(colour);
					break;
				case SLOT_COLOUR:
					break;
				case SLOT_REG:
					break;
				case STATUS:
					parkingLot.getStatus();
					break;
				default:
					break;
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		}
	}
}