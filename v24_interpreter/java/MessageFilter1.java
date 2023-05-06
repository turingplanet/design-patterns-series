package v24_interpreter.java;

public class  MessageFilter1 {

    public static boolean containsKeyword(String message, String keyword) {
        return message.contains(keyword);
    }

    public static boolean andFilter(String message, String keyword1, String keyword2) {
        return containsKeyword(message, keyword1) && containsKeyword(message, keyword2);
    }

    public static boolean orFilter(String message, String keyword1, String keyword2) {
        return containsKeyword(message, keyword1) || containsKeyword(message, keyword2);
    }

    public static void main(String[] args) {
        String message1 = "This is an urgent message";
        String message2 = "This is an important message";
        String message3 = "This is an unimportant message";

        System.out.println("Message 1: " + orFilter(message1, "urgent", "important")); // true
        System.out.println("Message 2: " + orFilter(message2, "urgent", "important")); // true
        System.out.println("Message 3: " + orFilter(message3, "urgent", "important")); // false
        System.out.println("Message 1 & 2: " + andFilter(message1 + " " + message2, "urgent", "important")); // true
    }
}
