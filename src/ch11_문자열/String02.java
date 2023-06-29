package ch11_문자열;

public class String02 {
	public static void main(String[] args) {
		
		String phone = "010-9988-1916";
		
		// indexOf : 해당 위치의 인덱스 찾기
		int index = phone.indexOf("-");
		int lastindex = phone.lastIndexOf("-");
		
		
		System.out.println(index);	
		System.out.println(lastindex);
		
		String midNumber = phone.substring(index + 1, lastindex);
		System.out.println(midNumber);
		
		boolean fineFlag = phone.contains("010");
		System.out.println(fineFlag);
		
		
	}
}