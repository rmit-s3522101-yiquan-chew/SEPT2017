package user;

public class Employee {
	
	private String employeeName;
	private String date;
	private String time;
	
	public Employee(String Employeename, String date, String time){
		this.employeeName = Employeename;	
		
		//date time formatting should be done
		this.date = date;
		this.time = time;
	}
	
	public String getEmployeeName() {
		return employeeName;
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
	
	public String toString(){
		return employeeName + ":" + date + ":" + time;
	}
	
}
