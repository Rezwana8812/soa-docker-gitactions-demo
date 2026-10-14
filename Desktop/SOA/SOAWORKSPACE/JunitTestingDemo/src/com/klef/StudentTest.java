package com.klef;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StudentTest {

private Student s;

@BeforeAll//before all test cases
 static void beforeAll() {
	System.out.println("***** Testing Started *****");
}

@BeforeEach
public void setData() 

{
	System.out.println("*** Before Each Test Case ***");
	s = new Student(1, "klu", "female", 50);
//	s = null;
	
}
@Test
public void testcase1() 
{
	assertNotNull(s);
//pass	
}
@Test
public void testcase2() {
	assertNull(s);
}//fail

@Test
public void testcase3() {
	assertEquals(1, s.getId());
}//pass

@Test
public void testcase4() {
	assertNotEquals("klef", s.getName());
	
}//fail


@Test
public void testcase5() {
	assertNotEquals(81, s.getMarks());
}//pass



@Test
public void testcase6() {
	Student s1 = new Student(2, "ram", "male", 30);
	
	assertTrue(s1.isPassed());
}//fail

@Test
public void testcase7() {
	assertFalse(s.isPassed());
	
}//pass

@Test
public void testcase8() {
	assertThrows(IllegalArgumentException.class, 
			() -> s.setMarks(110) );
	
}
}
