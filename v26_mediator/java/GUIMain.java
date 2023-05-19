package v26_mediator.java;

// Mediator interface
interface Mediator {
    void notify(Component sender, String event);
}

// Concrete Mediator
class ConcreteMediator implements Mediator {
    private Button button;
    private TextBox textBox;
    private Label label;

    public ConcreteMediator(Button button, TextBox textBox, Label label) {
        this.button = button;
        this.button.setMediator(this);
        this.textBox = textBox;
        this.textBox.setMediator(this);
        this.label = label;
        this.label.setMediator(this);
    }

    @Override
    public void notify(Component sender, String event) {
        if (sender == button && event.equals("clicked")) {
            textBox.clear();
            label.show("Button was clicked");
        }
    }
}

// Abstract Colleague
abstract class Component {
    protected Mediator mediator;

    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    public void changed(String event) {
        mediator.notify(this, event);
    }
}

// Button Colleague
class Button extends Component {
    public void click() {
        System.out.println("Button clicked");
        changed("clicked");
    }
}

// TextBox Colleague
class TextBox extends Component {
    public void clear() {
        System.out.println("TextBox cleared");
    }
}

// Label Colleague
class Label extends Component {
    public void show(String message) {
        System.out.println("Label shows: " + message);
    }
}

// Main
public class GUIMain {
    public static void main(String[] args) {
        Button button = new Button();
        TextBox textBox = new TextBox();
        Label label = new Label();
        new ConcreteMediator(button, textBox, label);

        // Simulate a button click
        button.click();
    }
}

