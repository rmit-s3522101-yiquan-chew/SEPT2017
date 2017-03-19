package function;

import java.io.*;
import java.util.Scanner;

import user.*;


public class Owner {

	public User OwnerSelecton(){
		
		boolean check = false;
		do{
		System.out.println(" ");
		System.out.println("1. Add Employee");
		System.out.println("2. Add Working Date/Time");
		System.out.println("3. View Summaries booking"); 	//calculate the booking
		System.out.println("4. View New booking");  		// show new booking
		System.out.println("5. View All workers' availability date");
		System.out.println("0. Logout");
		System.out.print("Please select a function:	");
		Scanner sc = new Scanner(System.in);
		String select = sc.nextLine();
		
		try {
			switch(select){
				
				case "1":{
					Owner.AddEmployee();
					return OwnerSelecton();
				}
				case "2":{
					Owner.AddDateTime();
					return OwnerSelecton();
				}
				case "3":{
					Owner.ViewAllBooking();
					return OwnerSelecton();
				}
				case "4":{
					Owner.ViewNewbooking();
					return OwnerSelecton();
				}
				case "5":{
					Owner.ViewWorkerAvailabilityDate();
					return OwnerSelecton();
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
		String newEmployeename = sc.nextLine();
		
		Employee Employee = new Employee (newEmployeename); //Need to create user Employee
		System.out.println("Your new employee has been added");
		System.out.println("");
		pw.println(Employee.toString());
		pw.close();
	}
	
	public static void AddDateTime() throws IOException{
		FileWriter fw = new FileWriter("workingtimedate.txt",true);
		PrintWriter pw = new PrintWriter(new BufferedWriter(fw));
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Please enter the working time (Hr/Min)");
		String newTime = sc.nextLine();
		System.out.println("Please enter the working date (DD/MM/YYYY)");
		String newDate = sc.nextLine();
		
		DateTime newDateTime = new DateTime(newTime,newDate); 
		System.out.println("The new working time and date has/have been added");
		System.out.println("");
		pw.println(newDateTime.toString());
		pw.close();
	}
	
	public static void ViewAllBooking() 
	{
		
	}
	
	public static void ViewNewbooking() 
	{
		
	}
	
	public static void ViewWorkerAvailabilityDate() 
	{
		
	}
	
}
