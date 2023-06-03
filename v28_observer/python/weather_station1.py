from abc import ABC, abstractmethod

class Display(ABC):
    @abstractmethod
    def update(self, temperature):
        pass

class CurrentTemperatureDisplay(Display):
    def update(self, temperature):
        print(f"Current Temperature: {temperature}")

class TemperatureHistoryDisplay(Display):
    def update(self, temperature):
        print(f"Temperature History Updated with: {temperature}")

class WeatherStation:
    def __init__(self, current_temperature_display, temperature_history_display):
        self.temperature = None
        self.current_temperature_display = current_temperature_display
        self.temperature_history_display = temperature_history_display

    def set_temperature(self, temperature):
        self.temperature = temperature
        self.current_temperature_display.update(temperature)
        self.temperature_history_display.update(temperature)


if __name__ == "__main__":
    current_temperature_display = CurrentTemperatureDisplay()
    temperature_history_display = TemperatureHistoryDisplay()
    weather_station = WeatherStation(current_temperature_display, temperature_history_display)

    weather_station.set_temperature(25)
    weather_station.set_temperature(26)

