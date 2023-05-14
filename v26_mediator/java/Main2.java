package v26_mediator.java;

interface Mediator {
    void notify(Component sender, String event);
}

class Dialog implements Mediator {
    private TextField textField;
    private Button button;
    private Label label;

    public Dialog(TextField textField, Button button, Label label) {
        this.textField = textField;
        this.button = button;
        this.label = label;

        this.textField.setMediator(this);
        this.button.setMediator(this);
        this.label.setMediator(this);
    }

    @Override
    public void notify(Component sender, String event) {
        if (sender == button && event.equals("clicked")) {
            String text = textField.getText();
            label.setText(text);
            System.out.println("Dialog notified of button click, text from TextField: " + text);
        }
    }
}

abstract class Component {
    protected Mediator mediator;

    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }
}

class Button extends Component {
    public void clicked() {
        mediator.notify(this, "clicked");
        System.out.println("Button clicked");
    }
}

class TextField extends Component {
    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
        System.out.println("Text set in TextField: " + text);
    }
}

class Label extends Component {
    private String text;

    public void setText(String text) {
        this.text = text;
        System.out.println("Text set in Label: " + text);
    }
}

public class Main2 {
    public static void main(String[] args) {
        TextField textField = new TextField();
        Button button = new Button();
        Label label = new Label();

        Dialog dialog = new Dialog(textField, button, label);

        textField.setText("Hello, World!");
        button.clicked();
    }
}
