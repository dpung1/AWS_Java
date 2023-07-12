package Test01;

class Factory {
	
	private String factoryName;
	
	private static Factory instance;
	
	private Factory(String factoryName) {
		this.factoryName = factoryName;
	}
	
	public static Factory getInstance(String factoryName) {
		if(instance == null) {
			instance = new Factory(factoryName);
		}
		
		return instance;
	}
	
	public String getFactoryName() {
		return factoryName;
	}
	
	public void setFactoryName(String factoryName) {
		this.factoryName = factoryName;
	}
	
}

public class FactoryMain {
	public static void main(String[] args) {
		
		Factory myFactory = Factory.getInstance("SuperFactory");
		
		System.out.println(myFactory.getFactoryName());
		
		myFactory.setFactoryName("MegaFactory");
		
		System.out.println(myFactory.getFactoryName());
		
	}
}
