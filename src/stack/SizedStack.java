package stack;
import java.util.Stack;

/**
 * Class that adds size functions to Stack (for undo actions).
 */
public class SizedStack<T> extends Stack<T> {

    /**
     * Size of the Stack
     */
    private int size;

    /**
     * SizedStack constructor.
     * @param size size of the SizedStack
     */
    public SizedStack(int size) {
        super();
        this.size = size;
    }

    /**
    * Pushes to Stack, leaves just 5 moves.
    * @param object actual move
    * @return true on success, false otherwise
    */
    @Override
    public T push(T object) {
        if (this.size() >= size)
            this.remove(0);

        return super.push(object);
    }
}
