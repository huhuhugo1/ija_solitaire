package classes;
import interfaces.Card;
import interfaces.CardDeck;

public class TargetCardDeckClass extends CardDeckClass {
    Card.Color color;
    
    public TargetCardDeckClass(int size, Card.Color color) {
        super(size);    //vola konstruktor predka
        this.color = color; 
    }

    @Override
    public boolean put (Card card) {
        if (top == deck.length)
            return false;
        
        if (top == 0) {
            if (card.value() != 1)
                return false;
        } else {
            if ((deck[top-1].value() + 1) != card.value())
                return false;
        }

        if (card.color() != color)
            return false;

        deck[top] = card;
        top++;
        
        return true;
    }
}
