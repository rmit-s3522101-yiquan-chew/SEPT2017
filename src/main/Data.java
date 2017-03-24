package main;

import java.io.*;
import java.util.*;

import user.*;

//to read data from txt file
public class Data {
	
	public static Owner[] ownerArray(String fileName) throws IOException {
		Owner[] owner = new Owner[10];
		
		String line;
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		
		while((line = br.readLine()) != null){
			StringTokenizer inReader = new StringTokenizer(line, ":");
			
			int newOwner = -1;
			for(int i=0; i<owner.length; i++){
				if(owner[i] == null){
					newOwner = i;
					break;
				}
			}
			
			if(inReader.countTokens() == 6){
				String username = inReader.nextToken();
				String password = inReader.nextToken();
				String bName = inReader.nextToken();
				String oName = inReader.nextToken();
				String address = inReader.nextToken();
				String phone = inReader.nextToken();
				
				owner[newOwner] = new Owner(username, password, bName, oName, address, phone);
			}
		}
		br.close();
		return owner;
	}
	
	public static Customer[] customerArray(String fileName) throws IOException {
		Customer[] customer = new Customer[50];
		
		String line;
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		
		while((line = br.readLine()) != null){
			StringTokenizer inReader = new StringTokenizer(line, ":");
			
			int newCustomer = -1;
			for( int i = 0; i < customer.length;i++)
			{
				if( customer[i] == null )
				{
					newCustomer = i;
					break;
				}		
			}
			
			if(inReader.countTokens() == 5){
				String username = inReader.nextToken();
				String password = inReader.nextToken();
				String name = inReader.nextToken();
				String address = inReader.nextToken();
				String phone = inReader.nextToken();
				
				customer[newCustomer] = new Customer(username, password, name, address, phone);
			}
		}
		br.close();
		return customer;
	}
	
	public static Employee[] employeeArray(String fileName) throws IOException {
		Employee[] employee = new Employee[50];
		
		String line;
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		
		while((line = br.readLine()) != null){
			StringTokenizer inReader = new StringTokenizer(line, ":");
			
			int newEmployee = -1;
			for( int i = 0; i < employee.length;i++)
			{
				if( employee[i] == null )
				{
					newEmployee = i;
					break;
				}		
			}
			
			if(inReader.countTokens() == 5){
				String Employeename = inReader.nextToken();
				
				employee[newEmployee] = new Employee(Employeename);
			}
		}
		br.close();
		return employee;
	}
		
	//booking.txt?
}
