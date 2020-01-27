package Assignment3;

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

public class TestString {
	@Test
	public void test1() {
		StringOp s = new StringOp();
		String s1 = "bhavesh";
		String s2 = "bhavesh";
		boolean out = s.stringComparison(s1, s2);
		assertEquals(true, out);
	}

	@Test
	public void test2() {
		StringOp s = new StringOp();
		String s1 = "bhavesh";
		String out = s.stringReverse(s1);
		assertEquals("hsevahb", out);
	}

	public void test3() {
		StringOp s = new StringOp();
		String s1 = "bhavesh";
		String out = s.reverseCase(s1);
		assertEquals("BHAVESH", out);
	}

	public void test4() {
		StringOp s = new StringOp();
		String s1 = "hello my name is bhavesh";
		String out = s.stringLongest(s1);
		assertEquals("bhavesh", out);
	}
}