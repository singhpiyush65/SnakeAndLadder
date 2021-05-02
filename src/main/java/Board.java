import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

class Board {
    private final Dice dice;
    private Queue<Player> nextPlayer;
    private static Map<Integer, Integer> snakes = new HashMap<>();
    private Map<Player, Integer> currentPosition;
    int boardSize;

    Board(Dice dice, Queue<Player> nextPlayer, HashMap<Integer, Integer> snakes, Map<Player, Integer> currentPosition, int boardSize) {
        this.dice = dice;
        this.nextPlayer = nextPlayer;
        Board.snakes = snakes;
        this.currentPosition = currentPosition;
        this.boardSize = boardSize;
    }

    void startGame() {
        Scanner scanner = new Scanner(System.in);
        String userDecision = "Y";
        while (userDecision.equalsIgnoreCase("Y")) {
            Player player = nextPlayer.poll();
            int currentPosition = this.currentPosition.get(player);
            int diceValue = dice.rollDice();
            int nextTile = currentPosition + diceValue;
            if (nextTile > boardSize) nextPlayer.offer(player);
            else if (nextTile == boardSize) {
                System.out.println(player.getName() + " won the game");
                System.exit(0);
            } else {
                int[] nextPosition = new int[1];
                boolean[] b = new boolean[1];
                nextPosition[0] = nextTile;
                snakes.forEach((k, v) -> {
                    if (k == nextTile) {
                        nextPosition[0] = v;
                    }
                });
                if (nextPosition[0] != nextTile)
                    System.out.println(player.getName() + " Bitten by Snake present at: " + nextTile);

                if (nextPosition[0] != nextTile && b[0])
                    System.out.println(player.getName() + " Got ladder present at: " + nextTile);
                if (nextPosition[0] == boardSize) {
                    System.out.println(player.getName() + " won the game");
                    break;
                } else {
                    this.currentPosition.put(player, nextPosition[0]);
                    System.out.println(player.getName() + " is at position " + nextPosition[0]);
                    nextPlayer.offer(player);
                }
            }
            System.out.println("Do you want to play more. Y/N");
            userDecision = scanner.next();
        }
    }
}
