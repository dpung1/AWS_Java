package ch08_생성자;

public class Constructor01 {
	
	// 생성자 특징
	// 1. 반환 자료형이 없다.
	// 2. 클래스명과 동일한 이름을 사용한다.
	// 3. 메소드처럼 오버로딩이 가능하다.
	
	Constructor01() {
		System.out.println("생성자 호출");
	}
	
	Constructor01(String name, int age) {
		System.out.println("이름 : " + name);
		System.out.println("나이 : " + age);
	}
}
