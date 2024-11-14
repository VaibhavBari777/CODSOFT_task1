import java.util.Random;
import java.util.Scanner;

public class TASK {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean playAgain = true;
        int roundsWon = 0;
        
        System.out.println("Welcome to the Number Guessing Game!");
        
        while (playAgain) {
            int generatedNumber = random.nextInt(100) + 1;  // Random number between 1 and 100
            int attempts = 0;
            int maxAttempts = 5;  // Limit the number of attempts per round
            boolean roundWon = false;
            
            System.out.println("\nI have generated a number between 1 and 100. Try to guess it!");
            System.out.println("You have " + maxAttempts + " attempts to guess correctly.");
            
            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess == generatedNumber) {
                    System.out.println("Congratulations! You guessed the correct number in " + attempts + " attempts.");
                    roundsWon++;
                    roundWon = true;
                    break;
                } else if (userGuess > generatedNumber) {
                    System.out.println("Your guess is too high.");
                } else {
                    System.out.println("Your guess is too low.");
                }

                System.out.println("Attempts remaining: " + (maxAttempts - attempts));
            }
            
            if (!roundWon) {
                System.out.println("Sorry, you've run out of attempts. The correct number was " + generatedNumber + ".");
            }
            
            System.out.println("Rounds won: " + roundsWon);
            
            System.out.print("Would you like to play another round? (yes/no): ");
            playAgain = scanner.next().equalsIgnoreCase("yes");
        }

        System.out.println("Thank you for playing! You won a total of " + roundsWon + " round(s).");
        scanner.close();
    }
}
