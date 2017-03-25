package function;

import java.io.*;
import java.util.Scanner;
import user.*;
import user.Customer;
import user.Owner;
import main.Data;

public class Mainpage {
	
	public static User loginUser;
	public static String lStatus;

	public User login() throws IOException {
		// TODO Auto-generated method stub
		//for now, user will be a string
		String username, password;
		
		Scanner sc = new Scanner(System.in);
				
		System.out.println("Please enter your username");
		username = sc.nextLine();
		
		System.out.println("Please enter your password");
		password = sc.nextLine();
		
		System.out.println("");
		//check username and password
		lStatus = check(username, password);
		
		if(lStatus.equals("owner") || lStatus.equals("customer")){
			System.out.println("Welcome " + loginUser.getUsername());			
			return loginUser;
		}
		else
			System.out.println("Invalid username/password");
		
		return loginUser;
	}
	
	//for checking username and password
	public String check(String username, String password) throws IOException{
		//readfile to check
		Owner[] owner = Data.ownerArray("business.txt");
		Customer[] customer = Data.customerArray("customerinfo.txt");
		
		String status = "invalid";
		
		//check if match owner
		for(int i=0; i<owner.length; i++){
			if(owner[i] != null && (owner[i].getUsername()).equals(username)){
				if((owner[i].getPassword()).equals(password)){
					loginUser = owner[i];
					status = "owner";
					//System.out.println(loginUser.toString());
				}
			}
		}
		
		//check if match customer details
		for(int j=0; j<customer.length; j++){
			if(customer[j] != null && (customer[j].getUsername()).equals(username)){
				if((customer[j].getPassword()).equals(password)){
					loginUser = customer[j];
					status = "customer";
					//System.out.println(loginUser.toString());
				}
			}
		}
		
		return status;
	}
	
	//register
	public static void register() throws IOException{
		FileWriter fw = new FileWriter("customerinfo.txt",true);
		PrintWriter pw = new PrintWriter(new BufferedWriter(fw));
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Please enter your username");
		String newUsername = sc.nextLine();
		System.out.println("Please enter your password");
		String newPassword = sc.nextLine();
		System.out.println("Please enter your full name");
		String newName = sc.nextLine();
		System.out.println("Please enter your company address");
		String newAddress = sc.nextLine();
		System.out.println("Please enter your contact number");
		String newPhone = sc.nextLine();
		
		Customer newCustomer = new Customer(newUsername, newPassword, newName, newAddress, newPhone);
		System.out.println("Successfully registered.");
		pw.println(newCustomer.toString());
		pw.close();
	}

}
