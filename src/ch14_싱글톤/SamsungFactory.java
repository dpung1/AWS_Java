package ch14_싱글톤;

public class SamsungFactory {
	
	public Galaxy produce(String model) {
		System.out.println(Samsung.getInstance().getCompanyName() + "에서 스마트폰을 생산합니다.");
		int newSeriaNumber = Samsung.getInstance().getAutoIncrementSerialNumber() + 1;
		Samsung.getInstance().setAutoIncrementSerialNumber(newSeriaNumber);
		return new Galaxy(newSeriaNumber, model);
	}
	
	public void showCompanyName() {
		System.out.println("회사명 : " + Samsung.getInstance().getCompanyName());
	}
	
}
