
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ZooTest implements abs {
	
	@Test
	public void test()
	{
		Animal a=new Crow("C11",23.00f,44);
		assertEquals("Chirping",a.getSound());
	}
	@Test
	public void test1()
	{
		Animal a=new Crow("C11",23.00f,44);
		
		assertEquals(true,n3.alocateAnimal(a));
	}
	public void test2()
	{
		Animal a=new Crow("C11",23.00f,44);
		
		assertEquals(true,n3.removeAnimal(a));
	}

}
