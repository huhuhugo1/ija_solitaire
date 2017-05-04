package ija.ija2016.project.model.cards;
import ija.ija2016.project.model.cards.Card;
import ija.ija2016.project.model.cards.CardDeck;

public class CardDeckClass extends CardPackClass implements CardDeck {
    public CardDeckClass(int size) {
        super(size);
    }

    /*** Interface implementation ***/
    public CardStack get(int length) {
        return null;
    }

    public CardStack get(Card card) {
        return null;
    }

    public CardStack pop(int length) {
        return null;
    }

    public CardStack pop(Card card) {
        return null;
    }
    
    public boolean put(CardStack pack) {
        return false;     
    }

    public static CardDeckClass createStandardDeck() {
        CardDeckClass pack = new CardDeckClass(13*4); 
        for (CardClass.Color color : CardClass.Color.values()) {
            for (int val = 1; val <= 13; val++) {
                pack.put(new CardClass(color, val));
            }
        }
        return pack;
    }
}
