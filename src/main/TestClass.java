package main;

import lists.doubleLinkedList.DLLItem;
import lists.doubleLinkedList.DoubleLinkedList;

public class TestClass
{
    public static void main(String[] args)
    {
        // TODO Auto-generated method stub
        DoubleLinkedList<Integer> intList = new DoubleLinkedList<>();
        System.out.println(intList.toString());

        intList.addElement(10);
        System.out.println(intList.toString());
        intList.addElement(2);
        System.out.println(intList.toString());
        intList.addElement(50);
        System.out.println(intList.toString());

        intList.addElement(15);
        System.out.println(intList.toString());

        intList.addElement(30);
        System.out.println(intList.toString());


        intList.addElement(25);

        System.out.println(intList.toString());

        intList.addElement(25);
        System.out.println(intList.toString());

        intList.removeItemByValue(15);
        System.out.println(intList.toString());

        intList.removeItemByValue(10);
        System.out.println(intList.toString());

        intList.removeItemByValue(50);
        System.out.println(intList.toString());

        intList.removeItemByValue(30);
        System.out.println(intList.toString());

        intList.removeItemByValue(25);
        System.out.println(intList.toString());

        intList.removeItemByValue(2);
        System.out.println(intList.toString());

        DLLItem<Integer> first_item = new DLLItem<>(10);
        DLLItem<Integer> second_item = new DLLItem<>(2);
        DLLItem<Integer> third_item = new DLLItem<>(25);
        DLLItem<Integer> fourth_item = new DLLItem<>(15);

        intList.addItem(first_item);
        intList.addItem(second_item);
        intList.addItem(third_item);
        intList.addItem(fourth_item);

        System.out.println(intList.toString());

    }
}
