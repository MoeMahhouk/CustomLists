package Lists;

import Enums.DeleteState;
import Enums.ElementState;
import Enums.InsertState;
import Interfaces.IList;

public class DoubleLinkedList<T extends Comparable<T>> implements IList<T, DLLItem<T>> {
    private DLLItem<T> head;
    private DLLItem<T> tail;

    public DoubleLinkedList() {
        super();
        this.head = null;
        this.tail = null;
    }

    public DoubleLinkedList(T init_value) {
        super();
        this.head = this.tail = new DLLItem<T>(init_value, null);
    }
    public DoubleLinkedList(DLLItem<T> head) {
        super();
        this.head = this.tail = head;
    }
    @Override
    public InsertState add_element(T elem) {
        if (this.head == null) {
            this.head = this.tail = new DLLItem<T>(elem, null);
            return InsertState.SUCCESS;
        } else {
            DLLItem<T> tmp = head;
            while(tmp != null) {
                if(elem.compareTo(tmp.getValue()) == 0) {
                    return InsertState.EXISTS;
                } else if(elem.compareTo(tmp.getValue()) < 0) {
                    DLLItem<T> new_item = new DLLItem<T>(elem, tmp.getPrev(),tmp);
                    if(tmp.getPrev() != null) {
                        tmp.getPrev().setNext(new_item);
                    } else {
                        this.head = new_item;
                    }
                    tmp.setPrev(new_item);
                    break;
                } else {
                    if (tmp.getNext() == null) {
                        DLLItem<T> new_item = new DLLItem<T>(elem, tmp, tmp.getNext());
                        tmp.setNext(new_item);
                        this.tail = new_item;
                    } else {
                        tmp = tmp.getNext();
                    }
                }
            }
        }
        return InsertState.SUCCESS;
    }

    @Override
    public DLLItem<T> get_item(T elem) {  //ToDo: create a tuple class that returns the state and potentially the item in case it was successful
        if (elem == null) return null;
        DLLItem<T> tmp_head = head;
        DLLItem<T> tmp_tail = tail;

        while (tmp_head != tmp_tail) {
            if(tmp_head.getValue().compareTo(elem) == 0) {
                return tmp_head;
            }
            if(tmp_tail.getValue().compareTo(elem) == 0) {
                return tmp_tail;
            }
            tmp_head = tmp_head.getNext();
            tmp_tail = tmp_tail.getPrev();
        }
        if(tmp_head.getValue().compareTo(elem) == 0) return tmp_head;
        return null;
    }

    @Override
    public ElementState is_exist(T elem) {
        DLLItem<T> tmp = head;
        while (tmp != null) {
            if(tmp.getValue().compareTo(elem) == 0) {
                return ElementState.EXISTS;
            }
            tmp=tmp.getNext();
        }
        return ElementState.NOT_EXISTS;
    }

    @Override
    public DeleteState remove_item(DLLItem<T> item) {
        DLLItem<T> tmp = get_item(item.getValue());   //this should be something else in case the tuples class is implemented
        if(tmp == null) return DeleteState.NOT_EXIST;

        if(tmp.getPrev() != null && tmp.getNext() != null)
        {
            tmp.getPrev().setNext(tmp.getNext());
            tmp.getNext().setPrev(tmp.getPrev());
            return DeleteState.SUCCESS;
        } else if (tmp.getPrev() == null && tmp.getNext() != null) {
            this.head = tmp.getNext();
            tmp.getNext().setPrev(null);
            return DeleteState.SUCCESS;
        } else if (tmp.getPrev() != null && tmp.getNext() == null) {
            this.tail = tmp.getPrev();
            tmp.getPrev().setNext(null);
            return DeleteState.SUCCESS;
        } else {
            this.head = this.tail = null;
            return DeleteState.SUCCESS;
        }
    }

    @Override
    public DeleteState remove_item_by_value(T elem) { //ToDo: here a tuple class would also be better let the method return the deleted object back instead
        DLLItem<T> tmp = get_item(elem);
        return remove_item(tmp);
    }

    public String toString() {
        DLLItem<T> tmp = head;
        String result = "";
        if (tmp == null) {
            result = "The list is empty";
            return result;
        }
        result="The list contains : \n\t\t";
        while (tmp != null) {
            result += tmp.getValue().toString();
            if(tmp.getNext() != null) result += ", ";
            tmp=tmp.getNext();
        }
        return result;
    }

}
