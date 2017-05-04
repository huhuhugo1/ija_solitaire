package ija.ija2016.project.model;

import java.io.*;
import ija.ija2016.project.model.cards.Card;
import ija.ija2016.project.model.cards.CardDeck;
import ija.ija2016.project.model.cards.TargetPack;
import ija.ija2016.project.model.cards.WorkingPack;

public class Board implements Serializable {
   WorkingPack workingPacks[];
   TargetPack targetPacks[];

   Board() {
      this.workingPacks = new WorkingPack[7];
      for (int i = 0; i < 7; i++)
         this.workingPacks[i] = new WorkingPack(13 + i);

      this.targetPacks = new TargetPack[4];
      for (int i = 0; i < 4; i++)
         this.targetPacks[i] = new TargetPack(13, Card.Color.values()[i]);

      CardDeck deck4 = CardDeck.create4StandardDeck();
      deck4.shuffle();

      //System.arrayCopy()
   }
}
