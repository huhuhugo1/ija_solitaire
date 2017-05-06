package logic.cards;
import java.io.*;

public class CardDeck extends CardStack implements Serializable {
   public CardDeck(int size) {
      super(size);
   }

   /*** Interface implementation ***/
   public CardStack get(int length) {
      return null;
   }

   public CardStack get(Card card) {
      return null;
   }
   
   public boolean put(CardStack pack) {
      return false;    
   }

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
