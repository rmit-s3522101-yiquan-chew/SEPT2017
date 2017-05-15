package main;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

import function.Activity;
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
			
			if(inReader.countTokens() == 7){
				String username = inReader.nextToken();
				String password = inReader.nextToken();
				String bName = inReader.nextToken();
				String oName = inReader.nextToken();
				String address = inReader.nextToken();
				String phone = inReader.nextToken();
				String bussinesshour = inReader.nextToken();
				
				owner[newOwner] = new Owner(username, password, bName, oName, address, phone, bussinesshour);
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
				String employeeName = inReader.nextToken();
				//String employeebusinesshour = inReader.nextToken();
				//format for date time should be done
				String employeeDate = inReader.nextToken();
				String startTime = inReader.nextToken();
				String endTime = inReader.nextToken();
				String activity = inReader.nextToken();
				
				employee[newEmployee] = new Employee(employeeName,  employeeDate,  startTime,  endTime,  activity);
			}
		}
		br.close();
		return employee;
	}
	
	public static int bookingLength = 0;
	public static Booking[] bookingDetails(String fileName) throws IOException {
		//check for file existence. create if non
		Path path = Paths.get(fileName);
		if (!Files.exists(path, LinkOption.NOFOLLOW_LINKS))
		    Files.createFile(path);
		
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
			
			if(inReader.countTokens() == 6){
				//customer name
				String cName = inReader.nextToken();
				//employee name
				String eName = inReader.nextToken();
				//booking date
				String bDate = inReader.nextToken();
				//Activity
				String activity = inReader.nextToken();
				//booking start time
				String bsTime = inReader.nextToken();
				//booking end time
				String beTime = inReader.nextToken();
				
				
				bDetails[newEmployee] = new Booking( cName, eName, bDate, activity, bsTime, beTime);
				bookingLength++;
			}
		}
		br.close();
		
		return bDetails;
	}
	
	public static Activity[] ActivityDetails(String fileName) throws IOException {
		Activity[] Activity = new Activity[50];
		
		String line;
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		
		while((line = br.readLine()) != null){
			StringTokenizer inReader = new StringTokenizer(line, ":");
			
			int newActivity = -1;
			for( int i = 0; i < Activity.length;i++)
			{
				if( Activity[i] == null )
				{
					newActivity = i;
					break;
				}		
			}
			
			if(inReader.countTokens() == 4){
				//Activity
				String activityname = inReader.nextToken();
				//Duration
				int duration = Integer.parseInt(inReader.nextToken());
				
				Activity[newActivity] = new Activity(activityname, duration);
			
			}
		}
		br.close();
		
		return Activity;
	}
	
	//not done implementing
	public static void remove(String details, String fileName) throws Exception{
		// Accepting toString data, remove details by creating a tempfile
		File file = new File(fileName);
		File tempFile = File.createTempFile("file", ".txt", file.getParentFile());
		String charset = "UTF-8";
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), charset));
		PrintWriter writer = new PrintWriter(new OutputStreamWriter(new FileOutputStream(tempFile), charset));
		
		for(String line; (line = reader.readLine()) != null;){
			line = line.replace(details, "");
			writer.println(line);
		}
		
		reader.close();
		writer.close();
		
		file.delete();
		tempFile.renameTo(file);
	}
	
	//booking.txt?
}
