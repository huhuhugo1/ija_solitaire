package logic.cards;
import java.io.*;

/**
 * This class represents one specific Card, giving it value and color, sets if it's FacedUp or FacedDown.
 */
public class Card implements Serializable {

   /**
   *  Colors that can be used in Card.
   */
   private Card.Color color;
    /**
     *  Value in range from 1 to 13.
     */
   private int value;
    /**
     *  Boolean if the Card is facedUp or facedDown.
     */
   private boolean faceUp;

   /**
    *  Colors that can be used in Card.
    */
   public static enum Color {
      /**
       * Black color
       */
      CLUBS,
      /**
       * Red color
       */
      DIAMONDS,
      /**
       * Red color
       */
      HEARTS,
      /**
       * Black color
       */
      SPADES;


      /**
      * Generates string of Color in Card.
      * @return Color as string
      */
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

   /**
    * Card constructor. Natively face down.
    * @param c    the text of the tool tip
    * @param value value in range from 1 to 13
    */
   public Card(Card.Color c, int value) {
      this.color = c;
      this.value = value;
      this.faceUp = false;
   }

   /**
    * Generates string describing a Card.
    * @return Card as string
    */
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

   /**
    * Compares two Cards according to their value and color.
    * @param other comparable object
    * @return true if equals, false otherwise
    */
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

   /**
    * Generates hash code of Card.
    * @return hash code
    */
   public int hashCode() {
      return value*10 + color.ordinal();
   }

   /*** Interface implementation ***/

   /**
    * Gets value of Card.
    * @return Card value
    */
   public int value() {
      return value;
   }

   /**
    * Gets color of Card.
    * @return Card color
    */
   public Card.Color color() {
      return color;
   }

   /**
    * Recognizes if Card is faced up.
    * @return true if yes, false otherwise
    */
   public boolean isTurnedFaceUp(){
      return faceUp;
   }

   /**
    * Turns a Card face up.
    * @return true if a card was faced down, false otherwise
    */
   public boolean turnFaceUp() {
      if (faceUp == false) {
         faceUp = true;
         return true;
      } else
         return false;
   }

   /**
    * Turns a Card face down.
    * @return true if a card was faced up, false otherwise
    */
   public boolean turnFaceDown() {
      if (faceUp == true) {
         faceUp = false;
         return true;
      } else
         return false;
   }

   /**
    * Compares color of card with another Card
    * @param c given Card to compare
    * @return true if the booth Cards are red or black, false otherwise
    */
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
   /**
    * Compares color of card with another color
    * @param c given color to compare
    * @return true if the booth color are red or black, false otherwise
    */
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

   /**
    * Compares Card with another Card according to their value
    * @param c given Card to compare
    * @return number as a difference between two Card values
    */
   public int compareValue(Card c) {
      return value - c.value();
   }
}
