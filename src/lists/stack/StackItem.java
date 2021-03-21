package lists.stack;

import items.Item;

public class StackItem<T extends Comparable<T>> extends Item<T> {
    protected StackItem<T> below;

    public StackItem(T value) {
        super(value);
        this.below = null;
    }

    public StackItem(T value, StackItem<T> below) {
        super(value);
        this.below = below;
    }
}
