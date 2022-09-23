public class MacBookV2 {
	private MacbookBasicProperty property;
	private MacbookExtensionProperty extensionProperty;
	private MacbookBasicFunction basicFunction;
	private MacbookExtensionFunction extensionFunction;

    public static void main(String[] args) {
        System.out.println("Hello");
    }

	public MacBookV2(MacbookBasicProperty bp, MacbookExtensionProperty ep,  MacbookBasicFunction bf, extensionFunction ef) {
		this.property = a
		this.extensionProperty = b
		this.basicFunction = bf
        this.extensionFunction = ef
	}
}


public class MacbookBasicProperty implements LaptopBasicProperty {
	String cpu
	int size
	TouchBar touchBar;
}
public class MacbookExtensionProperty implements LaptopExtensionProperty {
	Camera camera
}
public class MacbookBasicFunction implements LaptopBaseFunction {
	void startUp()
	void shutDown()
}
public class MacbookExtensionFunction implements LaptopExtentionFunction {
	void sleep()
}



public interface LaptopBasicProperty {
	String cpu 
	int size
}
public interface LaptopExtensionProperty {
Camera camera	
}
public interface LaptopBaseFunction {
    
	void startUp()
	void shutDown()
}
public interface LaptopExtentionFunction {
	void sleep()
}
