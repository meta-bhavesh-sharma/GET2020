package com.bhavesh.pojo;


/*
 * Item class to store items of online store and for fututre change in aveliable
 * items
 */
public class Items {
	public int item_no;
	public String item_name;
	public Double price;
	public String type;
	

	public Items(int n, String name, double p,String t) {
		this.item_no = n;
		this.item_name = name;
		this.price = p;
		this.type = t;
	}
}