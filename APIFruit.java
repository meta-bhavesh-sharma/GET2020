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
	
@Path("/{name}")
@GET
@Produces(MediaType.APPLICATION_JSON)
public String sendData( @PathParam("name") String itemName) {
	Inventory I=new Inventory();
	Fruit f=new Fruit();
	f=I.getInventory(itemName);
	String resultData ="{{'name':"+f.getName()+"},{'quantity':"+f.getQuantity()+"}}";
	return resultData;

}

@Path("/")
@GET
@Produces(MediaType.APPLICATION_JSON)
public ArrayList sendData() {
	ArrayList<Fruit> list=new ArrayList();
	Inventory I=new Inventory();
	list=I.getInventory();
	String resultData="{";
	for(int i=0;i<list.size();i++)
	{
		resultData=resultData+"{'name':"+list.get(i).getName()+"},{'quantity':"+list.get(i).getQuantity()+"}";
	}
	resultData=resultData+"}";
	return list;
	
}
@PUT
@Path("/update")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public String changeData(Fruit item) {
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
@PUT
@Path("/updatelist")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public String changeData(Fruits list) {
	Inventory i=new Inventory();
	int b=i.changeInventory(list);
	if(b>0)
	{
		return "success";
	}
	else
	{
		return "failure";
	}
}
@Path("delete/{name}")
@DELETE		
@Produces(MediaType.APPLICATION_JSON)
public String deleteData( @PathParam("name") String itemName) {
	Inventory I=new Inventory();
	boolean x=I.deleteInventory(itemName);
	if(x==true)
		return "Success";
	else
		return "Faileure";


}

@Path("/delete")
@DELETE
@Produces(MediaType.APPLICATION_JSON)
public String deleteData() {
	Inventory I=new Inventory();
	int x=I.deleteInventory();
	if(x>0)
		return "Success";
	else
		return "Faileure";
}
@Path("/add")
@POST 
@Produces(MediaType.APPLICATION_JSON)
public String addData(Fruit item) {
	Inventory I=new Inventory();
	int x=I.addInventory(item);
	if(x>0)
		return "Success";
	else
		return "Faileure";
}



}