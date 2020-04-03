package priorityqueue;

public class View {
	public static void main(String args[])
	{
		PriorityQueue pq=new PriorityQueue();
		pq.enqueue(10,5);
		pq.enqueue(5,2);
		pq.enqueue(20,6);
		pq.enqueue(8,3);
		pq.enqueue(3,4);
		pq.display();
		System.out.println();
		pq.dequeue();
		pq.dequeue();
		pq.display();
	}
}
