package datastructures.hashtable;

import java.util.*;

public class Main {

    /**
     * LEETCODE QUESTION
     * Given two integer arrays, array1 and array2, return true if there are any items that are in both arrays.
     * @param array1 - first array
     * @param array2 - second array
     * @return true if there are any items in common, false otherwise
     */
    public static boolean itemsInCommonUsingNestedFor(int[] array1, int[] array2) {
        for (int i = 0; i < array1.length; i++) {
            for (int j = 0; j < array2.length; j++) {
                if(array1[i] == array2[j]) return true;
            }
        }
        return false;
    }

    /**
     * LEETCODE QUESTION
     * Given two integer arrays, array1 and array2, return true if there are any items that are in both arrays.
     * @param array1 - first array
     * @param array2 - second array
     * @return true if there are any items in common, false otherwise
     */
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

    /**
     * LEETCODE QUESTION
     * Given an integer array nums, return an array of all the integers in the array that appear more than once.
     * @param nums
     * @return
     */
    public static List<Integer> findDuplicates(int[] nums) {
//        // brute force method
//        List<Integer> duplicates = new ArrayList<>();
//        HashMap<Integer,Boolean> myhashMap = new HashMap<>();
//        for(int i:nums) {
//            if(myhashMap.get(i) == null) {
//                myhashMap.put(i,true);
//            } else {
//                if(!duplicates.contains(i)) {
//                    duplicates.add(i);
//                }
//
//            }
//        }
//        return duplicates;



        // LeetCode solution - Create a new HashMap to store the count of occurrences
        // Create a new HashMap to store the count of occurrences
        // of each integer.
        Map<Integer, Integer> numCounts = new HashMap<>();

        // Loop through each integer in the input array and update
        // its count in the HashMap.
        for (int num : nums) {
            numCounts.put(num, numCounts.getOrDefault(num, 0) + 1);
        }

        // Create a new ArrayList to store the duplicate integers.
        List<Integer> duplicates = new ArrayList<>();

        // Loop through each entry in the HashMap and check if the
        // count of occurrences is greater than 1.
        for (Map.Entry<Integer, Integer> entry : numCounts.entrySet()) {
            if (entry.getValue() > 1) {
                duplicates.add(entry.getKey());
            }
        }

        // Return the ArrayList of duplicate integers.
        return duplicates;
    }

    /**
     * LEETCODE QUESTION
     * Given a string, find the first non-repeating character in it and return its index. If it doesn't exist, return -1.
     * @param str - input string
     * @return the first non-repeating character in the string
     */
    public static Character firstNonRepeatingChar(String str) {
        HashMap<Character, Integer> charCounts = new HashMap<>();
        for(Character c:str.toCharArray()) {
            charCounts.put(c, charCounts.getOrDefault(c,0)+1);
        }
//        A HashMap does not maintain the order of insertion; its entries are unordered.
//        Therefore, we cannot rely on the order of the entries in the HashMap to determine the first non-repeating character.
//        for(Map.Entry<Character,Integer> entry:charCounts.entrySet()) {
//            if(entry.getValue() == 1){
//                return entry.getKey();
//            }
//        }
        for(Character c:str.toCharArray()) {
            if(charCounts.get(c) == 1) {
                return c;
            }
        }
        return null;
    }

    /**
     * LEETCODE QUESTION
     * Given an array of strings, group anagrams together.
     * @param strings - array of strings
     * @return a list of groups of anagrams
     */
    public static List<List<String>> groupAnagrams(String[] strings) {
        Map<String,List<String>> anagramGroups = new HashMap<>();
        for(String string:strings) {
            char[] chars = string.toCharArray();
            Arrays.sort(chars);
            String canonical = new String(chars);
            if(anagramGroups.containsKey(canonical)){
                anagramGroups.get(canonical).add(string);
            } else {
                List<String> group = new ArrayList<>();
                group.add(string);
                anagramGroups.put(canonical,group);
            }
        }
        return new ArrayList<>(anagramGroups.values());
    }


    /**
     * LEETCODE QUESTION
     * Given an array of integers `nums` and an integer `target`, return the indices of the two numbers such that they add up to `target`.
     *
     * @param nums the array of integers
     * @param target the target sum
     * @return an array containing the indices of the two numbers that add up to the target, or an empty array if no such pair exists
     */
    public static int[] twoSum(int[] nums, int target) {
//        // Brute force method
        for(int i = 0;i<nums.length-1;i++) {
            for(int j = i+1;j<nums.length;j++) {
                if(target-(nums[i]+nums[j]) == 0) {
                    return new int[]{i,j};
                }
            }
        }
        return new int[0];
//        // Using a HashMap to store the index of the complement
//        Map<Integer,Integer> numMap = new HashMap<>();
//        for (int i=0;i<nums.length;i++) {
//            int num = nums[i];
//            int complement = target - num;
//            if(numMap.containsKey(complement)) {
//                return new int[]{numMap.get(complement),i};
//            } else {
//                numMap.put(num,i);
//            }
//        }
//        return new int[0];
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

//        // Test cases for itemsInCommon
//        int[] array1 = {1, 2, 3, 4, 5};
//        int[] array2 = {5, 6, 7, 8, 9};
//        System.out.println(itemsInCommonUsingNestedFor(array1, array2)); // returns true
//        System.out.println(itemsInCommonUsingHashTable(array1, array2)); // returns true



//        // Test cases for findDuplicates
//        int[] nums = {1, 2, 3, 2, 1, 4, 5, 4};
//        List<Integer> duplicates = findDuplicates(nums);
//        System.out.println(duplicates);
//
//        /*
//            EXPECTED OUTPUT:
//            ----------------
//			[1, 2, 4]
//
//        */

//        // Test cases for firstNonRepeatingChar
//        System.out.println(firstNonRepeatingChar("leetcode"));
//        System.out.println(firstNonRepeatingChar("hello"));
//        System.out.println(firstNonRepeatingChar("aabbcc"));
//
//        /*
//            EXPECTED OUTPUT:
//            ----------------
//            l
//            h
//            null
//
//        */

//        // Test cases for groupAnagrams
//        System.out.println("1st set:");
//        System.out.println(groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
//
//        System.out.println("\n2nd set:");
//        System.out.println(groupAnagrams(new String[]{"abc", "cba", "bac", "foo", "bar"}));
//
//        System.out.println("\n3rd set:");
//        System.out.println(groupAnagrams(new String[]{"listen", "silent", "triangle", "integral", "garden", "ranged"}));
//
//        /*
//            EXPECTED OUTPUT:
//            ----------------
//            1st set:
//            [[eat, tea, ate], [tan, nat], [bat]]
//
//            2nd set:
//            [[abc, cba, bac], [foo], [bar]]
//
//            3rd set:
//            [[listen, silent], [triangle, integral], [garden, ranged]]
//
//        */

        // Test cases for twoSum
        System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9)));
        System.out.println(Arrays.toString(twoSum(new int[]{3, 2, 4}, 6)));
        System.out.println(Arrays.toString(twoSum(new int[]{3, 3}, 6)));
        System.out.println(Arrays.toString(twoSum(new int[]{1, 2, 3, 4, 5}, 10)));
        System.out.println(Arrays.toString(twoSum(new int[]{1, 2, 3, 4, 5}, 7)));
        System.out.println(Arrays.toString(twoSum(new int[]{1, 2, 3, 4, 5}, 3)));
        System.out.println(Arrays.toString(twoSum(new int[]{}, 0)));

        /*
            EXPECTED OUTPUT:
            ----------------
            [0, 1]
            [1, 2]
            [0, 1]
            []
            [2, 3]
            [0, 1]
            []

        */



    }

}
