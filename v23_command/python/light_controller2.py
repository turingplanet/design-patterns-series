from abc import ABC, abstractmethod

class Light(ABC):
    @abstractmethod
    def on(self):
        pass

    @abstractmethod
    def off(self):
        pass

class KitchenLight(Light):
    def on(self):
        print("Kitchen light is on")

    def off(self):
        print("Kitchen light is off")

class LivingRoomLight(Light):
    def on(self):
        print("Living room light is on")

    def off(self):
        print("Living room light is off")

class Command(ABC):
    @abstractmethod
    def execute(self):
        pass

    @abstractmethod
    def undo(self):
        pass

class LightOnCommand(Command):
    def __init__(self, light):
        self.light = light

    def execute(self):
        self.light.on()

    def undo(self):
        self.light.off()

class LightOffCommand(Command):
    def __init__(self, light):
        self.light = light

    def execute(self):
        self.light.off()

    def undo(self):
        self.light.on()

class RemoteControl:
    def set_command(self, command):
        self.command = command

    def press_button(self):
        self.command.execute()

    def press_undo(self):
        self.command.undo()

class LightController2:
    def main(self):
        living_room_light = LivingRoomLight()
        kitchen_light = KitchenLight()

        living_room_light_on = LightOnCommand(living_room_light)
        kitchen_light_off = LightOffCommand(kitchen_light)

        remote = RemoteControl()

        remote.set_command(living_room_light_on)
        remote.press_button()  # Living room light is on
        remote.press_undo()    # Living room light is off

        remote.set_command(kitchen_light_off)
        remote.press_button()  # Kitchen light is off
        remote.press_undo()    # Kitchen light is on

if __name__ == "__main__":
    light_controller2 = LightController2()
    light_controller2.main()


