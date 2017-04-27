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
		System.out.println("2. View Summaries booking"); 	//calculate the booking
		System.out.println("3. View New booking");  		// show new booking
		System.out.println("4. View available date times");
		System.out.println("5. Add Employee activity and time");
		System.out.println("6. Add Customer booking");
		System.out.println("0. Logout");
		System.out.print("Please select a function:	");
		Scanner sc = new Scanner(System.in);
		String select = sc.nextLine();
		
		try {
			switch(select){
				
				case "1":{
					OwnerFunction.AddEmployee();
					return OwnerSelection(owner);
				}
				case "2":{
					GeneralFunction.viewAllBookingDetails();
					return OwnerSelection(owner);
				}
				case "3":{
					OwnerFunction.viewLatestBookingDetails();
					return OwnerSelection(owner);
				}
				case "4":{
					OwnerFunction.ViewWorkerAvailabilityDate();
					return OwnerSelection(owner);
				}
				case "5":{
					OwnerFunction.AddActivityandTime();
					return OwnerSelection(owner);
				}
				case "6":{
					OwnerFunction.AddCustomerBooking(owner);
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
	
	public static void AddEmployee() throws IOException{
		FileWriter fw = new FileWriter("employee.txt",true);
		PrintWriter pw = new PrintWriter(new BufferedWriter(fw));
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Please enter Employee name");
		String employeeName = sc.nextLine();
		
		System.out.println("Please enter the working time (Hr/Min)");
		String newTime = sc.nextLine();
		
		System.out.println("Please enter the working date (DD/MM/YYYY)");
		String newDate = sc.nextLine();
		
		Employee Employee = new Employee (employeeName, newDate, newTime); //Need to create user Employee
		
		pw.println(Employee.toString());
		System.out.println("New employee " + Employee.getEmployeeName() + " has been added");
		System.out.println("");
		pw.close();
	}
	
	public static void AddActivityandTime() throws IOException{
		FileWriter fw = new FileWriter("activity.txt",true);
		PrintWriter pw = new PrintWriter(new BufferedWriter(fw));
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Please enter Employee name");
		String employeename = sc.nextLine();
		
		System.out.println("Please enter the Activity name");
		String activityname = sc.nextLine();
		
		System.out.println("Does any comment?");
		String comment = sc.nextLine();
		
		System.out.println("Please enter the working duration");
		String duration = sc.nextLine();    
        
		Activity Activity = new Activity (employeename, activityname, duration, comment); 
		
		pw.println(Activity.toString());
		System.out.println("New employee " + Activity.getEmployeeName() + " has been added");
		System.out.println("");
		
		pw.close();
		
		
	}
		
	public static void ViewWorkerAvailabilityDate() throws FileNotFoundException, IOException 
	{
		GeneralFunction.employeeAvailability();
	}
	
	public static void viewLatestBookingDetails() throws IOException, FileNotFoundException{
		Booking[] bookingDetails = Data.bookingDetails("booking.txt");
		
		System.out.println("Showing the latest booking");		
		System.out.format("|%20s|%s\t|%s\t|%20s|\n", "Cust. Name", "Date", "Time", "Emp. Name");
		
		int booking = Data.bookingLength-1;
		
		//Showing the latest 3 booking
		for(int i=0; i<3; i++){
			booking--;
			if(booking >= -1){
				String cName = bookingDetails[i].getBookName();
				String bDate = bookingDetails[i].getBookDate();
				String bTime = bookingDetails[i].getBookTime();
				String eName = bookingDetails[i].getBookEmployee();
				System.out.format("|%20s|%s\t|%s\t|%20s|\n", cName, bDate, bTime, eName);
			}			
		}
	}
	public static void AddCustomerBooking(Owner owner) throws IOException{
		
		FileWriter fw = new FileWriter("booking.txt",true);
		PrintWriter pw = new PrintWriter(new BufferedWriter(fw));
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Please enter Customer name");
		String newname = sc.nextLine();
		System.out.println("Please enter Booking date (DD/MM/YYYY)");
		String newbookdate = sc.nextLine();
		System.out.println("Please enter Booking time (hh/min)");
		String newbooktime = sc.nextLine();
		System.out.println("Please enter Employee name");
		String newbookemployee = sc.nextLine();

		pw.println(newname +":"+newbookdate + ":" + newbooktime+":"+newbookemployee);		
		System.out.println("Your new booking has been added");
		System.out.println("");
		
		pw.close();
	}
}
