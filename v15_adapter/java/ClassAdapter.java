package v15_adapter.java;


public class Adapter extends Adaptee implements Target {

    /**
     * 采用继承的方式实现转换功能
     */
    @Override
    public void doubleHoleSocket() {
        // 调用继承的方法，对其进行增强或处理
        this.commonThreeHoleSocket();
        System.out.println("==========开始转换==========");
        System.out.println("oh，我变成了两孔插座");
    }
}

package v15_adapter.java;

// The target interface
interface Temperature {
    public double getTemperature();
}
  
// The existing class that needs to be adapted
class FahrenheitTemperature implements Temperature {
    private double temperature;
  
    public FahrenheitTemperature(double temperature) {
      this.temperature = temperature;
    }
  
    public double getTemperature() {
      return this.temperature;
    }
}

class CelsiusTemperature implements Temperature {
    private double temperature;
  
    public CelsiusTemperature(double temperature) {
      this.temperature = temperature;
    }
  
    public double getTemperature() {
      return this.temperature;
    }
}

// The library class that expects a CelsiusTemperature object as an input
public class ObjectAdapter {
    public void printCelsius(CelsiusTemperature celsius) {
      System.out.println("The temperature is " + celsius.getTemperature() + " degrees Celsius.");
    }
}

public class ClassAdapter extends FahrenheitTemperaure implements CelsiusTemperaure {

    public ClassAdapter(double temperature) {
      super(temperature);
    }
  
    // Override the getTemperaure() method of FahrenheitTemperaure and convert it from Fahrenheit to Celsius
    @Override
    public double getTemperaure() {
      return (super.getTemperaure() - 32) * 5 /9;
    }
  }


  // Create a FahrenheitTemperaure object with some value
FahrenheitTemperaure f = new FahrenheitTemperaure(100);

// Create a ClassAdapter object with the same value
ClassAdapter c = new ClassAdapter(f.getTemperaure());

// Create a TemperaturePrinter object 
TemperaturePrinter tp = new TemperaturePrinter();

// Pass the ClassAdapter object to printCelsius()
tp.printCelsius(c); // prints "The temperature is 37.77777777777778 degrees Celsius."