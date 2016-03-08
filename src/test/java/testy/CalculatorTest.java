package testy;

import org.junit.*;

import static org.junit.Assert.*;

public class CalculatorTest {
    Calculator calc = new Calculator();
    @Test
    public void testAdd() throws Exception {
        assertEquals(5, calc.add(2,3));;
        assertNotNull(calc.add(0,0));
    }

    @Test
    public void testSub() throws Exception {
        assertEquals(-1, calc.sub(2,3));
        assertNotNull(calc.sub(0,0));
    }

    @Test
    public void testMulti() throws Exception {
        assertEquals(6, calc.multi(2,3));
        assertNotNull(calc.multi(0,0));
    }

    @Test
    public void testDiv() throws Exception {
        assertEquals(2, calc.div(6,3));
        assertNotNull(calc.div(1,1));
    }
}