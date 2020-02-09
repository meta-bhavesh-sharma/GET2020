package com.bhavesh.service;
import com.bhavesh.DAO.*;
import com.bhavesh.pojo.*;

public class Cart {
	/**
	 * method for add to cart item
	 * 
	 * @param num
	 *            item number
	 * @param quantity
	 *            item quantity
	 */
	public boolean addToCart(int num, int quantity) {
		if (num <= 0 || quantity <= 0 || num > 6)// invalid inputs check
		{
			return false;
		}
		if (DataBase.search(num) == 0) {
			DataBase.addData(num,quantity);
			return true;
		} else {
			// if item allredy in cart then only DataBase.quantitylist update
			DataBase.updateData(num,DataBase.quantitylist.get(DataBase.search(num) - 1) + quantity);
			return true;
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
		}
		if (DataBase.search(num) == 0)// check item is in cart or not
		{
			System.out.println("item is not in cart please add it first");
		} else {
			DataBase.updateData(DataBase.search(num) - 1, quantity);
		}
	}

	/**
	 * method to remove item from cart
	 * 
	 * @param num
	 */
	public void removeCart(int num) {
		if (num <= 0 || num > 6)// invalid inputs check
		{
			System.out.println("please enter velid details");
			return;
		}
		if (DataBase.search(num) == 0)// item check
		{
			System.out.println("Item is not in cart");
		} else {
			DataBase.quantitylist.set(DataBase.search(num) - 1, 0);
		}
	}

	/**
	 * method to display cart
	 * 
	 */
	public void showCart() {
		System.out.println("Item No.	" + "Item Name	" + "DataBase.quantitylist 	");
		int flag = 0;
		for (int i = 0; i < DataBase.itom_no.size(); i++) {
			if (DataBase.quantitylist.get(i) == 0)
			System.out.println(DataBase.itom_no.get(i) + "		"
					+ Store.list.get(DataBase.itom_no.get(i) - 1).item_name + "		"
					+ DataBase.quantitylist.get(i));
			flag = 1;
		}
		if (DataBase.itom_no.size() == 0 || flag == 0)
			System.out.println("The Cart is empity");
	}

	
	
}
