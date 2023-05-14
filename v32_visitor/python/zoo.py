# no visitor
class Lion:
    def observe(self):
        print("You are observing a lion.")
    def feed(self):
        print("You are feeding a lion.")

class Monkey:
    def observe(self):
        print("You are observing a monkey.")
    def feed(self):
        print("You are feeding a monkey.")

class Elephant:
    def observe(self):
        print("You are observing an elephant.")
    def feed(self):
        print("You are feeding an elephant.")



# 访问者接口
class ZooVisitor:
    def visit_lion(self, lion):
        pass
    def visit_monkey(self, monkey):
        pass
    def visit_elephant(self, elephant):
        pass

# 具体访问者
class ZooKeeper(ZooVisitor):
    def visit_lion(self, lion):
        print("You are observing a lion.")
    def visit_monkey(self, monkey):
        print("You are observing a monkey.")
    def visit_elephant(self, elephant):
        print("You are observing an elephant.")

class ZooFeeder(ZooVisitor):
    def visit_lion(self, lion):
        print("You are feeding a lion.")
    def visit_monkey(self, monkey):
        print("You are feeding a monkey.")
    def visit_elephant(self, elephant):
        print("You are feeding an elephant.")

# 动物接口
class Animal:
    def accept(self, visitor):
        pass

class Lion(Animal):
    def accept(self, visitor):
        visitor.visit_lion(self)

class Monkey(Animal):
    def accept(self, visitor):
        visitor.visit_monkey(self)

class Elephant(Animal):
    def accept(self, visitor):
        visitor.visit_elephant(self)
