package com.shehan.preProgramAssignment.vehicles;

public abstract class Vehicle {
	
	//contains some variables which is common for all the vans,cars, and motorbikes
	private String ID;
	private String vehicleBrand;
	private DateAndTime dateAndTime;
	
	//returns the date and time
	public DateAndTime getDateAndTime() {
		return dateAndTime;
	}

	//set the date and time
	public void setDateAndTime(DateAndTime dateAndTime) {
		this.dateAndTime = dateAndTime;
	}

	//returns the id plate no
	public String getID() {
		return this.ID;
	}

	//set the id plate no
	public void setID(String iD) {
		this.ID = iD;
	}

	
	//returns the vehicle brand
	public String getVehicleBrand(){
		return this.vehicleBrand;
	}
	
	
	//set the vehicle brand for a particular vehicle
	public void setVehicleBrand(String brandName){
		this.vehicleBrand=brandName;
	}
	
}
