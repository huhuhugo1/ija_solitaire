package factories;

import interfaces.Card;
import interfaces.CardDeck;
import interfaces.CardStack;

import classes.CardClass;
import classes.CardDeckClass;
import classes.CardStackClass;

public abstract class AbstractFactorySolitaire extends java.lang.Object {
    public abstract CardDeck createCardDeck();

    public abstract Card createCard(Card.Color color, int value);

    public abstract CardDeck createTargetPack(Card.Color color);

    public abstract CardStack createWorkingPack();
}
