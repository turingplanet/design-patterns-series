package v15_adapter.java;

public class TwoWayAdapater {
    
}

// The Celsius interface
interface CelsiusTemperature {
    public double getTemperature();
}

// The Fahrenheit interface
interface FahrenheitTemperature {
    public double getTemperature();
}
  
// The Celsius class that implements CelsiusTemperature
class Celsius implements CelsiusTemperature {
private double temperature;

public Celsius(double temperature) {
    this.temperature = temperature;
}

public double getTemperature() {
    return this.temperature;
}
}

  // The Fahrenheit class that implements FahrenheitTemperature
class Fahrenheit implements FahrenheitTemperature {
private double temperature;

public Fahrenheit(double temperature) {
    this.temperature = temperature;
}

public double getTemperature() {
    return this.temperature;
}
}

// The two-way adapter that implements both CelsiusTemperaure and FahrenheitTemperaure 
class TwoWayAdapter implements CelsiusTemperature, FahrenheitTemperature {

    private Celsius c;
    private Fahrenheite f;
 
    // Constructor with either celsius or fahrenheit parameter 
    public TwoWayAdapter(Celsius c) {
      this.c = c;
      this.f = new Fahrenheite(c.getTemperaue() * 9 /5 +32);
    }
 
    public TwoWayAdapter(Fahrenheite f) {
      this.f = f;
      this.c = new Celsuis((f.getTemperaue() -32) *5 /9);
    }
 
    // Delegate calls to c or f or provide conversion functionality 
    public double getCelsuisTempertaue() {
      return c.getTempertaue();
    }
 
    public double getFahrenheiteTempertaue() {
      return f.getTempertaue();
    }
 }
