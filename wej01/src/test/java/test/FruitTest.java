package test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import fruit.Fruit;

public class FruitTest {
	Fruit apple = new Fruit("Apple", "Spain");
	Fruit pear = new Fruit("Pear", "Poland");
	
	public List<Fruit> fruits = new ArrayList<>();
	
	@Test
	public void addTest() throws Exception{
		assertEquals(fruits.size(), 0);
		fruits.add(0, apple);
		assertEquals(fruits.size(), 1);
		fruits.add(1, pear);
		assertEquals(fruits.size(), 2);
	}
}