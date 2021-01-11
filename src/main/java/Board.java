import java.util.Random;
import java.util.Scanner;

public class Board {
    private static int BOARD_SIZE;
    private static int currentPos = 0;

    public Board(int boardSize) {
        BOARD_SIZE = boardSize;
    }

    public int rollDice() {
        Random r = new Random();
        return r.nextInt(6) + 1;
    }

    public void movePlayer(int moveValue) {
        currentPos += moveValue;
        if (currentPos > BOARD_SIZE)
            currentPos -= moveValue;

    }

    public void startGame() {
        Scanner scanner = new Scanner(System.in);
        String userDecision = "Y";
        int diceValue = 0;

        while (userDecision.equalsIgnoreCase("Y")) {
            System.out.println("Do you want to roll dice. Press Y/N");
            userDecision = scanner.next();

            diceValue = rollDice();

            System.out.println("Dice Value = " + diceValue);
            movePlayer(diceValue);
            System.out.println("Player moved to: " + currentPos);
            if (currentPos == BOARD_SIZE) {
                System.out.println("Player won");
                System.out.println("Existing the game");
                break;
            }
        }
    }

}
