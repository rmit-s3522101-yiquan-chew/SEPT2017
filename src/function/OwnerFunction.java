package function;

import java.io.*;
import java.util.Scanner;

import main.Data;
import user.*;
import util.Time;


public class OwnerFunction {

	public Owner OwnerSelection(Owner owner){
		
		boolean check = false;
		do{
		System.out.println(" ");
		System.out.println("1. Add Employee");
		System.out.println("2. Add Business");
		System.out.println("3. View Summaries booking"); 	//calculate the booking
		System.out.println("4. View New booking");  		// show new booking
		System.out.println("5. View available date times");
		System.out.println("6. Add Employee activity and time");
		System.out.println("7. Add booking");
		System.out.println("0. Logout");
		System.out.print("Please select a function:	");
		Scanner sc = new Scanner(System.in);
		String select = sc.nextLine();
		
		try {
			switch(select){
				
				case "1":{
					OwnerFunction.addEmployeeMenu();
					return OwnerSelection(owner);
				}
				case "2":{
					OwnerFunction.addBusinessMenu();
					return OwnerSelection(owner);
				}
				case "3":{
					GeneralFunction.viewBookingDetails("booking.txt");
					return OwnerSelection(owner);
				}
				case "4":{
					OwnerFunction.viewLatestBookingDetails();
					return OwnerSelection(owner);
				}
				case "5":{
					OwnerFunction.ViewWorkerAvailabilityDate();
					return OwnerSelection(owner);
				}
				case "6":{
					OwnerFunction.addActivityMenu();
					return OwnerSelection(owner);
				}
				case "7":{
					AddCustomerBooking();
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
	
	public static void AddCustomerBooking() throws IOException{
		Customer tempCustomer = new Customer(null, null, null, null, null);

		Scanner sc = new Scanner(System.in);		
		System.out.println("Please enter Customer name");
		String newname = sc.nextLine();
		tempCustomer.setName(newname);
		
		Booking.addBookingMenu(tempCustomer);
		
		System.out.println("");		
	}
	
	public static void addBusinessMenu() throws IOException{
		
		Scanner sc = new Scanner(System.in);
		
		
		String username = null;
		String password = null;
		
		System.out.println("Please enter Business occupation");
		String businessName = sc.nextLine();
		
		System.out.println("Please enter Business name");
		String Name = sc.nextLine();
		
		System.out.println("Please enter Business address");
		String Address = sc.nextLine();
		
		System.out.println("Please enter Business number");
		String CNumber = sc.nextLine();
		
		System.out.println("Please enter the Business Hour ");
		String Businesshour = sc.nextLine();
		
		
		Owner tempBusiness = new Owner(username, password, businessName, Name, Address, CNumber, Businesshour);
		addBusiness(tempBusiness);
		
		System.out.println("Business added.");
		System.out.println("");
	}
	
	public static void addEmployeeMenu() throws IOException{ 
			Scanner sc = new Scanner(System.in);
			
			System.out.println("Please enter Employee name");
			String employeeName = sc.nextLine();
			
			System.out.println("Please enter Employee Business hours");
			String ebusinesshour = sc.nextLine();
			
			System.out.println("Please enter the working time (Hr/Min)");
			String newTime = sc.nextLine();
			
			System.out.println("Please enter the working date (DD/MM/YYYY)");
			String newDate = sc.nextLine();
			
			//Select activity
			System.out.println("Please enter the activity name");
			
			Activity[] activity = Data.ActivityDetails("activity.txt");
			for(int i=0; i<activity.length; i++){
				if(activity[i] != null)
					System.out.println(i+". "+activity[i].getActivityname());
			}
			int selectActivity = Integer.parseInt(sc.nextLine());
			
			Activity newactivity = activity[selectActivity];
			
			Employee tempEmployee = new Employee(employeeName, ebusinesshour, newDate, newTime, newactivity);
			boolean check = addEmployee(tempEmployee, newactivity);
			
			if(check)
				System.out.println("Employee added. You can check it at \"View available date\\times\". \n");
			else
				System.out.println("Failed to add employee's activity, please try again. \n");
	}
	
	public static void addBusiness(Owner business){
		try{
			FileWriter fw = new FileWriter("business.txt",true);
			PrintWriter pw = new PrintWriter(new BufferedWriter(fw));
			
			pw.println(business.toString());
			pw.close();			
		}
		catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public static boolean addEmployee(Employee employee, Activity activity){
		try{
			FileWriter fw = new FileWriter("employee.txt",true);
			PrintWriter pw = new PrintWriter(new BufferedWriter(fw));
			
			/* a method from util.Time to 
			 * print time slot and boolean (Stream) to "(EmployeeName + activity).txt
			 * for booking
			 * done@20052017
			 */
			pw.println(employee.toString());
			pw.close();
			
			//create employee time slot
			boolean check = Time.registerTimeSlot(employee);
			
			return true;
		}
		catch (Exception e){
			e.printStackTrace();
			return false;
		}
	}
		
	public static void ViewWorkerAvailabilityDate() throws FileNotFoundException, IOException 
	{
		GeneralFunction.displayEmployee();
	}
	
	public static void addActivity(String activityname, int duration) throws IOException{        /////////////////////////////
		 FileWriter fw = new FileWriter("activity.txt",true);
		 PrintWriter pw = new PrintWriter(new BufferedWriter(fw));
		    
		 Activity Activity = new Activity (activityname, duration); 
		 
		 pw.println(Activity.toString());
		 System.out.println("Activity " + " has been added");
		 System.out.println("");
		 
		 pw.close();
	}
	
	public static boolean addActivityMenu(){
		Scanner sc = new Scanner(System.in);
		 
		System.out.println("Please enter the Activity name");
		String activityname = sc.nextLine();
		
		try{
			System.out.println("Please enter the activity duration");
			int duration = sc.nextInt();    
	 		
			addActivity(activityname, duration);
			
			return true;
		}catch(NumberFormatException nfe){
			System.out.println("Invalid duration format, please try again");
			return false;
		}catch(IOException ioe){
			System.out.println("Failed to add activity, please try again.");
			return false;
		}
	}
	
	public static void viewLatestBookingDetails() throws IOException, FileNotFoundException{
		Booking[] bookingDetails = Data.bookingDetails("booking.txt");
		
		System.out.println("Showing the latest booking");		
		System.out.format("|%20s|%s\t|%s\t|%20s|\n", "Cust. Name", "Date", "Time", "Emp. Name");
		
		int booking = Data.bookingLength-1;
		
		//Showing the latest 3 booking
		for(int i=0; i<3; i++){
			booking--;
			if(booking >= -1){
				String cName = bookingDetails[i].getBookName();
				String bDate = bookingDetails[i].getBookDate();
				String bTime = bookingDetails[i].getBookTime();
				String eName = bookingDetails[i].getBookEmployee();
				System.out.format("|%20s|%s\t|%s\t|%20s|\n", cName, bDate, bTime, eName);
			}			
		}
	}

}
