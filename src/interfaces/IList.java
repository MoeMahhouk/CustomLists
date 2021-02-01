package interfaces;

import enums.DeleteState;
import enums.ElementState;
import enums.InsertState;

public interface IList<T extends Comparable<T>, I extends IItem<T>>
{

    InsertState addElement(T elem);

    InsertState addItem(I new_item);

    I getItemByValue(T elem);

    I getItem(I item);

    ElementState contains(T elem);

    DeleteState removeItem(I item);  //ToDo: replace this with a tuple instead

    DeleteState removeItemByValue(T elem);
}
