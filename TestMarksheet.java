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

public class TestMarksheet {

	@Test
	public void test1() {
		Marksheet m = new Marksheet();
		int[] st = { 10, 20, 30, 40, 50 };
		double x = m.findAvg(5, st);
		assertEquals(30, (int) x);

	}

	@Test
	public void test2() {
		Marksheet m = new Marksheet();
		int[] st = { 10, 20, 30, 40, 50 };
		double x = m.findMin(5, st);
		assertEquals(10, (int) x);

	}

	@Test
	public void test3() {
		Marksheet m = new Marksheet();
		int[] st = { 10, 20, 30, 40, 50 };
		double x = m.findMax(5, st);
		assertEquals(10, (int) x);

	}

	@Test
	public void test4() {
		Marksheet m = new Marksheet();
		int[] st = { 10, 20, 30, 40, 50 };
		double x = m.findPassPercent(5, st);
		assertEquals(40, (int) x);

	}
}