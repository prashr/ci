package com.ci.bean;

import org.junit.Test;
import static org.junit.Assert.*;

import org.junit.Before;

public class TestCategory {
	
	Category cat= null;
	
	@Before
	public void setClass(){
		cat = new Category();
	}
	
	
	@Test
	public void test(){
		
		cat = new Category();
		cat.setName("test");
		
		assertEquals("test", cat.getName());
		
		cat.setAbstract(true);
		
		assertEquals(cat.isAbstract(), true);
		
		cat.setId("123");
		
		assertEquals("123", cat.getId());
	}
	
	@Test
	public void test2(){
		cat = new Category();
		
		cat.setName("test");
		
		assertEquals("test", cat.getName());
		
		cat.setAbstract(true);
		
		assertEquals(cat.isAbstract(), true);
		
		cat.setId("123");
		
		assertEquals("123", cat.getId());
		
	}

}
