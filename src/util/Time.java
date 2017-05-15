package util;

import java.text.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Time {	
	private static List<String> activityTime = new ArrayList<String>();
	public static List<String> getActivityTime(){
		return activityTime;
	}
	
	public static void main(String[] args) throws ParseException{
		boolean check = availableTime("0500", "0700", 30);
		
		//test print activityTime
		for(int i=0; i<activityTime.size(); i++){
			System.out.println(activityTime.get(i));
		}
	}
	
	//this class is going to calculate and return available time for an activity within given time
	public static boolean availableTime(String startTime, String endTime, int activityPeriod){
		DateFormat df = new SimpleDateFormat("HHmm");
		try{
			Date sTime = df.parse(startTime);
			Date eTime = df.parse(endTime);
			Calendar sDate = Calendar.getInstance();
			sDate.setTime(sTime);
			Calendar eDate = Calendar.getInstance();
			eDate.setTime(eTime);
			Calendar c = Calendar.getInstance();
			
			String start, end;
			DateFormat df2 = new SimpleDateFormat("hh:mm a");
			int count = 0;
			for(long i=sDate.getTimeInMillis(); i<eDate.getTimeInMillis(); i+=(activityPeriod*60*1000)){				
				c.setTimeInMillis(i);
				System.out.print(count + ". start: " + df2.format(c.getTime()));
				start = df.format(c.getTime());
				long done = i+(activityPeriod*60*1000);
				c.setTimeInMillis(done);
				System.out.print(", end: " + df2.format(c.getTime()) + "\n");
				end = df.format(c.getTime());
				
				//add to list for selection
				activityTime.add(start + ":" + end);
				count++;
			}
			return true;
		}catch(ParseException pe){
			return false;
		}
	}
}
