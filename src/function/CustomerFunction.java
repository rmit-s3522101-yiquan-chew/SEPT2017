package function;

import java.io.*;
import java.util.Scanner;

import user.*;

public class CustomerFunction {
	public User CustomerSelecton(){
		
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
					return CustomerSelecton();
				}
				case "2":{
					CustomerFunction.AddBooking();
					return CustomerSelecton();
				}
				case "0":{
					System.out.println("Thank you for using Appointment System");
					System.out.println();
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
	
	public static void AddBooking() throws IOException{
		/*FileWriter fw = new FileWriter("booking.txt",true);
		PrintWriter pw = new PrintWriter(new BufferedWriter(fw));*/
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Please enter Employee name");
		String newBooking = sc.nextLine();
		
		//Booking newBooking = new Booking(newBooking); 
		System.out.println("Your new booking has been added");
		System.out.println("");
		//pw.println(newBooking.toString());
		//pw.close();
	}
	
	
	public static void ViewDatetime() 
	{
		
	}
	
	
	

}
