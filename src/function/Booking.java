package function;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import user.Customer;

public class Booking {
	
	private String bookname;
	private String bookemployee;
	private String bookdate;
	private String activity;
	private String bookstarttime;
	private String bookendtime;
		
	public Booking(String bookname, String bookemployee, String bookdate, String activity, String bookstarttime, String bookendtime){
		this.bookname = bookname;
		this.bookdate = bookdate;
		this.activity = activity;
		this.bookemployee = bookemployee;
		this.bookstarttime = bookstarttime;
		this.bookendtime = bookendtime;
	}
	
	public String getBookEmployee() {
		return bookemployee;
	}

	public String getBookDate() {
		return bookdate;
	}
	
	public String getActivity() {
		return activity;
	}
	
	public String getStartBookTime() {
		return bookstarttime;
	}
	
	public String getEndBookTime() {
		return bookendtime;
	}
	
	public String getBookName() {
		return bookname;
	}
	
	public String toString(){
		return bookname + ":" + bookemployee + ":" + bookdate + ":" + activity + ":" +bookstarttime + ":" +bookendtime;
	}
	
	//booking function
	public static void addBookingMenu(Customer customer) throws IOException{
		Scanner sc = new Scanner(System.in);		
		System.out.println("Please enter Employee name");
		String newbookemployee = sc.nextLine();
		System.out.println("Please enter Booking date (DD/MM/YYYY)");
		String newbookdate = sc.nextLine();
		System.out.println("Please select activity");
		String newactivity = sc.nextLine();
		System.out.println("Please enter booking start time (hh/min)");
		String newbookstarttime = sc.nextLine();
		System.out.println("Please enter booking end time (hh/min)");
		String newbookendtime = sc.nextLine();
		
		boolean check = addBooking(customer.getName(), newbookemployee, newbookdate, newactivity, newbookstarttime, newbookendtime );
		if(check == false){
			System.out.println("Unable to add new booking.");
			System.out.println("Please make sure you enter all required details.");
		}
		else
			System.out.println("Booking added.");
	}
	
	public static boolean addBooking(String customerName, String bookEmployee, String bookdate, String activity, String bookstartTime, String bookendtime) throws IOException{
		
		//check null
		if(customerName.equals("") || bookEmployee.equals("") || bookdate.equals("") || activity.equals("") || bookstartTime.equals("") || bookendtime.equals("") || customerName.equals(null) || bookEmployee.equals(null) || bookdate.equals(null) || activity.equals(null) || bookstartTime.equals(null) || bookendtime.equals(null)){
			return false;
		}
		else{
			//future plan: specific folder containing the bookings.
			FileWriter fw = new FileWriter((customerName + "Booking.txt"),true);
			FileWriter fwGeneral = new FileWriter("booking.txt", true);
			PrintWriter pw = new PrintWriter(new BufferedWriter(fw));
			PrintWriter pwGeneral = new PrintWriter(new BufferedWriter(fwGeneral));
			
			String booking = customerName +":"+bookEmployee + ":" + bookdate+ ":" + activity+ ":" + bookstartTime+ ":" + bookendtime;
			
			pw.println(booking);
			pwGeneral.println(booking);
			
			pw.close();
			pwGeneral.close();
			return true;
		}		
	}

}
