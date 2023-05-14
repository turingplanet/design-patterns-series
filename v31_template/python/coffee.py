# no pattern
class Coffee:
    def prepare(self):
        self.boil_water()
        self.brew_coffee()
        self.pour_in_cup()
        self.add_sugar_and_milk()

    def boil_water(self):
        print("Boiling water")

    def brew_coffee(self):
        print("Brewing coffee")

    def pour_in_cup(self):
        print("Pouring coffee into cup")

    def add_sugar_and_milk(self):
        print("Adding sugar and milk")

class Tea:
    def prepare(self):
        self.boil_water()
        self.steep_tea()
        self.pour_in_cup()
        self.add_lemon()

    def boil_water(self):
        print("Boiling water")

    def steep_tea(self):
        print("Steeping tea")

    def pour_in_cup(self):
        print("Pouring tea into cup")

    def add_lemon(self):
        print("Adding lemon")

# with pattern
class Beverage:
    def prepare(self):
        self.boil_water()
        self.brew()
        self.pour_in_cup()
        self.add_condiments()

    def boil_water(self):
        print("Boiling water")

    def brew(self):
        pass

    def pour_in_cup(self):
        print("Pouring beverage into cup")

    def add_condiments(self):
        pass

class Coffee(Beverage):
    def brew(self):
        print("Brewing coffee")

    def add_condiments(self):
        print("Adding sugar and milk")

class Tea(Beverage):
    def brew(self):
        print("Steeping tea")

    def add_condiments(self):
        print("Adding lemon")



