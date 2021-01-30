package Interfaces;

import Enums.DeleteState;
import Enums.ElementState;
import Enums.InsertState;

public interface IList<T extends Comparable<T>, I> {

    public InsertState add_element (T elem);
    public I get_item(T elem);
    public ElementState is_exist(T elem);
    public DeleteState remove_item(I item);  //ToDo: replace this with a tuple instead
    public DeleteState remove_item_by_value(T elem);
}
