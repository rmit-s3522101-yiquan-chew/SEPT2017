package user;

public class Customer extends User{

	private String name;
	private String address;
	private String cNumber;
	
	public Customer(String username, String password, String name, String address, String cNumber) {
		super(username, password);
		this.name = name;
		this.address = address;
		this.cNumber= cNumber;
		// TODO Auto-generated constructor stub
	}
	
	public String getName(){
		return name;
	}
	
	public String getAddress(){
		return address;
	}
	
	public String getCNumber(){
		return cNumber;
	}
	
	public String toString(){
		return super.toString() + ":" + name + ":" + address + ":" + cNumber;
	}
}
