package ch06_반복;

public class For01 {
	public static void main(String[] args) {
		 int[] numbers = {1, 2, 3, 4, 5, 6};
		 
		 // for(초기문; 조건문; 후처리) 
		 for(int i = 0; i < 6; i++) {
			 System.out.println(numbers[i]);
			 System.out.println("i : " + i);
		 }
		 
	}
}
