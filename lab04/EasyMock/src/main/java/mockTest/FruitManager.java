package mockTest;


public class FruitManager {
	
	private IMyList fruits;
	
	public FruitManager(IMyList fruits) {
		super();
		this.fruits = fruits;
	}

	public void add(Fruit f){
		fruits.add(f);
	}
							
	public IMyList getAll(){
		return fruits;
	}	
}
