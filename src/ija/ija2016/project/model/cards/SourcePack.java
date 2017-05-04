package ija.ija2016.project.model.cards;

import java.io.*;
import ija.ija2016.project.model.cards.Card;
import ija.ija2016.project.model.cards.CardDeck;

public class SourcePack extends CardDeck implements Serializable {
    
    public SourcePack(int size) {
        super(size);    //vola konstruktor predka
    }

}
