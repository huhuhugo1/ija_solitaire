package ija.ija2016.homework1.cardpack;

public class CardStack {

    Card stack[];
    int top;

    public CardStack(int size) {
        this.stack = new Card[size];
        this.top = 0;
    }

    public Card pop() {
        if (top == 0)
            return null;
        top--;
        return stack[top];
    }

    public void put(Card card) {
        stack[top] = card;
        top++;
    }

    public void put(CardStack stack) { 
        System.arraycopy(stack.stack, 0, this.stack, top, stack.stack.length);
        top += stack.stack.length;        
    }

    public boolean isEmpty() {
        return (top == 0);
    }

    public int size() {
        return top;
    }

    public CardStack takeFrom(Card card) {
        int index;
        if ((index = java.util.Arrays.asList(stack).indexOf(card)) >= 0) {
            int length = top - index;
            top = index;

            CardStack ret_stack = new CardStack(length);
            ret_stack.top = length;
            System.arraycopy(stack, index, ret_stack.stack, 0, length);
            return ret_stack;
        } else     
            return new CardStack(0);
    }

    public boolean equals(Object other){
        if (other == null) 
            return false;
        if (other == this) 
            return true;
        if (!(other instanceof CardStack))
            return false;
        CardStack cl_other = (CardStack) other;
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
}
