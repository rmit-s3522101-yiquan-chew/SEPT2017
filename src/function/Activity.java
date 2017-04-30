package function;

public class Activity {
	
	private String employeename;
	private String activityname;
	private String duration;
	private String comment;
	
	public Activity(String employeename, String activityname, String duration, String comment){
		this.employeename = employeename;	
		this.activityname = activityname;
		this.duration = duration;
		this.comment = comment;
	}
	
	
	public String getEmployeeName() {
		return employeename;
	}

	public String getActivityname() {
		return activityname;
	}

	public String getDuration() {
		return duration;
	}

	public String getComment() {
		return comment;
	}
	
	public String toString(){
		return employeename + ":" + activityname + ":" + duration + ":" + comment;
	}
	
}
