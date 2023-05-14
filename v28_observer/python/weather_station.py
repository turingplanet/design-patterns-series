# no pattern
class WeatherStation:
    def __init__(self):
        self.observers = [MobileApp(), TVStation(), Newspaper()]

    def notify_observers(self, weather_data):
        for observer in self.observers:
            observer.update(weather_data)

    def update_weather_data(self, new_data):
        self.notify_observers(new_data)
        
# with pattern
from abc import ABC, abstractmethod

class Observer(ABC):
    @abstractmethod
    def update(self, weather_data):
        pass

class MobileApp(Observer):
    def update(self, weather_data):
        print(f"MobileApp: {weather_data}")

class TVStation(Observer):
    def update(self, weather_data):
        print(f"TVStation: {weather_data}")

class Newspaper(Observer):
    def update(self, weather_data):
        print(f"Newspaper: {weather_data}")

class WeatherStation:
    def __init__(self):
        self.observers = []

    def register_observer(self, observer):
        self.observers.append(observer)

    def remove_observer(self, observer):
        self.observers.remove(observer)

    def notify_observers(self, weather_data):
        for observer in self.observers:
            observer.update(weather_data)

    def update_weather_data(self, new_data):
        self.notify_observers(new_data)



