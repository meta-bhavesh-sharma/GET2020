import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

public class TestMatrices {
	int raw1[]={0,1,2};
	int column1[]={0,1,2};
	int element1[]={1,1,1};
	int raw2[]={2,1,0};
	int column2[]={0,1,2};
	int element2[]={1,1,1};
	int[][] arr1= {{1,0,0},{0,1,0},{0,0,1}};
	int[][] sum= {{1,0,1},{0,2,0},{1,0,1}};
	int[][] multi= {{0,0,1},{0,1,0},{1,0,0}};
	@Test
	public void test()
	{
		Matrices m1=new Matrices(element1,raw1,column1,3);
		Matrices m2=m1.transpose();
		int[][] arr=m2.getMetrices();
		for(int i=0;i<3;i++)
		{
			for(int j=0;j<3;j++)
			{
				assertEquals(arr1[i][j],arr[i][j]);
			}
		}
	}
	@Test
	public void test1()
	{
		Matrices m1=new Matrices(element1,raw1,column1,3);
		boolean b1=m1.isSymmetric();
		assertEquals(true,b1);
	}
	@Test
	public void test2()
	{
		Matrices m1=new Matrices(element1,raw1,column1,3);
		Matrices m2=new Matrices(element2,raw2,column2,3);
		int[][] arr=m1.add(m1, m2);
		for(int i=0;i<3;i++)
		{
			for(int j=0;j<3;j++)
			{
				assertEquals(sum[i][j],arr[i][j]);
			}
		}
	}
	@Test
	public void test3()
	{
		Matrices m1=new Matrices(element1,raw1,column1,3);
		Matrices m2=new Matrices(element2,raw2,column2,3);
		int[][] arr=m1.multiMatrices(m1, m2);
		for(int i=0;i<3;i++)
		{
			for(int j=0;j<3;j++)
			{
				assertEquals(multi[i][j],arr[i][j]);
			}
		}
	}

}
