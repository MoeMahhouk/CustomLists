package main;

import Lists.DLLItem;
import Lists.DoubleLinkedList;

public class TestClass
{
    public static void main(String[] args)
    {
        // TODO Auto-generated method stub
        DoubleLinkedList<Integer> intList = new DoubleLinkedList<>();
        System.out.println(intList.toString());

        intList.add_element(10);
        System.out.println(intList.toString());
        intList.add_element(2);
        System.out.println(intList.toString());
        intList.add_element(50);
        System.out.println(intList.toString());

        intList.add_element(15);
        System.out.println(intList.toString());

        intList.add_element(30);
        System.out.println(intList.toString());


        intList.add_element(25);

        System.out.println(intList.toString());

        intList.add_element(25);
        System.out.println(intList.toString());

        intList.remove_item_by_value(15);
        System.out.println(intList.toString());

        intList.remove_item_by_value(10);
        System.out.println(intList.toString());

        intList.remove_item_by_value(50);
        System.out.println(intList.toString());

        intList.remove_item_by_value(30);
        System.out.println(intList.toString());

        intList.remove_item_by_value(25);
        System.out.println(intList.toString());

        intList.remove_item_by_value(2);
        System.out.println(intList.toString());

        DLLItem<Integer> first_item = new DLLItem<>(10);
        DLLItem<Integer> second_item = new DLLItem<>(2);
        DLLItem<Integer> third_item = new DLLItem<>(25);
        DLLItem<Integer> fourth_item = new DLLItem<>(15);

        intList.add_item(first_item);
        intList.add_item(second_item);
        intList.add_item(third_item);
        intList.add_item(fourth_item);

        System.out.println(intList.toString());

    }
}
