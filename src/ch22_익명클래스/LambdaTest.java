package ch22_익명클래스;

// 람다식은 매개변수의 자료형을 생략가능

public class LambdaTest {
		
	public static void main(String[] args) {
		GrantedAuthorities authorities2 = new GrantedAuthorities() {
			
			@Override
			public String getAuthoroty() {
				System.out.println("권한 출력1");
				return "ROLE_USER";
			}
		};
		
		GrantedAuthorities authorities = () -> {
			System.out.println("권한 출력");
			return "ROLE_USER";
		};
		
		System.out.println(authorities.getAuthoroty());
	}
}
