public class MacBookV1 {

	private MacLaptopProperty property;
	private MacLaptopFunction function;
    
    public static void main(String[] args) {
        System.out.println("Hello");   
    }
	public MacBookV1(MacLaptopProperty p, MacLaptopFunction f) {
		this.property = p;
		this.function = f;
	}
}


interface LaptopProperty {
	String cpu = "";
	int size = 0;
	String resolution = "";
}
interface LaptopFunction {
	void startUp();
	void shutDown();
}

class MacLaptopProperty implements LaptopProperty {
	String cpu = "";
	int size = 0;
	String resolution = "";
}

class MacLaptopFunction implements LaptopFunction {
	public void startUp() {};
	public void shutDown() {};
}
