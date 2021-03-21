package lists.queue;

public class QueueItem<T> {
    protected T item;
    protected QueueItem<T> next;
    public QueueItem() {
    }
    public QueueItem(T item) {
        this.item = item;
        this.next = null;
    }
}
