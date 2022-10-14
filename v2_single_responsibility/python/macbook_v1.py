class LaptopProperty: 
    cpu = ""
    size = 0
    resolution = ""

class LaptopFunction:
    def startUp(self): pass
    def shutDown(self): pass

class MacLaptopProperty(LaptopProperty):
    cpu = ""
    size = 0
    resolution = ""
    
class MacLaptopFunction(LaptopFunction):
    def startUp(self): pass
    def shutDown(self): pass

class MacBookV1:
    property: MacLaptopProperty
    function: MacLaptopFunction
    
    def __init__(self, p: MacLaptopProperty, f: MacLaptopFunction):
        self.property = p
        self.function = f

MacBookV1(MacLaptopProperty(), MacLaptopFunction())
