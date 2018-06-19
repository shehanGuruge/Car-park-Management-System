package com.shehan.preProgramAssignment.vehicles;

public class Motorbike extends Vehicle{
    //a private variable which is common for motor bikes only
	private String engineSize;
	
	public Motorbike() {
		super();
	}
	
	//returns the engine size of a particular engine object
	public String getEngineSize() {
		return engineSize;
	}
	
	//set the engine size of a particular bike
	public void setEngineSize(String engineSize) {
		this.engineSize = engineSize;
	}

}
