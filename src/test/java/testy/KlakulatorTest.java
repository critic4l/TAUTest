package testy;

import static org.junit.Assert.*;

import org.junit.Test;

public class KlakulatorTest {
	Kalkulator kalk = new Kalkulator();
	@Test
	public void testAdd() throws Exception {
		assertEquals(5, kalk.add(2,3));
		assertNotNull(kalk.add(0,0));
	}
	
	@Test
	public void testSub() throws Exception {
		assertEquals(3, kalk.sub(5, 2));
		assertNotNull(kalk.sub(0, 0));
	}
	
	@Test
	public void testDiv() throws Exception {
		assertEquals(5, kalk.div(25, 5));
		assertNotNull(kalk.div(1,1));
	}
	
	@Test
	public void testMulti() throws Exception {
		assertEquals(25, kalk.div(5,5));
		assertNotNull(kalk.multi(0, 0));
	}
}
