package Student;
/**
 *  student class that hold data of student 
 * @author Bhavesh
 *
 */
public class Student {

	private String name;
	private String[] programs=new String[5];
	String programAlloted="";
	public Student(String name,String []programs)
	{
		this.name=name;
		this.programs=programs;
	}
	public String getName()
	{
		return name;
	}
	public String[] getPrograms()
	{
		return programs;
	}
	public String getProgramAlloted() {
		return programAlloted;
	}

	public void setName(String name) {
		this.name = name;
	}
	public void setPrograms(String[] programs) {
		this.programs = programs;
	}
	public void setProgramAlloted(String programAlloted) {
	
		this.programAlloted=programAlloted;
	}
	
}
