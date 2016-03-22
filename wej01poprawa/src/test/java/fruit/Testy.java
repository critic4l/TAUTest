package fruit;

import static org.junit.Assert.*;

import org.junit.Test;


public class Testy {
	Fruit apple = new Fruit("Apple", "Spain");
	Fruit pear = new Fruit("Pear", "Poland");
	FruitManager fm = new FruitManager();
	
	@Test
	public void addTest() throws Exception{
		fm.dodaj(apple);
		assertEquals("Apple", fm.getAll().get(0).getName());
		assertEquals("Spain", fm.getAll().get(0).getOrigin());
		fm.dodaj(pear);
		assertEquals("Pear", fm.getAll().get(1).getName());
		assertEquals("Poland", fm.getAll().get(1).getOrigin());
	}
		
	@Test
	public void getTest() throws Exception{
		fm.dodaj(apple);
		fm.dodaj(pear);
		assertEquals(2, fm.getAll().size());
	}
}
