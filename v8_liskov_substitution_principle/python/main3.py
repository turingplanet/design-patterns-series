import abc
from typing import List, Set

class Calculator:

    @abc.abstractmethod
    def stringToList(self, input_str) -> List(str):
        raise NotImplementedError

class SuperCalculator(Calculator):

    def stringToList(self, input_str) -> Set(str): # return type doesn't match
        # TODO
        pass
