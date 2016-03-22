package mockTest;

public interface IMyList {
	
	public void add(Fruit fruit);
	Fruit get(int index);
	IMyList getAll();
	int size();
	boolean isEmpty();
	
}
