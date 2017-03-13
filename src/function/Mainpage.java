package function;

import java.util.Scanner;

public class Mainpage {

	public String login() {
		// TODO Auto-generated method stub
		//for now, user will be a string
		String user, username, password;
		
		Scanner sc = new Scanner(System.in);
				
		System.out.println("Username");
		username = sc.nextLine();
		
		System.out.println("Password");
		password = sc.nextLine();
		
		//check username and password
		user = username;
		System.out.println("Welcome " + username);
		
		return user;
	}
	
	//for checking username and password
	public boolean check(String username, String password){
		//readfile to check
		return true;
	}
	
	//owner or customer
	public String user(String username, String password){
		
		String user = "owner";
		return user;
	}
	
	//register
	public static void register(){
		
		System.out.println("Please enter your username");
		System.out.println("Please enter your password");
		System.out.println("Please enter your full name");
		System.out.println("Please enter your company address");
		System.out.println("Please enter your contact number");
		
	}

}
