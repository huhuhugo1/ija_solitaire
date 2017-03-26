package ija.ija2016.homework1.cardpack;
import ija.ija2016.homework2.model.cards.Card;
import ija.ija2016.homework2.model.cards.CardStack;; 

public class WorkingCardStackClass extends CardStackClass {
	Card.Color color;
    int expected_value;

	public WorkingCardStackClass(int size) {
		super(size);
        expected_value = 13;
    }

	@Override
    public boolean put (Card card) {
        if (top == stack.length)
            return false;

        if (card.value() != expected_value) 
            return false;
        
        if (!card.similarColorTo(super.stack[top-1].color()))
            return false;

		stack[top] = card;
        top++;
        expected_value--;

		return true;
	}
}
