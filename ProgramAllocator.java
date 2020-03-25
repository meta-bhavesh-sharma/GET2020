package Student;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * this class allotcate programs to students according to their preference and their rank
 * @author Bhavesh
 *
 */
public class ProgramAllocator implements IQueue {
	
	Student queue[]=new Student[Max_Size];
	/**
	 * 
	 * @return the list to programs to allocate
	 */
	public Program[] getPrograms()
	{
		String csvFile = "C:\\Users\\Bhavesh\\workspace\\Stack\\src\\Student\\programes.csv";
		String line = "";
		Program programs[]=new Program[5];
		try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
			int i=0;
        while ((line = br.readLine()) != null) {

            // use comma as separator
            String[] data = line.split(",");

            String[] preferences = new String[5];
   
            	Program program=new Program(data[0],Integer.parseInt(data[1]));
            	programs[i]=program;
            	i++;
        }
		}
        catch(IOException e)
        {
        	e.getMessage();
        }
		return programs;

	}
	int front=0,rear=0,count=0;
	/**
	 * this method check whether queue is full or not return true if queue is full else return false
	 */
	public Boolean isFull()
	{
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
	public int size()
	{
		return count;
	}
	/**
	 * this method delete the value from front of the queue if queue is not empty
	 */
	public Student dequeue()
	{
		Student student=null;
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
			student=queue[front];
			front++;
			count--;
		}
		return student;
	}
	/**
	 * this method add the item to the queue
	 * @param item is the item to add in the queue
	 */
	public void enqueue(Student item)
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
		count++;

		}
	}
	/**
	 * 
	 * @param programs the list of programs that have to allocated
	 */
	public void allocateProgram(Program[] programs)
	{
		while(!this.isEmpty()){
			boolean alloted=false;
			Student student=this.dequeue();
			String[] preferences = student.getPrograms();
			outer:for(int i=0;i<preferences.length;i++)
			{
				for(int j=0;j<5;j++)
				{
					if(preferences[i].equals(programs[j].getName()) && programs[j].occupied!=programs[j].getCapacity())
					{
						String programAlloted=programs[j].getName();
						student.setProgramAlloted(programAlloted);
						programs[j].occupied+=1;
						System.out.println(student.getName()+" has alloted seat is of "+student.getProgramAlloted());
						alloted=true;
						break outer;
					}
				}
				
			}
			if(alloted==false)
			{
				System.out.println(student.getName()+" has no seat alloted  ");
			}
			
		}
	}
	
	
}
