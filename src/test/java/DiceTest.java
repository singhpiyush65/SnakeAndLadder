import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DiceTest {


    @Test
    public void rollDiceEven() {
        Dice dice = new Dice(true);
        for (int i = 0; i < 10; i++) {
            int val = dice.rollDice();
            Assert.assertTrue(val % 2 == 0);
        }

    }

    @Test
    public void rollDiceValue() {
        Dice dice = new Dice(false);
        for (int i = 0; i < 10; i++) {
            int val = dice.rollDice();
            Assert.assertTrue(val <= 6 && val >= 1);
        }

    }
}