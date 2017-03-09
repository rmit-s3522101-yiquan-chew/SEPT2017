package Mockup;

import java.util.Scanner;

public class login {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		String username;
		String password;
		
		System.out.println("Username");
		username = sc.nextLine();
		
		System.out.println("Password");
		password = sc.nextLine();
		
		System.out.println("Welcome " + username);

	}

}
