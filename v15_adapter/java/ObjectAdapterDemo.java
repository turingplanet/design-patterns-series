package v15_adapter.java;

// The target interface
interface CelsiusTemperature {
  public double getCTemperature();
}

// The existing class that needs to be adapted
class FahrenheitTemperature {
  private double temperature;

  public FahrenheitTemperature(double temperature) {
      this.temperature = temperature;
  }

  public double getTemperature() {
      return this.temperature;
  }
}

// The adapter class that adapts FahrenheitTemperature to CelsiusTemperature
class FahrenheitToCelsiusAdapter implements CelsiusTemperature {
  private FahrenheitTemperature fahrenheit;

  public FahrenheitToCelsiusAdapter(FahrenheitTemperature fahrenheit) {
      this.fahrenheit = fahrenheit;
  }

  public double getCTemperature() {
      // Convert Fahrenheit to Celsius and return the temperature
      return (this.fahrenheit.getTemperature() - 32) * 5 / 9;
  }
}

// Client code that uses the adapter
public class ObjectAdapterDemo {
  public static void main(String[] args) {
      // Create a FahrenheitTemperature object with some value
      FahrenheitTemperature f = new FahrenheitTemperature(100);
    
      // Create a FahrenheitToCelsiusAdapter object with the FahrenheitTemperature object as input
      FahrenheitToCelsiusAdapter c = new FahrenheitToCelsiusAdapter(f);
    
      // Use the adapter to get the temperature in Celsius
      System.out.println("The temperature is " + c.getCTemperature() + " degrees Celsius.");
  }
}
