package ch17_추상;

public interface Button {
	/* 
	 * Interface
	 * - Static 상수만 사용(일반변수 사용 X)
	 * - 다중 구현이 가능, 다중 상속 X
	 */
	
	
	public int buttonCount = 4;
	
	public void powerOn();
	public void powerOff();
	public void volumUp();
	public void volumDown();
}
