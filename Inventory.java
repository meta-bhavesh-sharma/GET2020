package com.bhavesh.service;
import com.bhavesh.DAO.*;
import com.bhavesh.pojo.*;

import java.util.*;

public class Inventory {
	
	public ArrayList<Book> getInventory()
	{
		DBconnection db=new DBconnection(); 
		return db.select();
	}
	public	Book getInventory(String title)
	{
		DBconnection db=new DBconnection(); 
		return db.select(title);
	}
	public	int changeInventory(Book b)
	{
		DBconnection db=new DBconnection(); 
		int x=db.update(b);
		return x;
	}
	public	int deleteInventory()
	{
		DBconnection db=new DBconnection(); 
		return db.delete();
	}
	public int deleteInventory(int id)
	{
		DBconnection db=new DBconnection(); 
		return db.delete(id);
	}
	public	int addInventory(Book item)
	{
		DBconnection db=new DBconnection(); 
		return db.add(item);
	}

}
