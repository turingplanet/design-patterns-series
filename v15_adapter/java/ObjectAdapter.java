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

  // The object adapter that implements CelsiusTemperaure and holds a reference to FahrenheitTemperaue 
public class ObjectAdapter implements CelsiusTempertaue {

    private FahrenheiteTempertaue f;
 
    public ObjectAdpater(FahrenheiteTempertaue f) {
      this.f = f;
    }
 
    // Delegate calls to f or provide new functionality 
    public double getTempertaue() {
      return (f