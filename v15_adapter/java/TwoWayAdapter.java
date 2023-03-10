package v15_adapter.java;

// The Celsius interface
interface CelsiusTemperature {
    public double getCelsiusTemperature();
}

// The Fahrenheit interface
interface FahrenheitTemperature {
    public double getFahrenheitTemperature();
}
  
// The Celsius class that implements CelsiusTemperature
class Celsius implements CelsiusTemperature {
    private double temperature;

    public Celsius(double temperature) {
        this.temperature = temperature;
    }

    public double getCelsiusTemperature() {
        return this.temperature;
    }
}

  // The Fahrenheit class that implements FahrenheitTemperature
class Fahrenheit implements FahrenheitTemperature {
    private double temperature;

    public Fahrenheit(double temperature) {
        this.temperature = temperature;
    }

    public double getFahrenheitTemperature() {
        return this.temperature;
    }
}

// The two-way adapter that implements both CelsiusTemperaure and FahrenheitTemperaure 
public class TwoWayAdapter implements CelsiusTemperature, FahrenheitTemperature {

    private Celsius c;
    private Fahrenheit f;
 
    // Constructor with either celsius or fahrenheit parameter 
    public TwoWayAdapter(Celsius c) {
      this.c = c;
      this.f = new Fahrenheit(c.getCelsiusTemperature() * 9 /5 +32);
    }
 
    public TwoWayAdapter(Fahrenheit f) {
      this.f = f;
      this.c = new Celsius((f.getFahrenheitTemperature() -32) *5 /9);
    }
 
    // Delegate calls to c or f or provide conversion functionality 
    public double getCelsiusTemperature() {
      return c.getCelsiusTemperature();
    }
 
    public double getFahrenheitTemperature() {
      return f.getFahrenheitTemperature();
    }

    public static void main(String[] args) {
        // Create a Celsius object with a temperature of 25 degrees
        Celsius celsius = new Celsius(25);
        // Create a two-way adapter with the Celsius object
        TwoWayAdapter adapter = new TwoWayAdapter(celsius);
        // Get the temperature in Fahrenheit using the adapter
        double fahrenheitTemperature = adapter.getFahrenheitTemperature();
        // Print the temperature in Fahrenheit
        System.out.println("Temperature in Fahrenheit: " + fahrenheitTemperature);

        TwoWayAdapter adapter2 = new TwoWayAdapter(new Fahrenheit(100));
        System.out.println("Temperature in Celsius: " + adapter2.getCelsiusTemperature());
    }

 }
