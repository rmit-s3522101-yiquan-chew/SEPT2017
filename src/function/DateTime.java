package function;

public class DateTime {
	
	private String date;
	private String time;
	
	public DateTime(String date,String time){
		this.date = date;
		this.time = time;
	}
	
	public String toString(){
		return getDate() + ":" + getTime();
	}

	public String getDate() {
		return date;
	}
	
	public String getTime() {
		return time;
	}

}
