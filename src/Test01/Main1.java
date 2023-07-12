package Test01;

class Calculator {
	
	public int num1;
	public int num2;
	
	public int add(int num1, int num2) {
		return num1 + num2;
	}
	
	public int sub(int num1, int num2) {
		return num1 - num2;
	}
	
}

public class Main1 {
	public static void main(String[] args) {
		
		Calculator calculator = new Calculator();
		
		System.out.println(calculator.add(10, 20));
		System.out.println(calculator.sub(200, 100));
	}
}


