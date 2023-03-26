from abc import ABC, abstractmethod
from math import pi

class Shape(ABC):
    @abstractmethod
    def get_area(self):
        pass

class Circle(Shape):
    def __init__(self, radius):
        self.radius = radius

    def get_area(self):
        return pi * self.radius * self.radius

class Square(Shape):
    def __init__(self, side):
        self.side = side

    def get_area(self):
        return self.side * self.side

class ShapeGroup(Shape):
    def __init__(self):
        self.shapes = []

    def add_shape(self, shape):
        self.shapes.append(shape)

    def get_area(self):
        total_area = 0
        for shape in self.shapes:
            total_area += shape.get_area()
        return total_area

if __name__ == "__main__":
    circle = Circle(5)
    square = Square(4)

    shape_group1 = ShapeGroup()
    shape_group1.add_shape(circle)
    shape_group1.add_shape(square)

    circle2 = Circle(3)
    shape_group2 = ShapeGroup()
    shape_group2.add_shape(circle2)

    main_group = ShapeGroup()
    main_group.add_shape(shape_group1)
    main_group.add_shape(shape_group2)

    print("Total area:", main_group.get_area())


