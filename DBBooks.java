package com.bhavesh.DAO;
import java.util.*;

import com.bhavesh.pojo.*;

import java.sql.*;

public class DBconnection {
	String pcg="com.mysql.jdbc.Driver";
	String path="jdbc:mysql://localhost:3306/Inventory_tracking";
	String user="root";
	String password="root";
	
	public ArrayList<Book> select()
		{
			ArrayList<Book> book= new ArrayList<Book>();
			try
			{
				int id;
				String title;
				String writer;
				String publisher;
				int publishYear;
				Class.forName(pcg);
				Connection conn = DriverManager.getConnection(path,user,password);
				Statement stmt=conn.createStatement();
				ResultSet rs=stmt.executeQuery("Select*from book;");
				
				while(rs.next())
				{
					id=rs.getInt(1);
					title=rs.getString(2);
					writer=rs.getString(3);
					publisher=rs.getString(4);
					publishYear=rs.getInt(5);
					Book b=new Book();
					b.setId(id);
					b.setTitle(title);
					b.setWriter(writer);
					b.setPublisher(publisher);
					b.setPublishYear(publishYear);
					book.add(b);
				}
				conn.close();
			}
			catch(Exception e)
			{
				e.getMessage();
			}
			return book;
		}
		public Book select(String titleName)
		{
			Book b=new Book();
			try
			{
				int id;
				String title;
				String writer;
				String publisher;
				int publishYear;
				Class.forName(pcg);
				Connection conn = DriverManager.getConnection(path,user,password);
				Statement stmt=conn.createStatement();
				ResultSet rs=stmt.executeQuery("Select*from book where title='"+titleName+"';");
				while(rs.next())
				{
					id=rs.getInt(1);
					title=rs.getString(2);
					writer=rs.getString(3);
					publisher=rs.getString(4);
					publishYear=rs.getInt(5);
					b.setId(id);
					b.setTitle(title);
					b.setWriter(writer);
					b.setPublisher(publisher);
					b.setPublishYear(publishYear);
				}
				conn.close();
		
			}
			catch(Exception e)
			{
				e.getMessage();
			}
			return b;
		}
		public int delete(int id)
		{
			int x=0;
			try
			{
				Class.forName(pcg);
				Connection conn = DriverManager.getConnection(path,user,password);
				Statement stmt=conn.createStatement();
				x=stmt.executeUpdate("delete from book where id="+id+";");
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
				x=stmt.executeUpdate(" delete from book ;");
				conn.close();
			}
			catch(Exception e)
			{
				e.getMessage();
		
			}
			return x;
		}
		public int update(Book b)
		{
			int x=0;
			try
			{
				Class.forName(pcg);
				Connection conn = DriverManager.getConnection(path,user,password);
				Statement stmt=conn.createStatement();
				x=stmt.executeUpdate("update book set writer='"+b.getWriter()+"',publisher='"+b.getPublisher()+"' where title='"+b.getTitle()+"' and publish_Year='"+b.getPublishYear()+"';");
				conn.close();
			}
			catch(Exception e)
			{
				e.getMessage();
			}
			return x;
		}
		public int add(Book b)
		{
			int x=0;
			try
			{
				Class.forName(pcg);
				Connection conn = DriverManager.getConnection(path,user,password);
				Statement stmt=conn.createStatement();
				x=stmt.executeUpdate("insert into book values("+b.getId()+",'"+b.getTitle()+"','"+b.getWriter()+"','"+b.getPublisher()+"',"+b.getPublishYear()+");");
				conn.close();
			}
			catch(Exception e)
			{
				e.getMessage();
		
			}
			return x;
		}

}
