package ija.ija2016.project.model.cards;

import java.io.*;
import ija.ija2016.project.model.cards.Card;
import ija.ija2016.project.model.cards.CardDeck;

public class TargetPack extends CardDeck implements Serializable {
   Card.Color color;
   
   public TargetPack(int size, Card.Color color) {
      super(size);   //vola konstruktor predka
      this.color = color; 
   }

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
