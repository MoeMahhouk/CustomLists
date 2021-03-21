package interfaces;

import errors.QueueIsEmptyException;

public interface IQueue<T> {
    void enqueue(T item);
    T dequeue() throws QueueIsEmptyException;
    T peek() throws QueueIsEmptyException;
}
