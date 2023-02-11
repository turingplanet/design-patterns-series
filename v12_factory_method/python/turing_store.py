from abc import ABC, abstractmethod

class Car(ABC):

    @abstractmethod
    def startEngine(self):
        pass

    @abstractmethod
    def turnOffEngine(self):
        pass

class ModelA(Car):
    def startEngine(self):
        print("modelA startEngine")
        return True

    def turnOffEngine(self):
        print("modelA turnOffEngine")

class ModelB(Car):
    def startEngine(self):
        print("modelB startEngine")
        return True
    
    def turnOffEngine(self):
        print("modelB turnOffEngine")


class CarFactory(ABC):
    @abstractmethod
    def makeCar(self):
        pass

class ModelAFactory(CarFactory):
    def makeCar(self):
        modelA = ModelA()
        if modelA.startEngine() == True:
            modelA.turnOffEngine()
            return modelA
        else:
            return None

class ModelBFactory(CarFactory):
    def makeCar(self):
        modelB = ModelB()
        if modelB.startEngine() == True:
            modelB.turnOffEngine()
            return modelB
        else:
            return None

class TuringStorage:

    carStorage = [None] * 10

    def importCars(self):
        factoryA = ModelAFactory()
        factoryB = ModelBFactory()
        for i in range(5):
            self.carStorage[i] = factoryA.makeCar()
        for i in range(5, 10):
            self.carStorage[i] = factoryB.makeCar()

storage = TuringStorage()
storage.importCars()
