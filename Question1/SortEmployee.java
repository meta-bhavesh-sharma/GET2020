package Question1;
import java.util.*;
import java.lang.Comparable;

public class SortEmployee {
	static ArrayList<Employee> list=new ArrayList<Employee>();
	
	
	public static void main(String args[])
	{
		list.add(new Employee(13,"Bhavesh","Jaipur"));
		list.add(new Employee(20,"Anuj","Jaipur"));
		list.add(new Employee(10,"Udit","Jaipur"));
		list.add(new Employee(12,"ABhishek","Jaipur"));
		list.add(new Employee(28,"Dwarika","Jaipur"));

		System.out.println(list.toString());
		Collections.sort(list,new NameSorter());
		System.out.println(list.toString());
	}

}
