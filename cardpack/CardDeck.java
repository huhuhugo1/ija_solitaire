package ija.ija2016.homework1.cardpack;

public class CardDeck {

    Card deck[];
    int top;

    public CardDeck(int size) {
        this.deck = new Card[size];
        this.top = 0;
    }

    public static CardDeck createStandardDeck() {
        CardDeck deck = new CardDeck(13*4); 
        for (Card.Color color : Card.Color.values()) {
            for (int val = 1; val <= 13; val++) {
                deck.put(new Card(color, val));
            }
        }
        return deck;
    }

    public int size() {
        return this.top;
    }

    public void put (Card card) {
        this.deck[top] = card;
        this.top++;
    }

    public Card pop () {
        if (top == 0)
            return null;
        top--;
        return this.deck[top];
    }
}
