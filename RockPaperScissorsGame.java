import java.util.Random;
import java.util.Scanner;

public class RockPaperScissorsGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int userScore = 0;
        int computerScore = 0;

        while (true) {
            System.out.println("Enter your choice (rock/paper/scissors) or 'quit' to exit:");
            String userChoice = scanner.nextLine();

            if (userChoice.equalsIgnoreCase("quit")) {
                break;
            }

            String computerChoice = getComputerChoice(random);

            System.out.println("Computer choice: " + computerChoice);

            if (isUserWin(userChoice, computerChoice)) {
                userScore++;
                System.out.println("You win this round!");
            } else if (isComputerWin(userChoice, computerChoice)) {
                computerScore++;
                System.out.println("Computer wins this round!");
            } else {
                System.out.println("It's a tie!");
            }

            System.out.println("Score - You: " + userScore + ", Computer: " + computerScore);
        }

        scanner.close();
    }

    private static String getComputerChoice(Random random) {
        int choice = random.nextInt(3);
        switch (choice) {
            case 0:
                return "rock";
            case 1:
                return "paper";
            default:
                return "scissors";
        }
    }

    private static boolean isUserWin(String userChoice, String computerChoice) {
        return (userChoice.equalsIgnoreCase("rock") && computerChoice.equalsIgnoreCase("scissors")) ||
               (userChoice.equalsIgnoreCase("paper") && computerChoice.equalsIgnoreCase("rock")) ||
               (userChoice.equalsIgnoreCase("scissors") && computerChoice.equalsIgnoreCase("paper"));
    }

    private static boolean isComputerWin(String userChoice, String computerChoice) {
        return (computerChoice.equalsIgnoreCase("rock") && userChoice.equalsIgnoreCase("scissors")) ||
               (computerChoice.equalsIgnoreCase("paper") && userChoice.equalsIgnoreCase("rock")) ||
               (computerChoice.equalsIgnoreCase("scissors") && userChoice.equalsIgnoreCase("paper"));
    }
}