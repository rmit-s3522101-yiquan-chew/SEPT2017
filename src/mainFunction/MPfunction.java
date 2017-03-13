package mainFunction;

import java.util.Scanner;

public class MPfunction {

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
		return true;
	}
	
	//owner or customer
	public String user(String username, String password){
		
		String user = "owner";
		return user;
	}
	
	//register
	public static void register(){
		
	}

}
