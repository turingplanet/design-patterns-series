class BMW:
    def rent_bmw(self, model: str):
        print(f'BMW rented {model}')

class Mercedes:
    def rent_mercedes(self, model: str):
        print(f'Mercedes rented {model}')

class CarRentalAgency:
    def rent_car(self, brand: str, model: str):
        if brand == 'BMW':
            BMW().rent_bmw(model)
        elif brand == 'Mercedes':
            Mercedes().rent_mercedes(model)

agency = CarRentalAgency()
agency.rent_car('BMW', 'X5')
agency.rent_car('Mercedes', 'GLE')

