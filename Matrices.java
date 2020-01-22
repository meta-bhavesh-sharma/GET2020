import java.util.*;


public class Matrices {
	ArrayList<Element> list = new ArrayList<Element>();
	Matrices(int[] e,int[] i,int[] j)
	{
		for(int k=0;k<e.length;k++)
		{
			list.add(new Element(e[k],i[k],j[k]));
		}
	}
	
	Matrices transpose()
	{
		int[] e=new int[list.size()];
		int[] i=new int[list.size()];
		int[] j=new int[list.size()];
		for(int k=0;k<list.size();k++)
		{
			e[k]=list.get(k).element;
			i[k]=list.get(k).raw;
			j[k]=list.get(k).column;
			
		}
		return new Matrices(e,i,j);
		
	}
	boolean isSymmetric()
	{
		Matrices m=this.transpose();
		for(int k=0;k<list.size();k++)
		{
			if(!(list.get(k).element==m.list.get(k).element && list.get(k).raw==m.list.get(k).raw && list.get(k).column==m.list.get(k).column))
				return false;
		}
		return true;
	}
	Matrices add(Matrices m1,Matrices m2)
	{
		for()
		{
			
		}
	}

}
