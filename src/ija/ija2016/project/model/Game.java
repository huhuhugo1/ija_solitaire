package ija.ija2016.project.model;

import ija.ija2016.project.model.cards.Card;
import ija.ija2016.project.model.cards.CardStack;

import ija.ija2016.project.model.cards.CardClass;
import ija.ija2016.project.model.cards.CardPackClass;
import ija.ija2016.project.model.cards.CardDeckClass;
import ija.ija2016.project.model.cards.CardStackClass;
import ija.ija2016.project.model.cards.TargetCardDeckClass;
import ija.ija2016.project.model.cards.WorkingCardStackClass;

import java.util.*;

public class Game {
    Board board;
    Stack history; 

    Game() {
        board = new Board();
        history = new Stack();
    }

    public void backup() {
        //history.push(this.)
    }

    public boolean save() {
        return true;
    }

    public boolean load() {
        return true;
    }

    public boolean undo() {
        return true;        
    }

    public boolean hint() {
        return true;
    }

    public boolean move(CardPackClass source, CardPackClass target) {
        return move(source, target, 1);
    }

    public boolean move(CardPackClass source, CardPackClass target, int number) {
        Card card;
        CardStack cardstack;

        if (number == 1) {
            if ((card = source.get()) != null) {
                if (target.put(card)){
                    source.pop();
                    return true;
                }
            }
                    
        } else {
            if ((cardstack = source.get(number)) != null) {
                if (target.put(cardstack)) {
                    source.pop(number);
                    return true;
                }
            }
        }
        
        return false;
    }

    public boolean nextCard() {
        return true;
    }
    
}
