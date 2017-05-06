package logic.cards;
import java.io.*;

public class PutDownPack extends CardDeck implements Serializable {
    
   public PutDownPack(int size) {
      super(size);    //vola konstruktor predka
   }

   public boolean put(Card card) {
      return false;
   }
}
