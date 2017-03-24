package function;

public class Booking {
	
	private String bookdate;
	private String booktime;
	private String bookemployee;
	private String bookname;
	
	public Booking(String bookname, String bookdate,String booktime,String bookemployee){
		this.bookemployee = bookname;
		this.bookdate = bookdate;
		this.booktime = booktime;
		this.bookname = bookemployee;
	}
	
	public String getBookemployee() {
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
	
	

}
