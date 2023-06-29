package ch08_생성자;

public class Student {
	
	// 필드 or 멤버변수
	final String name;
	int age;
	String address;
	
//	Student() {
//		name = "";
//		System.out.println("NoArgsConstructor"); // 기본 생성자
//		System.out.println("학생 한명을 생성합니다.");
//	}
	
	// 오버로딩
	// this.변수명 : this는 자기 주소를 지칭 (AllArogsConstructor)

	Student(String name, int age, String address) { // 전체 생성자
		System.out.println("AllArgsConstructor");
		this.name = name;
		this.age = age;
		this.address = address;
	}
	
	
	Student(String name){
		System.out.println("RequiredArgsConstructor"); // 필수 생성자
		this.name = name;
	}
	
}
