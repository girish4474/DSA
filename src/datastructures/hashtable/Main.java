package datastructures.hashtable;

import java.util.HashMap;

public class Main {

    public static boolean itemsInCommonUsingNestedFor(int[] array1, int[] array2) {
        for (int i = 0; i < array1.length; i++) {
            for (int j = 0; j < array2.length; j++) {
                if(array1[i] == array2[j]) return true;
            }
        }
        return false;
    }

    public static boolean itemsInCommonUsingHashTable(int[] array1, int[] array2) {
        HashMap<Integer, Boolean> myHashMap = new HashMap<>();
//        for (int i = 0; i < array1.length; i++) {
//            myHashMap.put(array1[i], true);
//        }
//
//        for (int i = 0; i < array2.length; i++) {
//            if(myHashMap.get(array2[i]) != null) return true;
//        }
        for (int i : array1) {
            myHashMap.put(i, true);
        }

        for (int j : array2) {
            if (myHashMap.get(j) != null) return true;
        }
        return false;
    }

    public static void main(String[] args) {

//        HashTable myHashTable = new HashTable();
//        myHashTable.set("nails", 100);
//        myHashTable.set("tile", 50);
//        myHashTable.set("lumber", 80);
//        myHashTable.set("screws", 140);
//        myHashTable.set("bolts", 200);
//
//        myHashTable.printTable();
//        System.out.println(myHashTable.get("nails")); // returns 100
//        System.out.println(myHashTable.get("tiles")); // returns 0
//
//        System.out.println(myHashTable.keys()); // returns [nails, tile, lumber, screws, bolts]

        int[] array1 = {1, 2, 3, 4, 5};
        int[] array2 = {5, 6, 7, 8, 9};
        System.out.println(itemsInCommonUsingNestedFor(array1, array2)); // returns true
        System.out.println(itemsInCommonUsingHashTable(array1, array2)); // returns true

    }

}
