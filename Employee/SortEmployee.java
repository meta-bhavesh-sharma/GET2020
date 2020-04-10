package Employee;

public class SortEmployee {
	Employee head;
	Employee sorted;

	void insert(Employee emp) {
		Employee temp = null;
		if (head == null) {
			head = emp;
		} else {
			temp = head;
			while (temp.next != null) {
				temp = temp.next;
			}
			temp.next = emp;
		}

	}

    void insertionSort()  
    {  
    	sorted = null; 
    	Employee current = head; 
        while (current != null)  
        {  
        	Employee next = current.next; 
            sortedInsert(current); 
            current = next; 
        } 
        head = sorted; 
    } 
  
    void sortedInsert(Employee newnode)  
    { 
        if (sorted == null || sorted.salary < newnode.salary)  
        { 
            newnode.next = sorted; 
            sorted = newnode; 
        } 
        else 
        { 
            Employee current = sorted; 
            while (current.next != null && (current.next.salary > newnode.salary || current.next.age > newnode.age))  
            { 
                current = current.next; 
            } 
            newnode.next = current.next; 
            current.next = newnode; 
        } 
    } 


	void Display() {
		System.out.println(head.toString());
	}

	public static void main(String args[]) {
		SortEmployee sortEmp = new SortEmployee();
		sortEmp.insert(new Employee("Bhavesh", 112, 25000, 23));
		sortEmp.insert(new Employee("Anuj", 113, 20000, 22));
		sortEmp.insert(new Employee("Agraj", 115, 20000, 23));
		sortEmp.insert(new Employee("Dwarika", 114, 30000, 26));
		sortEmp.Display();
		sortEmp.insertionSort();
		sortEmp.Display();

	}

	
}
