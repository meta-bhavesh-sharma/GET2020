import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

public class TestJob {
	int[][] arr= {{0,10},{6,20},{60,10},{110,5}};
	int ct[]= {10,30,70,115};
	int wt[]= {0,4,0,0};
	int tat[]= {10,24,10,5};
	@Test
	public void test()
	{
		JobScheduler j1=new JobScheduler();
		int[] wt1=new int[4];
		j1.findWaitingTime(arr,wt1,4);
		for(int i=0;i<4;i++)
		{
			assertEquals(wt[i],wt1[i]);
		}
	}
	@Test
	public void test1()
	{
		JobScheduler j1=new JobScheduler();
		int[] ct1=new int[4];
		j1.findCompletetionTime(arr,tat,ct1,4);
		for(int i=0;i<4;i++)
		{
			assertEquals(ct[i],ct1[i]);
		}
	}
	@Test
	public void test2()
	{
		JobScheduler j1=new JobScheduler();
		int[] tat1=new int[4];
		j1.findTurnAroundTime(arr,wt,tat1,4);
		for(int i=0;i<4;i++)
		{
			assertEquals(tat[i],tat1[i]);
		}
	}
	@Test
	public void test3()
	{
		JobScheduler j1=new JobScheduler();
			assertEquals(1,(int)j1.findAvgWaitingTime(wt,4));
	}
	@Test
	public void test4()
	{
		JobScheduler j1=new JobScheduler();
			assertEquals(4,j1.findMaxWaitingTime(wt,4));
	}
}
