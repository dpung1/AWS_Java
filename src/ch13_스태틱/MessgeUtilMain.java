package ch13_스태틱;

import ch10_배열.Array01;

public class MessgeUtilMain {
	
	private int a;
	
	public static void main(String[] args) {
		
		MessgeUtilMain messgeUtilMain = new MessgeUtilMain();
		
		System.out.println(messgeUtilMain.a);
		
//		Array01.main(null);
		
		MessageUtil messageUtil = new MessageUtil();
		
//		messageUtil.sendMail();
//		messageUtil.sendFile();
		
		MessageUtil.sendFile();
		System.out.println();
		MessageUtil.data = "안녕";
		System.out.println(MessageUtil.data);
		
		System.out.println(messageUtil.data);
	}
	
}
