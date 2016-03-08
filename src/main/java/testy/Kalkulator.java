package testy;

public class Kalkulator {
	public int add(int x, int y){
		return x+y;
	}
	
	int sub(int x, int y){
		return x-y;
	}
	
	int multi(int x, int y){
		return x*y;
	}
	
	int div(int x, int y){
		if(y == 0 ){
			throw new IllegalArgumentException("Arg y is 0 ");
		}
		else return x/y;
	}
}
