package Question1;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class EmployeeMap {
static Map<Integer ,Employee> map=new HashMap<Integer ,Employee>();
	
	static boolean input(Employee emp)
	{
		if(!map.containsKey(emp.getId()))
		{
			map.put(emp.getId(), emp);
			return true;
		}
		else
		{
			System.out.println("Employee Already Exists");
			return false;
		}
	}
	public static void main(String args[])
	{
		
		
		input(new Employee(110,"Bhavesh","Jaipur"));
		input(new Employee(110,"Bhavesh","Jaipur"));
		System.out.println(map);
		
	}
}
