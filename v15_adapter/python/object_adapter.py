class FahrenheitSensor:
    def get_temperature(self):
        return 50  # dummy value for demo purposes

class CelsiusSensor:
    def get_temperature(self):
        pass

class FahrenheitToCelsiusAdapter(CelsiusSensor):
    def __init__(self, fahrenheit_sensor):
        self.fahrenheit_sensor = fahrenheit_sensor

    def get_temperature(self):
        f_temp = self.fahrenheit_sensor.get_temperature()
        c_temp = (f_temp - 32) * 5/9
        return c_temp

sensor = FahrenheitToCelsiusAdapter(FahrenheitSensor())
print(sensor.get_temperature())  # Output: 10.0
