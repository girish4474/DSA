package datastructures.queue;

public class Queue {
    private Node first;
    private Node last;
    private int length;

    class Node {
        int value;
        Node next;
        Node(int value){
            this.value = value;
        }
    }
    public Queue(int value) {
        Node newNode = new Node(value);
        first = newNode;
        last = newNode;
        length = 1;
    }

    public void printFirst() {
        System.out.println("First: "+ first.value);
    }

    public void printLast() {
        System.out.println("Last: "+ last.value);
    }

    public void printLength() {
        System.out.println("Length: "+ length);
    }

    public void printQueue() {
        Node temp = first;
        System.out.println("Queue");
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    // Add a new node to the end of the queue
    public void enqueue(int value){
        Node newNode = new Node(value);
        if(length == 0){
            first = newNode;
        } else{
            last.next = newNode;
        }
        last = newNode;
        length++;
    }

    // Remove the first node from the queue
    public Node dequeue() {
        if(length == 0) return null;
        Node temp = first;
        if(length == 1) {
            first = null;
            last = null;
        } else {
            first = first.next;
            temp.next = null;
        }
        length--;
        return temp;
    }
}
