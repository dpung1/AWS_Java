package ch12_상속;

public class Computer extends Product {
	
	private String type;
	
//	public Computer() {
//		super("", 10); // 부모(상위) 메모리 주소값 * 생략가능 *
//		System.out.println("컴퓨터 객체 생성");
//	}

	
	public Computer(String model, int price) {
		super(model, price);
	}

	
	
	public Computer(String model, int price, String type) {
	super(model, price);
	this.type = type;
}



	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}
}
