import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestCalculator {

    private Calculator calculator;
    private final String EXCEEDED_UPPER_LIMIT;
    private final String EXCEEDED_LOWER_LIMIT;

    public TestCalculator() {
        EXCEEDED_UPPER_LIMIT = "Exception is not being thrown when exceeding upper limit.";
        EXCEEDED_LOWER_LIMIT = "Exception is not being thrown when exceeding lower limit.";
    }

    @Before
    public void setUp() {
        calculator = new Calculator(-100, 100);
    }

    @Test
    public void testNumbersSum() {
        int result = calculator.add(1, 1);
        assertEquals(result, 2);
    }

    @Test
    public void testDifferentNumbersSum() {
        int result = calculator.add(5, 3);
        assertEquals(result, 8);
    }

    @Test
    public void testNumbersSubstraction() {
        int result = calculator.substract(1, 1);
        assertEquals(result, 0);
    }

    @Test
    public void testDifferentNumbersSubstraction() {
        int result = calculator.substract(3, 7);
        assertEquals(result, -4);
    }

    @Test
    public void testSetAndGetUpperLimit() {
        calculator.setUpperLimit(200);
        assertEquals(200, calculator.getUpperLimit());
    }

    @Test
    public void testSetAndGetLowerLimit() {
        calculator.setLowerLimit(-200);
        assertEquals(-200, calculator.getLowerLimit());
    }

    @Test
    public void testExceededUpperLimit() {
        try {
            int result = calculator.add(99, 5);
            fail(EXCEEDED_UPPER_LIMIT);
        } catch (RuntimeException e) {}
    }

    @Test
    public void testExceededLowerLimit() {
        try {
            int result = calculator.substract(-99, 5);
            fail(EXCEEDED_LOWER_LIMIT);
        } catch (RuntimeException e) {}
    }

    @Test
    public void testFirstParameterExceededALimit() {
        try {
            int result = calculator.substract(101, 3);
            fail(EXCEEDED_UPPER_LIMIT);
        } catch (RuntimeException e) {}
    }

    @Test
    public void testSecondParameterExceededALimit() {
        try {
            int result = calculator.add(90, -103);
            fail(EXCEEDED_LOWER_LIMIT);
        } catch (RuntimeException e) {}
    }
}
