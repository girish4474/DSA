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
        // Brute force method
        if (nums == null || nums.length == 0) {
            return new int[0]; // Return an empty array
        }
        for(int i=0;i<nums.length;i++) {
            int sum = 0;
            for (int j=i;j<nums.length;j++) {
                sum += nums[j];
                if(sum == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
//        // Using a HashMap to store the sum and index
//        // If the current sum - target is in the map, return the index of the sum and the current index
//        //If currentSum - target exists in the hash map at some index, it means the sum of the elements between that index + 1 and the current index equals target.
//        if (nums == null || nums.length == 0) {
//            return new int[0]; // Return an empty array
//        }
//        Map<Integer,Integer> sumIndex = new HashMap<>();
//        sumIndex.put(0,-1);
//        int currentSum = 0;
//        for (int i = 0;i<nums.length;i++) {
//            currentSum += nums[i];
//            if(sumIndex.containsKey(currentSum-target)) {
//                return new int[]{sumIndex.get(currentSum-target)+1,i};
//            } else {
//                sumIndex.put(currentSum,i);
//            }
//        }
//        return new int[0];
    }

    /**
     * Removes duplicate integers from a list.
     *
     * @param myList the list of integers from which duplicates need to be removed
     * @return a new list containing only unique integers from the original list
     */
    public static List<Integer> removeDuplicates(List<Integer> myList){
        Set<Integer> uniqueSet = new HashSet<>(myList);
        return new ArrayList<>(uniqueSet);
    }

    public static boolean hasUniqueChars(String string) {
//        // Brute force method - Using size and length
//        Set<Character> charSet = new HashSet<>();
//        for (char c : string.toCharArray()) {
//            charSet.add(c);
//        }
//        if(charSet.size() == string.length()) {
//            return true;
//        }
//        return false;
        // Using contains method
        Set<Character> charSet = new HashSet<>();
        for (char ch : string.toCharArray()) {
            if (charSet.contains(ch)) {
                return false;
            }
            charSet.add(ch);
        }
        return true;
    }

    /**
     * LEETCODE QUESTION
     * Finds pairs of integers from two arrays that sum up to a target value.
     *
     * @param arr1 the first array of integers
     * @param arr2 the second array of integers
     * @param target the target sum for the pairs
     * @return a list of integer arrays, each containing a pair of integers that sum up to the target value
     */
    public static List<int[]> findPairs(int[] arr1, int[] arr2, int target){
//        // Brute force method
//        List<int[]> pairsList = new ArrayList<>();
//        for(int i:arr1) {
//            for(int j:arr2) {
//                if (i+j == target) {
//                    pairsList.add(new int[]{i,j});
//                }
//            }
//        }
//        return pairsList;

        // Using a HashSet
        List<int[]> pairsList = new ArrayList<>();
        Set<Integer> mySet = new HashSet<>();
        for (int num : arr1) {
            mySet.add(num);
        }
        for (int num:arr2) {
            int complement = target - num;
            if(mySet.contains(complement)) {
                pairsList.add(new int[]{complement,num});
            }
        }
        return pairsList;
    }

    /**
     * LEETCODE QUESTION
     * Finds the length of the longest consecutive elements sequence in an array of integers.
     *
     * @param nums the array of integers
     * @return the length of the longest consecutive elements sequence
     */
    public static int longestConsecutiveSequence(int[] nums) {
//        // Using a sort and HashSet
//        Arrays.sort(nums);
//        Set<Integer> numSet = new HashSet<>();
//        int longestStreak = 0;
//        int currentStreak = 0;
//        for (int num:nums) {
//            if(numSet.contains(num)) {
//                continue;
//            }
//            numSet.add(num);
//            currentStreak +=1;
//            if(numSet.contains(num-1)) {
//                longestStreak = currentStreak;
//            } else {
//                currentStreak =1;
//            }
//        }
//        if (currentStreak > longestStreak) { longestStreak = currentStreak;}
//        return longestStreak;


        // Using just HashSet
        Set<Integer> numSet = new HashSet<>();
        for (int num:nums) {
            numSet.add(num);
        }
        int longestStreak = 0;
        for (int num:nums) {
            if(!numSet.contains(num-1)) {
                int currentStreak = 1;
                int currentNum = num;
                while(numSet.contains(currentNum+1)) {
                    currentStreak++;
                    currentNum++;
                }
                longestStreak = Math.max(longestStreak,currentStreak);
            }
        }
        return longestStreak;
    }

    /**
     * Test method for longestConsecutiveSequence.
     * @param title Title of the test
     * @param nums Input array
     * @param expected Expected result
     */
    private static void testLongestConsecutiveSequence(String title, int[] nums, int expected) {
        System.out.println("Test: " + title);
        System.out.print("Testing array: ");
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();

        int result = longestConsecutiveSequence(nums);
        System.out.println("Expected longest streak: " + expected);
        System.out.println("Actual longest streak: " + result);

        if (result == expected) {
            System.out.println("PASS\n");
        } else {
            System.out.println("FAIL\n");
        }
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

//        // Test cases for twoSum
//        System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9)));
//        System.out.println(Arrays.toString(twoSum(new int[]{3, 2, 4}, 6)));
//        System.out.println(Arrays.toString(twoSum(new int[]{3, 3}, 6)));
//        System.out.println(Arrays.toString(twoSum(new int[]{1, 2, 3, 4, 5}, 10)));
//        System.out.println(Arrays.toString(twoSum(new int[]{1, 2, 3, 4, 5}, 7)));
//        System.out.println(Arrays.toString(twoSum(new int[]{1, 2, 3, 4, 5}, 3)));
//        System.out.println(Arrays.toString(twoSum(new int[]{}, 0)));
//
//        /*
//            EXPECTED OUTPUT:
//            ----------------
//            [0, 1]
//            [1, 2]
//            [0, 1]
//            []
//            [2, 3]
//            [0, 1]
//            []
//
//        */

//        // Test cases for subarraySum
//        int[] nums1 = {1, 2, 3, 4, 5};
//        int target1 = 9;
//        int[] result1 = subarraySum(nums1, target1);
//        System.out.println("[" + result1[0] + ", " + result1[1] + "]");
//
//        int[] nums2 = {-1, 2, 3, -4, 5};
//        int target2 = 0;
//        int[] result2 = subarraySum(nums2, target2);
//        System.out.println("[" + result2[0] + ", " + result2[1] + "]");
//
//        int[] nums3 = {2, 3, 4, 5, 6};
//        int target3 = 3;
//        int[] result3 = subarraySum(nums3, target3);
//        System.out.println("[" + result3[0] + ", " + result3[1] + "]");
//
//        int[] nums4 = {};
//        int target4 = 0;
//        int[] result4 = subarraySum(nums4, target4);
//        System.out.println("[]");
//
//        /*
//            EXPECTED OUTPUT:
//            ----------------
//            [1, 3]
//            [0, 3]
//            [1, 1]
//            []
//
//        */

//        // Test cases for removeDuplicates
//        List<Integer> myList = List.of(1, 2, 3, 4, 1, 2, 5, 6, 7, 3, 4, 8, 9, 5);
//        List<Integer> newList = removeDuplicates(myList);
//        System.out.println(newList);
//
//        /*
//            EXPECTED OUTPUT:
//            ----------------
//            [1, 2, 3, 4, 5, 6, 7, 8, 9]
//
//            (Order may be different as sets are unordered)
//        */

//        // Test cases for hasUniqueChars
//        System.out.println(hasUniqueChars("abcdefg")); // should return true
//        System.out.println(hasUniqueChars("hello")); // should return false
//        System.out.println(hasUniqueChars("")); // should return true
//        System.out.println(hasUniqueChars("0123456789")); // should return true
//        System.out.println(hasUniqueChars("abacadaeaf")); // should return false
//
//        /*
//            EXPECTED OUTPUT:
//            ----------------
//            true
//            false
//            true
//            true
//            false
//
//        */

//        // Test cases for findPairs
//        int[] arr1 = {1, 2, 3, 4, 5};
//        int[] arr2 = {2, 4, 6, 8, 10};
//        int target = 7;
//
//        List<int[]> pairs = findPairs(arr1, arr2, target);
//        for (int[] pair : pairs) {
//            System.out.println(Arrays.toString(pair));
//        }
//
//        /*
//            EXPECTED OUTPUT:
//            ----------------
//            [5, 2]
//            [3, 4]
//            [1, 6]
//
//        */

        // Test cases for longestConsecutiveSequence
        testLongestConsecutiveSequence("Consecutive Integers", new int[] {1, 2, 3, 4, 5}, 5);
        testLongestConsecutiveSequence("No Sequence", new int[] {1, 3, 5, 7, 9}, 1);
        testLongestConsecutiveSequence("Duplicates", new int[] {1, 2, 2, 3, 4}, 4);
        testLongestConsecutiveSequence("Negative Numbers", new int[] {1, 0, -1, -2, -3}, 5);
        testLongestConsecutiveSequence("Empty Array", new int[] {}, 0);
        testLongestConsecutiveSequence("Multiple Sequences", new int[] {1, 2, 3, 10, 11, 12, 13}, 4);
        testLongestConsecutiveSequence("Unordered Elements", new int[] {5, 1, 3, 4, 2}, 5);
        testLongestConsecutiveSequence("Single Element", new int[] {1}, 1);
        testLongestConsecutiveSequence("All Identical Elements", new int[] {2, 2, 2, 2, 2}, 1);



    }

}
