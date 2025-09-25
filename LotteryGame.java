import java.util.Scanner;
import java.util.Random;

public class LotteryGame {
    public static void main(String[] args) {
        // Create Random object to generate lottery number
        Random rand = new Random();
        int lottery = rand.nextInt(90) + 10; // Two-digit number between 10 and 99

        // Get user input
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a two-digit number: ");
        int guess = scanner.nextInt();

        // Extract digits
        int lotteryDigit1 = lottery / 10;
        int lotteryDigit2 = lottery % 10;

        int guessDigit1 = guess / 10;
        int guessDigit2 = guess % 10;

        System.out.println("Lottery number is: " + lottery);

        // Check conditions
        if (guess == lottery) {
            System.out.println("Exact match: you win $10,000!");
        } else if ((guessDigit1 == lotteryDigit2 && guessDigit2 == lotteryDigit1)) {
            System.out.println("Match all digits: you win $3,000!");
        } else if (guessDigit1 == lotteryDigit1 || guessDigit1 == lotteryDigit2 ||
                   guessDigit2 == lotteryDigit1 || guessDigit2 == lotteryDigit2) {
            System.out.println("Match one digit: you win $1,000!");
        } else {
            System.out.println("Sorry, no match.");
        }

        scanner.close();
    }
}
