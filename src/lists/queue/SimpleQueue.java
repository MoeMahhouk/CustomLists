package lists.queue;

import errors.QueueIsEmptyException;
import interfaces.IQueue;

public class SimpleQueue<T extends Comparable<T>> implements IQueue<T> {


    private QueueItem<T> queueList;


    public SimpleQueue() {
        this.queueList = null;
    }
    public SimpleQueue(QueueItem<T> queueList) {
        this.queueList = queueList;
    }

    public QueueItem<T> getQueueList() {
        return queueList;
    }
    @Override
    public void enqueue(T item) {
        if (queueList == null) {
            queueList = new QueueItem<>(item);
        } else {
            append(item);
        }
    }

    private void append(T item) {
        QueueItem<T> tmp = queueList;
        while (tmp.next != null) {
            tmp = tmp.next;
        }
        tmp.next = new QueueItem<>(item);
    }

    @Override
    public T dequeue() throws QueueIsEmptyException {
        if (queueList == null) {
            throw new QueueIsEmptyException("The Queue is Empty!\n");
        } else {
            T item = queueList.getValue();
            queueList = queueList.next;
            return item;
        }
    }

    @Override
    public T peek() throws QueueIsEmptyException{
        if (queueList == null) {
            throw new QueueIsEmptyException("The Queue is Empty!\n");
        } else {
            return queueList.getValue();
        }
    }
}
