package ch22_익명클래스;

public class AuthorityMain {
	public static void main(String[] args) {
		
		GrantedAuthorities autoAuthorities = new GrantedAuthorities() {
			
			@Override
			public String getAuthoroty() {
				System.out.println("권한출력");
				return "ROLE_USER";
			}
		};	
		
		System.out.println(autoAuthorities.getAuthoroty());
		
		A a = new A();
		System.out.println(a.getAuthoroty());
	}
}

class A implements GrantedAuthorities {

	@Override
	public String getAuthoroty() {
		System.out.println("2번째 권한 출력");
		return "ROLE_ADMIN";
	}

}
