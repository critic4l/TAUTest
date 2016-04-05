package mockTest;

public class Fruit {
	
	public String name;
	public String origin;
	
	public Fruit(String name, String origin) {
		super();
		this.name = name;
		this.origin = origin;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}

}
