package priorityqueue;

import java.util.NoSuchElementException;
import java.util.*;

public class PriorityQueue {
	int max_size = 10;
	private ArrayList<element> list;
	private int size;
	int front = 0;
	int rear = 0;

	public PriorityQueue() {
		list = new ArrayList<element>(5);
		size = 0;
	}

	public Boolean isFull() {
		if ((rear + 1 == front) || (front == 0 && rear == max_size)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * this method check whether queue is empty or not return true if queue is
	 * empty else return false
	 */
	public Boolean isEmpty() {
		if ((front == rear)) {
			return true;
		} else {
			return false;
		}
	}

	public void enqueue(int data, int priority) {

		// If it is empty, insert in front
		if (size == 0) {
			size++;
			rear++;
			list.add(new element());
			list.get(0).data = data;
			list.get(0).priority = priority;
			return;
		}
		list.add(new element());
		element temp = new element();
		for (int i = 0; i < size + 1; i++) {
			if (priority >= list.get(i).priority) {
				element next;
				temp = list.get(i);

				list.set(i, new element());
				list.get(i).data = data;
				list.get(i).priority = priority;

				// Shifting
				while (i < size) {
					next = list.get(i + 1);
					list.set(i + 1, temp);
					temp = next;
					i++;
				}
				break;
			}
		}
		rear++;
		size++;

	}

	public void dequeue() {
		// NoSuchElement
		if (isEmpty())
			throw new NoSuchElementException("The queue is empty");

		if (front == max_size) {
			front = 0;
		}
		front++;
	}

	public int peek() {
		if (isEmpty())
			throw new NoSuchElementException("The queue is empty");
		return list.get(front).data;
	}

	public boolean contains(int x) {
		// Check for empty.
		if (isEmpty())
			return false;
		// Looping through the positions which contains inserted values,
		// ignoring trailing default 0 values.
		for (int i = 0; i < size; i++) {
			// Comparing
			if (list.get(i).data == x)
				return true;
		}
		// None found
		return false;
	}

	public int size() {
		return size;
	}

	void display() {
		for (int i = front; i < rear; i++)
			System.out.println(list.get(i).data);
	}

}