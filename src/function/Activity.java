package function;

public class Activity {	
	private String activityname;
	private int duration;

	//duration in mins
	public Activity(String activityName, int duration){
		this.activityname = activityName;
		this.duration = duration;		
	}
	
	public String getActivityname() {
		return activityname;
	}

	public int getDuration() {
		return duration;
	}

	public void setActivityname(String activityname) {
		this.activityname = activityname;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	
	public String toString(){
		return activityname + ":" + duration ;
	}
	
}
