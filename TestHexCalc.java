package Assignment2;
import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.anyOf;
import static org.hamcrest.CoreMatchers.both;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.everyItem;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.sameInstance;
import static org.hamcrest.CoreMatchers.startsWith;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.hamcrest.core.CombinableMatcher;
import org.junit.Test;

public class TestHexCalc {
	
	@Test
	public void test()
	{
		int x= HexCalc.toDeci("12AB",16);
		assertEquals(4779,x);
	}
	@Test
	public void test1()
	{
		String s= HexCalc.fromDeci(16,4779);
		assertEquals("12AB",s);
	}
	@Test
	public void test3()
	{
		String s= HexCalc.add("12AB","12AA",16);
		assertEquals("2555",s);
	}
	@Test
	public void test4()
	{
		String s= HexCalc.subtract("12AB","12AA",16);
		assertEquals("1",s);
	}
	@Test
	public void test5()
	{
		String s= HexCalc.multiply("12AB","12AA",16);
		assertEquals("15C6B8E",s);
	}
	@Test
	public void test6()
	{
		String s= HexCalc.divide("12AB","12AA",16);
		assertEquals("1",s);
	}
	

}
