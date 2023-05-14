package v26_mediator.java;

class Button {
    TextField textField;
    Label label;

    public Button(TextField textField, Label label) {
        this.textField = textField;
        this.label = label;
    }

    public void clicked() {
        String text = textField.getText();
        label.setText(text);
        System.out.println("Button clicked, text from TextField: " + text);
    }
}

class TextField {
    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
        System.out.println("Text set in TextField: " + text);
    }
}

class Label {
    private String text;

    public void setText(String text) {
        this.text = text;
        System.out.println("Text set in Label: " + text);
    }
}

public class Main1 {
    public static void main(String[] args) {
        TextField textField = new TextField();
        Label label = new Label();
        Button button = new Button(textField, label);

        textField.setText("Hello, World!");
        button.clicked();
    }
}
