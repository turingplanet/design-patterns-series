# The target interface
class CelsiusTemperature:
    def getCTemperature(self):
        pass

# The existing class that needs to be adapted
class FahrenheitTemperature:
    def __init__(self, temperature):
        self.temperature = temperature

    def getTemperature(self):
        return self.temperature

# The adapter class that adapts FahrenheitTemperature to CelsiusTemperature
class FahrenheitToCelsiusAdapter(CelsiusTemperature):
    def __init__(self, fahrenheit):
        self.fahrenheit = fahrenheit

    def getCTemperature(self):
        # Convert Fahrenheit to Celsius and return the temperature
        return (self.fahrenheit.getTemperature() - 32) * 5 / 9

# Client code that uses the adapter
if __name__ == '__main__':
    # Create a FahrenheitTemperature object with some value
    f = FahrenheitTemperature(100)
    # Create a FahrenheitToCelsiusAdapter object with the FahrenheitTemperature object as input
    c = FahrenheitToCelsiusAdapter(f)
    # Use the adapter to get the temperature in Celsius
    print("The temperature is", c.getCTemperature(), "degrees Celsius.")
