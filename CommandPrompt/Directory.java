package CommandPrompt;

import java.util.ArrayList;
import java.util.Date;
/**
 * 
 * @author Bhavesh
 *
 */
public class Directory {
	Date time;
	String name;
	Directory parent;
	ArrayList<Directory> subDirectories=new ArrayList<Directory>();
	public Directory(Directory parent,Date time,String name)
	{
		this.parent=parent;
		this.name=name;
		this.time=time;
	}
	public void addSubDirectory(Directory directory)
	{
		subDirectories.add(directory);
	}
	public ArrayList<Directory> getSubDirectories()
	{
		return subDirectories;
	}
	public String getName()
	{
		return name;
	}
	public Date getTime()
	{
		return time;
	}
	public Directory getParent()
	{
		return parent;
	}
	
}
