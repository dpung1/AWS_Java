package ch04_입력;

import java.util.Scanner;

public class Input02 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		/*
		 * 이름(name) : 
		 * 나이(age) : 
		 * 연락처(phone) : 
		 * 주소(address) :
		 * 성별(gender) : 
		 * 
		 * 고객님의 이름은 ooo이고 나이는 oo세입니다.
		 * 연락처는 010-0000-000이며 주소는 ooo ooo ooo 입니다.
		 * 성별은 남입니다.
		 */
		
		String name = "";
		int age = 0;
		String phone = "";
		String address = "";
		String gender = "";
		
		
		System.out.print("이름 : ");
		name = scanner.next();
		
		System.out.print("나이 : ");
		age = scanner.nextInt();
		
		System.out.print("연락처 : ");
		phone = scanner.next();
		
		scanner.nextLine(); // 버퍼로 인해 허공에 nextLine 사용 (전 순서에 남아있는 엔터키 날리는용도)
		
		System.out.print("주소 : ");
		address = scanner.nextLine(); 	// nextLine : 스페이스, 엔터키 적용된
		
		System.out.print("성별 : ");
		gender = scanner.next();		// next : 스페이스, 엔터키 무시됨
		
		System.out.println("고객님의 이름은 " + name + "이고 나이는 " + age + "세입니다.");
		System.out.println("연락처는 " + phone + "이며 주소는 " + address + "입니다.");
		System.out.println("성별은 " + gender + "입니다.");
		
		
		
		
		
		
		
		
		
		
		
	}
}
