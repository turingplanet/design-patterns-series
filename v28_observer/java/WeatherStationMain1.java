package v28_observer.java;

interface Display {
    void update(float temperature);
}

class CurrentTemperatureDisplay implements Display {
    @Override
    public void update(float temperature) {
        System.out.println("Current Temperature: " + temperature);
    }
}

class TemperatureHistoryDisplay implements Display {
    @Override
    public void update(float temperature) {
        System.out.println("Temperature History Updated with: " + temperature);
    }
}

class WeatherStation {
    private float temperature;
    private CurrentTemperatureDisplay currentTemperatureDisplay;
    private TemperatureHistoryDisplay temperatureHistoryDisplay;

    public WeatherStation(CurrentTemperatureDisplay currentTemperatureDisplay, TemperatureHistoryDisplay temperatureHistoryDisplay) {
        this.currentTemperatureDisplay = currentTemperatureDisplay;
        this.temperatureHistoryDisplay = temperatureHistoryDisplay;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
        currentTemperatureDisplay.update(temperature);
        temperatureHistoryDisplay.update(temperature);
    }
}


public class WeatherStationMain1 {
    public static void main(String[] args) {
        CurrentTemperatureDisplay currentTemperatureDisplay = new CurrentTemperatureDisplay();
        TemperatureHistoryDisplay temperatureHistoryDisplay = new TemperatureHistoryDisplay();
        WeatherStation weatherStation = new WeatherStation(currentTemperatureDisplay, temperatureHistoryDisplay);

        weatherStation.setTemperature(25);
        weatherStation.setTemperature(26);
    }
}