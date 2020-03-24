package Queue;
/**
 * 
 * @author Bhavesh
 *Queue class implements IQueue interface and its methods 
 **/
public class Queue implements IQueue
{
	int queue[]=new int[Max_Size];
	int front=0,rear=0;
	/**
	 * this method check whether queue is full or not return true if queue is full else return false
	 */
	public Boolean isFull()
	{
		int end=0;
		if((rear+1==front) ||(front==0 && rear==Max_Size) )
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	/**
	 * this method check whether queue is empty or not return true if queue is empty else return false
	 */
	public Boolean isEmpty()
	{
		if((front==rear))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	/**
	 * this method delete the value from front of the queue if queue is not empty
	 */
	public void delete()
	{
		if(this.isEmpty())
		{
			System.out.println("Queue is already Empty");
		}
		else
		{
			if(front==Max_Size)
			{
				front=0;
			}
			System.out.println(queue[front]+" Deleted");
			front++;
			
		}

	}
	/**
	 * this method add the q
	 * @param item is the item to add in the queue
	 */
	public void add(int item)
	{
		if(this.isFull())
		{
			System.out.println("Queue is already full");
		}
		else 
		{
		if(rear==Max_Size)
		{
			rear=0;
		}
		queue[rear]=item;
		rear++;
		System.out.println(item+" Added");

		}
	}
	public void printQueue()
	{
		if(this.isEmpty()) {
			System.out.println("Queue is Empty");
		}
		else
		{
		System.out.println("Queue is :- ");
		int tempRear=rear;
		if(rear<front)
		{
			tempRear=tempRear+Max_Size;
		}
		for(int i=front;i<rear;i++)
		{
			if(i==Max_Size)
			{
				i=0;
			}
			System.out.print(queue[i]+" ");
		}
		System.out.println();
	}
	}
	
	public static void main(String[] args) {
		Queue queue=new Queue();
		queue.delete();
		queue.add(10);
		queue.add(20);
		queue.add(30);
		queue.add(40);
		queue.add(50);
		queue.add(60);
		queue.delete();
		queue.printQueue();
		queue.delete();
		queue.delete();
		queue.add(60);
		queue.delete();
		queue.delete();
		queue.delete();
		queue.delete();
		queue.printQueue();
		
	}
	

}
