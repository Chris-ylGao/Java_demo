package com.gyl.arrayListDemo;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class ArrayListDemo {
    public static void main(String[] args) {
        Integer[] numbers = {0,1,2,3,4,5,6,7,8,9};
        ArrayList<Integer> numberList = new ArrayList(Arrays.asList(numbers));

        // copy1 refer to same reference as numberList;
        // in another words, change copy1 would affect numberList.
        ArrayList<Integer> copy1 = numberList;
        // make an actual copy of numberList;
        // change in copy2 would not influence original numberList;
        ArrayList<Integer> copy2 = new ArrayList(numberList);
        printArrayList(numberList);
        printArrayList(copy1);
        printArrayList(copy2);
        System.out.println("-----------------------------------");

        //ArrayList.add(int index, Element e)
        // by default, index = ArrayList.size();
        copy1.add(100);
        copy2.add(100000);
        copy1.add(0,-1);
        copy2.add(0,-10);
        printArrayList(numberList);
        printArrayList(copy1);
        printArrayList(copy2);
        System.out.println("-----------------------------------");

        //ArrayList.set(int index, Element e){
        copy1.set(0,0);
        printArrayList(numberList);
        printArrayList(copy1);
        printArrayList(copy2);
    }

    public static void printArrayList(ArrayList<Integer> al){
        for (int i = 0; i< al.size() ; ++i) {
            System.out.print("  " + al.get(i));
        }
        System.out.println();
    }
}
