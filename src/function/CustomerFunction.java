package function;

import java.io.*;
import java.util.Scanner;

import main.Data;
import user.*;

public class CustomerFunction {
	
	private Customer customer;
	
	public Customer CustomerSelection(Customer customer){
		this.customer = customer;
		
		boolean check = false;
		do{
		System.out.println("Please select a function");
		System.out.println("1. View available days/time");
		System.out.println("2. View employee activity and time");
		System.out.println("3. Add new booking"); //Do in Assignment2
		System.out.println("0. Logout");
		
		Scanner sc = new Scanner(System.in);
		String select = sc.nextLine();
		
		try {
			switch(select){
				
				case "1":{
					CustomerFunction.ViewDatetime();
					return CustomerSelection(customer);
				}
				case "2":{
					CustomerFunction.ViewActivityandTime();
					return CustomerSelection(customer);
				}
				case "3":{
					CustomerFunction.AddBooking(customer);
					return CustomerSelection(customer);
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
	
	public static void AddBooking(Customer customer) throws IOException{
		
		FileWriter fw = new FileWriter("booking.txt",true);
		PrintWriter pw = new PrintWriter(new BufferedWriter(fw));
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Please enter Booking date (DD/MM/YYYY)");
		String newbookdate = sc.nextLine();
		System.out.println("Please enter Booking time (hh/min)");
		String newbooktime = sc.nextLine();
		System.out.println("Please enter Employee name");
		String newbookemployee = sc.nextLine();

		pw.println(customer.getName() +":"+newbookdate + ":" + newbooktime+":"+newbookemployee);		
		System.out.println("Your new booking has been added");
		System.out.println("");
		
		pw.close();
	}
	
	
	public static void ViewDatetime() throws FileNotFoundException, IOException 
	{
		GeneralFunction.employeeAvailability();
	}
	
	public static void ViewActivityandTime() throws FileNotFoundException, IOException 
	{
		Activity[] Activity = Data.ActivityDetails("activity.txt");
				
		System.out.format("|%20s|%s\t|%s\t|%20s|\n", "Emp. Name", "Activity", "Durtion", "Comment");
		
		//Showing the latest 3 booking
		for(int i=0; i<Activity.length; i++){
			if(Activity[i] == null){
				break;
			}
			else{
				String employeename = Activity[i].getEmployeeName();
				String activityname = Activity[i].getActivityname();
				String duration = Activity[i].getDuration();
				String comment = Activity[i].getComment();
				System.out.format("|%20s|%s\t|%10s\t|%20s|\n", employeename, activityname, duration, comment);
			}
		}
		
	}
	

}
