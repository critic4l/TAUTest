package fruit;

import java.util.ArrayList;
import java.util.List;

public class FruitManager {
	public List<Fruit> fruits = new ArrayList<>();
	
	public void dodaj(Fruit fruit){
		fruits.add(fruit);
	}
	
	public List<Fruit> getAll(){
		return fruits;
	}		
}
