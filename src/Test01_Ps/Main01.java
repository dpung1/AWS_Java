package Test01_Ps;

class Calculator { // 클래스 2개 생성시 public 접근지정자 추가
	
	int add(int num1, int num2) {
		return num1 + num2;
	}
	
	int sub(int num1, int num2) {
		return num1 - num2;
	}
}

public class Main01 {
	public static void main(String[] args) {
		
		Calculator calculator = new Calculator();
		
		System.out.println(calculator.add(10, 20));
		System.out.println(calculator.sub(200, 100));
	}
}
