package datastructures.binarysearchtree;

public class BinarySearchTree {
    Node root;
    static class Node {
        int value;
        Node left;
        Node right;
        Node(int value){
            this.value = value;
            left = null;
            right = null;
        }
    }

    /**
     * Insert a new node in the binary search tree
     *
     * @param value value of the new node
     * @return true if the value is inserted successfully, false if the value already exists
     */
    public boolean insert (int value) {
        Node newNode = new Node(value);
        if(root == null) {
            root = newNode;
            return true;
        }
        Node temp = root;
        while(true) {
            if (newNode.value == temp.value) return false;
            if(newNode.value<temp.value) {
                if(temp.left==null) {
                    temp.left = newNode;
                    return true;
                }
                temp = temp.left;
            } else {
                if(temp.right==null) {
                    temp.right = newNode;
                    return true;
                }
                temp = temp.right;
            }
        }
    }

    /**
     * Checks if the binary search tree contains a specific value.
     *
     * @param value the value to search for in the tree
     * @return true if the value is found in the tree, false otherwise
     */
    public boolean contains(int value) {
//        if(root == null) return false;
        // above line is not needed as the while loop will take care of it
        Node temp = root;
        while(temp != null) {
            if(value < temp.value) {
                temp = temp.left;
            } else if(value > temp.value) {
                temp = temp.right;
            } else {
                return true;
            }
        }
        return false;
    }
}
