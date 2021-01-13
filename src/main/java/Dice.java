import java.util.Random;

public class Dice {
    private boolean isDiceCrooked;

    Dice(boolean isDiceCrooked) {
        this.isDiceCrooked = isDiceCrooked;
    }

    int rollDice() {
        Random random = new Random();
        if (isDiceCrooked) {
            return 1 + random.nextInt(3) * 2;
        } else {
            return random.nextInt(6) + 1;
        }
    }

}
