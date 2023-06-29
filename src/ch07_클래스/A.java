package ch07_클래스;

	// 클래스 : 틀
	// 객체 : 틀로 찍어낼 수 있는 것
	// 인스턴스 : 틀로 찍어 낸 것

public class A {
	int num1;
	int num2;
	
	void test1() {
		System.out.println("테스트1 함수 호출");
	}
	
	void test2(int x, int y) {
		System.out.println("x값 : " + x);
		System.out.println("y값 : " + y);
	}
	
	void test3() {
		System.out.println("num1 : " + num1);
		System.out.println("num2 : " + num2);
	}
	
	void test4() {
		System.out.println("합 : " + (num1 + num2));
	}
}
