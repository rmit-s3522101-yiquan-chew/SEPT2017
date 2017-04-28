package function;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import user.Customer;

public class Booking {
	
	private String bookdate;
	private String booktime;
	private String bookemployee;
	private String bookname;
	
	public Booking(String bookname, String bookdate,String booktime,String bookemployee){
		this.bookname = bookname;
		this.bookdate = bookdate;
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
	
	//booking function
	public static void addBookingMenu(Customer customer) throws IOException{
		Scanner sc = new Scanner(System.in);		
		System.out.println("Please enter Booking date (DD/MM/YYYY)");
		String newbookdate = sc.nextLine();
		System.out.println("Please enter Booking time (hh/min)");
		String newbooktime = sc.nextLine();
		System.out.println("Please enter Employee name");
		String newbookemployee = sc.nextLine();
		
		boolean check = addBooking(customer.getName(), newbookdate, newbooktime, newbookemployee);
		if(check == false){
			System.out.println("Unable to add new booking.");
			System.out.println("Please make sure you enter all required details.");
		}
		else
			System.out.println("Booking added.");
	}
	
	public static boolean addBooking(String customerName, String bookDate, String bookTime, String bookEmployee) throws IOException{
		
		//check null
		if(customerName.equals("") || bookDate.equals("") || bookTime.equals("") || bookEmployee.equals("")){
			return false;
		}
		else{
			//future plan: specific folder containing the bookings.
			FileWriter fw = new FileWriter((customerName + "Booking.txt"),true);
			FileWriter fwGeneral = new FileWriter("booking.txt", true);
			PrintWriter pw = new PrintWriter(new BufferedWriter(fw));
			PrintWriter pwGeneral = new PrintWriter(new BufferedWriter(fwGeneral));
			
			String booking = customerName +":"+bookDate + ":" + bookTime+":"+ bookEmployee;
			
			pw.println(booking);
			pwGeneral.println(booking);
			
			pw.close();
			pwGeneral.close();
			return true;
		}		
	}

}
