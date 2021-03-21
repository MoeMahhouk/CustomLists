package interfaces;

import errors.StackIsEmptyException;

public interface IStack<T> {
    void push(T item);
    T pop() throws StackIsEmptyException;
    T peek() throws StackIsEmptyException;
}
