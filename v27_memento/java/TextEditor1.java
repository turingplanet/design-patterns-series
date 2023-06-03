package v27_memento.java;

public class TextEditor1 {
    private StringBuilder content;

    public TextEditor1() {
        content = new StringBuilder();
    }

    public void write(String text) {
        content.append(text);
        System.out.println("Current content: " + content.toString()); 
    }
}