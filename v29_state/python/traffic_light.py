class TrafficLightState:
    def handle(self, traffic_light):
        pass


class RedState(TrafficLightState):
    def handle(self, traffic_light):
        print("Red Light: Stopped")
        traffic_light.state = GreenState()


class YellowState(TrafficLightState):
    def handle(self, traffic_light):
        print("Yellow Light: Be prepared to stop")
        traffic_light.state = RedState()


class GreenState(TrafficLightState):
    def handle(self, traffic_light):
        print("Green Light: Go")
        traffic_light.state = YellowState()


class TrafficLight:
    def __init__(self):
        self.state = RedState()

    def change(self):
        self.state.handle(self)


if __name__ == "__main__":
    traffic_light = TrafficLight()

    for _ in range(6):
        traffic_light.change()


