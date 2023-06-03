from abc import ABC, abstractmethod

class Observer(ABC):
    @abstractmethod
    def update(self, temperature):
        pass

class CurrentTemperatureDisplay(Observer):
    def update(self, temperature):
        print(f"Current Temperature: {temperature}")

class TemperatureHistoryDisplay(Observer):
    def update(self, temperature):
        print(f"Temperature History Updated with: {temperature}")

class Subject(ABC):
    @abstractmethod
    def add_observer(self, observer):
        pass

    @abstractmethod
    def remove_observer(self, observer):
        pass

    @abstractmethod
    def notify_observers(self):
        pass

class WeatherStation(Subject):
    def __init__(self):
        self.temperature = None
        self.observers = []

    def add_observer(self, observer):
        self.observers.append(observer)

    def remove_observer(self, observer):
        self.observers.remove(observer)

    def set_temperature(self, temperature):
        self.temperature = temperature
        self.notify_observers()

    def notify_observers(self):
        for observer in self.observers:
            observer.update(self.temperature)


if __name__ == "__main__":
    weather_station = WeatherStation()
    current_temperature_display = CurrentTemperatureDisplay()
    temperature_history_display = TemperatureHistoryDisplay()

    weather_station.add_observer(current_temperature_display)
    weather_station.add_observer(temperature_history_display)

    weather_station.set_temperature(25)
    weather_station.set_temperature(26)

