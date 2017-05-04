package ija.ija2016.project.model.cards;
import ija.ija2016.project.model.cards.Card;

public abstract class CardPackClass {
    Card pack[];
    int top;

    public CardPackClass(int size) {
        this.pack = new Card[size];
        this.top = 0;
    }

    public int size() {
        return this.top;
    }

    public boolean isEmpty() {
        return (this.top == 0);
    }

    public Card get() {
        if (this.top > 0)
            return this.pack[this.top-1];
        
        return null;
    }

    public Card pop() {
        if (this.top == 0)
            return null;
        this.top--;
        return this.pack[this.top];
    }

    public boolean put (Card card) {
        if (this.top == this.pack.length)
            return false;

        this.pack[this.top] = card;
        this.top++;
        return true; //TODO
    }
    
    public abstract CardStack get(int length);
    
    public abstract CardStack get(Card card);

    public abstract CardStack pop(int length);
    
    public abstract CardStack pop(Card card);

    public abstract boolean put(CardStack pack);

    /*public Card get(int index) {
        if (index > 0 && index < this.top)
            return this.pack[index];
        
        return null;
    }*/
}
