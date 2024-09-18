package datastructures.stack;

public class Stack {
    private Node top;
    private int height;

    class Node {
        int value;
        Node next;
        Node(int value){
            this.value = value;
        }
    }

    public Stack(int value) {
        Node newNode = new Node(value);
        top = newNode;
        height = 1;
    }

    public void printStack() {
        Node temp = top;
        System.out.println("Stack");
        while(temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void printTop() {
        System.out.println("Top: "+ top.value);
    }

    public void printHeight() {
        System.out.println("Height: "+ height);
    }

    // Add a new node to the top of the stack
    public void push(int value) {
        Node newNode = new Node(value);
        if (height == 0) {
           top = newNode;
        } else {
            newNode.next = top;
            top = newNode;
        }
        height++;
    }

    // Remove the top node from the stack
    public Node pop() {
        if(height == 0) return null;
        Node temp = top;
        top = top.next;
        temp.next = null;
        height--;
        return temp;
    }
}
