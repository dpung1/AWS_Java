package ch11_문자열;

public class String06 {
	public static void main(String[] args) {
		
		String token = "Baearer aaaaabbbbbb.cccccddddd.eeeeefffff";
		
		
		boolean flag = token.startsWith("Bearer"); // 해당 단어로 시작하니?
		System.out.println(flag);
		
		String url = "/api/v1/user/1";
		
		boolean flag2 = url.startsWith("/api/v1");
		
		if(flag2) {
			System.err.println("api 버전1 사용");
		}
		
	}
}
