package Dictionary;

public class Element {

	int key;
	int value;
	Element left;
	Element right;
	
	public int getKey() {
		return key;
	}
	public void setKey(int key) {
		this.key = key;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public Element getLeft() {
		return left;
	}
	public void setLeft(Element left) {
		this.left = left;
	}
	public Element getRight() {
		return right;
	}
	public void setRight(Element right) {
		this.right = right;
	}
	public Element(int key, int value) {
		super();
		this.key = key;
		this.value = value;
		this.left = null;
		this.right = null;
	}
	@Override
	public String toString() {
		return "Element [key=" + key + ", value=" + value + "]";
	}
	
	
}
