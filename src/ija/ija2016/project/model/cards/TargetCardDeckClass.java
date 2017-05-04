package ija.ija2016.project.model.cards;
import ija.ija2016.project.model.cards.Card;
import ija.ija2016.project.model.cards.CardDeck;

public class TargetCardDeckClass extends CardDeckClass {
    Card.Color color;
    
    public TargetCardDeckClass(int size, Card.Color color) {
        super(size);    //vola konstruktor predka
        this.color = color; 
    }

    @Override
    public boolean put (Card card) {
        if (top == pack.length)
            return false;
        
        if (top == 0) {
            if (card.value() != 1)
                return false;
        } else {
            if ((pack[top-1].value() + 1) != card.value())
                return false;
        }

        if (card.color() != color)
            return false;

        pack[top] = card;
        top++;
        
        return true;
    }
}
