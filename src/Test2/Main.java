package Test2;

class Calculator {
	
	public int mul(int num1, int num2) {
		return num1 * num2;
	}
	
	public int div(int num1, int num2) {
		return num1 / num2;
	}
}



public class Main {
	public static void main(String[] args) {
		
		Calculator calculator = new Calculator();
		
		System.out.println(calculator.mul(5, 2));
		System.out.println(calculator.div(200, 40));
	}
}
