package junitTest;

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
	
	@Test
	public void customerTest() throws IOException{
		Mainpage mp = new Mainpage();
		String checkCustomer = mp.check("eliah", "hon95");
		assertEquals("customer", checkCustomer);
	}
	
	@Test
	public void invalidTest() throws IOException{
		Mainpage mp = new Mainpage();
		String invalidCheck = mp.check("INVALID", "INVALID");
		assertEquals("invalid", invalidCheck);
	}
	
	@Test
	public void registerTest() throws IOException{
		Mainpage mp = new Mainpage();
		
	}
}
