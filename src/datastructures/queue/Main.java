package datastructures.queue;

public class Main {
    public static void main(String[] args) {
        Queue myQueue = new Queue(1);
        myQueue.enqueue(2);
        myQueue.printQueue();
        System.out.println(myQueue.dequeue().value);
        System.out.println(myQueue.dequeue().value);
    }
}
