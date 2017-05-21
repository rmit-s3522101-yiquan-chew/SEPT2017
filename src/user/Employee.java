package user;

import function.Activity;

public class Employee {
	
	private String employeeName;
	private String date;
	private String time;
	private String ebusinesshour;
	private Activity activity;
	
	public Employee(String Employeename, String ebusinesshour, String date, String time, Activity activity){
		this.employeeName = Employeename;	
		this.ebusinesshour = ebusinesshour;
		//date time formatting should be done
		this.date = date;
		this.time = time;
		this.activity = activity;
		
	}
	
	public String getEmployeeName() {
		return employeeName;
	}

	public String getEbusinesshour() {
		return ebusinesshour;
	}
	
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
	
	public Activity getActivity() {
		return activity;
	}
	public void setActivity(Activity activity) {
		this.activity = activity;
	}
	
	//save employee's activity by activity's name
	public String toString(){
		return employeeName + ":" + ebusinesshour + ":" + date + ":" + time +":"+ activity.getActivityname();
	}
	
}
