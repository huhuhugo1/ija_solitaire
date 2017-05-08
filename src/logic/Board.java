package logic;

import java.io.*;
import logic.cards.Card;
import logic.cards.CardDeck;
import logic.cards.CardStack;
import logic.cards.TargetPack;
import logic.cards.WorkingPack;
import logic.cards.SourcePack;
import logic.cards.PutDownPack;
/**
 * This class implements Game background.
 */
public class Board implements Serializable {
   /**
    * Array of WorkingPacks
    */
   public WorkingPack workingPacks[];
   /**
    * Array of TargetPacks
    */
   public TargetPack targetPacks[];
   /**
    * SourcePack
    */
   public SourcePack sourcePack;
   /**
    * PutDownPack
    */
   public PutDownPack putDownPack;
   /**
    * Score
    */
   int Score;

   /**
    * Constructor of Board. Creates all Packs -
    * WorkingPacks, TargetPacks, SourcePack, PutDownPack and Score.
    */
   public Board() {
      CardStack stack4 = CardDeck.createStandardDeck();
      stack4.shuffle();

      this.workingPacks = new WorkingPack[7];
      for (int i = 0; i < 7; i++) {
         this.workingPacks[i] = new WorkingPack(13 + i);
         this.workingPacks[i].insert(stack4.pop(i + 1));
         this.workingPacks[i].afterChange();
      }

      this.targetPacks = new TargetPack[4];
      for (int i = 0; i < 4; i++)
         this.targetPacks[i] = new TargetPack(13, Card.Color.values()[i]);

      sourcePack = new SourcePack(24);
      sourcePack.insert(stack4.pop(24));
      
      putDownPack = new PutDownPack(24);

      Score = 0;
   }
   /**
    * Creates DeepCopy of current game.
    * @return null if error occurred
    */
   public Board deepClone() {
      try {
         ByteArrayOutputStream baos = new ByteArrayOutputStream();
         ObjectOutputStream oos = new ObjectOutputStream(baos);
         oos.writeObject(this);

         ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
         ObjectInputStream ois = new ObjectInputStream(bais);
         return (Board) ois.readObject();
      } catch (IOException e) {
         System.err.println("ERR: Unable to create deep clone of Board class!");
         return null;
      } catch (ClassNotFoundException e) {
         System.err.println("ERR: Unable to create deep clone of Board class!");
         return null;
      }
   }
}
