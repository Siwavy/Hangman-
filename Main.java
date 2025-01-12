import java.util.Scanner;

//I have created the main class and entry point for the program
public class Main {
    public static void main(String[] args) {

        // This is where the game starts
        System.out.println("Welcome to Hangman!");

        // The word to guess
        String guessTheWord = "delaware";

        // Placeholder for the word using underscores
        StringBuilder guessWord = new StringBuilder("________");

        // Display the placeholder for the word
        System.out.println("Your word: " + guessWord);

        // I Created a Scanner object to read user input
        Scanner scanner = new Scanner(System.in);

        // This Keep track of how many attempts the player has left
        int attempts = 6;

        // Keep the game running until the word is guessed or the attempts run out
        while (!guessWord.toString().equals(guessTheWord) && attempts > 0) {
            // Ask the user to guess a letter
            System.out.print("Guess a letter: ");
            String userInput = scanner.nextLine();

            // Check if the input is valid (one letter only)
            if (userInput.length() != 1 || !Character.isLetter(userInput.charAt(0))) {
                System.out.println("Invalid input. Please enter one letter.");
                continue; // Skip to the next guess
            }

            // Print the guessed letter for testing
            System.out.println("Your guess: " + userInput);

            //to check if the guess is correct
            boolean isCorrect = false;

            // Check the word for the guessed letter
            for (int i = 0; i < guessTheWord.length(); i++) {
                if (guessTheWord.charAt(i) == userInput.charAt(0)) {
                    // Update the placeholder
                    guessWord.setCharAt(i, guessTheWord.charAt(i));
                    isCorrect = true;
                }
            }

            // Gives feedback based on whether the guess was correct
            if (isCorrect) {
                System.out.println("GREAT YOU ARE CORRECT;)");
            } else {
                System.out.println("SORRY YOU ARE WRONG :(");
                attempts--; // Reduce the number of attempts after each guess
            }

            // Shows the updated word and attempts left
            System.out.println("Your word: " + guessWord);
            System.out.println("Attempts left: " + attempts);
        }

        // Checks if the user has won or lost
        if (guessWord.toString().equals(guessTheWord)) {
            System.out.println("CONGRATULATIONS! YOU GUESSED THE WORD!");
        } else {
            System.out.println("GAME OVER! The word was: " + guessTheWord);
        }
    }
}
