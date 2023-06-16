from abc import ABC, abstractmethod

class House(ABC):

    def build_house(self):
        self.build_foundation()
        self.build_walls()
        self.build_windows()
        self.build_roof()
        if self.is_landscaping_needed():
            self.landscape()

    def build_foundation(self):
        print("Building basic foundation.")

    @abstractmethod
    def build_walls(self):
        pass

    @abstractmethod
    def build_windows(self):
        pass

    @abstractmethod
    def build_roof(self):
        pass

    def is_landscaping_needed(self):
        return True

    def landscape(self):
        print("Landscaping the surroundings.")


class ConcreteHouse(House):

    def build_walls(self):
        print("Building concrete walls.")

    def build_windows(self):
        print("Building concrete windows.")

    def build_roof(self):
        print("Building concrete roof.")

    def is_landscaping_needed(self):
        return False


class WoodenHouse(House):

    def build_walls(self):
        print("Building wooden walls.")

    def build_windows(self):
        print("Building wooden windows.")

    def build_roof(self):
        print("Building wooden roof.")


def main():
    concrete_house = ConcreteHouse()
    concrete_house.build_house()
    print("-------------------------------")
    wooden_house = WoodenHouse()
    wooden_house.build_house()


if __name__ == "__main__":
    main()


