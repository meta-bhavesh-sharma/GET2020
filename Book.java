package com.bhavesh.pojo;

public class Book {
	private int id;
	private String title;
	private String writer;
	private String publisher;
	private int publishYear;
	public int getId()
	{
		return this.id;
	}
	public void setId(int id)
	{
		this.id=id;
	}
	public String getTitle()
	{
		return this.title;
	}
	public void setTitle(String title)
	{
		this.title=title;
	}
	
	public String getWriter()
	{
		return this.writer;
	}
	public void setWriter(String writer)
	{
		this.writer = writer;
	}
	public void setPublisher(String publisher)
	{
		this.publisher=publisher;
	}
	public String getPublisher()
	{
		return this.publisher;
	}
	public void setPublishYear(int publishYear)
	{
		this.publishYear=publishYear;
	}
	public int getPublishYear()
	{
		return this.publishYear;
	}
}
