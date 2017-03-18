package main;

import java.io.IOException;
import java.util.*;

import com.sun.org.apache.xpath.internal.functions.Function;

import function.Mainpage;
import user.User;

public class Main {
	
	public static void main(String[] args) throws IOException {
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
		
			try {
				switch(select){
					//login
					case "1":{
						User user = mp.login();
						
						//after login, should continue to user function
						if((Mainpage.lStatus).equals("owner")){
							//owner function
							System.out.println(user.toString());
						}
						else if((Mainpage.lStatus).equals("customer")){
							//customer function
							System.out.println(user.toString());
						}
						
						check = true;
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
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		while(check);
		
		

	}

}
