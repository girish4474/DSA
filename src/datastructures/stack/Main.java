package datastructures.stack;

public class Main {
    public static void main(String[] args) {
        Stack myStack = new Stack(2);
        myStack.push(1);
        myStack.printStack();
        System.out.println("Pop: "+myStack.pop().value);
    }
}
