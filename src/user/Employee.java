package user;

public class Employee {
	
	private String Employeename;
	
	public Employee(String Employeename){
		this.Employeename = Employeename;	
	}
	
	public String toString(){
		return getEmployeename();
	}

	public String getEmployeename() {
		return Employeename;
	}
	
}
