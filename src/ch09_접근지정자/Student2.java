package ch09_접근지정자;

public class Student2 {
	
	private String name;
	private int age;
	
	private void test() {
		System.out.println("테스트 메소드 호출");
	}
	
	
	// Setter : 값을 받아 저장하는 역할
	public void setName(String name) {
		
		this.name = name;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	// Getter
	public String getName() {
		return name;
	}
	
	public int getAge() {
		return age;
	}
	
}
