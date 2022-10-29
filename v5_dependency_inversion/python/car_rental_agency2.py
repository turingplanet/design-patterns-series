class CarManufactory:
    def rent(self, model: str): pass

class BMW(CarManufactory):
    def rent(self, model: str):
        print(f'BMW rented {model}')

class Mercedes(CarManufactory):
    def rent(self, model: str):
        print(f'Mercedes rented {model}')

class Honda(CarManufactory):
    def rent(self, model: str):
        print(f'Honda rented {model}')
    
class CarRentalAgency2:
    def rent_car(self, manufactory: CarManufactory, model: str):
        manufactory.rent(model)

agency = CarRentalAgency2()
agency.rent_car(BMW(), 'X5')
agency.rent_car(Mercedes(), 'GLE')
agency.rent_car(Honda(), 'Accord')


