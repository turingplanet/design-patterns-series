class CelsiusTemperature:
    def getCTemperature(self):
        pass

class FahrenheitTemperature:
    def __init__(self, temperature):
        self.temperature = temperature

    def getTemperature(self):
        return self.temperature

class FahrenheitToCelsiusAdapter(FahrenheitTemperature, CelsiusTemperature):
    def __init__(self, temperature):
        super().__init__(temperature)

    def getCTemperature(self):
        return (super().getTemperature() - 32) * 5 / 9

f = FahrenheitTemperature(100)
c = FahrenheitToCelsiusAdapter(f.getTemperature())
print("The temperature is", c.getCTemperature(), "degrees Celsius.")

