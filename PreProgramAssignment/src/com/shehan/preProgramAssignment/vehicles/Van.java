package com.shehan.preProgramAssignment.vehicles;

public class Van extends Vehicle{
    
	//a private String variable which is common for a vans only
	private String cargoVolume; 
	public Van(){
	super();	
	}
	
	//returns the cargo value of a particular van
	public String getCargoVolume(){
		return this.cargoVolume;
	}

	//set the cargoVolume of a particular van
	public void setCargoVolume(String cargoVolume){
		this.cargoVolume=cargoVolume;
	}
}
