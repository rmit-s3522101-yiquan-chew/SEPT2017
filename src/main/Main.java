package main;

import java.util.*;

import com.sun.org.apache.xpath.internal.functions.Function;

import function.Mainpage;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		boolean check = false;
		
		do{
			System.out.println("Welcome to Appointment System");
			System.out.println("Please select a function");
			System.out.println("1. Login");
			System.out.println("2. Register");
			System.out.println("0. Exit");
			
			Scanner sc = new Scanner(System.in);
			String select = sc.nextLine();
			function.Mainpage mp = new Mainpage();
		
			switch(select){
				//login
				case "1":{
					mp.login();
					check = true;
					
					//after login, should continue to user function
					break;
				}
				
				//register
				case "2":{
					mp.register();
					check = true;
					
					//after register, should return here for login
					break;
				}
				
				case "0":{
					System.out.println("Thank you for using the system");
					System.exit(0);
				}
				
				default:
				{
					System.out.println("Invalid selection.");
					check = true;
				}
			}
		}
		while(check);
		
		

	}

}
