import java.util.Scanner;
import java.applet.*;
public class Hangman {

    private static String[] words = {"ABSTRACT", "ASSERT", "BOOLEAN", "BREAK", "BYTE",
            "CASE", "CATCH", "CHAR", "CLASS", "CONST",
            "CONTINUE", "DEFAULT", "DOUBLE", "DO", "ELSE",
            "EXTENDS", "FALSE", "FINAL", "FINALLY",
            "FLOAT", "FOR", "IF", "IMPLEMENTS",
            "IMPORT", "INTERFACE",
            "LONG", "NATIVE", "NEW", "NULL", "PACKAGE",
            "PRIVATE", "PROTECTED", "PUBLIC", "RETURN",
            "SHORT", "STATIC", "SUPER", "SWITCH",
            "SYNCHRONIZED", "THIS", "THROW", "THROWS",
             "TRUE", "TRY", "VOID", "VOLATILE", "WHILE", "JAVA", "APPLE",
            "TRAMPOLINE", "SWIMMING", "GARDEN", "GRASS", "COMPUTER", "CODING", "PROGRAMMING"};
    private static String word = words[(int) (Math.random() * words.length)];
    private static String letterCount = new String(new char[word.length()]).replace("\0", "_");
    private static int count = 0;

    public static void main(String[] args) {
        Scanner playerInput = new Scanner(System.in);

        while (count < 7 && letterCount.contains("_")) {
            System.out.println("Guess any letter: CAPITAL LETTERS ONLY");
            System.out.println("Word: " + letterCount);
            String guess = playerInput.next();
            hang(guess);
        }
        playerInput.close();
    }

    public static void hang(String guess) {
        String newLetterCount = "";
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == guess.charAt(0)) {
                newLetterCount += guess.charAt(0);
            } else if (letterCount.charAt(i) != '_') {
                newLetterCount += word.charAt(i);
            } else {
                newLetterCount += "_";
            }
        }

        if (letterCount.equals(newLetterCount)) {
            count++;
            hangmanImage();
        } else {
            letterCount = newLetterCount;
        }
        if (letterCount.equals(word)) {
            System.out.println("Congrats! You win! The word was " + word);
        }
    }

    public static void hangmanImage() {
        if (count == 1) {
            System.out.println("Wrong guess, try again | 6 guesses left!");
            System.out.println("   ____________");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   | ");
            System.out.println("___|___");
            System.out.println();
        }
        if (count == 2) {
            System.out.println("Wrong guess, try again | 5 guesses left!");
            System.out.println("   ____________");
            System.out.println("   |          _|_");
            System.out.println("   |        /     \\");
            System.out.println("   |        |     |");
            System.out.println("   |         \\_ _/");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("___|___");
        }
        if (count == 3) {
            System.out.println("Wrong guess, try again | 4 guesses left!");
            System.out.println("   ____________");
            System.out.println("   |          _|_");
            System.out.println("   |        /     \\");
            System.out.println("   |        |     |");
            System.out.println("   |         \\_ _/");
            System.out.println("   |           |");
            System.out.println("   |           |");
            System.out.println("   |");
            System.out.println("___|___");
        }
        if (count == 4) {
            System.out.println("Wrong guess, try again | 3 guesses left!");
            System.out.println("   ____________");
            System.out.println("   |          _|_");
            System.out.println("   |        /     \\");
            System.out.println("   |        |     |");
            System.out.println("   |         \\_ _/");
            System.out.println("   |           |");
            System.out.println("   |           |");
            System.out.println("   |          /  ");
            System.out.println("___|___      /   ");
        }
        if (count == 5) {
            System.out.println("   ____________");
            System.out.println("   |          _|_");
            System.out.println("   |        /     \\");
            System.out.println("   |        |     |");
            System.out.println("   |         \\_ _/");
            System.out.println("   |           |");
            System.out.println("   |           | ");
            System.out.println("   |          / \\ ");
            System.out.println("___|___      /   \\");
        }
        if (count == 6) {
            System.out.println("Wrong guess, try again | 1 guess left!");
            System.out.println("   ____________");
            System.out.println("   |          _|_");
            System.out.println("   |        /     \\");
            System.out.println("   |        |     |");
            System.out.println("   |         \\_ _/");
            System.out.println("   |          _|");
            System.out.println("   |         / | ");
            System.out.println("   |          / \\ ");
            System.out.println("___|___      /   \\");
        }
        if (count == 7) {
            System.out.println("GAME OVER!");
            System.out.println("   ____________");
            System.out.println("   |          _|_");
            System.out.println("   |        /     \\");
            System.out.println("   |        |     |");
            System.out.println("   |         \\_ _/");
            System.out.println("   |          _|_");
            System.out.println("   |         / | \\");
            System.out.println("   |          / \\ ");
            System.out.println("___|___      /   \\");
            System.out.println("GAME OVER! The word was " + word);
        }
    }
}