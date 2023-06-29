package ch06_반복;

public class While02 {
	public static void main(String[] args) {
		int i = 0;
		
		while(i < 10) {
			if(i % 2 == 0) {
				i++;
				continue; // 조건이 맞을시 다음 반복문으로 실행
			}
			System.out.println(i);
			i++;
		}
	}
}
