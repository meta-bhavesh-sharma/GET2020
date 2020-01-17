package Assignment4;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.*;

public class Tests {
	@Test
	public void test1() {
		JunitTest j = new JunitTest();
		int[] arr = { 1, 2, 2, 3, 3 };
		int x = j.clump(arr, 5);
		assertEquals(2, x);
	}

	@Test
	public void test2() {
		JunitTest j = new JunitTest();
		int[] arr = { 1, 1, 2, 1, 1 };
		int x = j.clump(arr, 5);
		assertEquals(2, x);
	}
	@Test
	public void test3() {
		JunitTest j = new JunitTest();
		int[] arr = { 1, 1, 1, 1, 1 };
		int x = j.clump(arr, 5);
		assertEquals(1, x);
	}
	@Test
	public void test4() {
		JunitTest j = new JunitTest();
		int[] arr = { 1, 2, 3, 8, 9, 3, 2, 1 };
		int x = j.largestMirror(arr, arr.length);
		assertEquals(3, x);
	}
	@Test
	public void test5() {
		JunitTest j = new JunitTest();
		int[] arr = { 7, 1, 4, 9, 7, 4, 1 };
		int x = j.largestMirror(arr, arr.length);
		assertEquals(2, x);
	}
	@Test
	public void test6() {
		JunitTest j = new JunitTest();
		int[] arr = { 1, 2, 1, 4 };
		int x = j.largestMirror(arr, arr.length);
		assertEquals(3, x);
	}
	@Test
	public void test7() {
		JunitTest j = new JunitTest();
		int[] arr = { 1, 4, 5, 3, 5, 4, 1 };
		int x = j.largestMirror(arr, arr.length);	
		assertEquals(7, x);
	}
	@Test
	public void test8() {
		JunitTest j = new JunitTest();
		int[] in = { 5, 4, 9, 4, 9, 5 };
		int[] out = { 9, 4, 5, 4, 5, 9 };
		int[] x = j.fixXY(in, 4, 5, 6);
		for(int i=0;i<in.length;i++)
			   assertEquals(out[i], x[i]);
	}
	@Test
	public void test10() {
		JunitTest j = new JunitTest();
		int[] in = { 1, 4, 1, 5 };
		int[] out = { 1, 4, 5, 1 };
		int[] x = j.fixXY(in, 4, 5, in.length);
		for(int i=0;i<in.length;i++)
			   assertEquals(out[i], x[i]);
	}
	@Test
	public void test11() {
		JunitTest j = new JunitTest();
		int[] in = { 1, 4, 1, 5, 5, 4, 1 };
		int[] out = { 1, 4, 5, 1, 1, 4, 5 };
		int[] x = j.fixXY(in, 4, 5, in.length);
		for(int i=0;i<in.length;i++)
			   assertEquals(out[i], x[i]);
	}
	@Test
	public void test9() {
		JunitTest j = new JunitTest();
		int[] in = { 5, 4, 9, 5, 4 };
		int[] out = null;
		int[] x = j.fixXY(in, 4, 5, in.length);
		assertEquals(out, x);
	}
	@Test
	public void test12() {
		JunitTest j = new JunitTest();
		int[] in = { 4, 4, 4, 5, 5 };
		int[] out = null;
		int[] x = j.fixXY(in, 4, 5, in.length);
		assertEquals(out, x);
	}
	@Test
	public void test13() {
		JunitTest j = new JunitTest();
		int[] in = {};
		int[] out = null;
		int[] x = j.fixXY(in, 4, 5, in.length);
		assertEquals(out, x);
	}
	@Test
	public void test14(){
		JunitTest j = new JunitTest();
		int[] in = { 1, 4, 4, 5, 5 };
		int[] out = null;
		int[]x=new int[in.length];
		x = j.fixXY(in, 4, 5, in.length);
		assertEquals(out, x);
	}
	@Test
	public void test15() {
		JunitTest j = new JunitTest();
		int[] in = { 1, 1, 1, 2, 1 };
		int x = j.split(in, in.length);
		assertEquals(3, x);
	}
	@Test
	public void test16() {
		JunitTest j = new JunitTest();
		int[] in = { 10, 10 };
		int x = j.split(in, in.length);
		assertEquals(1, x);
	}
	@Test
	public void test17() {
		JunitTest j = new JunitTest();
		int[] in = { 2, 1, 1, 2, 1 };
		int x = j.split(in, in.length);
		assertEquals(-1, x);
	}

}
