package gojeck.parkinglot.data;

import gojeck.parkinglot.utils.Constants;

public enum Commands{
	
	CREATE,PARK,LEAVE,STATUS, REG_NUMBERS, SLOT_COLOUR, SLOT_REG;
	
	public static Commands getCommand(String comm){
		if(Constants.CREATE.equals(comm))
				return CREATE;
		else if(Constants.PARK.equals(comm))
			return PARK;
		else if(Constants.LEAVE.equals(comm))
			return LEAVE;
		else if(Constants.STATUS.equals(comm))
			return STATUS;
		else if(Constants.REG_NUMBERS.equals(comm))
			return REG_NUMBERS;
		else if(Constants.SLOT_COLOUR.equals(comm))
			return SLOT_COLOUR;
		else if(Constants.SLOT_REG.equals(comm))
			return SLOT_REG;
		else
			return null;
		
	}
}