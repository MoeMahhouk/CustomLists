package items;

import interfaces.IItem;

public class Item<T extends Comparable<T>> implements IItem<T>
{
    protected T value;

    public T getValue()
    {
        return value;
    }

    public void setValue(T value)
    {
        this.value = value;
    }

    public Item(T value)
    {
        this.value = value;
    }

    @Override
    public int compareTo(IItem<T> o)
    {
        return this.value.compareTo(o.getValue());
    }
}
