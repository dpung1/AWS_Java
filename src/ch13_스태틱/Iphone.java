package ch13_스태틱;

public class Iphone {
	
	private static int autoIncrement = 1;
	
	private int seriaNumber = 20230600;
	private String model;
	
	public Iphone(String model) {
		super();
		this.seriaNumber += autoIncrement;
		this.model = model;
		autoIncrement++;
	}

	public void showInfo() {
		System.out.println("시리얼번호 : " + seriaNumber);
		System.out.println("모델명 : " + model);
	}
	
	public static void main(String[] args) {

		Iphone[] iphones = new Iphone[5];
		
		for(int i = 0; i < iphones.length; i++) {
//			iphones[i] = new Iphone(20230600 + i, "아이폰" + (i + 1));
			iphones[i] = new Iphone("아이폰" + (i + 1));
		}
		
		for(int i = 0; i < iphones.length; i++) {
			iphones[i].showInfo();
		}
		
	}
}
