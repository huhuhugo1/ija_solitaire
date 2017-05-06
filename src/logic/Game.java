package logic;

import java.io.*;
import java.util.*;
import org.apache.commons.lang3.SerializationUtils;

import logic.cards.Card;
import logic.cards.CardStack;

public class Game implements Serializable {
   public Board board;
   Stack<Board> history; 

   public Game() {
      board = new Board();
      history = new Stack();
   }

   public boolean undo() {
      this.board = history.pop();
      return true;      
   }

   public boolean save(String path) {
      try {
         SerializationUtils.serialize(this, new FileOutputStream(path));
         return true;
      } catch (Exception e) {
         return false;
      }
   }

   public boolean load(String path) {
      try {
         Game game = (Game) SerializationUtils.deserialize(new FileInputStream(path));
         board = game.board;
         history = game.history;
         return true;
      } catch (Exception e) {
         return false;
      }
   }

   public boolean hint() {
      //TODO
      return true;
   }

   public boolean nextCard() {
      Card card = board.sourcePack.pop();
      if (card != null)
         board.putDownPack.insert(card);
      else
         while((card = board.putDownPack.pop()) != null) {
            card.turnFaceDown();
            board.sourcePack.insert(card);
         }
            
      return true;
   }

   public boolean move(CardStack source, CardStack target) {
      return move(source, target, 1);
   }

   public boolean move(CardStack source, CardStack target, int number) {
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
}
