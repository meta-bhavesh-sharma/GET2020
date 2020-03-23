package Question1;

public class LinkedList {

	Node headNode;

	public void insert(int data) {

		Node node = new Node();
		node.data = data;
		node.next = null;

		if (headNode == null) {
			headNode = node;
		} else {
			Node tempNode = headNode;
			while (tempNode.next != null) {
				tempNode = tempNode.next;
			}
			tempNode.next = node;
		}
	}

	// Note:- index starts with 0
	public void insertAt(int index, int data) {

		Node node = new Node();
		node.data = data;
		node.next = null;

		if (index == 0) {
			node.next = headNode;
			headNode = node;
		} else {

			Node tempNode = headNode;
			for (int iterator = 0; iterator < index - 1; iterator++) {
				tempNode = tempNode.next;
			}
			node.next = tempNode.next;
			tempNode.next = node;
		}
	}

	public int deleteAt(int position) {
		int elementData=0;
		Node tempNode = headNode;
		Node secondTempNode = null;
		if (position == 0) {
			elementData=tempNode.data;
			headNode = headNode.next;
		} else {
			for (int iterator = 0; iterator < position - 1; iterator++) {
				tempNode = tempNode.next;
			}
			secondTempNode = tempNode.next;
			elementData=secondTempNode.data;
			tempNode.next = secondTempNode.next;
		}
		return elementData;
	}

	public void rotateClockwise(int left, int right, int steps) {
		for (int iterator = 0; iterator < steps; iterator++) {
			int dataOfRight = deleteAt(right-1);
			insertAt(left-1, dataOfRight);
		}
	}

	public String show() {
		String listData="";
		Node tempNode = headNode;
		
		while (tempNode != null) {
			listData=listData+tempNode.data+" ";
			tempNode = tempNode.next;
		}
		return listData;
	}
}
