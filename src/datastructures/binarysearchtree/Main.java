package datastructures.binarysearchtree;

public class Main{
    public static void main(String[] args){
        BinarySearchTree myBst = new BinarySearchTree();
//        System.out.println("root="+ myBst.root);

        // Insert values
        myBst.insert(47);
        myBst.insert(21);
        myBst.insert(76);
        myBst.insert(18);
        myBst.insert(52);
        myBst.insert(82);


        System.out.println("value 27 insertion is: "+myBst.insert(27));
//        System.out.println("root="+ myBst.root.value);
//        System.out.println("root.left="+ myBst.root.left.value);
//        System.out.println("root.right="+ myBst.root.right.value);
//        System.out.println("root.left.left="+ myBst.root.left.left.value);
//        // value 27 should be inserted to the right of 21
//        System.out.println("root.left.right="+ myBst.root.left.right.value);
//        System.out.println("root.right.left="+ myBst.root.right.left.value);
//        System.out.println("root.right.right="+ myBst.root.right.right.value);
        //--------------------------------------------------------------------------------

        // Check if the tree contains a value
        System.out.println("BST Contains 27: " + myBst.contains(27)); // true
        System.out.println("BST Contains 53: " + myBst.contains(53)); // true


    }
}
