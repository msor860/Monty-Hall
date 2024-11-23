import java.util.Random;

public class Main {
  public static void main(String[] args) {
    double win = 0.0;
    double loss = 0.0;
    Random choice = new Random();
    choice.setSeed(30); // keeps things random
    for (int i = 0; i < 10000; i++) {
      //10,000 checks: Player is given 3 doors, one has a prize, two have zonks
      int realDoor = choice.nextInt(3); // which door has the prize
      int doorChose = choice.nextInt(3); // player choice
      int fake = choice.nextInt(3); // one door with zonk
      while (fake == doorChose || fake == realDoor) { // this loop makes sure the fake door isn't the real door or the
                                                      // door the player chose
        fake = choice.nextInt(3);
      }
      //now knowing one of the fake doors, the player can stick to their
      //choice, or switch to the other closed door
      // player always switches
      if (fake == 0 && doorChose == 1) {
        doorChose = 2;
      } else if (fake == 0 && doorChose == 2) {
        doorChose = 1;
      } else if (fake == 1 && doorChose == 0) {
        doorChose = 2;
      } else if (fake == 1 && doorChose == 2) {
        doorChose = 0;
      } else if (fake == 2 && doorChose == 1) {
        doorChose = 0;
      } else if (fake == 2 && doorChose == 0) {
        doorChose = 1;
      }
      // did you win?
      if (doorChose == realDoor) {
        win++;
      } else {
        loss++;
      }
    }
    // result printed
    // without switch, chances are 50/50
    // with switch, 66% chance of win
    System.out.println("Win Percent: " + (win / 100) + "%");
    System.out.println("Loss Percent: " + (loss / 100) + "%");
  }
}