import java.util.Scanner;

/**
 * Representaion of the main entry of the game.
 * Allows interactive mode with multiple rounds using a shoe of cards.
 * 
 * @author Zeyad Bassyouni
 */
public class Baccarat {
  public static void main(String[] args) {
    // Create a shoe containing 6 full decks of cards, and shuffle it
    Shoe shoe = new Shoe(6);
    shoe.shuffle();

    // Create hands for the banker and a single player
    BaccaratHand playerHand = new BaccaratHand();
    BaccaratHand bankerHand = new BaccaratHand();

    // Variables to keep track of game statistics
    int roundsPlayed = 0;
    int playerWins = 0;
    int bankerWins = 0;
    int ties = 0;

    Scanner scanner = new Scanner(System.in);
    boolean interactiveMode = false;

    // Check if interactive mode is enabled
    if (args.length > 0 && (args[0].equals("-i") || args[0].equals("--interactive"))) {
      interactiveMode = true;
    }

    boolean playAgain = true;

    while (shoe.cardsRemaining() >= 6 && playAgain) {
      roundsPlayed++;

      // Deal two cards to player and banker
      playerHand.add(shoe.deal());
      bankerHand.add(shoe.deal());
      playerHand.add(shoe.deal());
      bankerHand.add(shoe.deal());

      // Display the hands
      System.out.println("Round " + roundsPlayed);
      System.out.println("Player: " + playerHand.toString() + " = " + playerHand.value());
      System.out.println("Banker: " + bankerHand.toString() + " = " + bankerHand.value());

      // Determine if a third card should be drawn for the player
      if (playerHand.shouldDrawThirdCard(playerHand.value())) {
        playerHand.add(shoe.deal());
        System.out.println("Dealing third card to player...");
        System.out.println("Player: " + playerHand.toString() + " = " + playerHand.value());
      }

      // Determine if a third card should be drawn for the banker
      if (bankerHand.shouldDrawThirdCard(bankerHand.value())) {
        bankerHand.add(shoe.deal());
        System.out.println("Dealing third card to banker...");
        System.out.println("Banker: " + bankerHand.toString() + " = " + bankerHand.value());
      }

      // Determine the winner
      int playerTotal = playerHand.value();
      int bankerTotal = bankerHand.value();
      String result;

      if (playerTotal > bankerTotal) {
        result = "Player wins!";
        playerWins++;
      } else if (bankerTotal > playerTotal) {
        result = "Banker wins!";
        bankerWins++;
      } else {
        result = "Tie";
        ties++;
      }

      System.out.println(result);

      // Check if interactive mode is enabled and prompt for another round
      if (interactiveMode && shoe.cardsRemaining() >= 6) {
        System.out.print("Another round? (y/n): ");
        if (scanner.hasNext()) {
          String input = scanner.next().trim();
          playAgain = input.startsWith("y") || input.startsWith("Y");
        } else {
          playAgain = false;
        }
        System.out.println();
      } else {
        playAgain = false;
      }

      // Reset the hands for the next round
      playerHand.discard();
      bankerHand.discard();
    }

    scanner.close();

    // Display game statistics
    System.out.println(roundsPlayed + " rounds played");
    System.out.println(playerWins + " player wins");
    System.out.println(bankerWins + " banker wins");
    System.out.println(ties + " ties");
  }
}

