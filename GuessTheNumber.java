import java.util.Random;
import java.util.Scanner;

public class GuessTheNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        int score = 0;
        boolean playAgain = true;
        
        while (playAgain) {
            int numberToGuess = random.nextInt(100) + 1;
            int numberOfAttempts = 0;
            int maxAttempts = 10;
            boolean hasGuessedCorrectly = false;
            
            System.out.println("Welcome to Guess the Number Game!");
            System.out.println("I have selected a number between 1 and 100.");
            System.out.println("You have " + maxAttempts + " attempts to guess it.");

            while (numberOfAttempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                numberOfAttempts++;
                
                if (userGuess == numberToGuess) {
                    hasGuessedCorrectly = true;
                    score += (maxAttempts - numberOfAttempts + 1) * 10; // Points based on attempts left
                    System.out.println("Congratulations! You guessed the number in " + numberOfAttempts + " attempts.");
                    break;
                } else if (userGuess < numberToGuess) {
                    System.out.println("Your guess is too low.");
                } else {
                    System.out.println("Your guess is too high.");
                }
            }

            if (!hasGuessedCorrectly) {
                System.out.println("Sorry, you have used all " + maxAttempts + " attempts. The number was " + numberToGuess + ".");
            }
            
            System.out.println("Your current score is: " + score);
            System.out.print("Do you want to play another round? (yes/no): ");
            String userResponse = scanner.next();
            playAgain = userResponse.equalsIgnoreCase("yes");
        }
        
        System.out.println("Thank you for playing! Your final score is: " + score);
        scanner.close();
    }
}
