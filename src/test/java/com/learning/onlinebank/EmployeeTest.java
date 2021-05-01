package com.learning.onlinebank;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import com.learning.onlinebank.model.Employee;


@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)

public class EmployeeTest {

	@LocalServerPort
	private int port;
	@Autowired
	private TestRestTemplate restTemplate;
	

	Employee employee = new Employee();
	
	@Test
	public void testEmployee()
	{
		
		try
		{
			String dateInString = "26-Aug-2020";
			employee.setAddress1("test");
			employee.setAddress2("test");
			employee.setBirth_date(dateInString);
			employee.setCity("test");
			employee.setDepartment("test");
			employee.setEmail("test");
			employee.setEmp_no("1");
			employee.setFirst_name("test");
			employee.setFullname("test");
			employee.setGender("Male");
			employee.setHire_date(dateInString);
			employee.setHrflag("test");
			employee.setLast_name("test");
			employee.setManagerflag("test");
			employee.setManagername("test");
			employee.setPassword("test");
			employee.setPhone("test");
			employee.setState("test");
			employee.setTheatre("test");
			employee.setZip("test");
			
		    Assert.assertEquals("test" ,employee.getAddress1());
		    Assert.assertEquals("test" ,employee.getAddress2());  
		    Assert.assertEquals(dateInString ,employee.getBirth_date());
		    Assert.assertEquals("test" ,employee.getCity());
		    Assert.assertEquals("test" ,employee.getDepartment());
		    Assert.assertEquals("test" ,employee.getEmail());
		    Assert.assertEquals("1" ,employee.getEmp_no());
		    Assert.assertEquals("test" ,employee.getFirst_name());
		    Assert.assertEquals("test" ,employee.getFullname());
		    Assert.assertEquals("Male" ,employee.getGender());
		    Assert.assertEquals(dateInString ,employee.getHire_date());
		    Assert.assertEquals("test" ,employee.getHrflag());
		    Assert.assertEquals("test" ,employee.getLast_name());
		    Assert.assertEquals("test" ,employee.getManagerflag());
		    Assert.assertEquals("test" ,employee.getManagername());
		    Assert.assertEquals("test" ,employee.getPassword());
		    Assert.assertEquals("test" ,employee.getPhone());
		    Assert.assertEquals("test" ,employee.getState());
		    Assert.assertEquals("test" ,employee.getTheatre());
		    Assert.assertEquals("test" ,employee.getZip());
		}
		catch(Exception e)
		{
			
		}
	}
	
}
