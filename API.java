package com.bhavesh.controlor;

import com.bhavesh.DAO.*;
import com.bhavesh.pojo.*;
import com.bhavesh.service.*;

import java.awt.List;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/")
public class API {
	
@Path("/{title}")//ok
@GET
@Produces(MediaType.APPLICATION_JSON)
public String sendData( @PathParam("title") String title) {
	Inventory I=new Inventory();
	Book b=new Book();
	b=I.getInventory(title);
	String resultData ="{{'id':"+b.getId()+"},{'title':"+b.getTitle()+"},{'writer':"+b.getWriter()+"},{'publisher':"+b.getPublisher()+"},{'publish_year':"+b.getPublishYear()+"}}";
	return resultData;

}

@Path("/")//ok
@GET
@Produces(MediaType.APPLICATION_JSON)
public ArrayList sendData() {
	ArrayList<Book> list=new ArrayList();
	Inventory I=new Inventory();
	list=I.getInventory();
	return list;
	
}
@PUT
@Path("/update")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public String changeData(Book item) {
	Inventory i=new Inventory();
	int b=i.changeInventory(item);
	if(b>0)
	{
		return "sucess";
	}
	else
	{
		return "failure";
	}
}
@Path("delete/{id}")//ok
@DELETE		
@Produces(MediaType.APPLICATION_JSON)
public String deleteData( @PathParam("id") int id) {
	Inventory I=new Inventory();
	int x=I.deleteInventory(id);
	if(x>0)
		return "Success";
	else
		return "faileure";

}

@Path("/delete")//ok
@DELETE
@Produces(MediaType.APPLICATION_JSON)
public String deleteData() {
	Inventory I=new Inventory();
	int x=I.deleteInventory();
	if(x>0)
		return "Success";
	else
		return "faileure";
}
@Path("/add")
@POST 
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public String addData(Book item) {
	

	Inventory I=new Inventory();
	int x=I.addInventory(item);
	if(x>0)
		return "Success";
	else
		return "faileure";
}



}