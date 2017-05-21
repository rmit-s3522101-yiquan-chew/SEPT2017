package user;

public class Owner extends User{

	private String bName;
	private String name;
	private String address;
	private String cNumber;
	private String bussinesshour;
	
	public Owner(String username, String password, String bName, String name, String address, String cNumber, String bussinesshour) {
		super(username, password);
		this.bName = bName;
		this.name = name;
		this.address = address;
		this.cNumber = cNumber;
		this.bussinesshour = bussinesshour;
		// TODO Auto-generated constructor stub
	}
	
	public String getBname(){
		return bName;
	}
	
	public String getName(){
		return name;
	}
	
	public String getAddress(){
		return address;
	}
	
	public String getCnumber(){
		return cNumber;
	}
	
	public String getBusinesshour(){
		return bussinesshour;
	}
	
	public String toString(){
		return super.toString() + ":" + bName + ":" + name + ":" + address + ":" + cNumber + ":" + bussinesshour;
	}
}
