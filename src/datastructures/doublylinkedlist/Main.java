package datastructures.doublylinkedlist;

public class Main {
    public static void main(String a[]) {
        DoublyLinkedList myDoublyLinkedList = new DoublyLinkedList(5);
        // append and remove Last
//        myDoublyLinkedList.append(10);
//        myDoublyLinkedList.append(15);
//        myDoublyLinkedList.printAll();
//        DoublyLinkedList.Node removed = myDoublyLinkedList.removeLast();
//        myDoublyLinkedList.printAll();

        // prepend and remove First
//        myDoublyLinkedList.prepend(10);
//        myDoublyLinkedList.prepend(15);
//        myDoublyLinkedList.printAll();
//        System.out.println("Removed First: "+myDoublyLinkedList.removeFirst().value);
//        myDoublyLinkedList.printAll();

        // get and set
//        myDoublyLinkedList.append(10);
//        myDoublyLinkedList.append(15);
//        myDoublyLinkedList.append(20);
//
//        System.out.println(myDoublyLinkedList.get(2).value);
//        System.out.println(myDoublyLinkedList.get(1).value);
//
//        System.out.println(myDoublyLinkedList.set(1, 25));
//        System.out.println(myDoublyLinkedList.set(-2, 30));
//        myDoublyLinkedList.printAll();

        // insert and remove
//        myDoublyLinkedList.insert(0, 10);
//        myDoublyLinkedList.insert(1, 15);
//        myDoublyLinkedList.insert(0, 20);
//        myDoublyLinkedList.insert(4, 25);
//        myDoublyLinkedList.printAll();
//        myDoublyLinkedList.remove(0);
//        myDoublyLinkedList.printAll();
//        myDoublyLinkedList.remove(2);
//        myDoublyLinkedList.printAll();
//        myDoublyLinkedList.remove(2);
//        myDoublyLinkedList.printAll();

        // swap first and last
//        DoublyLinkedList myDLL = new DoublyLinkedList(1);
//        myDLL.append(2);
//        myDLL.append(3);
//        myDLL.append(4);
//        myDLL.append(5);
//
//        System.out.println("DLL before swap:");
//        myDLL.printList();
//
//        myDLL.swapFirstLast();
//
//        System.out.println("\nDLL after swap:");
//        myDLL.printList();

        // reverse
//        DoublyLinkedList myDLL = new DoublyLinkedList(1);
//        myDLL.append(2);
//        myDLL.append(3);
//        myDLL.append(4);
//        myDLL.append(5);
//
//        System.out.println("DLL before reverse:");
//        myDLL.printList();
//
//        myDLL.reverse();
//
//        System.out.println("\nDLL after reverse:");
//        myDLL.printList();

        // isPalindrome
//        DoublyLinkedList myDLL1 = new DoublyLinkedList(1);
//        myDLL1.append(2);
//        myDLL1.append(3);
//        myDLL1.append(2);
//        myDLL1.append(1);
//
//        System.out.println("myDLL1 isPalindrome:");
//        System.out.println( myDLL1.isPalindrome() );
//
//
//
//        DoublyLinkedList myDLL2 = new DoublyLinkedList(1);
//        myDLL2.append(2);
//        myDLL2.append(3);
//
//        System.out.println("\nmyDLL2 isPalindrome:");
//        System.out.println( myDLL2.isPalindrome() );

        DoublyLinkedList myDll = new DoublyLinkedList(1);
        myDll.append(2);
        myDll.append(3);

        System.out.println("myDll before swapPairs:");
        myDll.printList();

        myDll.swapPairs();

        System.out.println("\nmyDll after swapPairs:");
        myDll.printList();


    }
}
