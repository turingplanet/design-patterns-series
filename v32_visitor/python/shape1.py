from abc import ABC, abstractmethod

class Shape(ABC):
    @abstractmethod
    def draw(self):
        pass

    @abstractmethod
    def resize(self):
        pass

class Circle(Shape):
    def draw(self):
        print("Drawing a circle")

    def resize(self):
        print("Resizing a circle")

class Rectangle(Shape):
    def draw(self):
        print("Drawing a rectangle")

    def resize(self):
        print("Resizing a rectangle")

def main():
    circle = Circle()
    rectangle = Rectangle()

    circle.draw()
    rectangle.draw()

    circle.resize()
    rectangle.resize()

if __name__ == "__main__":
    main()

