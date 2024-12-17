package datastructures.heap;

public class Main {
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

        // Inserting values into the MinHeap
        MinHeap myHeap = new MinHeap();
        myHeap.insert(99);
        myHeap.insert(72);
        myHeap.insert(61);
        myHeap.insert(58);

        System.out.println(myHeap.getHeap());

        myHeap.insert(10);

        System.out.println(myHeap.getHeap());

        myHeap.insert(75);

        System.out.println(myHeap.getHeap());

        /*
            EXPECTED OUTPUT:
            ----------------
            [58, 61, 72, 99]
            [10, 58, 72, 99, 61]
            [10, 58, 72, 99, 61, 75]
        */

        Integer removedValue1 = myHeap.remove();

        System.out.println("First Removed Value: " + removedValue1);
        System.out.println(myHeap.getHeap());

        Integer removedValue2 = myHeap.remove();

        System.out.println("Second Removed Value: " + removedValue2);
        System.out.println(myHeap.getHeap());

        /*
            EXPECTED OUTPUT:
            ----------------
            [10, 58, 72, 99, 61, 75]
            First Removed Value: 10
            [58, 61, 72, 99, 75]
            Second Removed Value: 58
            [61, 75, 72, 99]
        */



    }
}
