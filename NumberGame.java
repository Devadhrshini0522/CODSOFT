import java.util.Random;
import java.util.Scanner;

public class NumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int score = 0;  // To track total rounds won
        boolean playAgain = true;

        System.out.println(" Welcome to the Number Guessing Game!");
        System.out.println("--------------------------------------");

        while (playAgain) {
            int lowerBound = 1;
            int upperBound = 100;
            int randomNumber = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
            int attempts = 0;
            int maxAttempts = 7;
            boolean guessedCorrectly = false;

            System.out.println("\nI've chosen a number between " + lowerBound + " and " + upperBound + ".");
            System.out.println("Can you guess it? You have " + maxAttempts + " attempts!");

            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess == randomNumber) {
                    System.out.println(" Congratulations! You guessed the number in " + attempts + " attempts.");
                    guessedCorrectly = true;
                    score++;
                    break;
                } else if (userGuess < randomNumber) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }
            }

            if (!guessedCorrectly) {
                System.out.println("Sorry! You've used all attempts. The correct number was " + randomNumber + ".");
            }

            System.out.print("\nDo you want to play another round? (yes/no): ");
            String response = scanner.next().toLowerCase();
            playAgain = response.equals("yes");
        }

        System.out.println("\n Game Over! You won " + score + " round(s).");
        System.out.println("Thanks for playing!");
        scanner.close();
    }
}
