package function;

import java.io.*;
import java.util.Scanner;

import user.*;


public class OwnerFunction {

	public Owner OwnerSelection(Owner owner){
		
		boolean check = false;
		do{
		System.out.println(" ");
		System.out.println("1. Add Employee");
		System.out.println("2. View Summaries booking"); 	//calculate the booking
		System.out.println("3. View New booking");  		// show new booking
		System.out.println("4. View All workers' availability date");
		System.out.println("0. Logout");
		System.out.print("Please select a function:	");
		Scanner sc = new Scanner(System.in);
		String select = sc.nextLine();
		
		try {
			switch(select){
				
				case "1":{
					OwnerFunction.AddEmployee();
					return OwnerSelection(owner);
				}
				case "2":{
					GeneralFunction.viewAllBookingDetails();
					return OwnerSelection(owner);
				}
				case "3":{
					OwnerFunction.ViewNewbooking();
					return OwnerSelection(owner);
				}
				case "4":{
					OwnerFunction.ViewWorkerAvailabilityDate();
					return OwnerSelection(owner);
				}
				case "0":{
					System.out.println("Your account has been exited");
					System.out.println("");
					break;
				}
				
				default:
				{
					System.out.println("Invalid selection.");
					check = true;
				}
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		while(check);
		return null;
	}
	
	public static void AddEmployee() throws IOException{
		FileWriter fw = new FileWriter("employee.txt",true);
		PrintWriter pw = new PrintWriter(new BufferedWriter(fw));
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Please enter Employee name");
		String employeeName = sc.nextLine();
		
		System.out.println("Please enter the working time (Hr/Min)");
		String newTime = sc.nextLine();
		
		System.out.println("Please enter the working date (DD/MM/YYYY)");
		String newDate = sc.nextLine();
		
		Employee Employee = new Employee (employeeName, newDate, newTime); //Need to create user Employee
		
		pw.println(Employee.toString());
		System.out.println("New employee " + Employee.getEmployeeName() + " has been added");
		System.out.println("");
		pw.close();
	}
	
	public static void ViewNewbooking() throws IOException 
	{
		File f=new File("booking.txt");
		BufferedReader br = new BufferedReader(new FileReader(f));
		String line = br.readLine(), lastfourthline= "",lastthirdline= "", lastsecline= "", lastline = "" ;

		while(line!= null){
			lastfourthline= lastthirdline;
			lastthirdline= lastsecline;
			lastsecline=lastline ;
			lastline =line.trim();
			line=br.readLine();
		}
		System.out.println("lastfourthline= "+lastfourthline);
		System.out.println("lastthirdline= "+lastthirdline);
		System.out.println("lastsecline= "+lastsecline);
	}
	
	public static void ViewWorkerAvailabilityDate() throws FileNotFoundException, IOException 
	{
		GeneralFunction.employeeAvailability();
	}
	
}
