package v29_state.java;


interface TrafficLightState {
    void handle(TrafficLight trafficLight);
}

class RedState implements TrafficLightState {
    @Override
    public void handle(TrafficLight trafficLight) {
        System.out.println("Red Light: Stopped");
        trafficLight.setState(new GreenState());
    }
}

class YellowState implements TrafficLightState {
    @Override
    public void handle(TrafficLight trafficLight) {
        System.out.println("Yellow Light: Be prepared to stop");
        trafficLight.setState(new RedState());
    }
}

class GreenState implements TrafficLightState {
    @Override
    public void handle(TrafficLight trafficLight) {
        System.out.println("Green Light: Go");
        trafficLight.setState(new YellowState());
    }
}

class TrafficLight {
    private TrafficLightState state;

    public TrafficLight() {
        state = new RedState();
    }

    public void setState(TrafficLightState state) {
        this.state = state;
    }

    public void change() {
        state.handle(this);
    }
}

public class TrafficLightTest {
    public static void main(String[] args) {
        TrafficLight trafficLight = new TrafficLight();

        for (int i = 0; i < 6; i++) {
            trafficLight.change();
        }
    }
}
