package Student;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class View {
	public static void main(String []args)
	{
		ProgramAllocator programAllocator=new ProgramAllocator();
		String csvFile = "C:\\Users\\Bhavesh\\workspace\\Stack\\src\\Student\\data.csv";
        String line = "";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] data = line.split(",");

                String[] preferences = new String[5];
       
                for(int i=0;i<preferences.length;i++)
                {
                	preferences[i]=data[i+1];
                }
                Student student=new Student(data[0],preferences);
                programAllocator.enqueue(student);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

		Program programs[]=programAllocator.getPrograms();
		programAllocator.allocateProgram(programs);

	}

}
