package src.interfaces;

public interface CardStack
{   
    public boolean put(CardStack stack);

    public boolean put(Card card);

    public CardStack pop(Card card);

    public Card pop();

    public int size();
}
