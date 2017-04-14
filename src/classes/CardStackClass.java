package src.classes;
import src.interfaces.Card;
import src.interfaces.CardStack;

public class CardStackClass implements CardStack {

    Card stack[];
    int top;

    public CardStackClass(int size) {
        this.stack = new Card[size];
        this.top = 0;
    }

    public boolean isEmpty() {
        return (top == 0);
    }

    public int size() {
        return top;
    }

    public boolean equals(Object other){
        if (other == null) 
            return false;
        if (other == this) 
            return true;
        if (!(other instanceof CardStackClass))
            return false;
        CardStackClass cl_other = (CardStackClass) other;
        if (this.top != cl_other.top)
            return false;
        for (int i = 0; i < top; i++)
            if (!this.stack[i].equals(cl_other.stack[i]))
                return false;
        return true;
    }

    public int hashCode() {
        int hash = 0;
        for (int i = 0; i < top; i++)
            hash += stack[i].hashCode()*Math.pow(1000,i);
        return hash;
    }

    /*** Interface implementation ***/
    public boolean put(CardStack stack) {
        System.arraycopy(((CardStackClass)stack).stack, 0, this.stack, top, stack.size());
        top += stack.size();
        return true;     
    }

    public boolean put(Card card) {
        stack[top] = card;
        top++;
        return true;
    }

    public CardStack pop (Card card) {
        int index;
        if ((index = java.util.Arrays.asList(stack).indexOf(card)) >= 0) {
            int length = top - index;
            top = index;

            CardStackClass ret_stack = new CardStackClass(length);
            ret_stack.top = length;
            System.arraycopy(stack, index, ret_stack.stack, 0, length);
            return ret_stack;
        } else     
            return new CardStackClass(0);
    }

    public Card pop() {
        if (top == 0)
            return null;
        top--;
        return stack[top];
    }
}

