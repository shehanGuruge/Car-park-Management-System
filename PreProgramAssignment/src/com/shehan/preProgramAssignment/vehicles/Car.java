package com.shehan.preProgramAssignment.vehicles;

public class Car extends Vehicle{
	
	//2 private String variables which is common for only cars
	private String noOfDoors;
	private String color;
	
	public Car() {
		super();
	}

	//return the number of doors of a particular car object
	public String getNoOfDoors(){
		return this.noOfDoors;
	}
	
	//set the no of doors of a particular car
	public void setNoOfDoors(String noOfDoors){
		this.noOfDoors=noOfDoors;
	}
	
	//return the color of a particular car
	public String getColor(){
		return this.color;
	}
	
	//set the color of a particular car
	public void setColor(String color){
		this.color=color;
	}
}
