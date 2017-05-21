package util;

import java.io.*;
import java.text.*;
import java.util.*;

import function.Activity;
import main.Data;
import user.Employee;

public class Time {	
	private static String time = new String();
	
	public static String getTime(){
		return time;
	}
	
	private static List<String> activityTime = new ArrayList<String>();
	
	public static List<String> getActivityTime(){
		return activityTime;
	}
	
	//this class is going to calculate and return available time for an activity within given time
	/* sTime and eTime of employee is taken
	 * and divided with activity duration,
	 * save to a file.
	 * Data from the file will be saved to a list 
	 * done@20052017
	 */
	
	//used to create time slot
	//ONLY USE ONCE PER ACTIVITY ADDED
	public static boolean registerTimeSlot(Employee employee){
		String[] time = (employee.getTime()).split("-");
		Activity[] activityList;
		Activity activity = null;
		try {
			activityList = Data.ActivityDetails("activity.txt");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return false;
		}
		
		//search and match for activity
		for(int i=0; i<activityList.length; i++){
			if(activityList != null && activityList[i].getActivityname().equals((employee.getActivity()).getActivityname())){
				activity = activityList[i];
				break;
			}
		}
		
		int activityPeriod = activity.getDuration();
		
		DateFormat df = new SimpleDateFormat("HHmm");
		try{
			Date sTime = df.parse(time[0]);
			Date eTime = df.parse(time[1]);
			
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
//				System.out.print(count + ". start: " + df2.format(c.getTime()));
				start = df.format(c.getTime());
				
				long done = i+(activityPeriod*60*1000);
				c.setTimeInMillis(done);
//				System.out.print(", end: " + df2.format(c.getTime()) + "\n");
				end = df.format(c.getTime());
				
				//add to list for selection
				activityTime.add((start + "-" + end) + ":" +  "true");			
				count++;
			}
			writeToFile(employee, activityTime);
			return true;
		}catch(ParseException pe){
			pe.printStackTrace();
			return false;
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	public static boolean timeSlotMenu(Employee employee) throws IOException{
		Scanner sc = new Scanner(System.in);
		System.out.println("Please select a slot.");//test print activityTime
		
		List<String> timeSlot = Data.selectTimeSlot(employee);
		String[] temp;
		
		for(int i=0; i<timeSlot.size(); i++){
			temp = (timeSlot.get(i).toString()).split(":");
			if(temp[1].equals("true"))
				System.out.println(i + ". Time: " + temp[0]);
		}
		int select = sc.nextInt();
		
		temp = timeSlot.get(select).toString().split(":");
		if(temp[1].equals("true")){
			time = temp[0];
			temp[1] = "false";
			String build = (temp[0].toString() + ":" + temp[1].toString());
			timeSlot.set(select, build);
		}
		else{
			System.out.println("Invalid selection. Please try again");
			return false;
		}
		
		//write list to file
		boolean check = writeToFile(employee, timeSlot);
		
		if(check){
			System.out.println("Time slot registered.");
			return true;
		}
		
		return false;
	}
	
	public static boolean selectTimeSlot(int select, Employee employee){
		try{
			List<String> tempList = new ArrayList<String>();
			tempList = Data.selectTimeSlot(employee);
			
			String[] temp;
			temp = tempList.get(select).split(":");
			
			time = temp[0];
			temp[1] = "false";
			String build = (temp[0].toString() + ":" + temp[1].toString());
			tempList.set(select, build);
			
			//write list to file
			boolean check = writeToFile(employee, tempList);
			return true;
		}catch(IOException ioe){
			return false;
		}
	}
	
	public static boolean writeToFile(Employee employee, List<String> timeSlot) throws IOException{
		try{
			String fileName = (employee.getEmployeeName() + employee.getActivity().getActivityname() + ".txt");
			File file = new File(fileName);
			FileWriter fw = new FileWriter(file, false); //true to append, false to overwrite
			
			for(int i=0; i<timeSlot.size(); i++){
				//write to file
				fw.write((timeSlot.get(i).toString() + "\n"));
			}
			
			fw.close();
			return true;
			
		}catch(IOException ioe){
			ioe.printStackTrace();
			return false;
		}
	}
}
