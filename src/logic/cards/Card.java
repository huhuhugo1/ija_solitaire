package logic.cards;
import java.io.*;

public class Card implements Serializable {
   
   private Card.Color color;
   private int value;
   private boolean faceUp;

   public static enum Color {
      CLUBS,
      DIAMONDS,
      HEARTS,
      SPADES;

      @Override
      public String toString() {
         switch (this) {
            case CLUBS: return "C";
            case DIAMONDS: return "D";
            case HEARTS: return "H";
            default: return "S";
         }
      }
   }
   
   public Card(Card.Color c, int value) {
      this.color = c;
      this.value = value;
      this.faceUp = false;
   }

   public String toString() {
      String v;
      switch (value) {
         case 1: v = "A"; break;
         case 11: v = "J"; break;
         case 12: v = "Q"; break;
         case 13: v = "K"; break;
         default: v = String.valueOf(value); break;
      }

      return v + "(" + color + ")";
   }

   public boolean equals(Object other){
      if (other == null) 
         return false;
      if (other == this) 
         return true;
      if (!(other instanceof Card))
         return false;
      Card cl_other = (Card)other;
      if (this.color == cl_other.color && this.value == cl_other.value) 
         return true;
      return false;
   }

   public int hashCode() {
      return value*10 + color.ordinal();
   }

   /*** Interface implementation ***/
   public int value() {
      return value;
   }

   public Card.Color color() {
      return color;
   }

   public boolean isTurnedFaceUp(){
      return faceUp;
   }

   public boolean turnFaceUp() {
      if (faceUp == false) {
         faceUp = true;
         return true;
      } else
         return false;
   }

   public boolean turnFaceDown() {
      if (faceUp == true) {
         faceUp = false;
         return true;
      } else
         return false;
   }

   public boolean similarColorTo(Card c) {
      if (c.color() == Card.Color.DIAMONDS || c.color() == Card.Color.HEARTS)
         if (color == Card.Color.DIAMONDS || color == Card.Color.HEARTS)
            return true;
         else 
            return false;
      else
         if (color == Card.Color.DIAMONDS || color == Card.Color.HEARTS)
            return false;
         else 
            return true;
}

   public boolean similarColorTo(Card.Color c) {
      if (c == Card.Color.DIAMONDS || c == Card.Color.HEARTS)
         if (color == Card.Color.DIAMONDS || color == Card.Color.HEARTS)
            return true;
         else 
            return false;
      else
         if (color == Card.Color.DIAMONDS || color == Card.Color.HEARTS)
            return false;
         else 
            return true;   
   }
   
   public int compareValue(Card c) {
      return value - c.value();
   }
}
