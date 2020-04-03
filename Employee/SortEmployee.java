package Employee;

public class SortEmployee {
	Employee head;
	Employee end;
	Employee sorted;

	void insert(Employee emp) {
		Employee temp = null;
		if (head == null) {
			head = emp;
			end=emp;
		} else {
			temp = head;
			while (temp.next != null) {
				temp = temp.next;
			}
			temp.next = emp;
			end=temp.next;
		}

	}


  

 Employee paritionLast(Employee start, Employee end) 
 { 
     if(start == end ||  
        start == null || end == null) 
         return start; 
   
     Employee pivot_prev = start; 
     Employee curr = start;  
     Employee pivot = end;  

     while(start != end ) 
     { 
         if(start.salary > pivot.salary) 
         {  
           
             pivot_prev = curr;  
             int temp = curr.salary;  
             curr.salary = start.salary;  
             start.salary = temp; 
             
              temp = curr.id;  
             curr.id = start.id;  
             start.id = temp; 
             
             String name = curr.name;  
            curr.name = start.name;  
            start.name = name;

            temp = curr.age;  
           curr.age = start.age;  
           start.age = temp;
           
             curr = curr.next;  
         } 
         start = start.next;  
     } 

     Employee temp = curr;  
     curr = pivot;  
     end = temp;  
   
     return pivot_prev; 
 } 
   
 void sort(Employee start, Employee end) 
 { 
     if(start == end ) 
         return; 

     Employee pivot_prev = paritionLast(start, end); 
     sort(start, pivot_prev); 

     if( pivot_prev != null &&  
         pivot_prev == start ) 
         sort(pivot_prev.next, end); 
           
     else if(pivot_prev != null &&  
             pivot_prev.next != null) 
         sort(pivot_prev.next.next, end); 
 } 


	void Display() {
		System.out.println(head.toString());
	}

	public static void main(String args[]) {
		SortEmployee sortEmp = new SortEmployee();
		sortEmp.insert(new Employee("Anuj", 113, 20000, 22));
		sortEmp.insert(new Employee("Agraj", 115, 20000, 23));
		sortEmp.insert(new Employee("Dwarika", 114, 30000, 26));
		sortEmp.insert(new Employee("Bhavesh", 112, 25000, 23));
		sortEmp.Display();
		sortEmp.sort(sortEmp.head,sortEmp.end);
		sortEmp.Display();

	}

	
}
