package v28_observer.java;

import java.util.ArrayList;
import java.util.List;

interface Observer {
    void update(float temperature);
}

class CurrentTemperatureDisplay implements Observer {
    @Override
    public void update(float temperature) {
        System.out.println("Current Temperature: " + temperature);
    }
}

class TemperatureHistoryDisplay implements Observer {
    @Override
    public void update(float temperature) {
        System.out.println("Temperature History Updated with: " + temperature);
    }
}

interface Subject {
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();
}

class WeatherStation implements Subject {
    private float temperature;
    private List<Observer> observers = new ArrayList<>();

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
        notifyObservers();
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(temperature);
        }
    }
}

public class WeatherStationMain2 {
    public static void main(String[] args) {
        WeatherStation weatherStation = new WeatherStation();
        CurrentTemperatureDisplay currentTemperatureDisplay = new CurrentTemperatureDisplay();
        TemperatureHistoryDisplay temperatureHistoryDisplay = new TemperatureHistoryDisplay();

        weatherStation.addObserver(currentTemperatureDisplay);
        weatherStation.addObserver(temperatureHistoryDisplay);

        weatherStation.setTemperature(25);
        weatherStation.setTemperature(26);
    }
}
