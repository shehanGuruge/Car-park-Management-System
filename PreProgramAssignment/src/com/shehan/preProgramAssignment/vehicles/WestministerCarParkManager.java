package com.shehan.preProgramAssignment.vehicles;

import java.util.Scanner;

public class WestministerCarParkManager implements CarParkManager{
	private static Vehicle[] vehicle=new Vehicle[20];//Vehicle object array
	private static String[] vehicleType=new String[20];//vehicle type array of string for ezxampe car,bike and vans are considered as vehicle types in this program
	private static Car[] car=new Car[20];//car object array
	private static Van[] van=new Van[20];//van object arraty
	private static Motorbike[] bike= new Motorbike[20];//bike object array



	private static String input ;//stores each and every string user input
	private static Scanner sc=new Scanner(System.in);//a scanner object inorder to get the inputs from the user
	private static int vehicleCounter=0;
	private static String type;//stores the type of the vehicle
	private static int counter=0;//counts the number of vehicles in the array
	private static boolean trueOrFalse=false;//the do while loop ends when this variable becomes true
	private static String vehicleId;//stores the vehicle id
	private static String brand;//stores the vehicle brand
	private static int hour;//stores the hour in the time
	private static int min;//stores the minutes in the time
	private static int day;//stores the day in the date
	private static int month=1;//stores the month in the date 
	private static int year;//stores the year in the date
	private static int remainingSlots=20;//stores the amount of available slots and is initially declared to array length of 20

	private static int currentHour=0;//stores the user input of current hour
	private static int currentMins=0;//stores the user input of current minutes

	public static void main(String[] args){
		//making an object of the current class
		WestministerCarParkManager obj=new WestministerCarParkManager();

		//calling the displayMenu method
		obj.displayMenu();	
	}


	//Overriden display menu method. The menu options from the user are taken from this method and according to those inputs
	//the relevant other methods are called for different purposes
	@Override
	public void displayMenu() {


		System.out.println("\n\n============Welcome to the Westminister Car Park==========");
		System.out.println("Park your vehicle securely.");
		System.out.println("Menu options are listed below.\n");
		System.out.println("A. Add the vehicle to the car park.");
		System.out.println("D. Delete the vehicle if it's leaving.");
		System.out.println("P. Print the list of vehicles currently parked.");
		System.out.println("S. Print some statistics.");
		System.out.println("F. Get the parking fee.");
		System.out.println("R. Detailed Report (list of vehicles parked in a particular day).");
		System.out.println("C. Close the Westminister Car Park application.\n");
		System.out.print("Enter the option: ");
		do{
			input=sc.nextLine();
			switch(input.toUpperCase()){
			case "A" :
				if(counter<20){
					addVehicle();
				}else{
					System.err.println("No slots are currently available ");
					displayMenu();
				}
				break;
			case "D":
				if(counter>0){
					deleteVehicle();
				}else{
					System.err.println("No vehicles are currently added to the list to satisfy this function");
					displayMenu();
				}
				break;
			case "P":
				if(counter>=0){
					vehicleList();
				}else{
					System.out.println("List is Empty!!");
					displayMenu();
				}
				break;
			case "S":
				if(counter>0){
					printStatistics();
				}else{
					System.out.println("Statistics are currently unavailable");
					displayMenu();
				}
				break;
			case "F":
				if(counter>0){
					parkingFee();
				}else{
					System.out.println("Fee Calculation failed(Reasons)\n*Vehicles are not currently available \n*Inputs may not valid");
					displayMenu();
				}
				break;
			case "R":
				if(counter>0){
					detailedReport();
				}else{
					System.out.println("Warning! Detailed Report is empty");
					displayMenu();
				}
				break;
			case "C":

				//Application termination based on the user inputs
				System.err.println("Are you sure to exit from this application(Y/N)?\nEnter (Y) for Yes and (N) for No");
				System.out.println("\n");
				System.out.print("Enter the option: ");
				input=sc.nextLine();
				if(input.equalsIgnoreCase("Y") || input.equalsIgnoreCase("YES")){
					System.out.println("***********Good Bye!!**************");
					System.out.println("***********Have a good day************");
					trueOrFalse=false;
					break;
				}else if(input.equalsIgnoreCase("N")|| input.equalsIgnoreCase("NO")){
					trueOrFalse=true;
					displayMenu();
				}else{
					System.err.print("Invalid option.Please enter the correct option: ");
				}
			default:

				System.out.println("#############################  Invalid inputs  ############################");
				System.out.println("\n");
				displayMenu();
			}
		}while(trueOrFalse==true);
	}

	//adding a vehicle to the car park
	@Override
	public void addVehicle() {


		System.out.print("Enter the vehicle ID: ");
		vehicleId=sc.nextLine();
		System.out.print("Enter the vehicle brand: ");
		brand=sc.nextLine();
		System.out.print("\nEnter the vehicle type(Enter (C) for Car,Enter (V) for Van,Enter (B) for Bike): ");
		type=sc.nextLine();
		if(type.equalsIgnoreCase("C")|| type.equalsIgnoreCase("v") || type.equalsIgnoreCase("b")){



			System.out.print("Enter the today's day: ");
			day=sc.nextInt();
			validateDate();
			System.out.print("Enter the current month: ");
			month=sc.nextInt();
			validateDate();
			System.out.print("Enter the current year: ");
			year=sc.nextInt();


			System.out.println("\nEntrance Time");
			System.out.println("Enter the current hour: ");
			hour=sc.nextInt();
			validateTime();
			System.out.println("Enter the current minute: ");
			min=sc.nextInt();
			validateTime();

			DateAndTime d=new DateAndTime(day, month, year, hour, min );

			if(type.equalsIgnoreCase("C")){
				car[counter]=new Car();
				vehicle[counter]=new Car();

				if(vehicle[counter].getID()==null){

					System.out.println("Enter the number of doors: ");
					car[counter].setNoOfDoors(sc.next());
					System.out.print("\nEnter the color: ");
					car[counter].setColor(sc.nextLine());
					vehicleType[counter]="car";


					vehicle[counter].setID(vehicleId);
					vehicle[counter].setVehicleBrand(brand);
					vehicle[counter].setDateAndTime(d);

					System.out.println("Vehicle with Id number: "+vehicle[counter].getID()+" is successfully added to the slot No. : "+(counter+1));
					counter++;
					remainingSlots=remainingSlots-1;
					System.out.println("Number of slots currently available: "+remainingSlots);
					vehicleCounter++;

				}
			}else if(type.equalsIgnoreCase("v")){
				van[counter]=new Van();
				vehicle[counter]=new Van();

				if(vehicle[counter].getID()==null){

					System.out.println("Enter the cargo volume: ");
					van[counter].setCargoVolume(sc.next());
					vehicleType[counter]="van";
					vehicle[counter].setID(vehicleId);
					vehicle[counter].setVehicleBrand(brand);
					vehicle[counter].setDateAndTime(d);

					System.out.println("Vehicle with Id number: "+vehicle[counter].getID()+" is successfully added to the slot No. : "+(counter+1));
					remainingSlots=remainingSlots-2;
					System.out.println("Number of slots currently available: "+remainingSlots);
					counter=counter+2;
					vehicleCounter++;
				}
			}else if(type.equalsIgnoreCase("b")){
				bike[counter]=new Motorbike();
				vehicle[counter]=new Motorbike();

				if(vehicle[counter].getID()==null){

					System.out.println("Enter the engine capacity: ");
					bike[counter].setEngineSize(sc.nextLine());
					vehicleType[counter]="bike";


					vehicle[counter].setID(vehicleId);
					vehicle[counter].setVehicleBrand(brand);
					vehicle[counter].setDateAndTime(d);

					System.out.println("Vehicle with Id number: "+vehicle[counter].getID()+" is successfully added to the slot No. : "+(counter+1));
					remainingSlots=remainingSlots-1;
					System.out.println("Number of slots currently available: "+remainingSlots);
					counter++;
					vehicleCounter++;
				}
			}
		}else{
			System.out.println("#########   Invalid option  #############");
			System.out.println(" ");
			addVehicle();
		}
		displayMenu();
	}


	//deleting a vehicle from the car park when a vehicle leaves
	@Override
	public void deleteVehicle() {

		int c=0;
		System.out.print("Enter the vehicle Id: ");
		String deleteId=sc.nextLine();
		for(int i=0;i<vehicle.length;i++){
			try{
				if(vehicle[i].getID().equals(deleteId)){
					c++;
					vehicle[i].setID(null);	
					vehicle[i].setDateAndTime(null);
					vehicle[i].setVehicleBrand(null);


					if(vehicleType[i].equalsIgnoreCase("car")){
						vehicleCounter--;
						remainingSlots++;
						System.out.println("<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>>>>\n");
						System.out.println("Vehicle Type: Car successfully deleted");
						car[i].setColor(null);
						car[i].setNoOfDoors(null);
						vehicleType[i]=null;
						break;

					}else if(vehicleType[i].equalsIgnoreCase("van")){
						vehicleCounter--;
						remainingSlots+=2;
						System.out.println("<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>>>>\n");
						System.out.println("Vehicle Type: Van successfully deleted");
						van[i].setCargoVolume(null);
						vehicleType[i]=null;
						break;

					}else if(vehicleType[i].equalsIgnoreCase("bike")){
						vehicleCounter--;
						remainingSlots++;
						System.out.println("<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>>>>\n");
						System.out.println("Vehicle Type: Bike successfully deleted");
						bike[i].setEngineSize(null);
						vehicleType[i]=null;
						break;
					}

				}else if(i==vehicle.length-1){
					System.err.println("Vehicle with Id No. "+deleteId+" doesn't exist");


				}else{
					continue;
				}

			}catch(Exception e){
				continue;
			}
		}

		displayMenu();
	}


	//printing the list of vehicles currently parked
	@Override
	public void vehicleList() {

		String[] array;
		System.out.println("=============================== Details of the vehicles currently parked ==================================");
		for(int i=19;i>=0;i--){
			try{
				if(vehicle[i].getID()!=null){
					System.out.println((i+1)+". Vehicle Id: "+vehicle[i].getID()+"\nVehicle Entry Time: "+vehicle[i].getDateAndTime().getHours()+":"+vehicle[i].getDateAndTime().getMinutes()+"\nVehicle Type: "+vehicleType[i]+"\n");
				}else{
					continue;
				}
			}catch(Exception e){
				continue;
			}
		}
		displayMenu();
	}


	//displaying the percentage of cars,vans,bikes currently parked in the car park and dispalying the details of the
	// vehicle which is parked for the longest time 
	//and the last vehicle which arrived to the car park
	@Override
	public void printStatistics() {

		int carCounter=0;
		int vanCounter=0;
		int bikeCounter=0;

		System.out.println("==============================Statistics======================================");
		for(int i=0;i<vehicle.length;i++){
			try{
				if(vehicleType[i].equalsIgnoreCase("car")){
					carCounter++;
				}else if(vehicleType[i].equalsIgnoreCase("van")){
					vanCounter++;
				}else if(vehicleType[i].equalsIgnoreCase("bike")){
					bikeCounter++;
				}
			}catch(Exception e){
				continue;
			}
		}
		//Calculating the percentage
		double carPercentage=(double)carCounter*100/vehicleCounter;
		double vanPercentage=(double)vanCounter*100/vehicleCounter;
		double bikePercentage=(double)bikeCounter*100/vehicleCounter;

		System.out.println("\nPercentage of Cars parked: "+carPercentage);
		System.out.println("Percentage of Vans parked: "+vanPercentage);
		System.out.println("Percentage of Bikes parked: "+bikePercentage);


		//Finding out which vehicle is parked for the longest time in the car park

		System.out.print("Enter the current hour: ");
		currentHour=sc.nextInt();
		validateCurrentTime();
		System.out.print("Enter the current minutes: ");
		currentMins=sc.nextInt();
		validateCurrentTime();



		int maxTime=0;

		for(int i=0;i<vehicle.length;i++){
			try{
				if(vehicle[i].getDateAndTime().getDay()<vehicle[i+1].getDateAndTime().getDay()){
					maxTime=i+1;
				}else if(vehicle[i].getDateAndTime().getDay()==vehicle[i+1].getDateAndTime().getDay()){
					if(vehicle[i].getDateAndTime().getHours()<vehicle[i+1].getDateAndTime().getHours()){
						maxTime=i+1;

					}else if(vehicle[i].getDateAndTime().getHours()==vehicle[i+1].getDateAndTime().getHours()){
						if(vehicle[i].getDateAndTime().getMinutes()<vehicle[i+1].getDateAndTime().getMinutes()){
							maxTime=i+1;
						}else if(vehicle[i].getDateAndTime().getMinutes()==vehicle[i+1].getDateAndTime().getMinutes()){
							maxTime=i;
						}else if(vehicle[i].getDateAndTime().getMinutes()>vehicle[i+1].getDateAndTime().getMinutes()){
							maxTime=i;
						}
					}else if(vehicle[i].getDateAndTime().getHours()>vehicle[i+1].getDateAndTime().getHours()){
						maxTime=i;
					}
				}else{
					maxTime=i;
				}



			}catch(Exception e){
				continue;

			}
		}

		System.out.println("\n---------------Vehicle parked for the longest time----------------------");
		System.out.println("Vehicle Id: "+vehicle[maxTime].getID()+"\nVehicle Type: "+vehicleType[maxTime]+"\nEntrance Date: "+vehicle[maxTime].getDateAndTime().getDay()
				+"/"+vehicle[maxTime].getDateAndTime().getMonth()+"/"+vehicle[maxTime].getDateAndTime().getYear()+"\nEntrance Time: "
				+vehicle[maxTime].getDateAndTime().getHours()+":"+vehicle[maxTime].getDateAndTime().getMinutes());


		System.out.println("\n----------------Vehicle reached last to the car park----------------------");


		//Finding out which vehicle arrived last in the car park
		int latestVehicleIndex=0;
		for(int i=0;i<vehicle.length;i++){
			try{
				if(vehicle[i].getDateAndTime().getMonth()<vehicle[i+1].getDateAndTime().getMonth()){
					latestVehicleIndex=i+1;
				}else if(vehicle[i].getDateAndTime().getMonth()>vehicle[i+1].getDateAndTime().getMonth()){
					latestVehicleIndex=i;
				}else{
					if(vehicle[i].getDateAndTime().getDay()>vehicle[i+1].getDateAndTime().getDay()){
						latestVehicleIndex=i;
					}else if(vehicle[i].getDateAndTime().getDay()<vehicle[i+1].getDateAndTime().getDay()){
						latestVehicleIndex=i+1;
					}else{
						if(vehicle[i].getDateAndTime().getHours()>vehicle[i+1].getDateAndTime().getHours()){
							latestVehicleIndex=i;
						}else if(vehicle[i].getDateAndTime().getHours()<vehicle[i+1].getDateAndTime().getHours()){
							latestVehicleIndex=i+1;
						}else{
							if(vehicle[i].getDateAndTime().getMinutes()>vehicle[i+1].getDateAndTime().getMinutes()){
								latestVehicleIndex=i;
							}else if(vehicle[i].getDateAndTime().getMinutes()<vehicle[i+1].getDateAndTime().getMinutes()){
								latestVehicleIndex=i+1;
							}else{
								latestVehicleIndex=i;
							}
						}
					}
				}
			}catch(Exception ec){
				continue;
			}
		}
		System.out.println("Vehicle Id: "+vehicle[latestVehicleIndex].getID()+"\nVehicle Type: "+vehicleType[latestVehicleIndex]+"\nEntrance Date: "+vehicle[latestVehicleIndex].getDateAndTime().getDay()+"/"+vehicle[latestVehicleIndex].getDateAndTime().getMonth()
				+"/"+vehicle[latestVehicleIndex].getDateAndTime().getYear()+"\nEntrance time: "+vehicle[latestVehicleIndex].getDateAndTime().getHours()+":"+vehicle[latestVehicleIndex].getDateAndTime().getMinutes());

		displayMenu();
	}


	//calculation of the parking fee
	@Override
	public void parkingFee() {
		// TODO Auto-generated method stub
		System.out.print("Enter the current hour: ");
		currentHour=sc.nextInt();
		validateCurrentTime();
		int totalCost=0;
		int time=0;
		for(int i=0;i<vehicle.length;i++){
			try{
				if(vehicle[i].getID()==null){
					continue;
				}else{
					if((currentHour-vehicle[i].getDateAndTime().getHours())<=3 && (currentHour-vehicle[i].getDateAndTime().getHours())>0){
						totalCost=totalCost+((currentHour-vehicle[i].getDateAndTime().getHours())*1);
						System.out.println("\n"+(i+1)+". Vehicle ID: "+vehicle[i].getID()+"\nTotal Parking Fee: "+totalCost+" pounds");
					}else if((currentHour-vehicle[i].getDateAndTime().getHours())>3){
						totalCost=totalCost+3+(((currentHour-vehicle[i].getDateAndTime().getHours())-3)*1);
						System.out.println("\n"+(i+1)+". Vehicle ID: "+vehicle[i].getID()+"\nTotal Parking Fee: "+totalCost+" pounds");
					}else if(currentHour==24){
						totalCost=totalCost+30;
						System.out.println("\n"+(i+1)+". Vehicle ID: "+vehicle[i].getID()+"\nTotal Parking Fee: "+totalCost+" pounds");
					}else if((currentHour-vehicle[i].getDateAndTime().getHours())<=0){
						time=(24-vehicle[i].getDateAndTime().getHours())+currentHour;
						if(time<=3 && time>0){
							totalCost=totalCost+((currentHour-vehicle[i].getDateAndTime().getHours())*1);
							System.out.println("\n"+(i+1)+". Vehicle ID: "+vehicle[i].getID()+"\nTotal Parking Fee: "+totalCost+" pounds");
						}else if(time>3){
							totalCost=totalCost+3+(((currentHour-vehicle[i].getDateAndTime().getHours())-3)*1);
							System.out.println("\n"+(i+1)+". Vehicle ID: "+vehicle[i].getID()+"\nTotal Parking Fee: "+totalCost+" pounds");
						}else if(time==24){
							totalCost=totalCost+30;
							System.out.println("\n"+(i+1)+". Vehicle ID: "+vehicle[i].getID()+"\nTotal Parking Fee: "+totalCost+" pounds");
						}
					}
				}
			}catch(Exception e){
				continue;
			}
		}
		displayMenu();
	}


	//displaying the details about vehicles which have been parked for a particular date
	@Override
	public void detailedReport() {
		// TODO Auto-generated method stub
		System.out.print("Enter the Day: ");
		int day=sc.nextInt();
		System.out.print("Enter the Month: ");
		int month=sc.nextInt();
		System.out.println("Enter the Year: ");
		int year=sc.nextInt();
		boolean tf=false;
		System.out.println("============================================ Detailed Report ================================================");
		for(int i=0;i<vehicle.length;i++){
			try{
				if((day==vehicle[i].getDateAndTime().getDay()) && (month==vehicle[i].getDateAndTime().getMonth()) && (year==vehicle[i].getDateAndTime().getYear())){
					System.out.println("\n\nVehicle Id: "+vehicle[i].getID()+"\nVehicle Brand: "+vehicle[i].getVehicleBrand()+"\nEntrance time: "+vehicle[i].getDateAndTime().getHours()+":"+vehicle[i].getDateAndTime().getMinutes()
							+"\nEntrance Date: "+vehicle[i].getDateAndTime().getDay()+"/"+vehicle[i].getDateAndTime().getMonth()+"/"+vehicle[i].getDateAndTime().getYear()+"\nVehicle Type: "+vehicleType[i]);
					tf=true;
				}
			}catch(Exception e){
				continue;
			}
		}
		if(tf==false){
			System.out.println("\nNo vehicles are parked on "+day+"/"+month+"/"+year);
		}
		displayMenu();
	}


	//Validation of time
	@Override
	public void validateTime() {
		// TODO Auto-generated method stub
		if(hour<0 || hour>=24){
			System.out.println("############################ Warning!!!Hour entered is invalid  ##########################");
			System.out.print("Enter the entrance hour: ");
			hour=sc.nextInt();
		}else if(min>60){
			System.out.println("########################### Warning!!!Minutes entered are invalid ########################");
			System.out.print("Enter the entrance minutes: ");
			min=sc.nextInt();
		}

	}


	//Validation of Date
	@Override
	public void validateDate() {
		// TODO Auto-generated method stub
		if(month>12 || month<=0){
			System.out.println("################################# Warning!!! The month you entered is invalid ######################");	
			System.out.print("\nEnter the current month: ");
			month=sc.nextInt(); 
		}else if((month==1 ||  month==3 || month==5 || month==7 || month==8 || month==10 || month==12) && (day>31 || day<=0)){
			System.out.println("########################## Warning!!!The day you entered is invalid #############################");	
			System.out.print("\nEnter the current day: ");
			day=sc.nextInt();
		}else if((month==2 ||  month==4 || month==6 || month==9 || month==11) && (day>30|| day<=0)){
			System.out.println("############################  Warning!!! The day you entered is invalid  ##########################");	
			System.out.print("\nEnter the current day: ");
			day=sc.nextInt();
		}
	}


	//Validating the user entered current time
	@Override
	public void validateCurrentTime() {
		// TODO Auto-generated method stub
		if(currentHour<0 || currentHour>=24){
			System.out.println(" #########################  Warning!!!Hour entered is invalid   ######################################");
			System.out.print("\nEnter the current hour: ");
			currentHour=sc.nextInt();
		}else if(currentMins>60){
			System.out.println(" #########################  Warning!!!Minutes entered is invalid   ######################################");
			System.out.print("\nEnter the current minutes: ");
			currentMins=sc.nextInt();
		}

	}


}


