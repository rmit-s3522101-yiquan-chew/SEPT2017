package function;

import java.io.*;
import java.util.Scanner;

import user.*;

public class CustomerFunction {
	
	private Customer customer;
	
	public Customer CustomerSelection(Customer customer){
		this.customer = customer;
		
		boolean check = false;
		do{
		System.out.println("Please select a function");
		System.out.println("1. View available days/time");
		System.out.println("2. Add new booking"); //Do in Assignment2
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
	
	
	

}
