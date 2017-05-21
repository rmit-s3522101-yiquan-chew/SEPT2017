package function;

import java.io.*;
import java.util.*;
import main.Data;
import user.Employee;

public class GeneralFunction {
	
	//employee details
	public static void displayEmployee() throws IOException, FileNotFoundException{
		Employee[] employee = Data.employeeArray("employee.txt");
		
		System.out.format("|%20s|%30s|%s\t|%6s|%6s|\n", "Name", "Business Hour", "Date", "Time", "Activity");
		
		//printing employee details
		for(int i=0; i<employee.length; i++){
			if(employee[i] == null){
//				System.out.println("Finish printing");
				break;
			}
			else{
				String name = employee[i].getEmployeeName();
				String ebusinesshour = employee[i].getEbusinesshour();
				String date = employee[i].getDate();
				String time = employee[i].getTime();
				String activityname = employee[i].getActivity().getActivityname();
				System.out.format("|%20s|%30s|%s\t|%6s|%6s|\n", name, ebusinesshour, date, time, activityname);
			}
		}
//		return false;
	}
	
	//booking details
	public static void viewBookingDetails(String fileName) throws IOException, FileNotFoundException{
		Booking[] bookingDetails = Data.bookingDetails(fileName);
		
		System.out.format("|%20s|%s\t|%s\t|%20s|\n", "Cust. Name", "Date", "Time", "Emp. Name");
		
		//printing booking details
		for(int i=0; i<bookingDetails.length; i++){
			if(bookingDetails[i] == null){
				break;
			}
			else{
				String cName = bookingDetails[i].getBookName();
				String bDate = bookingDetails[i].getBookDate();
				String bTime = bookingDetails[i].getBookTime();
				String eName = bookingDetails[i].getBookEmployee();
				System.out.format("|%20s|%s\t|%s\t|%20s|\n", cName, bDate, bTime, eName);
			}
		}
	}

	//view activity
	public static void viewActivity(Employee[] employee){
		System.out.printf("|\t|%s\t|%s\t|%s\t|%s\t|\n", "Emp. Name", "Working date", "Working time", "Activity");
		
		String eName, wDate, wTime, activity;
		for(int i=0; i<employee.length; i++){
			if(employee[i] == null)
				break;
			
			eName = employee[i].getEmployeeName();
			wDate = employee[i].getDate();
			wTime = employee[i].getTime();
			activity = employee[i].getActivity().getActivityname();
			
			System.out.printf("|%d\t|%s\t|%s\t|%s\t|%s\t|\n", i, eName, wDate, wTime, activity);
		}
	}
}
