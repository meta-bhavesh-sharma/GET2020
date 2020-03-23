package Question3;

public class Runner {

	public static void main(String[] args) {
		
		MultivariatePolynomial multivariatePolynomial=new MultivariatePolynomial();
		Term term1=new Term();
		Term term2=new Term();
		Term term3=new Term();
		Term term4=new Term();
		
		term1.insert('v', 1);
		
		term2.insert('w', 2);
		term2.insert('v', 3);
		term2.insert('x', 5);
		
		term4.insert('x', 9);
		term4.insert('w', 6);
		
		multivariatePolynomial.insert('+', 3, term1);
		multivariatePolynomial.insert('-', 14, term2);
		multivariatePolynomial.insert('+', 6, term3);
		multivariatePolynomial.insert('+', 1, term4);
		multivariatePolynomial.show();
		System.out.println();
		System.out.println(multivariatePolynomial.findDegree());
	}

}
