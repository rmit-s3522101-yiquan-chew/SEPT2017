package main;

import java.io.*;
import java.util.*;

import function.Booking;
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
			
			if(inReader.countTokens() == 3){
				String employeeName = inReader.nextToken();
				
				//format for date time should be done
				String employeeDate = inReader.nextToken();
				String employeeTime = inReader.nextToken();
				
				employee[newEmployee] = new Employee(employeeName, employeeDate, employeeTime);
			}
		}
		br.close();
		return employee;
	}
	
	public static int bookingLength = 0;
	public static Booking[] bookingDetails(String fileName) throws IOException {
		Booking[] bDetails = new Booking[30];
		
		String line;
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		
		while((line = br.readLine()) != null){
			StringTokenizer inReader = new StringTokenizer(line, ":");
			
			int newEmployee = -1;
			for( int i = 0; i < bDetails.length;i++)
			{
				if( bDetails[i] == null )
				{
					newEmployee = i;
					break;
				}		
			}
			
			if(inReader.countTokens() == 4){
				//customer name
				String cName = inReader.nextToken();
				//booking date
				String bDate = inReader.nextToken();
				//booking time
				String bTime = inReader.nextToken();
				//employee name
				String eName = inReader.nextToken();
				
				bDetails[newEmployee] = new Booking(cName, bDate, bTime, eName);
				bookingLength++;
			}
		}
		br.close();
		
		return bDetails;
	}
	
	//not done implementing
	public static void removeUser(User[] user, String fileName) throws Exception{
		String line;
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		
		while((line = br.readLine()) != null){
			StringTokenizer inReader = new StringTokenizer(line, ":");
			
			int newCustomer = -1;
			for( int i = 0; i < user.length;i++)
			{
				if( user[i] == null )
				{
					newCustomer = i;
					break;
				}		
			}
			
			/*3 conditions
			 * - business.txt
			 * - customerinfo.txt
			 * - employee.txt
			 */
			if(inReader.countTokens() == 5){
				String username = inReader.nextToken();
				String password = inReader.nextToken();
				String name = inReader.nextToken();
				String address = inReader.nextToken();
				String phone = inReader.nextToken();
			}
		}
		br.close();
	}
	
	//booking.txt?
}
