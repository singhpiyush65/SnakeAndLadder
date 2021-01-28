import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.Map;
import java.util.Queue;

import static org.junit.Assert.*;

public class BoardTest {
    @InjectMocks
    Board board;
    @Mock
    Dice dice;
    @Mock
    Queue<Player> nextPlayer;
    @Mock
    Map<Integer, Integer> snakes;
    @Mock
    Map<Player, Integer> currentPosition;

    @Test
    public void startGame() {
        board.startGame();
    }
}