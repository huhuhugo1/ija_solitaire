package stack;
import java.util.Stack;

public class SizedStack<T> extends Stack<T> {
    private int size;

    public SizedStack(int size) {
        super();
        this.size = size;
    }

    @Override
    public T push(T object) {
        if (this.size() >= size)
            this.remove(0);

        return super.push(object);
    }
}
