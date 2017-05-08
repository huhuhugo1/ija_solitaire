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
import java.util.*;

/**
 * This class specifies CardStack - main class for others classes.
 */
public class CardStack implements Serializable {
   public Card pack[];
   int top;
   /**
    * CardStack constructor.
    * @param size size of the Stack
    */
   public CardStack(int size) {
      this.pack = new Card[size];
      this.top = 0;
   }

   public void afterChange() {}

   /**
    * Gets size of Stack.
    * @return size of Stack
    */
   public int size() {
      return this.top;
   }

   /**
    * Checks if Stack is empty.
    * @return true if is empty, false otherwise
    */
   public boolean isEmpty() {
      return (this.top == 0);
   }

   /**
    * Gets the first card from Stack
    * @return Card from top
    */
   public Card get() { return peek(); }

   /**
    * Peeks the first card from Stack
    * @return Card from top, null if empty
    */
   public Card peek() {
      if (this.top > 0)
         return this.pack[this.top-1];
      
      return null;
   }

   /**
    * Gets several Cards from Stack
    * @param length number of cards from top
    * @return Number of Cards from top
    */
   public CardStack get(int length) { return peek(length); }

   /**
    * Peeks several Cards from Stack
    * @param length number of cards
    * @return stack of Cards from top
    */
   public CardStack peek(int length) {
      if (length < 0)
         return new CardStack(0);

      CardStack ret_pack = new CardStack(length);
      ret_pack.top = length;
      System.arraycopy(pack, top - length, ret_pack.pack, 0, length);
      return ret_pack;
   }

   /**
    * Get defined cards from Stack
    * @param card card where the stack begins
    * @return Stack from Card
    */
   public CardStack get(Card card) { return peek(card); }

   /**
   * Peek defined cards from Stack
   * @param card card where the stack begins
   * @return stack from Card
   */
   public CardStack peek(Card card) {
      int index = java.util.Arrays.asList(pack).indexOf(card);
      return peek(top - index);
   }

   /**
    * Pop Card from Stack
    * @return Card from top
    */
   public Card pop() {
      Card card = this.peek();
      if (card != null) {
         this.top--;
         afterChange();
      }
      return card;
   }

   /**
    * Pop several Cards from Stack
    * @param length number of cards
    * @return Stack of Cards from top
    */
   public CardStack pop(int length) {
      CardStack x = this.peek(length);
      top -= length;
      afterChange();
      return x;
   }

   /**
    * Pop several Cards from Stack
    * @param card specified Card
    * @return Stack of Cards from specified Card
    */
   public CardStack pop(Card card) {
      int index = java.util.Arrays.asList(pack).indexOf(card);
      CardStack x = this.peek(top - index);
      top = index;
      afterChange();
      return x;
   }

   /**
    * Put Card to Stack
    * @param card specified Card
    * @return true on success, false otherwise
    */
   public boolean put(Card card) {
      boolean x = this.insert(card);
      afterChange();
      return x;
   }

   /**
    * Put Card to Stack
    * @param pack specified Pack
    * @return true on success, false otherwise
    */
   public boolean put(CardStack pack) {
      boolean x = this.insert(pack);
      afterChange();
      return x;
   }

   /**
    * Inset Card to Stack
    * @param card specified Card
    * @return true on success, false otherwise
    */
   public boolean insert (Card card) {
      if (top == pack.length)
         return false;

      pack[top] = card;
      top++;
      return true;
   }

   /**
    * Put Card to Stack
    * @param pack specified Stack
    * @return true on success, false otherwise
    */
   public boolean insert(CardStack pack) {
      System.arraycopy(((CardStack)pack).pack, 0, this.pack, top, pack.size());
      top += pack.size();
      return true;    
   }

   /**
    * Shuffle the Stack
    */
   public void shuffle() {
      List<Card> list = Arrays.asList(pack);
      Collections.shuffle(list);
      list.toArray(pack);
   }
}
