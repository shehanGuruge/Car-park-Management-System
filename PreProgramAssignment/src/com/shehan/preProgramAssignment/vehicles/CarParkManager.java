package com.shehan.preProgramAssignment.vehicles;

public interface CarParkManager{
	
	//Consists of abstract methods for different functions.
	//for usage these will be overrided by the implemented sub  class which is WestminsterCarPark
	public abstract void displayMenu();
	public abstract void addVehicle();
	public abstract void deleteVehicle();
	public abstract void vehicleList();
	public abstract void printStatistics();
	public abstract void parkingFee();
	public abstract void detailedReport();
	public abstract void validateTime();
	public abstract void validateCurrentTime();
	public abstract void validateDate();
}

