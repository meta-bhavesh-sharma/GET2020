package com.bhavesh.DAO;
import java.util.*;

import com.bhavesh.pojo.*;

import java.sql.*;

public class DBconnection {
	String pcg="com.mysql.jdbc.Driver";
	String path="jdbc:mysql://localhost:3306/Inventory_tracking";
	String user="root";
	String password="root";
	
	public ArrayList<Fruit> select()
		{
			ArrayList<Fruit> items= new ArrayList<Fruit>();
			try
			{
				String name;
				int quantity;
				Class.forName(pcg);
				Connection conn = DriverManager.getConnection(path,user,password);
				Statement stmt=conn.createStatement();
				ResultSet rs=stmt.executeQuery("Select*from items;");
				
				while(rs.next())
				{
					Fruit f=new Fruit();
					name=rs.getString(1);
					quantity=rs.getInt(2);
					f.setName(name);
					f.setQuantity(quantity);
					items.add(f);
				}
				conn.close();
			}
			catch(Exception e)
			{
				e.getMessage();
			}
			return items;
		}
		public ArrayList<Fruit> select(String fruitName)
		{
			ArrayList<Fruit> items= new ArrayList<Fruit>();
			try
			{
				String name;
				int quantity;
				Class.forName(pcg);
				Connection conn = DriverManager.getConnection(path,user,password);
				Statement stmt=conn.createStatement();
				ResultSet rs=stmt.executeQuery("Select*from items where name='"+fruitName+"';");
				while(rs.next())
				{
					Fruit f=new Fruit();
					name=rs.getString(1);
					quantity=rs.getInt(2);
					f.setName(name);
					f.setQuantity(quantity);
					items.add(f);
				}
				conn.close();
		
			}
			catch(Exception e)
			{
				e.getMessage();
			}
			return items;
		}
		public boolean delete(String fruitName)
		{
			boolean x=false;
			try
			{
				Class.forName(pcg);
				Connection conn = DriverManager.getConnection(path,user,password);
				Statement stmt=conn.createStatement();
				x=stmt.execute("delete*from items where name="+fruitName+";");
				conn.close();
			}
			catch(Exception e)
			{
				e.getMessage();
		
			}
			return x;
		}
		public int delete()
		{
			int x=0;
			try
			{
				Class.forName(pcg);
				Connection conn = DriverManager.getConnection(path,user,password);
				Statement stmt=conn.createStatement();
				x=stmt.executeUpdate(" delete from items ;");
				conn.close();
			}
			catch(Exception e)
			{
				e.getMessage();
		
			}
			return x;
		}
		public int update(String fruitName ,int quantity)
		{
			int x=0;
			try
			{
				Class.forName(pcg);
				Connection conn = DriverManager.getConnection(path,user,password);
				Statement stmt=conn.createStatement();
				x=stmt.executeUpdate("update items set quantity="+quantity+" where name='"+fruitName+"';");
				conn.close();
			}
			catch(Exception e)
			{
				e.getMessage();
			}
			return x;
		}
		public int add(String name,int quantity)
		{
			int x=0;
			try
			{
				Class.forName(pcg);
				Connection conn = DriverManager.getConnection(path,user,password);
				Statement stmt=conn.createStatement();
				x=stmt.executeUpdate("insert into items values('"+name+"',"+quantity+");");
				conn.close();
			}
			catch(Exception e)
			{
				e.getMessage();
		
			}
			return x;
		}

}
