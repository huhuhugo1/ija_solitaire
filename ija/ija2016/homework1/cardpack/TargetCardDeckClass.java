package ija.ija2016.homework1.cardpack;
import ija.ija2016.homework2.model.cards.Card;
import ija.ija2016.homework2.model.cards.CardDeck;

public class TargetCardDeckClass extends CardDeckClass {
    Card.Color color;
    int expected_value;
    
    public TargetCardDeckClass(int size, Card.Color color) {
        super(size);    //vola konstruktor predka
        this.color = color;
        expected_value = 1; 
    }

    @Override
    public boolean put (Card card) {
        if (top == deck.length)
            return false;
        
        if (card.value() != expected_value) 
            return false;

        if (card.color() != color) //vkladam inu ako pozadovanu farbu
            return false;

        deck[top] = card;
        top++;
        expected_value++;
        return true; //TODO
    }
}
