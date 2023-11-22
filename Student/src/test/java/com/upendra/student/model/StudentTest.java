package com.upendra.student.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import net.bytebuddy.agent.VirtualMachine.ForHotSpot.Connection.Response;

class StudentTest {

	@Test
	
		void testStudent()
	{
			
			Student response = new Student();
			
			
			response.setAge(0);
			response.setName(null);
			response.setSalary(0);
			
			response.getAge();
			response.getSalary();
			response.getName();
			
			
		
			response.equals(response);
			response.toString();
			response.hashCode();
			assertNotNull(response);
		
	}

}
