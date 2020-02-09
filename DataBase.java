package com.bhavesh.DAO;

import java.util.ArrayList;

public class DataBase {
	 public static ArrayList<Integer> itom_no = new ArrayList<Integer>(5);
	 public static ArrayList<Integer> quantitylist = new ArrayList<Integer>(5);
	public static void addData(int num,int quantity)
	{
		itom_no.add(num);
		quantitylist.add(quantity);
	}
	public static void updateData(int num,int quantity)
	{
		quantitylist.set(DataBase.search(num),quantity);
	}
	public static void deleteData(int num)
	{
		itom_no.remove(DataBase.search(num) - 1);
		quantitylist.remove(DataBase.search(num) - 1);
	}
	/**
	 * aditional function for traverse the cart
	 * 
	 * @param n
	 *            item number
	 * @return index where the item situated in cart
	 */
	public static  int search(int n) {
		int x = 0;
		for (int i = 0; i < itom_no.size(); i++)
			if (itom_no.get(i) == n)
				x = i + 1;
		return x;
	}

}
