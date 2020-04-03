package Employee;

public class Employee {

	String name;
	int id;
	int salary;
	int age;
	Employee next;
	
	public Employee(String name, int id, int salary, int age) {
		super();
		this.name = name;
		this.id = id;
		this.salary = salary;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Employee [name=" + name + ", id=" + id + ", salary=" + salary
				+ ", age=" + age + ", next=" + next + "]";
	}

	
	
}
