from abc import ABC, abstractmethod

class Shape(ABC):
    @abstractmethod
    def accept(self, visitor):
        pass

class Circle(Shape):
    def accept(self, visitor):
        visitor.visit_circle(self)

class Rectangle(Shape):
    def accept(self, visitor):
        visitor.visit_rectangle(self)

class Visitor(ABC):
    @abstractmethod
    def visit_circle(self, circle):
        pass

    @abstractmethod
    def visit_rectangle(self, rectangle):
        pass

class DrawVisitor(Visitor):
    def visit_circle(self, circle):
        print("Drawing a circle")

    def visit_rectangle(self, rectangle):
        print("Drawing a rectangle")

class ResizeVisitor(Visitor):
    def visit_circle(self, circle):
        print("Resizing a circle")

    def visit_rectangle(self, rectangle):
        print("Resizing a rectangle")

def main():
    circle = Circle()
    rectangle = Rectangle()

    draw_visitor = DrawVisitor()
    resize_visitor = ResizeVisitor()

    circle.accept(draw_visitor)
    rectangle.accept(draw_visitor)

    circle.accept(resize_visitor)
    rectangle.accept(resize_visitor)

if __name__ == "__main__":
    main()
