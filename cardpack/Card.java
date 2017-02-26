package ija.ija2016.homework1.cardpack;

public class Card {
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
    
    private Color color;
    private int value;

    public Card(Card.Color c, int value) {
        this.color = c;
        this.value = value;
    }

    public Card.Color color() {
        return color;
    }

    public int value() {
        return value;
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
}
