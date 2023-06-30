package ch14_싱글톤;

public class Galaxy {
	
	private int seriaNumber;
	private String model;
	
	public Galaxy(int seriaNumber, String model) {
		this.seriaNumber = seriaNumber;
		this.model = model;
	}
	
	public void showInfo() {
		System.out.println("시리얼번호 : " + seriaNumber);
		System.out.println("모델명 : " + model);
	}

	
}
