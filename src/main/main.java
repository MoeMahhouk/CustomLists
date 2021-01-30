package main;

import Lists.DoubleLinkedList;

public class main {
    public static void main(String[] args) {
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



    }
}
