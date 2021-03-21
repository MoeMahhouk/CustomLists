package lists.stack;

import errors.StackIsEmptyException;
import interfaces.IStack;

public class SimpleStack<T extends Comparable<T>> implements IStack<T> {

    private StackItem<T> topStackItem;

    public SimpleStack() {
        this.topStackItem = null;
    }
    public SimpleStack(StackItem<T> topStackItem) {
        this.topStackItem = topStackItem;
    }

    public StackItem<T> getTopStackItem() {
        return topStackItem;
    }

    @Override
    public void push(T item) {
        if(topStackItem == null) {
            topStackItem = new StackItem<>(item);
        } else {
            prepend(item);
        }
    }

    private void prepend(T item) {
        topStackItem= new StackItem<>(item, topStackItem);
    }

    @Override
    public T pop() throws StackIsEmptyException {
        if(topStackItem == null) {
            throw new StackIsEmptyException("Stack is empty!\n");
        } else {
            T resultItem = topStackItem.getValue();
            topStackItem = topStackItem.below;
            return resultItem;
        }
    }

    @Override
    public T peek() throws StackIsEmptyException {
        if(topStackItem == null) {
            throw new StackIsEmptyException("Stack is empty!\n");
        } else {
            return topStackItem.getValue();
        }
    }
}
