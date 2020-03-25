package Student;
/**
 * pogram class that hold the data of program 
 * @author Bhavesh
 *
 */
public class Program {
private String name;
private int capacity;
public int occupied=0;
public Program(String name,int capacity)
{
	this.name=name;
	this.capacity=capacity;
}
public String getName()
{
	return name;
}
public int getCapacity()
{
	return capacity;
}
public int getOccupied() {
	return occupied;
}
public void setOccupied(int occupied) {
	this.occupied = occupied;
}
public void setName(String name) {
	this.name = name;
}
public void setCapacity(int cap) {
	System.out.println(cap);
	this.capacity = cap;
	System.out.println(this.capacity);
}
@Override
public String toString() {
	return "Program [name=" + name + ", capacity=" + capacity + ", occupied="
			+ occupied + ", getName()=" + getName() + ", getCapacity()="
			+ getCapacity() + ", getOccupied()=" + getOccupied()
			+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
			+ ", toString()=" + super.toString() + "]";
}

}
