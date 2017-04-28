package ownerFunctionGUI;

import javafx.beans.property.*;

/* This is the data model for class /SEPT2017/src/user/Employee.java
 * to enable the data be shown in TablewView of GUI 
 */
public class EmployeeDM {
	private final StringProperty employeeName;
	private final StringProperty date;
	private final StringProperty time;
	
	public EmployeeDM(String employeeName, String date, String time){
		this.employeeName = new SimpleStringProperty(employeeName);	
		
		//date time formatting should be done
		this.date = new SimpleStringProperty(date);
		this.time = new SimpleStringProperty(time);
	}
	
	public String getEmployeeName() {
		return employeeName.get();
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName.set(employeeName);;
	}

	public String getDate() {
		return date.get();
	}

	public void setDate(String date) {
		this.date.set(date);;
	}

	public String getTime() {
		return time.get();
	}

	public void setTime(String time) {
		this.time.set(time);;
	}
}