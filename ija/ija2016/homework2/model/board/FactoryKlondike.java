package ija.ija2016.homework2.model.board;

import ija.ija2016.homework2.model.board.AbstractFactorySolitaire;

import ija.ija2016.homework2.model.cards.Card;
import ija.ija2016.homework2.model.cards.CardDeck;
import ija.ija2016.homework2.model.cards.CardStack;

import ija.ija2016.homework1.cardpack.CardClass;
import ija.ija2016.homework1.cardpack.CardDeckClass;
import ija.ija2016.homework1.cardpack.CardStackClass;

import ija.ija2016.homework1.cardpack.TargetCardDeckClass;
import ija.ija2016.homework1.cardpack.WorkingCardStackClass;

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
