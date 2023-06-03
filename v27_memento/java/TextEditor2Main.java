package v27_memento.java;

class TextEditor2 {
    private StringBuilder content;

    public TextEditor2() {
        content = new StringBuilder();
    }

    public void write(String text) {
        content.append(text);
        System.out.println("Current content: " + content.toString());
    }

    public Memento save() {
        return new Memento(content.toString());
    }

    public void restore(Memento memento) {
        content = new StringBuilder(memento.getContent());
    }

    static class Memento {
        private String content;

        public Memento(String content) {
            this.content = content;
        }

        public String getContent() {
            return content;
        }
    }
}

public class TextEditor2Main {
    public static void main(String[] args) {
        // 创建一个文本编辑器
        TextEditor2 editor = new TextEditor2();

        // 编辑文本
        editor.write("This is the first sentence."); 
        TextEditor2.Memento saved = editor.save(); // 保存当前状态
        
        editor.write(" This is the second sentence."); 
        System.out.println("Before restore: " + editor.save().getContent()); // 打印出当前文本
        
        // 恢复到之前的状态
        editor.restore(saved);
        System.out.println("After restore: " + editor.save().getContent()); // 打印出当前文本
    }
}
