package ija.ija2016.project.model.cards;

import java.io.*;
import ija.ija2016.project.model.cards.Card;
import ija.ija2016.project.model.cards.CardDeck;

public class PutDownPack extends CardDeck implements Serializable {
    
    public PutDownPack(int size) {
        super(size);    //vola konstruktor predka
    }

}
