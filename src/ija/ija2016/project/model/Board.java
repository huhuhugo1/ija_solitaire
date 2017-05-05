package ija.ija2016.project.model;

import java.io.*;
import ija.ija2016.project.model.cards.Card;
import ija.ija2016.project.model.cards.CardDeck;
import ija.ija2016.project.model.cards.CardStack;
import ija.ija2016.project.model.cards.TargetPack;
import ija.ija2016.project.model.cards.WorkingPack;
import ija.ija2016.project.model.cards.SourcePack;
import ija.ija2016.project.model.cards.PutDownPack;

public class Board implements Serializable {
   WorkingPack workingPacks[];
   TargetPack targetPacks[];
   SourcePack sourcePack;
   PutDownPack putDownPack;

   public Board() {
      CardStack stack4 = CardStack.create4StandardStack();
      stack4.shuffle();

      this.workingPacks = new WorkingPack[7];
      for (int i = 0; i < 7; i++) {
         this.workingPacks[i] = new WorkingPack(13 + i);
         this.workingPacks[i].put(stack4.pop(i + 1));
      }

      this.targetPacks = new TargetPack[4];
      for (int i = 0; i < 4; i++)
         this.targetPacks[i] = new TargetPack(13, Card.Color.values()[i]);

      sourcePack = new SourcePack(24);
      sourcePack.insert(stack4.pop(24));
      
      putDownPack = new PutDownPack(24);
   }
}
