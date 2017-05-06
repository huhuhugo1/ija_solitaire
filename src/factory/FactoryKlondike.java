package factory;

import logic.cards.Card;
import logic.cards.CardDeck;
import logic.cards.CardStack;
import logic.cards.TargetPack;
import logic.cards.WorkingPack;

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
