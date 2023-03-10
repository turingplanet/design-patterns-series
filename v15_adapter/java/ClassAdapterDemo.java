package v15_adapter.java;

interface CelsiusTemperature {
  double getCTemperature();
}

class FahrenheitTemperature {
  private double temperature;

  public FahrenheitTemperature(double temperature) {
      this.temperature = temperature;
  }

  public double getTemperature() {
      return temperature;
  }
}

class FahrenheitToCelsiusAdapter extends FahrenheitTemperature implements CelsiusTemperature {
  public FahrenheitToCelsiusAdapter(double temperature) {
      super(temperature);
  }

  public double getCTemperature() {
      return (super.getTemperature() - 32) * 5 / 9;
  }
}

public class ClassAdapterDemo {
  public static void main(String[] args) {
      FahrenheitTemperature f = new FahrenheitTemperature(100);
      CelsiusTemperature c = new FahrenheitToCelsiusAdapter(f.getTemperature());
      System.out.println("The temperature is " + c.getCTemperature() + " degrees Celsius.");
  }
}

