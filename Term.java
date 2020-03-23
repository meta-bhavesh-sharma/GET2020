package Question3;

public class Term {

	TermNode headNode;

	public void insert(char variable, int power) {

		TermNode TermNode = new TermNode();
		TermNode.variable=variable;
		TermNode.power=power;
		TermNode.next = null;

		if (headNode == null) {
			headNode = TermNode;
		} else {
			TermNode tempTermNode = headNode;
			while (tempTermNode.next != null) {
				tempTermNode = tempTermNode.next;
			}
			tempTermNode.next = TermNode;
		}
	}

	// Note:- index starts with 0
	public void insertAt(int index, char variable, int power) {

		TermNode TermNode = new TermNode();
		TermNode.variable=variable;
		TermNode.power=power;
		TermNode.next = null;
		
		if (index == 0) {
			TermNode.next = headNode;
			headNode = TermNode;
		} else {

			TermNode tempTermNode = headNode;
			for (int iterator = 0; iterator < index - 1; iterator++) {
				tempTermNode = tempTermNode.next;
			}
			TermNode.next = tempTermNode.next;
			tempTermNode.next = TermNode;
		}
	}
	
	public void deleteAt(int index) {
		TermNode tempNode=headNode;
		TermNode secondTempNode=null;
		
		if(index==0) {
			headNode=headNode.next;
		}
		else {
			for(int iterator=0;iterator<index-1;iterator++) {
				tempNode=tempNode.next;
			}
			secondTempNode=tempNode.next;
			tempNode.next=secondTempNode.next;
		}
	}

	public int findTotalDegree() {
		int totalDegree=0;
		if(headNode!=null) {
			TermNode tempTermNode = headNode;
			while(tempTermNode!=null) {
				totalDegree+=tempTermNode.power;
				tempTermNode=tempTermNode.next;
			}
		}
		return totalDegree;
	}
	public void show() {
		TermNode tempTermNode = headNode;
		if(headNode!=null) {
		while (tempTermNode != null) {
			System.out.print(tempTermNode.variable+"^"+tempTermNode.power);
			tempTermNode = tempTermNode.next;
		}}
	}
}
