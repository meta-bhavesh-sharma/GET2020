import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class ParameterTestLCM {
    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {     
                 { 12,39,156 }, { 4,6,12 }, { 36,24,72}, {21,28,84} });
    }

    private int Input1;
    private int Input2;

    private int fExpected;

    public ParameterTestLCM(int input1,int input2, int expected) {
        this.Input1 = input1;
        this.Input2 = input2;
        this.fExpected = expected;
    }

    @Test
    public void test() {
    	LcmHcf l1=new LcmHcf();
        assertEquals(fExpected, l1.LCM(Input1,Input2));
    }
    
}
