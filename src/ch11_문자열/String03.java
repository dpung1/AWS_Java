package ch11_문자열;

public class String03 {
	public static void main(String[] args) {
		
		String[] addressArray = new String[] {
				"창원시 마산합포구",
				"부산시 동래구", 
				"부산시 부산진구",
				"창원시 진해구"
		};
		
		String[] addressArray2 = new String[0];
		String[] addressArray3 = new String[0];
		
		for(int i = 0; i < addressArray.length; i++) {
			if(addressArray[i].contains("부산시")) {
				
				String[] tempArray = new String[addressArray2.length + 1]; // 기존 배열 공간보다 +1 큰 새로운 배열 생성
				
				for(int j = 0; j < addressArray2.length; j++) { 
					tempArray[j] = addressArray2[j]; // 기존 배열에 있는 정보를 새로운 배열에 이동
				}
				
				tempArray[addressArray2.length] = addressArray[i]; // 마지막 배열 공간에 새로운 값을 대입
				addressArray2 = tempArray;	// 새로운 배열을 기존 배열에 대입
			
			}else if(addressArray[i].contains("창원시")) {
						
				String[] tempArray = new String[addressArray3.length + 1]; // 기존 배열 공간보다 +1 큰 새로운 배열 생성
						
				for(int j = 0; j < addressArray3.length; j++) { 
					tempArray[j] = addressArray3[j]; // 기존 배열에 있는 정보를 새로운 배열에 이동
				}
				
				tempArray[addressArray3.length] = addressArray[i]; // 마지막 배열 공간에 새로운 값을 대입
				addressArray3 = tempArray; // 새로운 배열을 기존 배열에 대입
			}
		} 
		
		System.out.println("[부산시]");
		for(int i = 0; i  < addressArray2.length; i++) {
			System.out.println(addressArray2[i]);
		}
		
		System.out.println("[창원시]");
		for(int i = 0; i  < addressArray3.length; i++) {
			System.out.println(addressArray3[i]);
		}
		
	}
}
