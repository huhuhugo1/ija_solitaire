package factories;

import factories.AbstractFactorySolitaire;

import interfaces.Card;
import interfaces.CardDeck;
import interfaces.CardStack;

import classes.CardClass;
import classes.CardDeckClass;
import classes.CardStackClass;
import classes.TargetCardDeckClass;
import classes.WorkingCardStackClass;

public class FactoryKlondike extends AbstractFactorySolitaire {
    public CardDeck createCardDeck() {
        return CardDeckClass.createStandardDeck();
    }

    public Card createCard(Card.Color color, int value) {
        if (value < 1 || value > 13)
            return null;
        return new CardClass(color, value);
    }

    public CardDeck createTargetPack(Card.Color color) {
        return new TargetCardDeckClass(13, color);
    }

    public CardStack createWorkingPack() {
        return new WorkingCardStackClass(13);
    }
}
