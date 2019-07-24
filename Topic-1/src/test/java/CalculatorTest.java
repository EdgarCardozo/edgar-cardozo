import org.junit.Assert;
import org.junit.Test;

public class CalculatorTest {
    @Test
    public void additionTest(){
        int result = Calculator.add(5,1);
        int expected = 6;//5+1=6
        Assert.assertEquals(expected,result);
    }

    @Test
    public void subtractionTest(){
        int result = Calculator.subtract(5,1);
        int expected = 4; //5-1=4
        Assert.assertEquals(expected,result);
    }
}
