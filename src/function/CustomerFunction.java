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
		System.out.println("3. View my booking");
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
					Booking.addBookingMenu(customer);
					return CustomerSelection(customer);
				}
				case "3":{
					String fileName = customer.getName() + "Booking.txt";
					GeneralFunction.viewBookingDetails(fileName);
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
	
	
	
	
	public static void ViewDatetime() throws FileNotFoundException, IOException 
	{
		GeneralFunction.displayEmployee();
	}
	
	
	

}
