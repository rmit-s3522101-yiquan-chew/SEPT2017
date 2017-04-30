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
			System.out.println("Invalid username/password! Please try again!");
			
		return login();
		
	}
	
	//for checking username and password
	public static String check(String username, String password) throws IOException{
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
	
	//registerMenu
	public static void registerMenu() throws IOException{
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Please enter your username");
		String newUsername = sc.nextLine();
		System.out.println("Please enter your password");
		String newPassword = sc.nextLine();
		System.out.println("Please confirm your password");
		String confirmPassword = sc.nextLine();
		System.out.println("Please enter your full name");
		String newName = sc.nextLine();
		System.out.println("Please enter your company address");
		String newAddress = sc.nextLine();
		System.out.println("Please enter your contact number");
		String newPhone = sc.nextLine();
		
		String registerStatus = register(newName, newUsername, newPassword, confirmPassword, newAddress, newPhone);
		
		if(!registerStatus.equals("success")){
			System.out.println("Opps! Error occured. Please try again.");
			//return menu
		}
		else if(registerStatus.equals("success")){
			System.out.println("Successfully register, Please login from the main screen");
			//return menu
		}
		
		
		
	}
	
	//register
	public static String register(String fullName, String userName, String password, String confirmPW, String address, String phone) throws IOException{
		//check fill
		if(!fullName.equals("") && !userName.equals("") && !password.equals("") && !confirmPW.equals("") && address != null && phone != null){
			if(!confirmPW.equals(password)){
				return "wrongPW";
			}
			else{
				FileWriter fw = new FileWriter("customerinfo.txt",true);
				PrintWriter pw = new PrintWriter(new BufferedWriter(fw));
				
				Customer newCustomer = new Customer(userName, password, fullName, address, phone);
				pw.println(newCustomer.toString());
				pw.close();
				return "success";
			}
		}		
		return "noFill";
		
	}

}
