package src.factories;

import src.interfaces.Card;
import src.interfaces.CardDeck;
import src.interfaces.CardStack;

import src.classes.CardClass;
import src.classes.CardDeckClass;
import src.classes.CardStackClass;

public abstract class AbstractFactorySolitaire extends java.lang.Object {
    public abstract CardDeck createCardDeck();

    public abstract Card createCard(Card.Color color, int value);

    public abstract CardDeck createTargetPack(Card.Color color);

    public abstract CardStack createWorkingPack();
}
