package function;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import main.Data;
import user.Customer;
import user.Employee;
import util.Time;

public class Booking {
	
	private String bookdate;
	private String booktime;
	private String bookemployee;
	private String bookname;
	private String activity;
	
	public Booking(String bookname, String bookdate, String activity, String booktime,String bookemployee){
		this.bookname = bookname;
		this.bookdate = bookdate;
		this.activity = activity;
		this.booktime = booktime;
		this.bookemployee = bookemployee;
	}
	
	public String getBookEmployee() {
		return bookemployee;
	}

	public String getBookDate() {
		return bookdate;
	}
	
	public String getBookTime() {
		return booktime;
	}
	
	public String getBookName() {
		return bookname;
	}
	
	public String toString(){
		return bookname + ":" + bookdate + ":" + booktime + ":" +bookemployee;
	}
	
	//booking function
	public static void addBookingMenu(Customer customer) throws IOException{
		Employee tempEmployee;
		Employee[] employee = Data.employeeArray("employee.txt");
		
		Activity tempActivity;
		Activity[] activity = Data.ActivityDetails("activity.txt");
		
		Scanner sc = new Scanner(System.in);		
		
		System.out.println("Please select an activity.");
		GeneralFunction.viewActivity(employee);
		int sEmployee = sc.nextInt();
		tempEmployee = employee[sEmployee];
		
		Time.timeSlotMenu(tempEmployee);
		
		/* get employee working time and activity,
		 * read from employee to get eName and activity to
		 * read from (employeeName+activity).txt
		 * to get available time slot and
		 * print out and select available time slot
		 * add into booking
		 * done @ 20052017
		 */
		
		
		
		boolean check = addBooking(customer.getName(), tempEmployee.getDate(), tempEmployee.getActivity().getActivityname(), Time.getTime(), tempEmployee.getEmployeeName());
		if(check == false){
			System.out.println("Unable to add new booking.");
			System.out.println("Please make sure you enter all required details.");
		}
		else
			System.out.println("Booking added.");
	}
	
	public static boolean addBooking(String customerName, String bookDate, String activity, String bookTime, String bookEmployee) throws IOException{
		
		//check null
		if(customerName.equals("") || bookDate.equals("") || bookTime.equals("") || bookEmployee.equals("") || customerName.equals(null) || bookDate.equals(null) || bookTime.equals(null) || bookEmployee.equals(null)){
			return false;
		}
		else{
			//future plan: specific folder containing the bookings.
			FileWriter fw = new FileWriter((customerName + "Booking.txt"),true);
			FileWriter fwGeneral = new FileWriter("booking.txt", true);
			PrintWriter pw = new PrintWriter(new BufferedWriter(fw));
			PrintWriter pwGeneral = new PrintWriter(new BufferedWriter(fwGeneral));
			
			String booking = customerName +":"+bookDate + ":" + activity + ":" + bookTime+":"+ bookEmployee;
			
			pw.println(booking);
			pwGeneral.println(booking);
			
			pw.close();
			pwGeneral.close();
			return true;
		}		
	}

}
