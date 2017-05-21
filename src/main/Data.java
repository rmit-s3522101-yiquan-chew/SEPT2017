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
				String employeebusinesshour = inReader.nextToken();
				//format for date time should be done
				String employeeDate = inReader.nextToken();
				String employeeTime = inReader.nextToken();
				String activityname = inReader.nextToken();
				
				//get activity by name
				Activity[] activity = ActivityDetails("activity.txt");
				Activity tempActivity = null;
				for(int i=0; i<activity.length; i++){
					if(activity[i] != null){
						tempActivity = activity[i];
					}
				}
				
				employee[newEmployee] = new Employee(employeeName, employeebusinesshour, employeeDate, employeeTime,tempActivity);
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
			
			int newBooking = -1;
			for( int i = 0; i < bDetails.length;i++)
			{
				if( bDetails[i] == null )
				{
					newBooking = i;
					break;
				}		
			}
			
			if(inReader.countTokens() == 5){
				//customer name
				String cName = inReader.nextToken();
				//booking date
				String bDate = inReader.nextToken();
				//activity
				String activity = inReader.nextToken();								
				//booking time
				String bTime = inReader.nextToken();
				//employee name
				String eName = inReader.nextToken();
				
				bDetails[newBooking] = new Booking(cName, bDate, activity, bTime, eName);
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
			
			int newEmployee = -1;
			for( int i = 0; i < Activity.length;i++)
			{
				if( Activity[i] == null )
				{
					newEmployee = i;
					break;
				}		
			}
			
			if(inReader.countTokens() == 2){
				//booking date
				String activityname = inReader.nextToken();
				//booking time
				int duration = Integer.parseInt(inReader.nextToken());
				
				
				Activity[newEmployee] = new Activity(activityname, duration);
			
			}
		}
		br.close();
		
		return Activity;
	}
	
	//available time slot
	public static List<String> selectTimeSlot(Employee employee) throws IOException{
		List<String> timeSlot = new ArrayList<String>();
		String fileName = (employee.getEmployeeName() + employee.getActivity().getActivityname() + ".txt");
		
		String line;
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		
		while((line = br.readLine()) != null){
			timeSlot.add(line);
		}
		return timeSlot;
	}
	
	//done implementing
	public static boolean remove(String details, String fileName){
		try{
			List<String> tempList = new ArrayList<String>();
			
			// Accepting toString data, remove details by creating a tempfile
			File file = new File(fileName);
			FileWriter fw = new FileWriter(file, false);
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			
			//add all line to list
			String line;
			while((line = br.readLine()) != null){
				tempList.add(line);
			}
			
			//remove if list contains detail
			for(int i=0; i<tempList.size(); i++){
				if((tempList.get(i).toString()).equals(details))
					tempList.remove(i);
			}
			
			//overwrite templist to file
			for(int i=0; i<tempList.size(); i++){
				//write to file
				fw.write((tempList.get(i).toString() + "\n"));
			}
			
			fw.close();
			br.close();
			return true;
		}catch(FileNotFoundException fnfe){
			System.out.println(fileName + " not found.");
			return false;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
}
