package datastructures.heap;

import java.util.ArrayList;
import java.util.List;

public class Main {

    /**
     * This method finds the kth smallest element in an array of integers.
     * Using a max heap to store the k smallest elements.
     * @param nums The array of integers.
     * @param k The kth smallest element to find.
     * @return The kth smallest element in the array.
     */
    public static int findKthSmallest(int[] nums, int k) {
        if(k > nums.length) {
            return 0;
        }
        Heap maxHeap = new Heap();
        for(int i: nums) {
            maxHeap.insert(i);
            if(maxHeap.getHeap().size()>k) {
                maxHeap.remove();
            }
        }
        return maxHeap.remove();

    }

    /**
     * This method finds the maximum value in a stream of integers.
     * Using a max heap to store the maximum value in the stream.
     * @param nums The stream of integers.
     * @return A list of the maximum values in the stream.
     */
    public static List<Integer> streamMax(int[] nums) {
//        // Using a brute force approach to find the maximum value in the stream
//        // Using maxValue int to store the maximum value in the stream
//        // complexity: O(n)
//        if(nums.length == 0) {
//            return new ArrayList<>();
//        }
//        List<Integer> resultList = new ArrayList<>();
//        int maxValue = nums[0];
//        for(int num: nums) {
//            if(num > maxValue) {
//                resultList.add(num);
//                maxValue = num;
//            } else {
//                resultList.add(maxValue);
//            }
//        }
//        return resultList;

        // Using a max heap to store the maximum value in the stream
        // complexity: O(nlogn)
        Heap maxHeap = new Heap();
        List<Integer> maxStream = new ArrayList<>();

        for (int num : nums) {
            maxHeap.insert(num);
            // The heap's root is always the maximum, so we add it to the result list
            maxStream.add(maxHeap.getHeap().get(0));
        }

        return maxStream;
    }

    public static void main(String[] args) {
//        Heap myHeap = new Heap();
//        // Inserting values into the heap
//        myHeap.insert(99);
//        myHeap.insert(72);
//        myHeap.insert(61);
//        myHeap.insert(58);
//        System.out.println(myHeap.getHeap());
//        myHeap.insert(100);
//        System.out.println(myHeap.getHeap());
//        myHeap.insert(75);
//        System.out.println(myHeap.getHeap());
//        // Removing values from the heap
//        myHeap.insert(95);
//        myHeap.insert(75);
//        myHeap.insert(80);
//        myHeap.insert(55);
//        myHeap.insert(60);
//        myHeap.insert(50);
//        myHeap.insert(65);
//        System.out.println(myHeap.getHeap());
//        System.out.println(myHeap.remove());
//        System.out.println(myHeap.getHeap());
//        System.out.println(myHeap.remove());
//        System.out.println(myHeap.getHeap());

//        // Inserting values into the MinHeap
//        MinHeap myHeap = new MinHeap();
//        myHeap.insert(99);
//        myHeap.insert(72);
//        myHeap.insert(61);
//        myHeap.insert(58);
//
//        System.out.println(myHeap.getHeap());
//
//        myHeap.insert(10);
//
//        System.out.println(myHeap.getHeap());
//
//        myHeap.insert(75);
//
//        System.out.println(myHeap.getHeap());
//
//        /*
//            EXPECTED OUTPUT:
//            ----------------
//            [58, 61, 72, 99]
//            [10, 58, 72, 99, 61]
//            [10, 58, 72, 99, 61, 75]
//        */
//
//        Integer removedValue1 = myHeap.remove();
//
//        System.out.println("First Removed Value: " + removedValue1);
//        System.out.println(myHeap.getHeap());
//
//        Integer removedValue2 = myHeap.remove();
//
//        System.out.println("Second Removed Value: " + removedValue2);
//        System.out.println(myHeap.getHeap());
//
//        /*
//            EXPECTED OUTPUT:
//            ----------------
//            [10, 58, 72, 99, 61, 75]
//            First Removed Value: 10
//            [58, 61, 72, 99, 75]
//            Second Removed Value: 58
//            [61, 75, 72, 99]
//        */

//        // Test case 1
//        int[] nums1 = {7, 10, 4, 3, 20, 15};
//        int k1 = 3;
//        System.out.println("Test case 1:");
//        System.out.println("Expected output: 7");
//        System.out.println("Actual output: " + findKthSmallest(nums1, k1));
//        System.out.println();
//
//        // Test case 2
//        int[] nums2 = {2, 1, 3, 5, 6, 4};
//        int k2 = 2;
//        System.out.println("Test case 2:");
//        System.out.println("Expected output: 2");
//        System.out.println("Actual output: " + findKthSmallest(nums2, k2));
//        System.out.println();
//
//        // Test case 3
//        int[] nums3 = {9, 3, 2, 11, 7, 10, 4, 5};
//        int k3 = 5;
//        System.out.println("Test case 3:");
//        System.out.println("Expected output: 7");
//        System.out.println("Actual output: " + findKthSmallest(nums3, k3));
//        System.out.println();
//
//
//        /*
//            EXPECTED OUTPUT:
//            ----------------
//            Test case 1:
//            Expected output: 7
//            Actual output: 7
//
//            Test case 2:
//            Expected output: 2
//            Actual output: 2
//
//            Test case 3:
//            Expected output: 7
//            Actual output: 7
//
//        */

        // Test case 1
        int[] nums1 = {1, 5, 2, 9, 3, 6, 8};
        System.out.println("Test case 1:");
        System.out.println("Input: [1, 5, 2, 9, 3, 6, 8]");
        System.out.println("Expected output: [1, 5, 5, 9, 9, 9, 9]");
        System.out.println("Actual output: " + streamMax(nums1));
        System.out.println();

        // Test case 2
        int[] nums2 = {10, 2, 5, 1, 0, 11, 6};
        System.out.println("Test case 2:");
        System.out.println("Input: [10, 2, 5, 1, 0, 11, 6]");
        System.out.println("Expected output: [10, 10, 10, 10, 10, 11, 11]");
        System.out.println("Actual output: " + streamMax(nums2));
        System.out.println();

        // Test case 3
        int[] nums3 = {3, 3, 3, 3, 3};
        System.out.println("Test case 3:");
        System.out.println("Input: [3, 3, 3, 3, 3]");
        System.out.println("Expected output: [3, 3, 3, 3, 3]");
        System.out.println("Actual output: " + streamMax(nums3));
        System.out.println();

        /*
            EXPECTED OUTPUT:
            ----------------
            Test case 1:
            Input: [1, 5, 2, 9, 3, 6, 8]
            Expected output: [1, 5, 5, 9, 9, 9, 9]
            Actual output: [1, 5, 5, 9, 9, 9, 9]

            Test case 2:
            Input: [10, 2, 5, 1, 0, 11, 6]
            Expected output: [10, 10, 10, 10, 10, 11, 11]
            Actual output: [10, 10, 10, 10, 10, 11, 11]

            Test case 3:
            Input: [3, 3, 3, 3, 3]
            Expected output: [3, 3, 3, 3, 3]
            Actual output: [3, 3, 3, 3, 3]

        */



    }
}
