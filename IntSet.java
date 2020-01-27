import java.util.*;
public class IntSet {
	private int[] Set;
	IntSet(int[] set)
	{
		this.Set=set;
	}
	boolean isMember(int item)
	{
		int i=0;
		for(int x:Set)
		{
			if(x==item)
				return true;
			else
				i++;
		}
		return false;
	}
	int size()
	{
		return Set.length;
	}
	boolean isSubset(IntSet subset)
	{
		int i=0;
		for(int x:this.Set)
		{
			if(subset.Set[i]==x)
				i++;
			i=0;
		}
		if(i==subset.Set.length-1)
			return true;
		else
			return false;
	}
	 IntSet getComplement()
	{
		int[] arr=new int[1000-this.Set.length];
		int j=0;
		for(int i=1;i<=1000;i++)
		{
			if(this.isMember(i))
				continue;
			else 
			{
				arr[j]=i;
				j++;
			}
		}
		return new IntSet(arr);
	}
	IntSet union(IntSet set1 ,IntSet set2)
	{ 
		ArrayList<Integer> list = new ArrayList<Integer>(5);
		for(int i=0;i<set1.Set.length;i++)
		{
			 	list.add(set1.Set[i]);
		}
		for(int i=0;i<set2.Set.length;i++)
		{
			if(!set1.isMember(set2.Set[i]))
			 	list.add(set2.Set[i]);
		}
		int[] arr=new int[list.size()];
		for(int i=0;i<list.size();i++)
		{
			arr[i]=list.get(i);
		}
		return new IntSet(arr);
	}
}
