package logic.cards;
import java.io.*;

/**
 * This class represents WorkingPack - in game set in the bottom.
 */
public class WorkingPack extends CardStack implements Serializable {

   /**
    * Constructor of WorkingPack
    * @param size length of the WorkingPack
    */
   public WorkingPack(int size) {
      super(size);
      top = 0;
   }

   /**
    * Turn the card Face Up when its on top
    */
   public void afterChange() {
      Card card = peek();
      if (card != null)
         card.turnFaceUp();
   }

   /**
    * Puts the Card to WorkingPack
    * @param card Card to pun in
    * @return true on success, false otherwise
    */
   public boolean put(Card card) {
      if (top == pack.length)
         return false;

      if (top == 0) {
         if (card.value() != 13)
            return false;
      } else {
         if ((pack[top-1].value() - 1) != card.value())
            return false;
      
         if (card.similarColorTo(pack[top-1].color()))
            return false;
      }

      return super.put(card);
   }

    /**
     * Puts the CardStack to WorkingPack
     * @param pack CardStack to pun in
     * @return true on success, false otherwise
     */
   public boolean put(CardStack pack) {
      if (top + pack.size() >= this.pack.length)
         return false;

      Card card = ((CardStack) pack).pack[0];

      if (top == 0) {
         if (card.value() != 13)
            return false;
      } else {
         if ((this.pack[top-1].value() - 1) != card.value())
            return false;
      
         if (card.similarColorTo(this.pack[top-1].color()))
            return false;
      }
      
      return super.put(pack);   
   }
}
