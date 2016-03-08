package testy;
public class Calculator {
    public int add(int a,int b){
        return a+b;
    }
    int sub(int a, int b) { return a-b; }
    int multi(int a, int b) { return a*b; }
    int div(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("Argument 'b' is 0");
        }
        else return a/b;
    }
    boolean greater(int a, int b) {
        if (a>b) return true;
        else return false;
    }
}