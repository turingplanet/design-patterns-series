from abc import ABC, abstractmethod

class RacketPrototype(ABC):
    def __init__(self, brand, model, weight, balancePoint):
        self.brand = brand
        self.model = model
        self.weight = weight
        self.balancePoint = balancePoint

    @abstractmethod
    def clone(self):
        pass

class WilsonTennisRacket(RacketPrototype):
    def __init__(self, brand, model, weight, balancePoint):
        super().__init__(brand, model, weight, balancePoint)

    def clone(self):
        print("Wilson clone: {} {} {} {}".format(self.brand, self.model, self.weight, self.balancePoint))
        return WilsonTennisRacket(self.brand, self.model, self.weight, self.balancePoint)

class HeadTennisRacket(RacketPrototype):
    def __init__(self, brand, model, weight, balancePoint):
        super().__init__(brand, model, weight, balancePoint)

    def clone(self):
        print("Head clone: {} {} {} {}".format(self.brand, self.model, self.weight, self.balancePoint))
        return HeadTennisRacket(self.brand, self.model, self.weight, self.balancePoint)

class TennisRacketPrototypeManager:
    racketMap = {}

    @staticmethod
    def getClonedRacket(model):
        r = TennisRacketPrototypeManager.racketMap.get(model)
        return r.clone()

    @staticmethod
    def buildProtypes():
        r1 = WilsonTennisRacket("Wilson", "Pro Staff", 320.0, 32.5)
        TennisRacketPrototypeManager.racketMap["pro staff"] = r1
        h1 = HeadTennisRacket("Head", "Graphene 360 Speed", 320.0, 32.5)
        TennisRacketPrototypeManager.racketMap["graphene 360"] = h1

def main():
    TennisRacketPrototypeManager.buildProtypes()
    for i in range(10):
        TennisRacketPrototypeManager.getClonedRacket("pro staff")

if __name__ == '__main__':
    main()

