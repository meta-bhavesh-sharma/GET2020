package Dictionary;

import java.util.ArrayList;
import java.util.Map;

public class BST implements BinerySearchTree {

	static ArrayList<Element> list = new ArrayList<Element>();
	Element head;

	public BST(int key, int value) {
		this.head = new Element(key, value);
	}

	@Override
	public int get(int key) {
		Element base = this.findBaseElement(head, key);
		System.out.println(base.toString());
		return base.getValue();
	}

	@Override
	public void add(int key, int value) {
		Element base = this.findBaseElement(head, key);
		if (base.getKey() > key) {
			base.setLeft(new Element(key, value));
		} else if (base.getKey() < key) {
			base.setRight(new Element(key, value));
		} else if (base.getKey() < key) {
			System.out.println("Duplicate Entry");
		}
	}

	// This method mainly calls deleteRec()
	@Override
	public void delete(int key) {
		head = deleteRec(head, key);
	}

	@Override
	public ArrayList<Element> sort() {
		list = this.inorderRec(head);
		return list;
	}

	@Override
	public ArrayList<Element> sortBetween(int key1, int key2) {
		list = this.inorderRec(head, key1, key2);
		return list;
	}

	Element findBaseElement(Element parent, int key) {
		if (key > parent.getKey()) {
			if (parent.getRight() != null) {
				parent = findBaseElement(parent.getRight(), key);
			} else {
				return parent;
			}
		} else if (key < parent.getKey()) {
			if (parent.getLeft() != null) {
				parent = findBaseElement(parent.getLeft(), key);
			} else {
				return parent;
			}
		} else if (key == parent.getKey()) {
			return parent;
		}
		return parent;
	}

	Element deleteRec(Element root, int key) {

		if (root == null)
			return root;

		if (key < root.key)
			root.left = deleteRec(root.left, key);
		else if (key > root.key)
			root.right = deleteRec(root.right, key);

		else {
			if (root.left == null)
				return root.right;
			else if (root.right == null)
				return root.left;
			root.key = minValue(root.right);
			root.right = deleteRec(root.right, root.key);
		}

		return root;
	}

	int minValue(Element root) {
		int minv = root.key;
		while (root.left != null) {
			minv = root.left.key;
			root = root.left;
		}
		return minv;
	}

	// A utility function to do inorder traversal of BST
	ArrayList<Element> inorderRec(Element root) {

		if (root != null) {
			inorderRec(root.left);
			list.add(new Element(root.key, root.value));
			inorderRec(root.right);
		}
		return list;
	}

	ArrayList<Element> inorderRec(Element root, int key1, int key2) {

		if (root != null) {
			if (root.getKey() != key1 && root.getKey() != key2) {
				inorderRec(root.left, key1, key2);
			}
			list.add(new Element(root.key, root.value));
			if (root.getKey() != key1 && root.getKey() != key2) {
				inorderRec(root.right, key1, key2);
			}
		}
		return list;
	}

	public static void main(String args[]) {
		BST sample = new BST(23, 45);
		sample.add(24, 20);
		sample.add(22, 20);
		sample.add(20, 20);
		sample.add(26, 20);
		System.out.println(sample.sortBetween(20, 24));

	}
}
