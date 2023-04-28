from abc import ABC, abstractmethod

class Light(ABC):
    @abstractmethod
    def on(self):
        pass

    @abstractmethod
    def off(self):
        pass

class LivingRoomLight(Light):
    def on(self):
        print("Living room light is on")

    def off(self):
        print("Living room light is off")

class KitchenLight(Light):
    def on(self):
        print("Kitchen light is on")

    def off(self):
        print("Kitchen light is off")

class LightController1:
    def main(self):
        living_room_light = LivingRoomLight()
        kitchen_light = KitchenLight()

        kitchen_light.on()
        kitchen_light.off()
        living_room_light.on()
        living_room_light.off()

if __name__ == "__main__":
    light_controller1 = LightController1()
    light_controller1.main()

