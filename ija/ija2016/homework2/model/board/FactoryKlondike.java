package ija.ija2016.homework2.model.board;

import ija.ija2016.homework2.model.board.AbstractFactorySolitaire;

import ija.ija2016.homework2.model.cards.Card;
import ija.ija2016.homework2.model.cards.CardDeck;
import ija.ija2016.homework2.model.cards.CardStack;

import ija.ija2016.homework1.cardpack.CardClass;
import ija.ija2016.homework1.cardpack.CardDeckClass;
import ija.ija2016.homework1.cardpack.CardStackClass;

public class FactoryKlondike extends AbstractFactorySolitaire {
    public CardDeck createCardDeck() {
        return CardDeckClass.createStandardDeck();
    }

    public Card createCard(Card.Color color, int value) {
        return new CardClass(color, value);
    }

    public CardDeck createTargetPack(Card.Color color) {
        return new CardDeckClass(13);
    }

    public CardStack createWorkingPack() {
        return new CardStackClass(13);
    }
}
