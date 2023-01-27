from __future__ import annotations
from abc import ABC, abstractmethod

class Milktea:

    _price = None
    _topping = 'boba'
    _tea = 'regularMilktea'
    _sugar = 100

    def __init__(self) -> None:
        self._price = 7.0
    
    def getPrice(self):
        return self._price

class SignatureMilktea(Milktea):

    def __init__(self) -> None:
        self._price = 5.7

class OolongMilktea(Milktea):

    def __init__(self) -> None:
        self._price = 4.5


class MilkteaBuilder(ABC):

    @property
    @abstractmethod
    def reset(self) -> None:
        pass

    @property
    @abstractmethod
    def add_topping(self) -> None:
        pass

    @property
    @abstractmethod
    def add_tea(self) -> None:
        pass

    @property
    @abstractmethod
    def add_suger_level(self) -> None:
        pass

    @property
    @abstractmethod
    def get_product(self) -> None:
        pass


class SignatureMilkteaBuilder(MilkteaBuilder):

    def reset(self) -> None:
        self._product = SignatureMilktea()

    def add_topping(self) -> None:
        self._product._topping = 'boba'

    def add_tea(self) -> None:
        self._product._tea = 'signature tea'

    def add_suger_level(self) -> None:
        self._product._sugar = 100
    
    def get_product(self) -> None:
        print(f'Signature milktea: {self._product._topping} {self._product._tea} {self._product._sugar}')
        return self._product

class OolongMilkteaBuilder(MilkteaBuilder):

    def reset(self) -> None:
        self._product = OolongMilktea()

    def add_topping(self) -> None:
        self._product._topping = 'grass jelly'

    def add_tea(self) -> None:
        self._product._tea = 'oolong'

    def add_suger_level(self) -> None:
        self._product._sugar = 50
    
    def get_product(self) -> None:
        print(f'Oolong milktea: {self._product._topping} {self._product._tea} {self._product._sugar}')
        return self._product

class CustomizedMilkteaBuilder:

    _product = None

    def reset(self) -> None:
        self._product = Milktea()

    def add_topping(self, topping: str) -> None:
        self._product._topping = topping

    def add_tea(self, tea: str) -> None:
        self._product._tea = tea

    def add_suger_level(self, sugar_level: int) -> None:
        self._product._sugar = sugar_level
    
    def get_product(self) -> None:
        print(f'Customized milktea: {self._product._topping} {self._product._tea} {self._product._sugar}')
        return self._product   

class MilkteaDirector:

    _milktea_builder = None

    def __init__(self, builder: MilkteaBuilder) -> None:
        self._milktea_builder = builder
    
    def change_builder(self, builder: MilkteaBuilder) -> None:
        self._milktea_builder = builder
    
    def make_milktea(self) -> Milktea:
        self._milktea_builder.reset()
        self._milktea_builder.add_topping()
        self._milktea_builder.add_tea()
        self._milktea_builder.add_suger_level()
        return self._milktea_builder.get_product()
    
    def make(self, type: str) -> Milktea:
        if type == 'signature':
            self.change_builder(SignatureMilkteaBuilder())
        elif type == 'oolong':
            self.change_builder(OolongMilkteaBuilder())
        return self.make_milktea()


director = MilkteaDirector(SignatureMilkteaBuilder())
director.make_milktea()
director.change_builder(OolongMilkteaBuilder())
director.make_milktea()
director.make('signature')
director.make('oolong')

builder = CustomizedMilkteaBuilder()
builder.reset()
builder.add_topping('boba')
builder.add_tea('Oolong')
builder.add_suger_level(10)
builder.get_product()
