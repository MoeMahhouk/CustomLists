package lists;

import enums.DeleteState;
import enums.ElementState;
import enums.InsertState;
import interfaces.IList;

public class DoubleLinkedList<T extends Comparable<T>> implements IList<T, DLLItem<T>>
{
    private DLLItem<T> head;
    private DLLItem<T> tail;

    public DoubleLinkedList()
    {
        super();
        this.head = null;
        this.tail = null;
    }

    public DoubleLinkedList(T init_value)
    {
        super();
        this.head = this.tail = new DLLItem<>(init_value, null);
    }

    public DoubleLinkedList(DLLItem<T> head)
    {
        super();
        this.head = this.tail = head;
    }

    @Override
    public InsertState addElement(T elem)
    {
        InsertState result = null;
        if (this.head == null)
        {
            this.head = this.tail = new DLLItem<>(elem, null);
            result = InsertState.SUCCESS;
        } else
        {
            DLLItem<T> tmp = head;
            while (tmp != null)
            {
                if (elem.compareTo(tmp.getValue()) == 0)
                {
                    result = InsertState.EXISTS;
                    break;
                } else if (elem.compareTo(tmp.getValue()) < 0)
                {
                    DLLItem<T> new_item = new DLLItem<>(elem, tmp.getPrev(), tmp);
                    if (tmp.getPrev() != null)
                    {
                        tmp.getPrev().setNext(new_item);
                    } else
                    {
                        this.head = new_item;
                    }
                    tmp.setPrev(new_item);
                    break;
                } else
                {
                    if (tmp.getNext() == null)
                    {
                        DLLItem<T> new_item = new DLLItem<>(elem, tmp, tmp.getNext());
                        tmp.setNext(new_item);
                        this.tail = new_item;
                    } else
                    {
                        tmp = tmp.getNext();
                    }
                }
            }
            if (result == null)
            {
                result = InsertState.SUCCESS;
            }
        }
        return result;
    }

    @Override
    public InsertState addItem(DLLItem<T> new_item)
    {
        if (new_item == null)
        {
            return InsertState.FAILED;
        }
        if (this.head == null)
        {
            this.head = this.tail = new_item;
            return InsertState.SUCCESS;
        } else
        {
            DLLItem<T> tmp = head;
            while (tmp != null)
            {
                if (new_item.compareTo(tmp) == 0)
                {
                    return InsertState.EXISTS;
                } else if (new_item.compareTo(tmp) < 0)
                {
                    new_item.setPrev(tmp.getPrev());
                    new_item.setNext(tmp);
                    if (tmp.getPrev() != null)
                    {
                        tmp.getPrev().setNext(new_item);
                    } else
                    {
                        this.head = new_item;
                    }
                    tmp.setPrev(new_item);
                    break;
                } else
                {
                    if (tmp.getNext() == null)
                    {
                        new_item.setPrev(tmp);
                        new_item.setNext(tmp.getNext());
                        tmp.setNext(new_item);
                        this.tail = new_item;
                    } else
                    {
                        tmp = tmp.getNext();
                    }
                }
            }
        }
        return InsertState.SUCCESS;
    }

    @Override
    public DLLItem<T> getItemByValue(T elem)
    {  //ToDo: create a tuple class that returns the state and potentially the item in case it was successful
        if (elem == null) return null;
        DLLItem<T> tmp_head = head;
        DLLItem<T> tmp_tail = tail;

        while (tmp_head != tmp_tail)
        {
            if (tmp_head.getValue().compareTo(elem) == 0)
            {
                return tmp_head;
            }
            if (tmp_tail.getValue().compareTo(elem) == 0)
            {
                return tmp_tail;
            }
            tmp_head = tmp_head.getNext();
            tmp_tail = tmp_tail.getPrev();
        }
        if (tmp_head.getValue().compareTo(elem) == 0) return tmp_head;
        return null;
    }

    @Override
    public DLLItem<T> getItem(DLLItem<T> item)
    { //ToDo: create a tuple class that returns the state and potentially the item in case it was successful
        if (item == null) return null;
        DLLItem<T> tmp_head = head;
        DLLItem<T> tmp_tail = tail;

        while (tmp_head != tmp_tail)
        {
            if (tmp_head.compareTo(item) == 0)
            {
                return tmp_head;
            }
            if (tmp_tail.compareTo(item) == 0)
            {
                return tmp_tail;
            }
            tmp_head = tmp_head.getNext();
            tmp_tail = tmp_tail.getPrev();
        }
        if (tmp_head.compareTo(item) == 0) return tmp_head;
        return null;
    }

    @Override
    public ElementState contains(T elem)
    {
        DLLItem<T> tmp = head;
        while (tmp != null)
        {
            if (tmp.getValue().compareTo(elem) == 0)
            {
                return ElementState.EXISTS;
            }
            tmp = tmp.getNext();
        }
        return ElementState.NOT_EXISTS;
    }

    @Override
    public DeleteState removeItem(DLLItem<T> item)
    {
        DLLItem<T> tmp = getItem(item);   //this should be something else in case the tuples class is implemented
        if (tmp == null) return DeleteState.NOT_EXIST;

        if (tmp.getPrev() != null && tmp.getNext() != null)
        {
            tmp.getPrev().setNext(tmp.getNext());
            tmp.getNext().setPrev(tmp.getPrev());
            return DeleteState.SUCCESS;
        } else if (tmp.getPrev() == null && tmp.getNext() != null)
        {
            this.head = tmp.getNext();
            tmp.getNext().setPrev(null);
            return DeleteState.SUCCESS;
        } else if (tmp.getPrev() != null && tmp.getNext() == null)
        {
            this.tail = tmp.getPrev();
            tmp.getPrev().setNext(null);
            return DeleteState.SUCCESS;
        } else
        {
            this.head = this.tail = null;
            return DeleteState.SUCCESS;
        }
    }

    @Override
    public DeleteState removeItemByValue(T elem)
    { //ToDo: here a tuple class would also be better let the method return the deleted object back instead
        DLLItem<T> tmp = getItemByValue(elem);
        return removeItem(tmp);
    }

    public String toString()
    {
        DLLItem<T> tmp = head;
        StringBuilder result;
        if (tmp == null)
        {
            result = new StringBuilder("The list is empty");
            return result.toString();
        }
        result = new StringBuilder("The list contains : \n\t\t");
        while (tmp != null)
        {
            result.append(tmp.getValue().toString());
            if (tmp.getNext() != null) result.append(", ");
            tmp = tmp.getNext();
        }
        return result.toString();
    }

}
