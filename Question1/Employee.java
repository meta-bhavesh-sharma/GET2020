package Question1;



public class Employee implements Comparable<Employee>{
	int id;
	String name;
	String Address;
	
	public Employee(int id, String name, String address) {
		super();
		this.id = id;
		this.name = name;
		Address = address;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Override
	public int compareTo(Employee emp)
	{
		return this.id-emp.id;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", Address=" + Address
				+ "]";
	}
	
	
}
