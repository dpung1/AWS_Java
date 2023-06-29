package ch02_변수;

public class Variable {
	
	public static void main(String[] args) {
		boolean flag;	//선언
		flag = true;	// 초기화(대입)
		System.out.print("FLAG : ");
		System.out.println(flag);
		
		char lastName = '김';
		System.out.println(lastName);
		
		int number = 100;
		System.out.println("번호 : " + number);
		
		double pi = 3.14;
		System.out.println(pi);
		
		String name = "김준일";
		System.out.println(name);
		
		String num1 = "10";
		int num2 = 10;
		System.out.println("String : " + num1);
		System.out.println("int : " + num2);
		System.out.println(Integer.parseInt(num1) + 10);
		
		char num3 = '5';
		System.out.println(num3 + num2);
		
		// 크기순 : 문자 > 정수 > 실수 
		System.out.println((int)num3); // char > int 형변환 (캐스팅)
		
		// 1. 묵시적 형변환 (업캐스팅시) 문자 > 정수 > 실수
		int num4 = num3; // or (int)num3; *형변환타입 생략 가능*
		System.out.println(num4);
		// 2. 명시적 형변환 (다운캐스팅시) 실수 > 정수 > 문자
		char num5 = (char)num4;
		System.out.println(num5);
	}
}