package logic;

import java.io.*;
import stack.SizedStack;
import logic.cards.Card;
import logic.cards.CardStack;

/**
*
* This class implements Game functionality.
*
*/
public class Game implements Serializable {
   /**
   * Puts the Card to WorkingPack
   */
   public Board board;
   SizedStack<Board> history;

   /**
   * Constructor of class Game -
   * creates new game and prepares history for undo commands
   */
   public Game() {
      board = new Board();
      history = new SizedStack(5);
   }

   /**
   * Gets actual Score from game.
   * @return actual score
   */
   public int getScore() {
      return board.Score;
   }

   /**
   * Counts that all cards are in right TargetPacks.
   * @return true if won
   */
   public boolean win() {
      return (board.targetPacks[0].size() + board.targetPacks[1].size() + board.targetPacks[2].size() + board.targetPacks[3].size() == 52);
   }

   /**
   * Undo action goes one step back.
   * @return true on success, false otherwise
   */
   public boolean undo() {
      if (history.size() > 0) {
         board = history.pop();
         return true;
      }
      return false;
   }

   /**
   * Saves current game.
   * @param file specified file
   * @return true on success, false otherwise
   */
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

   /**
   * Loads concrete game.
   * @param file specified file
   * @return true on success, false otherwise
   */
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

   /**
   * Gets hint for current game.
   * @return help message in string
   */
   public String hint() {
      for (int i = 0; i < 7; i++) { //vsetky working packy
         CardStack stack = board.workingPacks[i];

         //WP -> TP
         for (int k = 0; k < 4; k++) {
            Card card = stack.get();
            if (card != null && board.targetPacks[k].put(card)) {
               board.targetPacks[k].pop();
               return "From: WorkingPack " + (i + 1) + " card " + card + " to TargetPack " + (k + 1);
            }
         }

         //WP -> WP
         for (int j = 0; j < stack.size(); j++) {
            Card card = board.workingPacks[i].pack[j];
            if (card.isTurnedFaceUp()) {
               CardStack sub_stack = stack.get(stack.size() - j);
               for (int k = 0; k < 7; k++) {
                  if (board.workingPacks[k].put(sub_stack)) {
                     board.workingPacks[k].pop(stack.size() - j);
                     return "From: WorkingPack " + (i + 1) + " card " + card + " to WorkingPack " + (k + 1);
                  }
               }
            }
         }

      }

      //PDP -> TP
      for (int k = 0; k < 4; k++) {
         Card card = board.putDownPack.get();
         if (card != null && board.targetPacks[k].put(card)) {
            board.targetPacks[k].pop();
            return "From: PutDownPack " + "card " + card + " to TargetPack " + (k + 1);
         }
      }

      //PDP -> WP
      for (int k = 0; k < 7; k++) {
         Card card = board.putDownPack.get();
         if (card != null && board.workingPacks[k].put(card)) {
            board.workingPacks[k].pop();
            return "From: PutDownPack " + "card " + card + " to WorkingPack " + (k + 1);
         }
      }

      if (board.sourcePack.size() > 0)
         return "Click on SourcePack for next card";

      //TP -> WP
      for (int j = 0; j < 4; j++) {
         Card card = board.targetPacks[j].get();
         for (int k = 0; k < 7; k++) {
            if (card != null && board.workingPacks[k].put(card)) {
               board.workingPacks[k].pop();
               return "From: TargetPack " + (j + 1) + " card " + card + " to WorkingPack " + (k + 1);
            }
         }
      }
                
      return "No hint was found";
   }

   /**
   * Saves one step behind and goes to another step, increments score and faces up cards
   * @return true on success, false otherwise
   */
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

   /**
   * Move one card from specified Pack to another Pack
   * @param source specified first Pack
   * @param target specified second Pack
   * @return true on success, false otherwise
   */
   public boolean move(CardStack source, CardStack target) {
      return move(source, target, 1);
   }

   /**
   * Move number card from specified Pack to another Pack
   * @param source specified first Pack
   * @param target specified second Pack
   * @param  number number of card from Pack 1 (numbered from top)
   * @return true on success, false otherwise
   */
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
