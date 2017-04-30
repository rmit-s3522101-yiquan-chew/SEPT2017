package main;

import java.io.IOException;
import java.util.*;

import function.Mainpage;
import function.OwnerFunction;
import function.CustomerFunction;
import user.*;

public class MainConsole {
	
//	public static void main(String[] args) throws IOException {
//		//to complie to excutable jar
//		javax.swing.SwingUtilities.invokeLater(new Runnable(){
//			public void run(){
//				mainMenu();
//			};
//		});
//	}
	
	public static void mainMenu(){
		
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
			function.OwnerFunction bo = new OwnerFunction();
			function.CustomerFunction c = new CustomerFunction();
			try {
				switch(select){
					//login
					case "1":{
						User user = mp.login();
						
						//after login, should continue to user function
						if((Mainpage.lStatus).equals("owner")){
							//owner function
							Owner owner = (Owner) user;
							bo.OwnerSelection(owner);
							//System.out.println(user.toString());
						}
						else if((Mainpage.lStatus).equals("customer")){
							//customer function
							Customer customer = (Customer) user;
							c.CustomerSelection(customer);
							//System.out.println(user.toString());
						}
						
						check = true;
						break;
					}
					
					//register
					case "2":{
						mp.registerMenu();
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
