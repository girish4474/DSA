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

    /**
     * ---------------------------------------------------------------------------
     * LEETCODE PROBLEMS
     * ---------------------------------------------------------------------------
     */

    /**
     * Swap the first and last node
     */
    public void swapFirstLast(){
        if(length < 2) return;
        // brute force swapping the pointers
//        head.next.prev = tail;
//        tail.prev.next = head;
//        head.prev = tail.prev;
//        tail.next = head.next;
//        head.next = null;
//        tail.prev = null;
//        Node headTemp = head;
//        head = tail;
//        tail = headTemp;
        // swapping the values
        int temp = head.value;
        head.value = tail.value;
        tail.value = temp;
    }

    public void reverse() {
        if(length <= 0) return;
        // Using before and after pointers
//        Node temp = head;
//        head = tail;
//        tail = temp;
//        Node after = temp.next;
//        Node before = null;
//        for (int i = 0;i<length;i++) {
//            after = temp.next;
//            temp.next = before;
//            temp.prev = after;
//            before = temp;
//            temp = after;
//        }

        Node current = head;
        Node temp = null;

        while (current != null) {
            temp = current.prev;
            // Swap the next and prev pointers
            current.prev = current.next;
            current.next = temp;
            // 'next' node is now in 'current.prev',
            // so we update 'current' to this node.
            current = current.prev;
        }

        temp = head;
        head = tail;
        tail = temp;
    }

    /**
     * Check if the list is palindrome
     * @return - true if the list is palindrome
     */
    public boolean isPalindrome() {
        if (length <= 1) return true;
        Node forwardNode = head;
        Node backwardNode = tail;
        for (int i = 0; i < length / 2; i++) {
            if (forwardNode.value != backwardNode.value) return false;
            forwardNode = forwardNode.next;
            backwardNode = backwardNode.prev;
        }
        return true;
    }

    /**
     * Swap Nodes in Pairs
     * Given a linked list, swap every two adjacent nodes.
     * You should not modify the values in the list's nodes, only nodes itself may be changed.
     */
    public void swapPairs() {
        // brute force
//        if(length <=1) return;
//        Node temp = head;
//        Node tempImmNext = temp.next;
//        Node nextTemp = temp.next.next;
//        Node beforeTemp = null;
//        while(temp != null && temp.next != null) {
//            tempImmNext = temp.next;
//            beforeTemp = temp.prev;
//            nextTemp = tempImmNext.next;
//            if(beforeTemp != null) {
//                beforeTemp.next = tempImmNext;
//            }
//            temp.prev = tempImmNext;
//            temp.next = nextTemp;
//            if(nextTemp != null) {
//                nextTemp.prev = temp;
//            }
//            tempImmNext.prev = beforeTemp;
//            tempImmNext.next = temp;
//            temp = nextTemp;
//        }
//        head = head.prev;
//        if(length%2 == 0) {
//            tail = tail.next;
//        }
        // Udemy Solution with inline comments
        // Create a placeholder (dummyNode) node to simplify swapping.
        Node dummyNode = new Node(0);

        // Link the dummyNode node to the start of our list.
        dummyNode.next = head;

        // Initialize 'previousNode' to 'dummyNode' to remember the node
        // before each pair we're swapping.
        Node previousNode = dummyNode;

        // Continue as long as there's a pair of nodes to swap.
        while (head != null && head.next != null) {

            // Identify the first node of the pair to swap.
            Node firstNode = head;

            // Identify the second node of the pair to swap.
            Node secondNode = head.next;

            // Connect the previousNode's 'next' pointer to secondNode,
            // essentially skipping over firstNode.
            previousNode.next = secondNode;

            // Connect firstNode to the node after secondNode.
            // This ensures we don't lose the rest of the list.
            firstNode.next = secondNode.next;

            // Connect secondNode back to firstNode,
            // completing the swap.
            secondNode.next = firstNode;

            // Adjust 'prev' pointers for our doubly linked list.
            // Set secondNode's 'prev' to the node before current pair.
            secondNode.prev = previousNode;

            // Set firstNode's 'prev' to secondNode as they've been swapped.
            firstNode.prev = secondNode;

            // If there's a node after our current pair, set its 'prev' to firstNode.
            if (firstNode.next != null) {
                firstNode.next.prev = firstNode;
            }

            // Move the head pointer to the node after the current pair.
            head = firstNode.next;

            // Update 'previousNode' for the next pair of nodes.
            previousNode = firstNode;
        }

        // After swapping all pairs, update our list's head to
        // start at the node after dummyNode.
        head = dummyNode.next;

        // Ensure the new head's 'prev' is null, indicating the start of list.
        if (head != null) head.prev = null;
    }
}
