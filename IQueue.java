package Student;
/**
 * 
 * @author Bhavesh
 *
 */
public interface IQueue {
	int Max_Size=10;
	Boolean isFull();
	Boolean isEmpty();
	Student dequeue();
	void enqueue(Student item);
	int size();
	
}
