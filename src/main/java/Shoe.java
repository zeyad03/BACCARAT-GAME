import java.util.Collections;

/**
 * Representation of a shoe containing a collection of cards.
 * Extends CardCollection class.
 * 
 * @author Zeyad Bassyouni
 */
public class Shoe extends CardCollection {

  private final int numDecks;

  /**
   * Creates a Shoe containing the specified number of decks of cards.
   *
   * @param numDecks The number of decks of cards
   * @throws CardException if numDecks is not 6 or 8
   */
  public Shoe(int newNumDecks) throws CardException {
    if (newNumDecks != 6 && newNumDecks != 8) {
      throw new CardException("Invalid number of decks: " + newNumDecks);
    }
    this.numDecks = newNumDecks;
    fillShoe();
  }

  /**
   * Fills the shoe with the specified number of decks of cards.
   */
  private void fillShoe() {
    for (int i = 0; i < numDecks; i++) {
      for (Card.Suit suit : Card.Suit.values()) {
        for (Card.Rank rank : Card.Rank.values()) {
          cards.add(new BaccaratCard(rank, suit));
        }
      }
    }
  }

  /**
   * Shuffles the cards in the shoe randomly.
   */
  public void shuffle() {
    Collections.shuffle(cards);
  }

  /**
   * Removes the first card in the shoe and returns it.
   *
   * @return The first card in the shoe
   * @throws CardException if the shoe is empty
   */
  public Card deal() throws CardException {
    if (cards.isEmpty()) {
      throw new CardException("Cannot deal from an empty shoe");
    }
    return cards.remove(0);
  }

  /**
   * Returns the number of cards remaining in the shoe.
   *
   * @return the number of cards remaining in the shoe
   */
  public int cardsRemaining() {
    return cards.size();
  }

}
