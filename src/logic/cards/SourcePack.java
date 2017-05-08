/**
 * Project to Java Programming Language - 2016/2017
 * ------------------------------------------------
 * Project: Solitaire game
 * Date: May 2017
 *
 * @author  Juraj Kubis
 * @author  Jan Kubica
 */

package logic.cards;
import java.io.*;

/**
 * This class represents SourcePack - in game set in the top left corner.
 */
public class SourcePack extends PutDownPack implements Serializable {
    /**
     * Constructor of SourcePack
     * @param size length of the SourcePack
     */
    public SourcePack(int size) {
      super(size);    //vola konstruktor predka
   }

    /**
     * Gets a Card from SourcePack
     * @return null
     */
    public Card get() {
      return null;
   }
}
