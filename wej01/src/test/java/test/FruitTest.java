package test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import fruit.Fruit;
import fruit.FruitManager;

public class FruitTest {
	Fruit apple = new Fruit("Apple", "Spain");
	Fruit pear = new Fruit("Pear", "Poland");
	FruitManager fm = new FruitManager();
	
	@Test
	public void addTest() throws Exception{
		assertEquals(fm.fruits.size(), 0);
		fm.dodaj(apple);
		assertEquals(fm.fruits.size(), 1);
		assertEquals("Apple", fm.fruits.get(0).getName());
		fm.dodaj(pear);
		assertEquals(fm.fruits.size(), 2);
		assertEquals("Pear", fm.fruits.get(1).getName());
	}
	
	@Test
	public void getTest() throws Exception{
		fm.dodaj(apple);
		fm.dodaj(pear);
		assertEquals(2, fm.fruits.size());
	}
}