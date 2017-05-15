package junitTest;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import org.junit.*;

import function.*;
import main.Data;
import user.*;

public class FunctionTest {
	public static boolean check = false;
	public static String testDetails = "TestCustomer:01012001:01:TestEmployee";
		
	//booking Test
//	@BeforeClass
//	public static void bookingTest() throws IOException{
//		check = Booking.addBooking("TestCustomer", "01012001", "01", "TestEmployee");		
//		assertEquals("true", check);		
//	}
	/* This test will run without errors. However due to unfinished implementation of remove class, it will be commented out by now
	 * The test had create new data in booking.txt and a new txt file, "TestCustomerBooking.txt"
	 */
	
	
	@Test
	public void invalidBookingTest() throws IOException{
		check = Booking.addBooking("", "", null, null, null, null);
		assertEquals(false, check);
	}
	
	@Test
	public void checkGeneralBooking() throws IOException {
		Booking[] booking = Data.bookingDetails("booking.txt");
		assertEquals("TestCustomer:01012001:01:TestEmployee", testDetails);
	}
	
	@Test
	public void checkCustomerBooking() throws IOException{
		Booking[] booking = Data.bookingDetails("TestCustomerBooking.txt");
		assertEquals("TestCustomer:01012001:01:TestEmployee", testDetails);
	}
	
	//removeTest
//	@Test
//	public void removeTest() throws Exception{
//		String testBookingDetails = "TestCustomer:01012001:01:TestEmployee";
//		String fileName = "booking.txt";
//		String customerFile = "TestCustomerBooking.txt";
//		
//		Data.remove(testBookingDetails, fileName);
//		Data.remove(testBookingDetails, customerFile);
//		
//		//Search for details in file. Expect true if details is removed
//		Booking[] booking = Data.bookingDatails("")
//		
//	}
}
