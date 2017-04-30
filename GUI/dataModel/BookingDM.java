package dataModel;

import javafx.beans.property.*;

/* This is the data model for class /SEPT2017/src/function/Booking.java
 * to enable the data be shown in TablewView of GUI 
 */

public class BookingDM {
	private final StringProperty bookDate;
	private final StringProperty bookTime;
	private final StringProperty bookEmployee;
	private final StringProperty bookName;
	
	public BookingDM(String bookname, String bookdate,String booktime,String bookemployee){
		this.bookName = new SimpleStringProperty(bookname);
		this.bookDate = new SimpleStringProperty(bookdate);
		this.bookTime = new SimpleStringProperty(booktime);
		this.bookEmployee = new SimpleStringProperty(bookemployee);
	}
	
	public String getBookEmployee() {
		return bookEmployee.get();
	}
	
	public void setBookEmployee(String employeeName){
		this.bookEmployee.set(employeeName);
	}

	public String getBookDate() {
		return bookDate.get();
	}
	
	public void setBookDate(String bookDate){
		this.bookDate.set(bookDate);
	}
	
	public String getBookTime() {
		return bookTime.get();
	}
	
	public void setBookTime(String bookTime){
		this.bookTime.set(bookTime);
	}
	
	public String getBookName() {
		return bookName.get();
	}
	
	public void setBookName(String bookName){
		this.bookName.set(bookName);
	}
}
