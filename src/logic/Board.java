package logic;

import java.io.*;
import logic.cards.Card;
import logic.cards.CardDeck;
import logic.cards.CardStack;
import logic.cards.TargetPack;
import logic.cards.WorkingPack;
import logic.cards.SourcePack;
import logic.cards.PutDownPack;

public class Board implements Serializable {
   public WorkingPack workingPacks[];
   public TargetPack targetPacks[];
   public SourcePack sourcePack;
   public PutDownPack putDownPack;

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
   }
}
