package function;

import java.io.*;
import java.util.Scanner;

import main.Data;
import user.*;


public class OwnerFunction {

	public Owner OwnerSelection(Owner owner){
		
		boolean check = false;
		do{
		System.out.println(" ");
		System.out.println("1. Add Employee");
		System.out.println("2. Add Business details");
		System.out.println("3. View Summaries booking"); 	//calculate the booking
		System.out.println("4. View New booking");  		// show new booking
		System.out.println("5. View available date times");
		System.out.println("6. Add Employee activity and time");
		System.out.println("7. Add booking");
		System.out.println("0. Logout");
		System.out.print("Please select a function:	");
		Scanner sc = new Scanner(System.in);
		String select = sc.nextLine();
		
		try {
			switch(select){
				
				case "1":{
					OwnerFunction.addEmployeeMenu();
					return OwnerSelection(owner);
				}
				case "2":{
					OwnerFunction.addBusinessMenu();
					return OwnerSelection(owner);
				}
				case "3":{
					GeneralFunction.viewBookingDetails("booking.txt");
					return OwnerSelection(owner);
				}
				case "4":{
					OwnerFunction.viewLatestBookingDetails();
					return OwnerSelection(owner);
				}
				case "5":{
					OwnerFunction.ViewWorkerAvailabilityDate();
					return OwnerSelection(owner);
				}
				case "6":{
					OwnerFunction.addActivityMenu();
					return OwnerSelection(owner);
				}
				case "7":{
					AddCustomerBooking();
					return OwnerSelection(owner);
				}
				case "0":{
					System.out.println("Your account has been exited");
					System.out.println("");
					break;
				}
				
				default:
				{
					System.out.println("Invalid selection.");
					check = true;
				}
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		while(check);
		return null;
	}
	
	public static void AddCustomerBooking() throws IOException{
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Please enter Customer name");
		String newname = sc.nextLine();
		System.out.println("Please enter Employee name");
		String newbookemployee = sc.nextLine();
		System.out.println("Please enter Booking date (DD/MM/YYYY)");
		String newbookdate = sc.nextLine();
		System.out.println("Please select activity");
		String newactivity = sc.nextLine();
		System.out.println("Please enter booking start time (hh/min)");
		String newbookstarttime = sc.nextLine();
		System.out.println("Please enter booking end time (hh/min)");
		String newbookendtime = sc.nextLine();
		

		boolean isBooked = Booking.addBooking(newname, newbookemployee, newbookdate, newactivity, newbookstarttime, newbookendtime);
		if(isBooked)
			System.out.println("Your new booking has been added");
		System.out.println("");		
	}
	
	public static void addBusinessMenu() throws IOException{
		
		Scanner sc = new Scanner(System.in);
		
		
		String username = null;
		String password = null;
		
		System.out.println("Please enter Business occupation");
		String businessName = sc.nextLine();
		
		System.out.println("Please enter Business name");
		String Name = sc.nextLine();
		
		System.out.println("Please enter Business address");
		String Address = sc.nextLine();
		
		System.out.println("Please enter Business number");
		String CNumber = sc.nextLine();
		
		System.out.println("Please enter the Business Hour ");
		String Businesshour = sc.nextLine();
		
		
		Owner tempBusiness = new Owner(username, password, businessName, Name, Address, CNumber, Businesshour);
		addBusiness(tempBusiness);
		
		System.out.println("Business added.");
		System.out.println("");
	}
	
	public static void addEmployeeMenu() throws IOException{
			
			Scanner sc = new Scanner(System.in);
			
			System.out.println("Please enter Employee name");
			String employeeName = sc.nextLine();
			
			System.out.println("Please enter the working date (DD/MM/YYYY)");
			String newDate = sc.nextLine();
			
			System.out.println("Please enter the working start time (Hr/Min)");
			String newstartTime = sc.nextLine();
			
			System.out.println("Please enter the working end time (Hr/Min)");
			String newendTime = sc.nextLine();
			
			System.out.println("Please select the activity");
			
			Activity[] activity = Data.ActivityDetails("activity.txt");
			for(int i=0; i<activity.length; i++){
				System.out.println(i + ". " + activity[i].getActivityname());
			}
			int selectActivity = Integer.parseInt(sc.nextLine());
			
			String newactivity = activity[selectActivity].getActivityname();
			
			Employee tempEmployee = new Employee(employeeName, newDate, newstartTime, newendTime, newactivity);
			addEmployee(tempEmployee);
			
			System.out.println("Employee added. You can check it at \"View available date\times\".");
			System.out.println("");
	}
	
	public static void addBusiness(Owner business){
		try{
			FileWriter fw = new FileWriter("business.txt",true);
			PrintWriter pw = new PrintWriter(new BufferedWriter(fw));
			
			pw.println(business.toString());
			pw.close();			
		}
		catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public static void addEmployee(Employee employee){
		try{
			FileWriter fw = new FileWriter("employee.txt",true);
			PrintWriter pw = new PrintWriter(new BufferedWriter(fw));
			
			pw.println(employee.toString());
			pw.close();			
		}
		catch (Exception e){
			e.printStackTrace();
		}
	}
		
	public static void ViewWorkerAvailabilityDate() throws FileNotFoundException, IOException 
	{
		GeneralFunction.displayEmployee();
	}
	
	
	
	public static void viewLatestBookingDetails() throws IOException, FileNotFoundException{
		Booking[] bookingDetails = Data.bookingDetails("booking.txt");
		
		System.out.println("Showing the latest booking");		
		System.out.format("|%20s|%20s|%20s\t|%30s|%20s|%20s|\n", "Cust. Name", "Emp. Name", "Date", "Activity", "Book Start time", "Book End time");
		
		int booking = Data.bookingLength-1;
		
		//Showing the latest 3 booking
		for(int i=0; i<3; i++){
			booking--;
			if(booking >= -1){
				String cName = bookingDetails[i].getBookName();
				String EName = bookingDetails[i].getBookEmployee();
				String activity = bookingDetails[i].getActivity();
				String bDate = bookingDetails[i].getBookDate();
				String bsTime = bookingDetails[i].getStartBookTime();
				String beTime = bookingDetails[i].getEndBookTime();
				System.out.format("|%20s|%20s|%20s\t|%30s|%20s|%20s|\n", cName, EName, activity, bDate, bsTime, beTime);
			}			
		}
	}
	public static void addActivityMenu() throws IOException{
		
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Please enter Activity name");
		String activityname = sc.nextLine();

		boolean checkInt = false;
		int duration = 0;
		do{
			try{
				System.out.println("Please enter the working duration in mins");
				duration = Integer.parseInt(sc.nextLine());
				checkInt = true;
			}
			catch(NumberFormatException nfe){
				checkInt = false;
			}
		}while(checkInt = false);
        
		boolean check = addActivity(activityname, duration);
		if(check)
			System.out.println(activityname + " has been added");
		System.out.println("");
	}
	
	public static boolean addActivity(String activityName, int activityTime) throws IOException{
		if(!activityName.equals(null) && activityTime != 0){
			FileWriter fw = new FileWriter("activity.txt",true);
			PrintWriter pw = new PrintWriter(new BufferedWriter(fw));
			
			//check for repetative activity
			Activity Activity = new Activity (activityName, activityTime); 
			
			pw.println(Activity.toString());
			pw.close();
			return true;
		}		
		return false;
	}
}
