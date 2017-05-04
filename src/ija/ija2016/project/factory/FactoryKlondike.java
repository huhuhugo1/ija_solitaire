package ija.ija2016.project.factory;

import ija.ija2016.project.factory.AbstractFactorySolitaire;

import ija.ija2016.project.model.cards.Card;
import ija.ija2016.project.model.cards.CardDeck;
import ija.ija2016.project.model.cards.CardStack;

import ija.ija2016.project.model.cards.TargetPack;
import ija.ija2016.project.model.cards.WorkingPack;

public class FactoryKlondike extends AbstractFactorySolitaire {
    public CardDeck createCardDeck() {
        return CardDeck.createStandardDeck();
    }

    public Card createCard(Card.Color color, int value) {
        if (value < 1 || value > 13)
            return null;
        return new Card(color, value);
    }

    public CardDeck createTargetPack(Card.Color color) {
        return new TargetPack(13, color);
    }

    public CardStack createWorkingPack() {
        return new WorkingPack(13);
    }
}
