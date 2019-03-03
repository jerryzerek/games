import java.util.Random;

public class Game2 {
    public void chooseWhoStarts(String player, String computer) {
        Random generator = new Random();
        String startingPlayer;
        int randomNumber = generator.nextInt(2);
        if (randomNumber == 0) {
            startingPlayer = player;
        } else {
            startingPlayer = computer;
        }
    }


}
