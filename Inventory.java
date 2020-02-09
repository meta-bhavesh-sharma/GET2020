package com.bhavesh.service;
import com.bhavesh.DAO.*;
import com.bhavesh.pojo.*;
import java.util.*;

public class Inventory {
	
	public ArrayList<Fruit> getInventory()
	{
		DBconnection db=new DBconnection(); 
		return db.select();
	}
	public	Fruit getInventory(String name)
	{
		DBconnection db=new DBconnection(); 
		ArrayList<Fruit> inventory=db.select(name);
		Fruit f=inventory.get(0);
		return f;
	}
	public	int changeInventory(Fruit f)
	{
		DBconnection db=new DBconnection(); 
		int x=db.update(f.getName(),f.getQuantity());
		return x;
	}
	public	int changeInventory(Fruits f)
	{
		int x=0;
		DBconnection db=new DBconnection(); 
		for(int i=0;i<f.fruits.size();i++)
		{
			x=db.update(f.fruits.get(i).getName(),f.fruits.get(i).getQuantity());
		}
		return x;
	}
	public	int deleteInventory()
	{
		DBconnection db=new DBconnection(); 
		return db.delete();
	}
	public boolean deleteInventory(String name)
	{
		DBconnection db=new DBconnection(); 
		return db.delete(name);
	}
	public	int addInventory(Fruit item)
	{
		DBconnection db=new DBconnection(); 
		return db.add(item.getName(),item.getQuantity());
	}

}
