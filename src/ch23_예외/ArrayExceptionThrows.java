package ch23_예외;

public class ArrayExceptionThrows {
	
	public static void main(String[] args) {
		
		Integer[] nums = new Integer[] { 1, 2, 3, 4, 5 };
		try {
			printArray(nums);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		System.out.println("프로그램 정상 종료");
		
		
	}
	
	public static void printArray(Integer[] numArray) throws Exception { // 예외를 미루어 강제로 찾게함
		
		if(true) {
			throw new RuntimeException("내가 강제로 생성한 예외"); // 강제 예외 생성
		}
			
		for(int i = 0; i < numArray.length + 1; i++) {
			System.out.println(numArray[i]);
		}
	}
}


