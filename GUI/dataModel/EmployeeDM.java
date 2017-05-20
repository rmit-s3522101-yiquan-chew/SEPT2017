package dataModel;

import function.Activity;
import javafx.beans.property.*;

/* This is the data model for class /SEPT2017/src/user/Employee.java
 * to enable the data be shown in TablewView of GUI 
 */
public class EmployeeDM {
	private final StringProperty employeeName;
	private final StringProperty date;
	private final StringProperty time;
	private final SimpleObjectProperty<Activity> activity;
	private final StringProperty actName;
	
	public EmployeeDM(String employeeName, String date, String time, Activity activity){
		this.employeeName = new SimpleStringProperty(employeeName);	
		
		//date time formatting should be done
		this.date = new SimpleStringProperty(date);
		this.time = new SimpleStringProperty(time);
		this.activity = new SimpleObjectProperty<Activity>(activity);
		this.actName = new SimpleStringProperty(activity.getActivityname());
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
	
	public String getActName(){
		return actName.get();
	}
	
	public void setActName(String actName){
		this.actName.set(actName);
	}
}
