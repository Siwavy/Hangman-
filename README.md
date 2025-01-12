Hangman

Introduction

This is a simple Hangman game written in Java. The goal is to guess the hidden word by suggesting one letter at a time. The game keeps track of your progress, tells you how many attempts you have left, and lets you know whether you’ve guessed correctly or not. You win if you guess the entire word before running out of attempts.

How the Game Works

Starting the Game:
The program begins by displaying a word represented by underscores (________). Each underscore corresponds to a letter in the word.

Guessing a Letter:
You’re asked to input one letter at a time. If the letter is in the word, it replaces the corresponding underscores with the correct letter.
If the letter isn’t in the word, you lose an attempt.

Ending the Game:
The game ends when:
You’ve guessed all the letters correctly (you win), or
You’ve run out of attempts (you lose). If you lose, the program reveals the correct word.


What I Learned
This project helped me develop a better understanding of core Java programming concepts:

Scanners:
I learned how to use Scanner to read user input, which is crucial for making interactive programs. I used scanner.nextLine() to capture guesses from the user.

String Manipulation:
I worked with StringBuilder to dynamically update the placeholder word as correct letters were guessed. I also used methods like charAt to compare individual letters in the word.

Loops:
I used a while loop to control the flow of the game, ensuring the user could keep guessing until the game ended.
I used a for loop to compare the user’s guess against each letter in the word.
Logic and Problem Solving:
Setting up the game logic, such as validating input, tracking attempts, and checking win/lose conditions, strengthened my understanding of how to structure a program effectively.

How to Play:
Start the game by running the program.
Follow the prompts to guess one letter at a time.
After each guess:
The game shows your progress on the word.
It tells you if your guess was correct or not.
It displays how many attempts you have left.
The game ends when you’ve either guessed the word or run out of attempts.
Example Game

Welcome to Hangman!
Your word: ________

Guess a letter: a

Your guess: a

GREAT YOU ARE CORRECT;)

Your word: ___a__a_
Attempts left: 6

Guess a letter: z

Your guess: z

SORRY YOU ARE WRONG :(

Your word: ___a__a_

Attempts left: 5


Future Ideas

Add a feature to randomly select a word from a list so the game is different every time.
Display previously guessed letters to help players avoid repeating guesses.
Implement a scoring system to reward players for fewer wrong guesses.


Reflection

This project was a great learning experience for me. I was able to:
Understand what scanners are for and how they handle user input.
Learn how to manipulate strings dynamically using StringBuilder and methods like setCharAt and charAt.
Practice setting up and using loops effectively to control the game flow.
Improve my logic and problem-solving skills by thinking through the game structure step by step.
I really enjoyed building this game and seeing my progress in Java programming!

