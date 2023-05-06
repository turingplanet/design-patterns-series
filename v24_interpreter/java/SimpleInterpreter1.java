package v24_interpreter.java;

public class SimpleInterpreter1 {
    public static void main(String[] args) {
        String command = "REPEAT 3 TIMES: PRINT Hello";

        // Split the command into words based on whitespace
        String[] words = command.split(" ");

        //Handle the command
        if (words[0].equalsIgnoreCase("REPEAT")) {
            int repeatCount = Integer.parseInt(words[1]);
            for (int i = 0; i < repeatCount; i++) {
                if (words[3].equalsIgnoreCase("PRINT")) {
                    System.out.println(words[4]);
                }
            }
        }
    }
}
