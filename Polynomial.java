import java.util.*;

public class Polynomial {
	ArrayList<Term> term = new ArrayList<Term>();

	Polynomial() {
	}
	Polynomial(int[] power, int[] coofitient) {
		for (int i = 0; i < power.length; i++) {
			term.add(new Term(power[i], coofitient[i]));
		}
	}
	Polynomial(ArrayList<Term> list) {
		term=list;
	}

	float evaluate(float x) {
		float sum = 0;
		for (int i = 0; i < term.size(); i++) {
			sum = (float) (sum + Math.pow(x, term.get(i).power) * (term.get(i).coofitient));
		}
		return sum;
	}
	int digree()
	{
		int max=0;
		for(int i=0;i<term.size();i++)
		{
			if(max<term.get(i).power)
				max=term.get(i).power;
		}
		return max;
	}
	Polynomial addPoly(Polynomial p1,Polynomial p2)
	{
		ArrayList<Term> list=new ArrayList<Term>();
		Polynomial p3=new Polynomial();
		for(int i=0;i<p1.term.size();i++)
		{
			for(int j=0;j<p2.term.size();j++)
			{
				if(p1.term.get(i).power==p2.term.get(j).power)
				{
					list.add(new Term(p1.term.get(i).power,p1.term.get(i).coofitient+p2.term.get(j).coofitient));
					p1.term.get(i).coofitient=0;
					p2.term.get(j).coofitient=0;
				}	
			}
		}
		for(int i=0;i<p1.term.size();i++)
		{
			if(p1.term.get(i).coofitient!=0)
				list.add(new Term(p1.term.get(i).power,p1.term.get(i).coofitient));
		}
		for(int i=0;i<p2.term.size();i++)
		{
			if(p2.term.get(i).coofitient!=0)
				list.add(new Term(p2.term.get(i).power,p2.term.get(i).coofitient));
		}

		return new Polynomial(list);
	}
	Polynomial multiPoly(Polynomial p1,Polynomial p2)
	{
		ArrayList<Term> list=new ArrayList<Term>();
		for(int i=0;i<p1.term.size();i++)
		{
			for(int j=0;j<p2.term.size();j++)
			{
				list.add(new Term(p1.term.get(i).power+p2.term.get(j).power,p1.term.get(i).coofitient*p2.term.get(j).coofitient));
			}
		}
		for(int i=0;i<list.size();i++)
		{
			for(int j=i+1;j<list.size();j++)
			{
				if(list.get(i).power==list.get(j).power)
				{
					list.get(i).coofitient=list.get(i).coofitient+list.get(j).coofitient;
					list.remove(j);
				}
			}
		}
		return new Polynomial(list);
	}
	public static void main(String args[])
	{
		int[] p1={0,1,2,3};
		int[] c1={1,2,3,4};
		Polynomial x1=new Polynomial(p1,c1);
		int[] p2={0,1,2,3};
		int[] c2={1,2,3,4};
		Polynomial x2=new Polynomial(p2,c2);
		Polynomial p3=x1.multiPoly(x1,x2);
		for(int i=0;i<p3.term.size();i++)
		{
			System.out.print(p3.term.get(i).power+"  ");
			System.out.print(p3.term.get(i).coofitient+"  ");
			System.out.println();
		}
	}
	}
