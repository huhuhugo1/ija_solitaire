package src.factories;

import src.factories.AbstractFactorySolitaire;

import src.interfaces.Card;
import src.interfaces.CardDeck;
import src.interfaces.CardStack;

import src.classes.CardClass;
import src.classes.CardDeckClass;
import src.classes.CardStackClass;
import src.classes.TargetCardDeckClass;
import src.classes.WorkingCardStackClass;

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
