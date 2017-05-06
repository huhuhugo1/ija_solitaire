package logic.cards;
import java.io.*;

public class WorkingPack extends CardStack implements Serializable {
   public WorkingPack(int size) {
      super(size);
      top = 0;
   }

   public void afterChange() {
      Card card = peak();
      if (card != null)
         card.turnFaceUp();
   }

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
