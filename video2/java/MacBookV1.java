public class MacBookV1 {

	private MacLaptopProperty property;
	private MacLaptopFunction function;
    
    public static void main(String[] args) {
        System.out.println("Hello");   
    }
	public MacBook(MacLaptopProperty p, MacLaptopFunction f) {
		this.property = p;
		this.function = f;
	}
}


interface LaptopProperty {
	String cpu = "";
	int size = 0;
}
interface LaptopFunction {
	void startUp();
	void shutDown();
}

class MacLaptopProperty implements LaptopProperty {
	String cpu = "";
	int size = 0;
	Camera camera = new Camera();
}
class MacLaptopFunction implements LaptopFunction {
	public void startUp() {};
	public void shutDown() {};
}

class Camera {}
