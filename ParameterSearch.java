import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class ParameterSearch {
    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {     
                 {1,0 }, {5,2 }, {7,3 }, {11,-1} });
    }

    private int Input1;

    private int fExpected;

    public ParameterSearch(int input1, int expected) {
        this.Input1 = input1;
        this.fExpected = expected;
    }

    @Test
    public void test() {
    	int[] arr= {1,2,5,7,8,9};
    	search s=new search();
        assertEquals(fExpected, s.binarySearch(arr,0,arr.length-1,Input1));
    }
    @Test
    public void test1() {
    	int[] arr= {1,2,5,7,8,9};
    	search s=new search();
        assertEquals(fExpected, s.linearSearch(arr,0,Input1));
    }
    
}

