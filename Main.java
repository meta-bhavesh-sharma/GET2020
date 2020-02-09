package com.bhavesh.view;
import com.bhavesh.service.*;
import com.bhavesh.DAO.*;
import com.bhavesh.pojo.*;

import java.util.*;


public class Main {

	// driver code
		public static void main(String args[]) {
			int n, quantity;
			// adding items into store
			Store.list.add(new Items(1, "pen", 10,"Stationary"));
			Store.list.add(new Items(2, "pencil", 20,"Stationary"));
			Store.list.add(new Items(3, "rubber", 30,"Stationary"));
			Store.list.add(new Items(4, "scale", 40,"Stationary"));
			Store.list.add(new Items(5, "colors", 50,"Stationary"));
			Store.list.add(new Items(6, "fluid", 60,"Stationary"));
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
					showCart();
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
					generateBill();
				} else if (choise == 0) {
					System.exit(0);
				} else {
					sc.close();
					System.out.println("please choose correct option");
				}
			}

		}
		/**
		 * final bill generate with ammount of an item and total ammount
		 * 
		 */
		public static void generateBill() {
			int flag = 0;
			Double sum = 0.00;
			for (int i = 0; i < DataBase.itom_no.size(); i++) {
				if (DataBase.quantitylist.get(i) == 0)
					continue;
				System.out.println("item number 	" + "item name	"
						+ "quantitylist 	" + "Ammount		");
				System.out.println(DataBase.itom_no.get(i) + "		"
						+ Store.list.get(DataBase.itom_no.get(i) - 1).item_name + "		"
						+ DataBase.quantitylist.get(i) + "		" + DataBase.quantitylist.get(i)
						* Store.list.get(DataBase.itom_no.get(i) - 1).price + "RS");
				sum = sum + DataBase.quantitylist.get(i)
						* Store.list.get(DataBase.itom_no.get(i) - 1).price;
				flag = 1;
			}
			if (flag == 0) {
				System.out.println("The Cart is empty");
			}
			System.out.println("Total Ammount:-" + sum + "Rs");
		}
		/**
		 * method to display cart
		 * 
		 */
		public static  void showCart() {
			int flag = 0;
			System.out.println("Item No.	" + "Item Name	" + "DataBase.quantitylist 	");
			for (int i = 0; i < DataBase.itom_no.size(); i++) {
				if (DataBase.quantitylist.get(i) != 0)
				System.out.println(DataBase.itom_no.get(i) + "		"
						+ Store.list.get(DataBase.itom_no.get(i) - 1).item_name + "		"
						+ DataBase.quantitylist.get(i));
				flag = 1;
			}
			if (DataBase.itom_no.size() >0 || flag==0)
			{
				System.out.println("The Cart is empity");
				return;
			}
		}

}
