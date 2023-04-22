package v23_command.java;
import java.util.Stack;

interface Command {
   void execute();
   void undo();
}

class InsertTextCommand implements Command {
   private String textToInsert;
   private StringBuilder textEditor;
   private int position;

   public InsertTextCommand(String text, StringBuilder editor, int position) {
         this.textToInsert = text;
         this.textEditor = editor;
         this.position = position;
   }

   @Override
   public void execute() {
       textEditor.insert(position, textToInsert);
   }

   @Override
   public void undo() {
       textEditor.delete(position, position + textToInsert.length());
   }
}

class DeleteTextCommand implements Command {
   private String deletedText;
   private StringBuilder textEditor;
   private int position;

   public DeleteTextCommand(StringBuilder editor, int position, int length) {
       this.textEditor = editor;
       this.position = position;
       this.deletedText = textEditor.substring(position, position + length);
   }
   
   @Override
   public void execute() {
       textEditor.delete(position, position + deletedText.length());
   }

   @Override
   public void undo() {
       textEditor.insert(position, deletedText);
   }
}


class CommandInvoker {
    Stack<Command> commandStack = new Stack<>();
    Stack<Command> undoStack = new Stack<>();

    public void execute(Command command) {
        command.execute();
        commandStack.push(command);
    }

    public void undo() {
        if (!commandStack.isEmpty()) {
            Command command = commandStack.pop();
            command.undo();
            undoStack.push(command);
        }
    }

    public void redo() {
        if (!undoStack.isEmpty()) {
            Command command = undoStack.pop();
            command.execute();
            commandStack.push(command);
        }
    }
}

public class TextEditor {
   public static void main(String[] args) {
       // Initialize the text editor and invoker
       StringBuilder textEditor = new StringBuilder();
       CommandInvoker invoker = new CommandInvoker();

       // Insert "Hello, "
       invoker.execute(new InsertTextCommand("Hello, ", textEditor, 0));

       // Insert "world!"
       invoker.execute(new InsertTextCommand("world!", textEditor, 7));

       // Delete ", "
       invoker.execute(new DeleteTextCommand(textEditor, 5, 2));

       // Current text should be "Helloworld!"
       System.out.println("Current text: " + textEditor.toString());

       invoker.undo(); // Undo delete - should be back to "Hello, world!"
       System.out.println("After undo: " + textEditor.toString());

       invoker.undo(); // Undo last insert - should be back to "Hello, "
       System.out.println("After undo: " + textEditor.toString());

       invoker.redo(); // Redo last insert - should be back to "Hello, world!"
       System.out.println("After redo: " + textEditor.toString());
   }
}
