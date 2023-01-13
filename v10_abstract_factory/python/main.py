from abc import ABC, abstractmethod

class Sedan(ABC):

    @abstractmethod
    def turn_on_head_light(self) -> None:
        pass

class SUV(ABC):

    @abstractmethod
    def turn_on_head_light(self) -> None:
        pass

class BMWM5(Sedan):

    def turn_on_head_light(self) -> None:
        print("BMWM5 head light")

class BMWX5(SUV):

    def turn_on_head_light(self) -> None:
        print("BMWX5 head light")

class TeslaModelS(Sedan):

    def turn_on_head_light(self) -> None:
        print("Tesla ModelS head light")

class TeslaModelY(SUV):

    def turn_on_head_light(self) -> None:
        print("Tesla ModelY head light")

class CarFactory(ABC):

    @abstractmethod
    def create_sedan(self) -> Sedan:
        pass

    @abstractmethod
    def create_suv(self) -> SUV:
        pass

class BMWFactory(CarFactory):

    def create_sedan(self) -> Sedan:
        return BMWM5()

    def create_suv(self) -> SUV:
        return BMWX5()

class TeslaFactory(CarFactory):

    def create_sedan(self) -> Sedan:
        return TeslaModelS()
    
    def create_suv(self) -> SUV:
        return TeslaModelY()


class BrandBooth:

    sedan: Sedan = None
    suv: SUV = None

    def __init__(self, factory: CarFactory):
        self.sedan = factory.create_sedan()
        self.suv = factory.create_suv()
    
    def show_time(self):
        self.sedan.turn_on_head_light()
        self.suv.turn_on_head_light()
    
if __name__ == '__main__':
    bmw_factory = BMWFactory()
    bmw_booth = BrandBooth(bmw_factory)
    bmw_booth.show_time()
    tesla_factory = TeslaFactory()
    tesla_booth = BrandBooth(tesla_factory)
    tesla_booth.show_time()
