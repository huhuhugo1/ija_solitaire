package ija.ija2016.project.model.cards;

public interface CardStack
{   
    public boolean put(CardStack stack);

    public boolean put(Card card);

    public CardStack pop(Card card);

    public Card pop();

    public int size();
}
