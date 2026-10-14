package com.klef;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

public class StringUtilTest
{
StringUtil util = new StringUtil();
@Test
public void testcase1() {
String output = util.stringreverse("soa");
assertEquals("aos", output);
}//pass
@Test
public void testcase2() {
String output = util.stringlowercase("ParadisE");
assertEquals("paradise", output);
}//pass
@Test
public void testcase3() {
boolean output = util.isEmpty(null);
assertTrue(output);
}//pass
@Test
public void testcase4() {
boolean output = util.isEmpty("shit");
assertTrue(output);
}// test case failed

@Test
public void testcase5() {
	String output = util.stringuppercase("pARADISe");
			
			assertEquals("PARADISE", output);
}//pass
@Test
public void testcase6() {
	int len = util.stringlength("kluniversity");
	assertEquals(12, len);
}//pass

@Test
public void testcase7() {
	String output = util.stringreverse("fsad");
	
	assertNotEquals("fsad", output);
	//fail
	
}

@Test
public void testcase8() 
{
	boolean output = util.isEmpty("klef");
	
	
	assertFalse(output);
	
}//pass


@Test
public void testcase9() 
{
	String output = util.stringlowercase("Klef");
	
	assertNotNull(output);
	
}//pass

@Test
public void testcase10() 
{
	
	int length = util.stringlength("klef");
	
	assertNotEquals(4, length);
	
}  //test case failed
}
