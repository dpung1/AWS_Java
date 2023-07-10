package Test2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main03 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		List<String> names = new ArrayList<>();
		for(int i = 0; i < 2; i++) {
			System.out.print("이름을 입력하세요 : ");
			names.add(scanner.nextLine());
		}
		
		System.out.println(names);
	}
}
