package Test02;

import java.util.ArrayList;
import java.util.List;

interface Wifi {
	public void connected();
}

class SmartPhone implements Wifi {
	@Override
	public void connected() {
		System.out.println("스마트폰 와이파이에 연결합니다.");
	}
	
	public void call() {
		System.out.println("상대방에게 음성통화를 연결합니다.");
	}
}

class Laptop implements Wifi {
	@Override
	public void connected() {
		System.out.println("노트북을 와이파이에 연결합니다.");
	}
	public void onSavingMode() {
		System.out.println("절전 모드를 활성화합니다.");
	}
}
// 주석
public class Casting {
	public static void main(String[] args) {
		List<Wifi> devices = new ArrayList<>();
		devices.add(new SmartPhone());
		devices.add(new Laptop());
		
		for(Wifi device : devices) {
			device.connected();
			
			if(device.getClass() == SmartPhone.class) {
				SmartPhone smartPhone = (SmartPhone) device;
				smartPhone.call();
			} else if(device.getClass() == Laptop.class) {
				Laptop laptop = (Laptop) device;
				laptop.onSavingMode();
			}
		}
	}
}