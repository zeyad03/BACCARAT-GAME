/**
 * Representaion of a card.
 * Extends the Card class.
 * 
 * @author Zeyad Bassyouni
 */
public class BaccaratCard extends Card {

    /**
     * Constructor for creating a BaccaratCard object with specified rank and suit.
     *
     * @param rank Rank of the card
     * @param suit Suit of the card
     */
    public BaccaratCard(Rank rank, Suit suit) {
        super(rank, suit);
    }

    /**
     * Returns a string representation of this card, including its rank and suit.
     *
     * @return String representation of the card
     */
    public String toString() {
        String rankString;
        switch (getRank()) {
            case ACE:
            rankString = "A";
            break;
            case TWO:
            rankString = "2";
            break;
            case THREE:
            rankString = "3";
            break;
            case FOUR:
            rankString = "4";
            break;
            case FIVE:
            rankString = "5";
            break;
            case SIX:
            rankString = "6";
            break;
            case SEVEN:
            rankString = "7";
            break;
            case EIGHT:
            rankString = "8";
            break;
            case NINE:
            rankString = "9";
            break;
            case TEN:
            rankString = "T";
            break;
            case JACK:
            rankString = "J";
            break;
            case QUEEN:
            rankString = "Q";
            break;
            case KING:
            rankString = "K";
            break;
            default:
            rankString = "";
            break;
        }
        char suitSymbol = getSuit().getSymbol();
        return rankString + suitSymbol;
    }

    /**
     * Compares this card to another object for equality, using their ranks and suits.
     *
     * @param other Object to compare to
     * @return true if the other object is a card with the same rank and suit, false otherwise
     */
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof BaccaratCard)) {
            return false;
        }
        BaccaratCard otherCard = (BaccaratCard) other;
        return this.getRank() == otherCard.getRank() && this.getSuit() == otherCard.getSuit();
    }    
    
    /**
     * Compares this card to another card, using their ranks and suits.
     *
     * @param other Card to compare to
     * @return -1, 0, or 1 depending on whether this card is less than, equal to,
     *          or greater than the other card
     */
    public int compareTo(BaccaratCard other) {
        int suitCompare = this.getSuit().compareTo(other.getSuit());
        if (suitCompare != 0) {
            return suitCompare < 0 ? -1 : 1;
        }
        int rankCompare = this.getRank().compareTo(other.getRank());
        if (rankCompare != 0) {
            return rankCompare < 0 ? -1 : 1;
        }
        return 0;
    }
    
    /**
     * Returns the points value of this card in the game of Baccarat.
     *
     * @return Points value of the card
     */
    public int value() {
        int rankValue = getRank().ordinal() + 1;
        return rankValue > 9 ? 0 : rankValue;
    }
}
