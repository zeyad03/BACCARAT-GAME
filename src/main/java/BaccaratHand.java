/**
 * Representation of hand of cards.
 * Extends the CardCollection class.
 * 
 * @author Zeyad Bassyouni
 */
public class BaccaratHand extends CardCollection {

  /**
   * Determines whether a third card should be drawn based on the player's total.
   *
   * @param playerTotal the total value of the player's hand
   * @return true if a third card should be drawn, false otherwise
   */
  public boolean shouldDrawThirdCard(int playerTotal) {
    if (size() <= 2 && playerTotal <= 5) {
      return true;
    }
    return false;
  }

  /**
   * Provides a string representation of the cards in the hand.
   *
   * @return a string representation of the cards in the hand
   */
  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    for (Card card : cards) {
      sb.append(card.toString()).append(" ");
    }
    return sb.toString().trim();
  }

  /**
   * Calculates the value of the hand.
   * The value is obtained by summing up the values of all the cards in the hand
   * and returning the result modulo 10.
   *
   * @return the value of the hand modulo 10
   */
  @Override
  public int value() {
    int sum = 0;
    for (Card card : cards) {
      sum += card.value();
    }
    return sum % 10;
  }

  /**
   * Determines if the hand is a natural hand in Baccarat.
   * A natural hand is a hand consisting of two cards with a total value of either 8 or 9.
   *
   * @return true if the hand is a natural hand, false otherwise
   */
  public boolean isNatural() {
    return cards.size() == 2 && (value() == 8 || value() == 9);
  }
}
