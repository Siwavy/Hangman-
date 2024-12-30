import java.util.Scanner;

//I have created the main class and entry point for the program
public class Main {
    public static void main(String[] args) {

        //this is where the game will start
        System.out.println("Welcome to Hangman!");

        // This is where I defined the word to guess
        String guessTheWord = "delaware";

        //Now I need a placeholder for my word using underscores with StringBuilder
        StringBuilder guessWord = new StringBuilder("________");

        // Display the placeholder for the word
        System.out.println("Your word: " + guessWord);

        // Create a Scanner object to read user input
        Scanner scanner = new Scanner(System.in);

        // This tells the user to guess a letter
        System.out.print("Guess a letter: ");
        String userInput = scanner.nextLine(); // Read the input of the user

        // Print the guessed letter to verify the input. this will be for testing
        System.out.println("Your guess: " + userInput);

        // Flag to check if the guess is correct
        boolean isCorrect = false;

        // Go through each letter in the word
        for (int i = 0; i < guessTheWord.length(); i++) {
            // If the guessed letter matches this letter in the word
            if (guessTheWord.charAt(i) == userInput.charAt(0)) {
                // Update the placeholder to show the correct letter
                guessWord.setCharAt(i, guessTheWord.charAt(i));
                // Set the flag to show the guess was correct
                isCorrect = true;
            }
        }

        //these are the conditions for correct and incorrect guesses
        if (isCorrect) {
            System.out.println("GREAT YOU ARE CORRECT;)");
        } else {
            System.out.println("SORRY YOU ARE WRONG :(");
        }

        //This will Display the updated placeholders/underscores after each guess
        System.out.println("Your word: " + guessWord);
    }
}
