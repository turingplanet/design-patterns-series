from typing import Dict
from abc import ABC, abstractmethod

class SoldierFlyweight(ABC):
    @abstractmethod
    def display(self, x: int, y: int):
        pass

class SoldierType(SoldierFlyweight):
    def __init__(self, soldier_type: str, weapon: str, armor: str):
        self.soldier_type = soldier_type
        self.weapon = weapon
        self.armor = armor

    def display(self, x: int, y: int):
        print(f"Displaying {self.soldier_type} at ({x}, {y}) with weapon {self.weapon} and armor {self.armor}")

class SoldierFlyweightFactory:
    def __init__(self):
        self.soldier_type_map: Dict[str, SoldierFlyweight] = {}

    def get_soldier_type(self, soldier_type: str, weapon: str, armor: str) -> SoldierFlyweight:
        soldier_flyweight = self.soldier_type_map.get(soldier_type)
        if soldier_flyweight is None:
            soldier_flyweight = SoldierType(soldier_type, weapon, armor)
            self.soldier_type_map[soldier_type] = soldier_flyweight
        return soldier_flyweight

class Soldier:
    def __init__(self, soldier_flyweight: SoldierFlyweight, x: int, y: int):
        self.soldier_flyweight = soldier_flyweight
        self.x = x
        self.y = y

    def display(self):
        self.soldier_flyweight.display(self.x, self.y)

class SoldierGame:
    @staticmethod
    def main():
        soldier_type_factory = SoldierFlyweightFactory()

        archer_type = soldier_type_factory.get_soldier_type("Archer", "Bow", "Leather")
        knight_type = soldier_type_factory.get_soldier_type("Knight", "Sword", "Plate")

        archer1 = Soldier(archer_type, 100, 50)
        archer2 = Soldier(archer_type, 120, 60)
        knight1 = Soldier(knight_type, 200, 100)
        knight2 = Soldier(knight_type, 250, 120)

        archer1.display()
        archer2.display()
        knight1.display()
        knight2.display()

if __name__ == "__main__":
    SoldierGame.main()
