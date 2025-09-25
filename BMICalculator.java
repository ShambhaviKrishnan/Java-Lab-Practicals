import java.util.Scanner;

public class BMICalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt user for weight in pounds
        System.out.print("Enter weight in pounds: ");
        double weightPounds = scanner.nextDouble();

        // Prompt user for height in inches
        System.out.print("Enter height in inches: ");
        double heightInches = scanner.nextDouble();

        // Convert pounds to kilograms
        double weightKg = weightPounds * 0.45359237;

        // Convert inches to meters
        double heightMeters = heightInches * 0.0254;

        // Calculate BMI
        double bmi = weightKg / (heightMeters * heightMeters);

        // Display BMI
        System.out.printf("Your BMI is: %.2f%n", bmi);

        // Interpret BMI based on given ranges
        if (bmi < 18.5) {
            System.out.println("Interpretation: Underweight");
        } else if (bmi < 25.0) {
            System.out.println("Interpretation: Normal");
        } else if (bmi < 30.0) {
            System.out.println("Interpretation: Overweight");
        } else {
            System.out.println("Interpretation: Obese");
        }

        scanner.close();
    }
}
