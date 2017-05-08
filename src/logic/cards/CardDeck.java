package logic.cards;
import java.io.*;

/**
 * This class specifies CardDeck and its methods.
 */
public class CardDeck extends CardStack implements Serializable {
   public CardDeck(int size) {
      super(size);
   }

   /*** Interface implementation ***/

   /**
    * Gets Card from Stack.
    * @param length length of Stack
    * @return null
    */
   public CardStack get(int length) {
      return null;
   }

   /**
    * Gets Card from Stack.
    * @param card Card in Stack
    * @return null
    */
   public CardStack get(Card card) {
      return null;
   }

   /**
    * Puts Card from Stack.
    * @param pack Stack
    * @return false
    */
   public boolean put(CardStack pack) {
      return false;    
   }

   /**
    * Creates 52 Cards as StandardDeck.
    * @return Deck of sorted 52 Cards
    */
   public static CardDeck createStandardDeck() {
      CardDeck pack = new CardDeck(13*4); 
      for (Card.Color color : Card.Color.values()) {
         for (int val = 1; val <= 13; val++) {
            pack.put(new Card(color, val));
         }
      }
      return pack;
   }
}
