package logic.cards;
import java.io.*;
import java.util.*;

public class CardStack implements Serializable {
   Card pack[];
   int top;

   public CardStack(int size) {
      this.pack = new Card[size];
      this.top = 0;
   }

   public void afterChange() {}

   public int size() {
      return this.top;
   }

   public boolean isEmpty() {
      return (this.top == 0);
   }

   public Card get() { return peak(); }
   public Card peak() {
      if (this.top > 0)
         return this.pack[this.top-1];
      
      return null;
   }

   public CardStack get(int length) { return peak(length); }
   public CardStack peak(int length) {
      if (length < 0)
         return new CardStack(0);

      CardStack ret_pack = new CardStack(length);
      ret_pack.top = length;
      System.arraycopy(pack, top - length, ret_pack.pack, 0, length);
      return ret_pack;
   }

   public CardStack get(Card card) { return peak(card); }
   public CardStack peak(Card card) {
      int index = java.util.Arrays.asList(pack).indexOf(card);
      return peak(top - index);
   }

   public Card pop() {
      Card card = this.peak();
      if (card != null) {
         this.top--;
         afterChange();
      }
      return card;
   }

   public CardStack pop(int length) {
      CardStack x = this.peak(length);
      top -= length;
      afterChange();
      return x;
   }

   public CardStack pop(Card card) {
      int index = java.util.Arrays.asList(pack).indexOf(card);
      CardStack x = this.peak(top - index);
      top = index;
      afterChange();
      return x;
   }

   public boolean put(Card card) {
      boolean x = this.insert(card);
      afterChange();
      return x;
   }

   public boolean put(CardStack pack) {
      boolean x = this.insert(pack);
      afterChange();
      return x;
   }

   public boolean insert (Card card) {
      if (top == pack.length)
         return false;

      pack[top] = card;
      top++;
      return true;
   }

   public boolean insert(CardStack pack) {
      System.arraycopy(((CardStack)pack).pack, 0, this.pack, top, pack.size());
      top += pack.size();
      return true;    
   }

   public static CardStack create4StandardStack() {
      CardStack pack = new CardStack(13*4*4);
      for (int i = 0; i < 4; i++) {
         for (Card.Color color : Card.Color.values()) {
            for (int val = 1; val <= 13; val++) {
               pack.put(new Card(color, val));
            }
         }
      }
      return pack;
   }

   public void shuffle() {
      List<Card> list = Arrays.asList(pack);
      Collections.shuffle(list);
      list.toArray(pack);
   }
}
