package datastructures.linkedlist;

public class LinkedList {
    private Node head;
    private Node tail;
    private int length;

    /**
     * Node class
     */
    class Node {
        int value;
        Node next;
        Node(int value) {
            this.value = value;
        }
    }

    /**
     * Constructor
     * @param value
     */
    LinkedList(int value) {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }

    /**
     * Prints the head value of the linked list
     */
    public void getHead() {
        System.out.println("Head: "+ head.value);
    }

    /**
     * Prints the tail value of the linked list
     */
    public void getTail() {
        System.out.println("Tail: "+ tail.value);
    }

    /**
     * Prints the length of the linked list
     */
    public void getLength() {
        System.out.println("Length: "+ length);
    }

    /**
     * Prints the linked list
     */
    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    /**
     * Prints the head, tail, length and the list of the linked list
     */
    public void printAll() {
        if (length == 0) {
            System.out.println("Head: null");
            System.out.println("Tail: null");
        } else {
            System.out.println("Head: " + head.value);
            System.out.println("Tail: " + tail.value);
        }
        System.out.println("Length:" + length);
        System.out.println("\nLinked List:");
        if (length == 0) {
            System.out.println("empty");
        } else {
            printList();
        }
    }

    /**
     * Append a value at the end of linked list
     * @param value
     */
    public void append(int value) {
        Node newNode = new Node(value);
        if (length == 0){
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;

        }
        length++;
    }

    /**
     * Remove the last node of the linked list
     * @return the removed node
     */
    public Node removeLast() {
        Node temp = head;
        if(length == 0) {
            return null;
        } else if (length == 1) {
            head = null;
            tail = null;
            length--;
            return temp;
        } else {
            while (temp.next.next != null) {
                temp = temp.next;
            }
            Node removedNode = temp.next;
            tail = temp;
            tail.next = null;
            length--;
            return removedNode;
        }
    }

    /**
     * Prepend a value at the beginning of the linked list
     * @param value
     */
    public void prepend(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        length++;
    }

    /**
     * Remove the first node of the linked list
     * @return the removed node
     */
    public Node removeFirst() {
        if(length == 0) return null;
        Node temp = head;
        head = head.next;
        temp.next = null;
        length--;
        if(length == 0) {
            tail = null;
        }
        return temp;
    }

    /**
     * Get node at index
     * @param index
     * @return Node at index
     */
    public Node get(int index) {
        if (index >= length || index < 0) return null;
        Node temp = head;
//        int i = 0;
//        while(i != index) {
//            temp = temp.next;
//            i++;
//        }
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }

        return temp;
    }

    /**
     * Set value at index
     * @param index
     * @param value
     * @return true if successful, false otherwise
     */
    public boolean set(int index, int value) {
        Node temp = get(index);
        if(temp!=null) {
            temp.value = value;
            return true;
        }
        return false;
    }

    /**
     * Insert value at index
     * @param index
     * @param value
     * @return true if successful, false otherwise
     */
    public boolean insert (int index, int value) {

        if(index < 0 || index > length) return false;
        if(index == 0) {
            prepend(value);
            return true;
        } else if (index == length) {
            append(value);
            return true;
        }
        Node temp = new Node(value);
        Node pre = get(index-1);
        temp.next = pre.next;
        pre.next = temp;
        length++;
        return true;
    }

    /**
     * Remove value at index
     * @param index
     * @return Node at index
     */
    public Node remove(int index) {
        if(index < 0 ||index>=length) return null;
//        Node temp = head;
//        if(index == 0) {
//            head = head.next;
//            temp.next = null;
//            length--;
//            if(length == 0){
//              tail = null;
//            }
//            return temp;
//        }
//        Node pre = get(index-1);
//        temp = pre.next;
//        pre.next = temp.next;
//        temp.next = null;
//        length--;
//        return temp;
        if(index == 0) return removeFirst();
        if(index == length-1) return removeLast();
        Node pre = get(index-1);
        Node temp = pre.next;
        pre.next = temp.next;
        temp.next = null;
        length--;
        return temp;
    }

    /**
     * Reverse the linked list
     */
    public void reverse() {
        Node temp = head;
        head = tail;
        tail = temp;
        Node after = temp.next;
        Node before = null;
        for (int i = 0; i < length; i++) {
            // Instead of the for loop you could use:
            // while (temp != null) {
            after = temp.next;
            temp.next = before;
            before = temp;
            temp = after;
        }
    }
}
