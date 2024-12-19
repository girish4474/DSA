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

    public Node getRoot() {
        return root;
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

    private boolean rContains(Node currentNode, int value) {
        if(currentNode == null) return false;
        if(currentNode.value == value) return true;
        if(value < currentNode.value) {
            return rContains(currentNode.left, value);
        } else {
            return rContains(currentNode.right, value);
        }
    }

    public boolean rContains(int value){
        return rContains(root, value);
    }


    private Node rInsert(Node currentNode, int value) {
        if(currentNode == null) return new Node(value);
        if(value < currentNode.value) {
            currentNode.left = rInsert(currentNode.left, value);
        } else if(value > currentNode.value) {
            currentNode.right = rInsert(currentNode.right, value);
        }
        return currentNode;
    }

    public void rInsert(int value) {
        if (root == null) root = new Node(value);
        rInsert(root, value);
    }

    public int minValue(Node currentNode) {
        while (currentNode.left != null) {
            currentNode = currentNode.left;
        }
        return currentNode.value;

        //
//        if(currentNode.left == null) return currentNode.value;
//        return minValue(currentNode.left);
    }

    private Node deleteNode(Node currentNode, int value) {
        // Base case, tree is empty
        if (currentNode == null) return null;

        // Recurse down the tree
        if (value < currentNode.value) {
            // If less, go left
            currentNode.left = deleteNode(currentNode.left, value);
        } else if (value > currentNode.value) {
            // If more, go right
            currentNode.right = deleteNode(currentNode.right, value);
        } else {
            // Value is same as current's value, node to delete
            if (currentNode.left == null && currentNode.right == null) {
                // Node is a leaf node
                return null;
            } else if (currentNode.left == null) {
                // Node has only right child
                currentNode = currentNode.right;
            } else if (currentNode.right == null) {
                // Node has only left child
                currentNode = currentNode.left;
            } else {
                // Node has two children
                int subTreeMin = minValue(currentNode.right);
                // Replace with min in right subtree
                currentNode.value = subTreeMin;
                // Delete the minimum in right subtree
                currentNode.right = deleteNode(currentNode.right, subTreeMin);
            }
        }
        // Return the modified tree
        return currentNode;
    }

    public void deleteNode(int value) { root = deleteNode(root, value); }
}
