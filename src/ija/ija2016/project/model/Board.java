package ija.ija2016.project.model;

import ija.ija2016.project.model.cards.TargetCardDeckClass;
import ija.ija2016.project.model.cards.WorkingCardStackClass;

public class Board {
    WorkingCardStackClass work[];
    TargetCardDeckClass target[];

    Board() {
        this.work = new WorkingCardStackClass[7];
        this.target = new TargetCardDeckClass[4];
    }
}
