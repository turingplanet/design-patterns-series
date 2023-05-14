# no pattern
class Navigator:
    def find_route(self, strategy):
        if strategy == 'shortest_path':
            return self.shortest_path()
        elif strategy == 'least_time':
            return self.least_time()
        elif strategy == 'least_cost':
            return self.least_cost()

    def shortest_path(self):
        print("Finding the shortest path")
        # ...实现最短路径算法

    def least_time(self):
        print("Finding the route with the least time")
        # ...实现最少时间算法

    def least_cost(self):
        print("Finding the route with the least cost")
        # ...实现最少费用算法

# with pattern
from abc import ABC, abstractmethod

class RouteStrategy(ABC):
    @abstractmethod
    def find_route(self):
        pass

class ShortestPathStrategy(RouteStrategy):
    def find_route(self):
        print("Finding the shortest path")
        # ...实现最短路径算法

class LeastTimeStrategy(RouteStrategy):
    def find_route(self):
        print("Finding the route with the least time")
        # ...实现最少时间算法

class LeastCostStrategy(RouteStrategy):
    def find_route(self):
        print("Finding the route with the least cost")
        # ...实现最少费用算法

class Navigator:
    def __init__(self, strategy):
        self.strategy = strategy

    def set_strategy(self, strategy):
        self.strategy = strategy

    def find_route(self):
        self.strategy.find_route()

