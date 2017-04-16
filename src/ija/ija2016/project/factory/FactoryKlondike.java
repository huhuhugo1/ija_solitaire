package ija.ija2016.project.factory;

import ija.ija2016.project.factory.AbstractFactorySolitaire;

import ija.ija2016.project.model.cards.Card;
import ija.ija2016.project.model.cards.CardDeck;
import ija.ija2016.project.model.cards.CardStack;

import ija.ija2016.project.model.cards.CardClass;
import ija.ija2016.project.model.cards.CardDeckClass;
import ija.ija2016.project.model.cards.CardStackClass;
import ija.ija2016.project.model.cards.TargetCardDeckClass;
import ija.ija2016.project.model.cards.WorkingCardStackClass;

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
