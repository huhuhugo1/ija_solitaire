package logic;

import java.io.*;
import stack.SizedStack;
import logic.cards.Card;
import logic.cards.CardStack;

public class Game implements Serializable {
   public Board board;
   SizedStack<Board> history;

   public Game() {
      board = new Board();
      history = new SizedStack(5);
   }

   public int getScore() {
      return board.Score;
   }

   public boolean win() {
      return (board.targetPacks[0].size() + board.targetPacks[1].size() + board.targetPacks[2].size() + board.targetPacks[3].size() == 52);
   }

   public boolean undo() {
      if (history.size() > 0) {
         board = history.pop();
         return true;
      }
      return false;
   }

   public boolean save(File file) {
      try {
         FileOutputStream fstream = new FileOutputStream(file);
         ObjectOutputStream ostream = new ObjectOutputStream(fstream);
         ostream.writeObject(board);
         ostream.close();
         fstream.close();
      } catch (Exception e) {
         return false;
      }

      return true;
   }

   public boolean load(File file) {
      try {
         FileInputStream fstream = new FileInputStream(file);
         ObjectInputStream ostream = new ObjectInputStream(fstream);
         board = (Board) ostream.readObject();
         ostream.close();
         fstream.close();
      } catch (Exception e) {
         return false;
      }

      history.clear();
      return true;
   }

   public boolean hint() {
      //TODO
      return true;
   }

   public boolean nextCard() {
      Board backup;
      try {
         backup = board.deepClone();
      } catch (Exception e) {
         return false;
      }

      Card card = board.sourcePack.pop();
      if (card != null) {
         card.turnFaceUp();
         board.putDownPack.insert(card);
      } else
         while((card = board.putDownPack.pop()) != null) {
            card.turnFaceDown();
            board.sourcePack.insert(card);
         }

      board.Score++;
      history.push(backup);
      return true;
   }

   public boolean move(CardStack source, CardStack target) {
      return move(source, target, 1);
   }

   public boolean move(CardStack source, CardStack target, int number) {
      Card card;
      CardStack cardstack;
      Board backup;

      try {
         backup = board.deepClone();
      } catch (Exception e) {
         return false;
      }

      if (number == 1) {
         if ((card = source.get()) != null) {
            if (target.put(card)){
               source.pop();
               board.Score++;
               history.push(backup);
               return true;
            }
         }
               
      } else {
         if ((cardstack = source.get(number)) != null) {
            if (target.put(cardstack)) {
               source.pop(number);
               board.Score++;
               history.push(backup);
               return true;
            }
         }
      }

      return false;
   }
}
