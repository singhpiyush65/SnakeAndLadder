import java.util.*;

public class SnakeAndLadderClient {
    public static void main(String[] args) {
        Dice dice = new Dice(true);
        Player p1 = new Player("Piyush", 1);
        Queue<Player> allPlayers = new LinkedList<>();
        allPlayers.offer(p1);
        Map<Player, Integer> playersCurrentPosition = new HashMap<>();
        playersCurrentPosition.put(p1, 0);
        HashMap<Integer, Integer> snakes = new HashMap<>();
        snakes.put(7, 1);

        Board gb = new Board(dice, allPlayers, snakes, playersCurrentPosition, 100);
        gb.startGame();
    }
}
