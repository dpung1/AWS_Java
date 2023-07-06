package test;

class Factory {
	
	private static Factory instance = null;
	
	private Factory() {
		
	}
	
	public static Factory getInstance() {
		if(instance == null) {
			instance = new Factory();
		}
		
		return instance;
	}
	
	public void printFactoryName() {
		System.out.println(getClass().getSimpleName());
	}
	
}

public class FactoryMain {
	public static void main(String[] args) {
		
		Factory factory = Factory.getInstance();
		Factory factory2 = new Factory();
		
		factory.printFactoryName();
		
	}
}
