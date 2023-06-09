from abc import ABC, abstractmethod

class SortingStrategy(ABC):
    @abstractmethod
    def sort(self, data):
        pass

class BubbleSort(SortingStrategy):
    def sort(self, data):
        n = len(data)
        for i in range(n-1):
            for j in range(n-i-1):
                if data[j] > data[j+1]:
                    # swap data[j+1] and data[j]
                    data[j], data[j+1] = data[j+1], data[j]
        return data

class QuickSort(SortingStrategy):
    def sort(self, data):
        self.quick_sort(data, 0, len(data)-1)
        return data

    def quick_sort(self, data, low, high):
        if low < high:
            pi = self.partition(data, low, high)
            self.quick_sort(data, low, pi-1)
            self.quick_sort(data, pi+1, high)

    def partition(self, data, low, high):
        pivot = data[high]
        i = (low - 1)
        for j in range(low, high):
            if data[j] < pivot:
                i += 1
                data[i], data[j] = data[j], data[i]
        data[i+1], data[high] = data[high], data[i+1]
        return i+1

class Sorter:
    def __init__(self, strategy):
        self.strategy = strategy

    def sort(self, data):
        return self.strategy.sort(data)

if __name__ == '__main__':
    data = [5, 2, 4, 1, 3]
    sorter = Sorter(BubbleSort())
    sorted_data = sorter.sort(data)
    print(f"BubbleSort result: {sorted_data}")

    data = [5, 2, 4, 1, 3]
    sorter = Sorter(QuickSort())
    sorted_data = sorter.sort(data)
    print(f"QuickSort result: {sorted_data}")


