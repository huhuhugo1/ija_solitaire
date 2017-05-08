package logic.cards;
import java.io.*;

/**
 * This class represents TargetPack - in game set in the top right corner
 */
public class TargetPack extends CardDeck implements Serializable {
   Card.Color color;

   /**
    * Constructor of TargetPack
    * @param size length of the TargetPack
    * @param color Color of the TargetPack
    */
   public TargetPack(int size, Card.Color color) {
      super(size);   //vola konstruktor predka
      this.color = color; 
   }

   /**
    * Put on TargetPack
    * @param card Card to put on the TargetPack
    * @return true in success, false otherwise
    */
   @Override
   public boolean put(Card card) {
      if (top == pack.length)
         return false;
      
      if (top == 0) {
         if (card.value() != 1)
            return false;
      } else {
         if ((pack[top-1].value() + 1) != card.value())
            return false;
      }

      if (card.color() != color)
         return false;

      return super.put(card);
   }
}
