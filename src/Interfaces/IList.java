package Interfaces;

import Enums.DeleteState;
import Enums.ElementState;
import Enums.InsertState;

public interface IList<T extends Comparable<T>, I extends IItem<T>>
{

    InsertState add_element(T elem);

    InsertState add_item(I new_item);

    I get_item_by_value(T elem);

    I get_item(I item);

    ElementState is_exist(T elem);

    DeleteState remove_item(I item);  //ToDo: replace this with a tuple instead

    DeleteState remove_item_by_value(T elem);
}
