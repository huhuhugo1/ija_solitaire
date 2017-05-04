package ija.ija2016.project.model.cards;

import java.io.*;
import ija.ija2016.project.model.cards.Card;
import ija.ija2016.project.model.cards.CardStack;

public class CardStack extends CardPack implements Serializable {
    public CardStack(int size) {
        super(size);
    }

    /*** CardStack interface implementations ***/
    public CardStack get(int length) {
        if (length < 0)
            return new CardStack(0);

        CardStack ret_pack = new CardStack(length);
        ret_pack.top = length;
        System.arraycopy(pack, top - length, ret_pack.pack, 0, length);
        return ret_pack;
    }

    public CardStack get(Card card) {
        int index = java.util.Arrays.asList(pack).indexOf(card);
        return get(top - index);
    }

    public CardStack pop(int length) {
        CardStack x = get(length);
        top -= length;
        return x;
    }

    public CardStack pop(Card card) {
        int index = java.util.Arrays.asList(pack).indexOf(card);
        CardStack x = get(top - index);
        top = index;
        return x;
    }

    public boolean put(CardStack pack) {
        System.arraycopy(((CardStack)pack).pack, 0, this.pack, top, pack.size());
        top += pack.size();
        return true;     
    }
}
