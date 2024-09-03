package datastructures.doublylinkedlist;

public class DoublyLinkedList {
    private Node head;
    private Node tail;
    private int length;

    /**
     * Node class
     */
    class Node {
        int value;
        Node next;
        Node prev;

        Node(int value) {
            this.value = value;
        }
    }

    /**
     * Constructor
     * @param value
     */
    public DoublyLinkedList(int value) {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }

    /**
     * Print the list
     */
    public void printList() {
        Node temp = head;
        System.out.println("Doubly Linked List: ");
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    /**
     * Get the head of the list
     */
    public void getHead() {
        System.out.println("Head: "+ head.value);
    }

    /**
     * Get the tail of the list
     */
    public void getTail() {
        System.out.println("Tail: " + tail.value);
    }

    /**
     * Get the length of the list
     */
    public void getLength() {
        System.out.println("Length: "+ length);
    }

    /**
     * Print all the details
     */
    public void printAll() {
        this.getHead();
        this.getTail();
        this.getLength();
        this.printList();
    }

    /**
     * Append a new node to the list
     * @param value - value to be appended for new node
     */
    public void append(int value) {
        Node newNode = new Node(value);
//        if (length == 0) {
//            newNode.prev = null;
//            head = newNode;
//
//        } else {
//            tail.next = newNode;
//            newNode.prev = tail;
//        }
//        newNode.next = null;
//        tail = newNode;
//        length++;
        if(length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        length++;
    }

    /**
     * Remove the last node from the list
     * @return - removed node
     */
    public Node removeLast() {
        if(length == 0) return null;
        Node temp = tail;
        if(length == 1) {
            head = null;
            tail = null;
        } else {
            tail = temp.prev;
            tail.next = null;
            temp.prev = null;
        }
        length--;
        return temp;
    }

    /**
     * Prepend a new node to the list
     * @param value - value to be prepended for new node
     */
    public void prepend(int value) {
        Node newNode = new Node(value);
        if(length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            head.prev = newNode;
            newNode.next = head;
            head = newNode;
        }
        length++;
    }

    /**
     * Remove the first node from the list
     * @return - removed node
     */
    public Node removeFirst() {
        if (length == 0) return null;
        Node temp = head;
        if (length == 1) {
            head = null;
            tail = null;
        } else {
            head = head.next;
            temp.next = null;
            head.prev = null;
        }
        length--;
        return temp;
    }

    /**
     * Get the node at the given index
     * @param index - index of the node
     * @return - node at the given index
     */
    public Node get(int index) {
        if (index < 0 || index > length) return null;
        Node temp = head;
        if (index < length/2) {
//            System.out.println("Working from head");
            for (int i = 0; i< index; i++) {
                temp = temp.next;
            }
        } else {
            temp = tail;
//            System.out.println("Working from tail");
            for(int i = length-1; i>index; i--) {
                temp = temp.prev;
            }
        }
        return temp;
    }

    /**
     * Set the value of the node at the given index
     * @param index - index of the node
     * @param value - value to be set
     * @return - true if the value is set successfully
     */
    public boolean set(int index, int value) {
//        if(index < 0 || index > length) return false;
//        Node temp = head;
//        if (index < length/2) {
////            System.out.println("Working from head");
//            for (int i = 0; i < index; i++) {
//                temp = temp.next;
//            }
//        } else {
//            temp = tail;
////            System.out.println("Working from tail");
//            for (int i = length -1; i > index; i--) {
//                temp = temp.prev;
//            }
//        }
//        temp.value = value;
//        return true;
        // using get method
        Node temp = this.get(index);
        if (temp != null) {
            temp.value = value;
            return true;
        }
        return false;
    }

    /**
     * Insert a new node at the given index
     * @param index - index of the node
     * @param value - value to be inserted
     * @return - true if the value is inserted successfully
     */
    public boolean insert(int index, int value) {
        Node newNode = new Node(value);
        if (index < 0 || index > length) {
            return false;
        }else if(index == 0) {
            prepend(value);
            return true;
        } else if (index == length) {
            append(value);
            return true;
        }
//        Node temp = get(index);
//        newNode.next = temp;
//        newNode.prev = temp.prev;
//        temp.prev.next = newNode;
//        temp.prev = newNode;
//        length++;
//        return true;
        Node before = get(index-1);
        Node after = before.next;
        newNode.next = after;
        newNode.prev = before;
        before.next = newNode;
        after.prev = newNode;
        length++;
        return true;
    }

    /**
     * Remove the node at the given index
     * @param index - index of the node
     * @return - removed node
     */
    public Node remove(int index) {
        if (index < 0 || index>= length) return null;
        if (index == 0) {
            return removeFirst();
        } else if (index == length-1) {
            return removeLast();
        }
        Node removedNode = get(index);
//        Node before = removedNode.prev;
//        Node after = removedNode.next;
//        before.next = after;
//        after.prev = before;
//        removedNode.next = null;
//        removedNode.prev = null;
        removedNode.prev.next = removedNode.next;
        removedNode.next.prev = removedNode.prev;
        removedNode.next = null;
        removedNode.prev = null;
        length--;
        return removedNode;
    }
}
