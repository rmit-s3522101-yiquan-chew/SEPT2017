package user;

public class Employee {
	
	private String employeeName;
	private String date;
	private String starttime;
	private String endtime;
	private String activity;
	
	
	public Employee(String employeename, String date, String starttime, String endtime, String activity){
		this.employeeName = employeename;	
		this.starttime = starttime;
		//date time formatting should be done
		this.date = date;
		this.endtime = endtime;
		this.activity = activity;
		
	}
	
	public String getEmployeeName() {
		return employeeName;
	}

	public String getStarttime() {
		return starttime;
	}
	
	public String getDate() {
		return date;
	}
	
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}


	public void setDate(String date) {
		this.date = date;
	}

	public String getEndTime() {
		return endtime;
	}
	
	public String getActivity() {
		return activity;
	}
	
	public void setActivity(String activity) {
		this.activity = activity;
	}

	public void setStartTime(String starttime) {
		this.starttime = starttime;
	}
	
	public void setEndTime(String endtime) {
		this.endtime = endtime;
	}
	
	public String toString(){
		return employeeName + ":" + date + ":" + starttime + ":" + endtime + ":" + activity;
	}
	
}
