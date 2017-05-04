package ija.ija2016.project.model.cards;

import ija.*;
import java.io.*;
import java.util.*;

public class CardDeck extends CardPack implements Serializable {
    public CardDeck(int size) {
        super(size);
    }

    /*** Interface implementation ***/
    public CardStack get(int length) {
        return null;
    }

    public CardStack get(Card card) {
        return null;
    }

    public CardStack pop(int length) {
        return null;
    }

    public CardStack pop(Card card) {
        return null;
    }
    
    public boolean put(CardStack pack) {
        return false;     
    }

    public static CardDeck createStandardDeck() {
        CardDeck pack = new CardDeck(13*4); 
        for (Card.Color color : Card.Color.values()) {
            for (int val = 1; val <= 13; val++) {
                pack.put(new Card(color, val));
            }
        }
        return pack;
    }

    public static CardDeck create4StandardDeck() {
        CardDeck pack = new CardDeck(13*4*4);
        for (int i = 0; i < 4; i++) {
            for (Card.Color color : Card.Color.values()) {
                for (int val = 1; val <= 13; val++) {
                    pack.put(new Card(color, val));
                }
            }
        }
        return pack;
    }

    public void shuffle() {
        List<Card> list = Arrays.asList(super.pack);
        Collections.shuffle(list);
        list.toArray(super.pack);
    }
}
