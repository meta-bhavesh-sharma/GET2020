package Question2;

public class Runner {

	public static void main(String[] args) {
		
		LinkedList list=new LinkedList();
		list.insert(2);
		list.insert(3);
		list.insert(4);
		list.insert(5);
		list.insert(6);
		list.insert(7);
		System.out.println(list.show());
		System.out.println(list.detectLoop());
		list.createLoop();
		System.out.println(list.detectLoop());
	}

}
