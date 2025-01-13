import java.util.Scanner; // Import Scanner to get user input
import java.util.Random; // Import Random to select a random word from the list
import java.nio.file.Files; // Import Files to read file contents
import java.nio.file.Paths; // Import Paths to handle file paths
import java.io.IOException; // Import IOException to handle file reading errors
import java.util.List; // Import List interface to store words
import java.util.ArrayList; // Import ArrayList to manage lists of words

// Main class and entry point of the program
public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to Hangman!\n"); // Display a welcome message to the user
        System.out.println("Looking for file at: " + "wordsList.txt"); // Inform the user where the program is looking for the word list

        // Load words from the file
        List<String> words = loadWordsFromFile("wordsList.txt"); // Call the method to read words from the file
        if (words.isEmpty()) { // Check if the word list is empty
            System.out.println("No words available to play. Please check the wordsList.txt file."); // Let the user know if no words were found
            return; // Exit the program if no words are available
        }

        Random random = new Random(); // Create a Random object to select a random word
        String guessTheWord = words.get(random.nextInt(words.size())); // Pick a random word from the list

        StringBuilder guessWord = new StringBuilder("_".repeat(guessTheWord.length())); // Create a placeholder with underscores for the word

        System.out.println("Your word: " + guessWord); // Show the user the placeholder word

        Scanner scanner = new Scanner(System.in); // Create a Scanner object to get user input
        int attempts = 6; // Set the number of attempts the user has

        // Main game loop: runs until the word is guessed or attempts run out
        while (!guessWord.toString().equalsIgnoreCase(guessTheWord) && attempts > 0) {
            System.out.print("Guess a letter: "); // Prompt the user to guess a letter
            String userInput = scanner.nextLine().toLowerCase(); // Read the user's input and convert it to lowercase

            // Validate the user's input
            if (userInput.length() != 1 || !Character.isLetter(userInput.charAt(0))) { // Check if the input is a single valid letter
                System.out.println("Invalid input. Please enter one letter."); // Let the user know if the input is invalid
                continue; // Skip to the next iteration of the loop
            }

            System.out.println("Your guess: " + userInput); // Display the guessed letter for clarity

            boolean isCorrect = checkGuess(guessTheWord.toLowerCase(), guessWord, userInput.charAt(0)); // Check if the guess is correct

            // Provide feedback based on whether the guess was correct
            if (isCorrect) {
                System.out.println("GREAT YOU ARE CORRECT;)"); // Positive feedback for a correct guess
            } else {
                System.out.println("SORRY YOU ARE WRONG :("); // Negative feedback for an incorrect guess
                attempts--; // Reduce the number of attempts
            }

            System.out.println("Your word: " + guessWord); // Show the updated placeholder word
            System.out.println("Attempts left: " + attempts + "\n"); // Display the remaining attempts
        }

        // Check the final result of the game
        if (guessWord.toString().equalsIgnoreCase(guessTheWord)) { // If the user guessed the word correctly
            System.out.println("CONGRATULATIONS! YOU GUESSED THE WORD!"); // Congratulate the user
        } else {
            System.out.println("GAME OVER! The word was: " + guessTheWord); // Reveal the correct word
        }
    }

    // Method to load words from a file
    public static List<String> loadWordsFromFile(String fileName) {
        try {
            return Files.readAllLines(Paths.get(fileName)); // Read all lines from the file and return as a list
        } catch (IOException e) { // Catch any errors during file reading
            System.out.println("Error reading the file: " + e.getMessage()); // Print an error message
            return new ArrayList<>(); // Return an empty list if an error occurs
        }
    }

    // Method to check if the guessed letter is in the word
    public static boolean checkGuess(String guessTheWord, StringBuilder guessWord, char guessedLetter) {
        boolean isCorrect = false; // Flag to track if the guess is correct

        // Loop through each character in the word
        for (int i = 0; i < guessTheWord.length(); i++) {
            if (guessTheWord.charAt(i) == guessedLetter) { // Check if the guessed letter matches
                guessWord.setCharAt(i, guessedLetter); // Update the placeholder with the correct letter
                isCorrect = true; // Mark the guess as correct
            }
        }

        return isCorrect; // Return whether the guess was correct
    }
}
