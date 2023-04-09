from typing import Dict
from abc import ABC, abstractmethod

class Shape(ABC):
    @abstractmethod
    def draw(self, x: int, y: int, radius: int):
        pass

class CircleFlyweight(Shape):
    def __init__(self, color: str):
        self.color = color

    def draw(self, x: int, y: int, radius: int):
        print(f'Drawing circle of color {self.color} at position ({x}, {y}) with radius {radius}')

class ShapeFactory:
    _circle_map: Dict[str, CircleFlyweight] = {}

    @staticmethod
    def get_circle(color: str) -> CircleFlyweight:
        circle = ShapeFactory._circle_map.get(color)

        if circle is None:
            circle = CircleFlyweight(color)
            ShapeFactory._circle_map[color] = circle
            print(f'Creating circle of color: {color}')

        return circle

class DrawingApp2:
    @staticmethod
    def main():
        red_circle = ShapeFactory.get_circle("red")
        red_circle.draw(10, 10, 50)

        blue_circle = ShapeFactory.get_circle("blue")
        blue_circle.draw(20, 20, 60)

        another_red_circle = ShapeFactory.get_circle("red")
        another_red_circle.draw(30, 30, 40)

if __name__ == "__main__":
    DrawingApp2.main()
