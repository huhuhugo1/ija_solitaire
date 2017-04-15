package classes;
import interfaces.Card;
import interfaces.CardStack;; 

public class WorkingCardStackClass extends CardStackClass
{
	Card.Color color;

	public WorkingCardStackClass(int size) {
		super(size);
        top = 0;
    }

	public boolean put(Card card) {
        if (top == stack.length)
            return false;

        if (top == 0) {
            if (card.value() != 13)
                return false;
        } else {
            if ((stack[top-1].value() - 1) != card.value())
                return false;
        
            if (card.similarColorTo(stack[top-1].color()))
                return false;
        }

		stack[top] = card;
        top++;

		return true;
	}

    public boolean put(CardStack stack) {
        
        if (top + stack.size() >= this.stack.length)
            return false;

        Card card = ((CardStackClass) stack).stack[0];

        if (top == 0) {
            if (card.value() != 13)
                return false;
        } else {
            if ((this.stack[top-1].value() - 1) != card.value())
                return false;
        
            if (card.similarColorTo(this.stack[top-1].color()))
                return false;
        }
        
        System.arraycopy(((CardStackClass)stack).stack, 0, this.stack, top, stack.size());
        top += stack.size();
        return true;     
    }
}
