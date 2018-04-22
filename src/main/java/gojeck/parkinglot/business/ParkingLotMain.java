package gojeck.parkinglot.business;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import gojeck.parkinglot.data.Car;
import gojeck.parkinglot.data.Commands;

public class ParkingLotMain{
	public static void main(String[] args){
		ParkingLotImpl parkingLot;
		
		Scanner sc ;
		try {
			
			if(args.length > 0){
				String fileName = args[0];
				File f = new File(fileName);
				sc = new Scanner(f);
			}
			else
				sc = new Scanner(System.in);
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
					colour = commandLine[1];
					parkingLot.getSlotNumberForColor(colour);
					break;
				case SLOT_REG:
					regNo = commandLine[1];
					parkingres = parkingLot.getSlotNumberForReqNumber(regNo);
					if(parkingres != -1){
						System.out.println(parkingres);
					}
					else
						System.out.println("Not Found");
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