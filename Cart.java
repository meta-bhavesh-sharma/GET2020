package Assignment1;

/*
 programme to mannage online shopping cart
 add item,update quantityuantity,remove quantityuantity,display cart,generate bill
 */
import java.util.*;

class Cart {
	private ArrayList<Integer> itom_no = new ArrayList(5);
	private ArrayList<Integer> quantityuantity = new ArrayList(5);

	/**
	 * method for add to cart item
	 * 
	 * @param num
	 *            item number
	 * @param quantity
	 *            item quantity
	 */
	public void addToCart(int num, int quantity) {
		if (num <= 0 || quantity <= 0 || num > 6)// invalid inputs check
		{
			System.out.println("please enter velid details");
			return;
		}
		if (this.search(num) == 0) {
			itom_no.add(num);
			quantityuantity.add(quantity);
		} else {
			// if item allredy in cart then only quantityuantity update
			quantityuantity.set(this.search(num) - 1,
					quantityuantity.get(this.search(num) - 1) + quantity);
		}

	}

	/**
	 * method to update card details
	 * 
	 * @param num
	 *            item number
	 * @param quantity
	 *            item quantity
	 */
	public void updateCart(int num, int quantity) {
		if (num <= 0 || quantity <= 0 || num > 6)// invalid inputs check
		{
			System.out.println("please enter velid details");
			return;
		}
		int flag = 0;
		if (this.search(num) == 0)// check item is in cart or not
		{
			System.out.println("item is not in cart please add it first");
		} else {
			quantityuantity.set(this.search(num) - 1, quantity);
		}
	}

	/**
	 * method to remove item from cart
	 * 
	 * @param num
	 */
	public void removeCart(int num) {
		int flag = 0;
		if (num <= 0 || num > 6)// invalid inputs check
		{
			System.out.println("please enter velid details");
			return;
		}
		if (this.search(num) == 0)// item check
		{
			System.out.println("Item is not in cart");
		} else {
			quantityuantity.set(this.search(num) - 1, 0);
		}
	}

	/**
	 * method to display cart
	 * 
	 */
	public void showCart() {
		System.out.println("Item No.	" + "Item Name	" + "quantityuantity 	");
		int flag = 0;
		for (int i = 0; i < itom_no.size(); i++) {
			if (quantityuantity.get(i) == 0)
				continue; // retriving item's names from store
			System.out.println(itom_no.get(i) + "		"
					+ Store.list.get(itom_no.get(i) - 1).item_name + "		"
					+ quantityuantity.get(i));
			flag = 1;
		}
		if (itom_no.size() == 0 || flag == 0)
			System.out.println("The Cart is empity");
	}

	/**
	 * final bill generate with ammount of an item and total ammount
	 * 
	 */
	public void generateBill() {
		int flag = 0;
		Double sum = 0.00;
		for (int i = 0; i < itom_no.size(); i++) {
			if (quantityuantity.get(i) == 0)
				continue;
			System.out.println("item number 	" + "item name	"
					+ "quantityuantity 	" + "Ammount		");
			System.out.println(itom_no.get(i) + "		"
					+ Store.list.get(itom_no.get(i) - 1).item_name + "		"
					+ quantityuantity.get(i) + "		" + quantityuantity.get(i)
					* Store.list.get(itom_no.get(i) - 1).price + "RS");
			sum = sum + quantityuantity.get(i)
					* Store.list.get(itom_no.get(i) - 1).price;
			flag = 1;
		}
		if (flag == 0) {
			System.out.println("The Cart is empty");
		}
		System.out.println("Total Ammount:-" + sum + "Rs");
	}

	/**
	 * aditional function for traverse the cart
	 * 
	 * @param n
	 *            item number
	 * @return index where the item situated in cart
	 */
	public int search(int n) {
		int x = 0;
		for (int i = 0; i < itom_no.size(); i++)
			if (itom_no.get(i) == n)
				x = i + 1;
		return x;
	}

	// driver code
	public static void main(String args[]) {
		int n, quantity;
		// adding items into store
		Store.list.add(new Items(1, "pen", 10));
		Store.list.add(new Items(2, "pencil", 20));
		Store.list.add(new Items(3, "rubber", 30));
		Store.list.add(new Items(4, "scale", 40));
		Store.list.add(new Items(5, "colors", 50));
		Store.list.add(new Items(6, "fluid", 60));
		System.out.println("Wellcome to aur online Mart");
		System.out.println("These are the availiable items");
		// items display
		for (int i = 0; i < 6; i++)
			System.out.println(Store.list.get(i).item_no + "	"
					+ Store.list.get(i).item_name + "		"
					+ Store.list.get(i).price);
		Cart c1 = new Cart();
		System.out.println("	1 for show cart");
		System.out.println("	2 for add to cart");
		System.out.println("	3 for update cart");
		System.out.println("	4 for Remove from cart");
		System.out.println("	5 for Generate Bill");
		System.out.println("	0 for exit");
		while (true) {
			Scanner sc = new Scanner(System.in);
			System.out.println("Select form the aveliable services:-");
			int choise;
			try {
				choise = sc.nextInt();
			} catch (InputMismatchException In) {
				In.getMessage();
				System.out.println("Please Select Valid Option");
				continue;
			}
			if (choise == 1)
				c1.showCart();
			else if (choise == 2) {
				System.out.println("please enter itom no and quantityuantity for add to cart");
				// exception handling for input missmatch exception
				try {
					n = sc.nextInt();
					quantity = sc.nextInt();
				} catch (InputMismatchException In) {
					In.getMessage();
					System.out.println("Please Select Valid Option");
					continue;
				}
				c1.addToCart(n, quantity);
			} else if (choise == 3) {
				System.out
						.println("please enter itom no and quantityuantity to update quantityuantity ");
				// exception handling for input missmatch exception
				try {
					n = sc.nextInt();
					quantity = sc.nextInt();
				} catch (InputMismatchException In) {
					In.getMessage();
					System.out.println("Please Select Valid Option");
					continue;
				}
				c1.updateCart(n, quantity);
			} else if (choise == 4) {
				System.out.println("please enter itom no to remove that item");
				// exception handling for input missmatch exception
				try {
					n = sc.nextInt();
				} catch (InputMismatchException In) {
					In.getMessage();
					System.out.println("Please Select Valid Option");
					continue;
				}
				c1.removeCart(n);
			} else if (choise == 5) {
				c1.generateBill();
			} else if (choise == 0) {
				System.exit(0);
			} else {
				System.out.println("please choose correct option");
			}
		}

	}
}

/*
 * Item class to store items of online store and for fututre change in aveliable
 * items
 */
class Items {
	int item_no;
	String item_name;
	Double price;

	public Items(int n, String name, double p) {
		this.item_no = n;
		this.item_name = name;
		this.price = p;
	}
}

/*
 * class Store to access items through store
 */
class Store {
	static ArrayList<Items> list = new ArrayList<Items>();

}
