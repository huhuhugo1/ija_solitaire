package classes;
import interfaces.Card;
import interfaces.CardDeck;

public class CardDeckClass implements CardDeck {

    Card deck[];
    int top;

    public CardDeckClass(int size) {
        this.deck = new CardClass[size];
        this.top = 0;
    }

    public static CardDeckClass createStandardDeck() {
        CardDeckClass deck = new CardDeckClass(13*4); 
        for (CardClass.Color color : CardClass.Color.values()) {
            for (int val = 1; val <= 13; val++) {
                deck.put(new CardClass(color, val));
            }
        }
        return deck;
    }

/*** Interface implementation ***/
    public int size() {
        return this.top;
    }

    public boolean put (Card card) {
        if (top == deck.length)
            return false;

        this.deck[top] = card;
        this.top++;
        return true; //TODO
    }

    public Card pop () {
        if (top == 0)
            return null;
        top--;
        return this.deck[top];
    }

    public Card get() {
        if (top > 0) {
            return deck[top-1];
        }
        else
            return null;
    }

    public Card get(int index) {
        if (index > 0 && index < top) {
            return deck[index];
        }
        else
            return null;
    }

    public boolean isEmpty() {
        if (top > 0)
            return false;
        else 
            return true;        
    }
}
