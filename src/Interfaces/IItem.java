package Interfaces;

public interface IItem<T extends Comparable<T>> extends Comparable<IItem<T>>
{

    T getValue();

    void setValue(T value);

}
