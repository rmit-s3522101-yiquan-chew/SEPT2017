package function;

public abstract class Booking {
	
	protected String bookdate;
	protected String booktime;
	
	public Booking(String bookdate,String booktime){
		this.setbookdate(bookdate);
		this.setbooktime(booktime);
	}
	
	public String toString(){
		return getBookDate() + ":" + getBookTime();
	}

	public String getBookDate() {
		return bookdate;
	}
	
	public String getBookTime() {
		return booktime;
	}
	
	public void setbookdate(String bookdate) {
		this.bookdate = bookdate;
	} 
	
	public void setbooktime(String booktime) {
		this.booktime = booktime;
	} 

}
