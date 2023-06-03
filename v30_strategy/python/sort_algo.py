from abc import ABC, abstractmethod
from typing import List

class SortingStrategy(ABC):
    @abstractmethod
    def sort(self, data: List[int]) -> List[int]:
        pass

class BubbleSort(SortingStrategy):
    def sort(self, data: List[int]) -> List[int]:
        # Implement bubble sort
        pass

class QuickSort(SortingStrategy):
    def sort(self, data: List[int]) -> List[int]:
        # Implement quick sort
        pass

class Sorter:
    def __init__(self, strategy: SortingStrategy):
        self._strategy = strategy

    def sort(self, data: List[int]) -> List[int]:
        return self._strategy.sort(data)


data = [5, 2, 4, 1, 3]
sorter = Sorter(BubbleSort())
sorted_data = sorter.sort(data)
