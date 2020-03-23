package Question3;

public class MultivariatePolynomial {

	MultivariatePolynomialNode headNode;

	public void insert(char sign, int cofficient, Term term) {

		MultivariatePolynomialNode MultivariatePolynomialNode = new MultivariatePolynomialNode();
		MultivariatePolynomialNode.sign=sign;
		MultivariatePolynomialNode.cofficient=cofficient;
		MultivariatePolynomialNode.term=term;
		MultivariatePolynomialNode.next = null;

		if (headNode == null) {
			headNode = MultivariatePolynomialNode;
		} else {
			MultivariatePolynomialNode tempMultivariatePolynomialNode = headNode;
			while (tempMultivariatePolynomialNode.next != null) {
				tempMultivariatePolynomialNode = tempMultivariatePolynomialNode.next;
			}
			tempMultivariatePolynomialNode.next = MultivariatePolynomialNode;
		}
	}

	// Note:- index starts with 0
	public void insertAt(int index, char sign, int cofficient, Term term) {

		MultivariatePolynomialNode MultivariatePolynomialNode = new MultivariatePolynomialNode();
		MultivariatePolynomialNode.sign=sign;
		MultivariatePolynomialNode.cofficient=cofficient;
		MultivariatePolynomialNode.term=term;
		MultivariatePolynomialNode.next = null;
		
		if (index == 0) {
			MultivariatePolynomialNode.next = headNode;
			headNode = MultivariatePolynomialNode;
		} else {

			MultivariatePolynomialNode tempMultivariatePolynomialNode = headNode;
			for (int iterator = 0; iterator < index - 1; iterator++) {
				tempMultivariatePolynomialNode = tempMultivariatePolynomialNode.next;
			}
			MultivariatePolynomialNode.next = tempMultivariatePolynomialNode.next;
			tempMultivariatePolynomialNode.next = MultivariatePolynomialNode;
		}
	}
	
	public int findDegree() {
		int currentDegree=0;
		int maxDegree=0;
		MultivariatePolynomialNode tempMultivariatePolynomialNode = headNode;
		while(tempMultivariatePolynomialNode!=null) {
			currentDegree=0;
			currentDegree=tempMultivariatePolynomialNode.term.findTotalDegree();
			if(currentDegree>maxDegree) {
				maxDegree=currentDegree;
			}
			tempMultivariatePolynomialNode=tempMultivariatePolynomialNode.next;
		}
		return maxDegree;
	}

	public void show() {
		MultivariatePolynomialNode tempMultivariatePolynomialNode = headNode;
		while (tempMultivariatePolynomialNode != null) {
			System.out.print(tempMultivariatePolynomialNode.sign+""+tempMultivariatePolynomialNode.cofficient);
			tempMultivariatePolynomialNode.term.show();
			System.out.print(" ");
			tempMultivariatePolynomialNode = tempMultivariatePolynomialNode.next;
		}
	}
}
