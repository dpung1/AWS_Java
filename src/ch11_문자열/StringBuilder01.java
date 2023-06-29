package ch11_문자열;

public class StringBuilder01 {
	public static void main(String[] args) {
		
		StringBuilder builder = new StringBuilder();
		
		builder.append("이름 : "); // 문자열 끝에 추가
		builder.append("김준일");
		builder.delete(builder.indexOf(":"), builder.indexOf(":") + 1 ); // 문자열 삭제 
		builder.insert(3, ">>"); // 중간에 문자열 삽입 
		
		String str = builder.toString();
		
		System.out.println(str);
		
		
		String name = "이름 : 김준일";
		System.out.println(name.substring(0, name.indexOf(":")).concat(name.substring(name.indexOf(":") + 1 )));
		System.out.println(name.substring(0, 3).concat(name.substring(4)));
	}
}
