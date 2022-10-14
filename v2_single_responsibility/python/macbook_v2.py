class LaptopBasicProperty: 
    cpu = ""
    size = 0

class LaptopExtensionProperty:
    resolution = ""
    
class LaptopBasicFunction:
    def startUp(self): pass
    def shutDown(self): pass

class LaptopExtensionFunction:
    def sleep(self): pass

class MacLaptopBasicProperty(LaptopBasicProperty):
    cpu = ""
    size = 0

class MacLaptopExtensionProperty(LaptopExtensionProperty):
    resolution = ""
    
class MacLaptopBasicFunction(LaptopBasicFunction):
    def startUp(self): pass
    def shutDown(self): pass

class MacLaptopExtensionFunction(LaptopExtensionFunction):
    def sleep(self): pass

class MacBookV2:
    basic_property: MacLaptopBasicProperty
    basic_function: MacLaptopBasicFunction
    extension_property: MacLaptopExtensionProperty
    extension_function: MacLaptopExtensionFunction
    
    def __init__(self, bp: MacLaptopBasicProperty, bf: MacLaptopBasicFunction, ep: MacLaptopBasicFunction, ef: MacLaptopExtensionFunction):
        self.basic_property = bp
        self.basic_function = bf
        self.extension_property = ep
        self.extension_function = ef

MacBookV2(MacLaptopBasicProperty(), MacLaptopBasicFunction(), MacLaptopBasicFunction(), MacLaptopExtensionFunction())