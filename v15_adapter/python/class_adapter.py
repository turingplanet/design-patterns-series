# Adaptee class
class FahrenheitSensor:
    def get_temperature(self):
        return 50  # dummy value for demo purposes
 
# Target interface
class CelsiusSensor:
    def get_temperature(self):
        pass
 
# Adapter class (subclass of Adaptee)
class FahrenheitToCelsiusAdapter(FahrenheitSensor, CelsiusSensor):
    def get_temperature(self):
        f_temp = super().get_temperature()
        return (f_temp - 32) * 5/9
 
# Client code
sensor = CelsiusSensor()
print(sensor.get_temperature())  # Output: None (default value)
 
sensor = FahrenheitToCelsiusAdapter()
print(sensor.get_temperature())  # Output: 10.0


