package function;

public class Activity {
	
	private String activityname;
	private int duration;
	
	public Activity(String activityname, int duration){	
		this.activityname = activityname;
		this.duration = duration;
	}
	
	public String getActivityname() {
		return activityname;
	}

	public int getDuration() {
		return duration;
	}
	
	public String toString(){
		return activityname + ":" + duration;
	}
	
}
