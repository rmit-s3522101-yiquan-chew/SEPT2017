package function;

import java.io.*;
import java.util.*;

import main.Data;
import user.Employee;

public class GeneralFunction {
	
	//employee details
	public static void displayEmployee() throws IOException, FileNotFoundException{
		Employee[] employee = Data.employeeArray("employee.txt");
		
		System.out.format("|%20s|%20s|%20s|%20s|%30s|\n", "Name", "Date", "Start Time", "End Time", "Activity");
		
		//printing employee details
		for(int i=0; i<employee.length; i++){
			if(employee[i] == null){
//				System.out.println("Finish printing");
				break;
			}
			else{
				String name = employee[i].getEmployeeName();
				//String ebusinesshour = employee[i].getEbusinesshour();
				String date = employee[i].getDate();
				String stime = employee[i].getStarttime();
				String etime = employee[i].getEndTime();
				String activity = employee[i].getActivity();
				System.out.format("|%20s|%20s|%20s|%20s|%30s|\n", name, date, stime, etime, activity);
			}
		}
//		return false;
	}
	
	//booking details
	public static void viewBookingDetails(String fileName) throws IOException, FileNotFoundException{
		Booking[] bookingDetails = Data.bookingDetails(fileName);
		
		System.out.format("|%20s|%20s|%20s\t|%30s|%20s|%20s|\n", "Cust. Name", "Emp. Name", "Date", "Activity", "Book Start time", "Book End time");
		
		//printing booking details
		for(int i=0; i<bookingDetails.length; i++){
			if(bookingDetails[i] == null){
				break;
			}
			else{
				String cName = bookingDetails[i].getBookName();
				String EName = bookingDetails[i].getBookEmployee();
				String activity = bookingDetails[i].getActivity();
				String bDate = bookingDetails[i].getBookDate();
				String bsTime = bookingDetails[i].getStartBookTime();
				String beTime = bookingDetails[i].getEndBookTime();
				System.out.format("|%20s|%20s|%20s\t|%30s|%20s|%20s|\n", cName, EName, bDate, activity, bsTime, beTime);
			}
		}
	}
}
