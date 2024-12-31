import java.util.Scanner;

public class GuessTheWord {
    public static void main(String[] args) {

        String[][] word_list = {
            {"algorithm", "Problem-solving"},
            {"compiler", "Code converter"},
            {"network", "Connections"},
            {"database", "Data storage"},
            {"programming", "Code writing"},
            {"java", "Programming language"},
            {"python", "Scripting language"},
            {"software", "Applications"},
            {"debugging", "Error fixing"},
            {"function", "Code block"},
            {"array", "Data structure"},
            {"coding", "Programming"}
        };
        
        // Randomly select a word and its hint from the list
        int randomIndex = (int)(Math.random() * word_list.length);
        String random_word = word_list[randomIndex][0];
        String hint = word_list[randomIndex][1];
        
        char[] hidden_word = new char[random_word.length()];
        
        // Get input from the user
        Scanner keyboard = new Scanner(System.in);
        String user_guess;
        int miss_chance = 0;
        char[] missed = new char[5];
        boolean letter_found;
        boolean solved = false;

        // Convert the selected word to underscores
        for (int i = 0; i < random_word.length(); i++) {
            hidden_word[i] = '_';
        }

        System.out.println("Let's play the game!\n");

        // Hint
        System.out.println("Hint: " + hint + "\n");

        while (miss_chance < 5 && !solved) {
            System.out.println("Chances Left: " + (5 - miss_chance));
            System.out.print("Word: ");
            for (int i = 0; i < random_word.length(); i++) {
                System.out.print(hidden_word[i] + " ");
            }

            System.out.print("\nLetters Guessed: ");
            for (int i = 0; i < miss_chance; i++) {
                System.out.print(missed[i] + " ");
            }

            System.out.print("\nGuess: ");
            user_guess = keyboard.next();
            letter_found = false;

            for (int i = 0; i < random_word.length(); i++) {
                if (user_guess.charAt(0) == random_word.charAt(i)) {
                    hidden_word[i] = random_word.charAt(i);
                    letter_found = true;
                }
            }

            if (letter_found) {
                System.out.println("Correct Letter!");
            } else {
                missed[miss_chance] = user_guess.charAt(0);
                miss_chance++;
                System.out.println("Incorrect Letter!");
            }

            int hidden_count = 0;
            for (int i = 0; i < random_word.length(); i++) {
                if (hidden_word[i] == '_') {
                    hidden_count++;
                }
            }
            if (hidden_count == 0) {
                solved = true;
            }

            System.out.println();
        }

        System.out.println("Chances Left: " + (5 - miss_chance));
        System.out.print("Word: ");
        for (int i = 0; i < random_word.length(); i++) {
            System.out.print(hidden_word[i] + " ");
        }
        System.out.print("\nLetters Guessed: ");
        for (int i = 0; i < miss_chance; i++) {
            System.out.print(missed[i] + " ");
        }

        // Result
        if (solved) {
            System.out.println("\nYou won!");
        } else {
            System.out.println("\nGame Over! The word was: " + random_word);
        }
    }
}
