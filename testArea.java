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

public class testArea {

	@Test
	public void test1() {
		Area a = new Area();
		double x;
		x = a.areaTriangle(6.00, 7.00);
		assertEquals(21, (int) x);

	}

	@Test
	public void test2() {
		Area a = new Area();
		double x;
		x = a.areaRectangle(6.00, 7.00);
		assertEquals(42, (int) x);

	}

	@Test
	public void test3() {
		Area a = new Area();
		double x;
		x = a.areaSquare(6.00);
		assertEquals(36, (int) x);

	}

	@Test
	public void test4() {
		Area a = new Area();
		double x;
		x = a.areaCircle(7.00);
		assertEquals(153, (int) x);

	}
}