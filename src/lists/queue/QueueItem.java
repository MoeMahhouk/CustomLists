package lists.queue;

import items.Item;

public class QueueItem<T extends Comparable<T>> extends Item<T> {
    protected QueueItem<T> next;

    public QueueItem(T item) {
        super(item);
        this.next = null;
    }
}
