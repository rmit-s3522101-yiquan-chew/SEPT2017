APPOINTMENT BOOKING SYSTEM
==
### Team member
* *Leung Chun Ki Jenkin - s3444706* 
* *Yi Quan Chew - s3522101*
* *Xiaohan Zeng - s3521491*   
* *Andy Tiu - s3568041*

### Tutor
* *Lawrence Cavedon*

### Tute/Lab
* *13.04.09*

### Day/Time
* *Tuesday 9:30-11:30*

### Synopsis

*Our project named (Appointment Booking System) will be an online system, created to allow customers to book an appointment. This booking system is extremely user friendly catered to patients with or without online booking experience. We plan on delivering a newly way that patients can book their appoints without the hassle of walking into a clinic.*
    
### Code Example
*This piece of code is for our Booking class.*
```
package function;

public class Booking {
	
	private String bookdate;
	private String booktime;
	private String bookemployee;
	private String bookname;
	
	public Booking(String bookname, String bookdate,String booktime,String bookemployee){
		this.bookname = bookname;
		this.bookdate = bookdate;
		this.booktime = booktime;
		this.bookemployee = bookemployee;
	}
	
	public String getBookEmployee() {
		return bookemployee;
	}

	public String getBookDate() {
		return bookdate;
	}
	
	public String getBookTime() {
		return booktime;
	}
	
	public String getBookName() {
		return bookname;
	}
	
	

}
```
### Motivation
*The motivation behind this group project was to create a user friendly online booking system. Our reasoning is that we believe that an online system would make it more convenient for patients, by prodiving an automated system. Patients are required to have a Username and Password in order to freely book an appointment suited to their needs.*

### Installation/Running
*Type:
java -jar SEPT2017.jar
should be able to run the program on console interface.*

### Tests
*This Junit tests the owner login details are correctly inputed.*

```package junitTest;

import static org.junit.Assert.*;
import java.io.IOException;
import function.*;
import main.Data;
import user.*;

import org.junit.Test;

public class MainpageTest {
	@Test
	public void ownerTest() throws IOException {
		Mainpage mp = new Mainpage();
		String checkOwner = mp.check("alex123", "123alex");
		assertEquals("owner", checkOwner);
	}
}
```
### Contributors
* *Leung Chun Ki Jenkin - s3444706 Coding - Minor Functional Implementation, Sprint Backlog, Product Backlog, HOWTO.Document 25% Contribution, * 
* *Yi Quan Chew - s3522101 Coding -  Major Functional Implementation, Junit Testing   25% Contribution*
* *Xiaohan Zeng - s3521491 Documentation - User Stories, Sprint Backlog, Prouct Backlog 25% Contribution*   
* *Andy Tiu - s3568041 Documentation - Class Diagram, README.md, High Level Architecture Diagram 25% Contribution*



### License

**Licensing Information: READ LICENSE**
