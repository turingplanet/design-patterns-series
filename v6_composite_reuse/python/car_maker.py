class GasolineCar:
    def move(self):
        print('gasoline move')

class ElectricCar:
    def move(self):
        print('electric move')

class RedGasolineCar(GasolineCar):
    def move(self):
        print('red gasoline move')


class BlueGasolineCar(GasolineCar):
    def move(self):
        print('blue gasoline move')

c = RedGasolineCar()
c.move()
