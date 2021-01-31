package Lists;

import Interfaces.IItem;

public class DLLItem<T extends Comparable<T>> extends Item<T>
{
    protected DLLItem<T> prev;
    protected DLLItem<T> next;

    protected DLLItem<T> getPrev()
    {
        return prev;
    }

    protected void setPrev(DLLItem<T> prev)
    {
        this.prev = prev;
    }

    protected DLLItem<T> getNext()
    {
        return next;
    }

    protected void setNext(DLLItem<T> next)
    {
        this.next = next;
    }


    public DLLItem(T value)
    {
        super(value);
        this.next = this.prev = null;
    }

    public DLLItem(T value, DLLItem<T> parent)
    {
        super(value);
        this.prev = parent;
        this.next = null;
    }

    public DLLItem(T value, DLLItem<T> prev, DLLItem<T> next)
    {
        super(value);
        this.prev = prev;
        this.next = next;
    }


}
