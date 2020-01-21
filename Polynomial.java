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
		Polynomial p3=new Polynomial();
		for(int i=0;i<p1.term.size();i++)
		{
			for(int j=0;j<p2.term.size();j++)
			{
				if(p1.term.get(i).power==p2.term.get(j).power)
				{
					p3.term.add(new Term(p1.term.get(i).power,p1.term.get(i).coofitient+p2.term.get(j).coofitient));
					p1.term.get(i).coofitient=0;
					p2.term.get(j).coofitient=0;
				}	
			}
		}
		for(int i=0;i<p1.term.size();i++)
		{
			if(p1.term.get(i).coofitient!=0)
				p3.term.add(new Term(p1.term.get(i).power,p1.term.get(i).coofitient));
		}
		for(int i=0;i<p2.term.size();i++)
		{
			if(p2.term.get(i).coofitient!=0)
				p3.term.add(new Term(p2.term.get(i).power,p2.term.get(i).coofitient));
		}

		return p3;
	}
	Polynomial multiPoly(Polynomial p1,Polynomial p2)
	{
		Polynomial p3=new Polynomial();
		for(int i=0;i<p1.term.size();i++)
		{
			for(int j=0;j<p2.term.size();j++)
			{
				p3.term.add(new Term(p1.term.get(i).power+p2.term.get(j).power,p1.term.get(i).coofitient*p2.term.get(j).coofitient));
			}
		}
		for(int i=0;i<p3.term.size();i++)
		{
			for(int j=i+1;j<p3.term.size();j++)
			{
				if(p3.term.get(i).power==p3.term.get(j).power)
				{
					p3.term.get(i).coofitient=p3.term.get(i).coofitient+p3.term.get(j).coofitient;
					p3.term.remove(j);
				}
			}
		}
		return p3;
	}
	}