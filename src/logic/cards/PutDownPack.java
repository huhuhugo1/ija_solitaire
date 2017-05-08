package logic.cards;
import java.io.*;

/**
 * This class represents PutDownPack - in game set next to SourcePack.
 */
public class PutDownPack extends CardDeck implements Serializable {

    /**
     * Constructor of PutDownPack
     * @param size length of the PutDownPack
     */
   public PutDownPack(int size) {
      super(size);    //vola konstruktor predka
   }

    /**
     * Puts a card in PutDownPack
     * @param card any card
     * @return false
     */
    public boolean put(Card card) {
      return false;
   }
}
