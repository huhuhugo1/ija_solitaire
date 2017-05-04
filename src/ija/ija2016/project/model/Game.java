package ija.ija2016.project.model;

import java.io.*;
import java.util.*;
import ija.ija2016.project.model.cards.Card;
import ija.ija2016.project.model.cards.CardStack;

import ija.ija2016.project.model.cards.CardPack;

import ija.ija2016.project.model.cards.TargetPack;
import ija.ija2016.project.model.cards.WorkingPack;

public class Game implements Serializable {
   Board board;
   Stack history; 

   Game() {
      board = new Board();
      history = new Stack();
   }

   public void backup() {
      //history.push(this.)
   }

   public boolean save() {
      return true;
   }

   public boolean load() {
      return true;
   }

   public boolean undo() {
      return true;      
   }

   public boolean hint() {
      return true;
   }

   public boolean move(CardPack source, CardPack target) {
      return move(source, target, 1);
   }

   public boolean move(CardPack source, CardPack target, int number) {
      Card card;
      CardStack cardstack;

      if (number == 1) {
         if ((card = source.get()) != null) {
            if (target.put(card)){
               source.pop();
               return true;
            }
         }
               
      } else {
         if ((cardstack = source.get(number)) != null) {
            if (target.put(cardstack)) {
               source.pop(number);
               return true;
            }
         }
      }
      
      return false;
   }

   public boolean nextCard() {
      return true;
   }
   
}
