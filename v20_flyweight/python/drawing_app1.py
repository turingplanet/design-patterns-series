class Circle:
    def __init__(self, color):
        self.color = color
        self.x = None
        self.y = None
        self.radius = None

    def set_x(self, x):
        self.x = x

    def set_y(self, y):
        self.y = y

    def set_radius(self, radius):
        self.radius = radius

    def draw(self):
        print(f'Drawing circle of color {self.color} at position ({self.x}, {self.y}) with radius {self.radius}')

class DrawingApp1:
    @staticmethod
    def main():
        red_circle = Circle("red")
        red_circle.set_x(10)
        red_circle.set_y(10)
        red_circle.set_radius(50)
        red_circle.draw()

        blue_circle = Circle("blue")
        blue_circle.set_x(20)
        blue_circle.set_y(20)
        blue_circle.set_radius(60)
        blue_circle.draw()

if __name__ == "__main__":
    DrawingApp1.main()


