package datastructures.linkedlist;

public class Main {

    public static void main(String a[]) {
        LinkedList myLinkedList = new LinkedList(10);
//        newLinkedList.append(5);
//        System.out.println(newLinkedList.removeLast().value);
//        newLinkedList.printAll();
//        System.out.println("--------------------");
//        System.out.println(newLinkedList.removeLast().value);
//        newLinkedList.printAll();
//        System.out.println("--------------------");
//        newLinkedList.prepend(5);
//        newLinkedList.prepend(1);
//        newLinkedList.printAll();
//        myLinkedList.makeEmpty();
//        int k = 2;
//        int result = myLinkedList.findKthFromEnd(k).value;
        myLinkedList.append(10);
        myLinkedList.append(10);
        myLinkedList.append(10);
        myLinkedList.append(10);
        myLinkedList.append(10);
        myLinkedList.append(10);
        myLinkedList.append(10);
        myLinkedList.removeDuplicates();
        myLinkedList.printList();

    }
}
