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


//        System.out.println("value 27 insertion is: "+myBst.insert(27));
//        System.out.println("root="+ myBst.root.value);
//        System.out.println("root.left="+ myBst.root.left.value);
//        System.out.println("root.right="+ myBst.root.right.value);
//        System.out.println("root.left.left="+ myBst.root.left.left.value);
//        // value 27 should be inserted to the right of 21
//        System.out.println("root.left.right="+ myBst.root.left.right.value);
//        System.out.println("root.right.left="+ myBst.root.right.left.value);
//        System.out.println("root.right.right="+ myBst.root.right.right.value);
        //--------------------------------------------------------------------------------

//        // Check if the tree contains a value
//        System.out.println("BST Contains 27: " + myBst.contains(27)); // true
//        System.out.println("BST Contains 53: " + myBst.contains(53)); // false

//        System.out.println("BST Contains 21: " + myBst.rContains(21)); // true
//        System.out.println("BST Contains 17: " + myBst.rContains(17)); // false


        //--------------------------------------------------------------------------------
        // Test cases for recursive insert
//        BinarySearchTree myBST = new BinarySearchTree();
//        myBST.rInsert(2);
//        myBST.rInsert(1);
//        myBST.rInsert(3);
//
//        System.out.println("Root: " + myBST.getRoot().value);
//        System.out.println("\nRoot->Left: " + myBST.getRoot().left.value);
//        System.out.println("\nRoot->Right: " + myBST.getRoot().right.value);

//        System.out.println(myBst.minValue( myBst.getRoot() ));
//
//        System.out.println(myBst.minValue( myBst.getRoot().right ));



        BinarySearchTree myBST = new BinarySearchTree();

        myBST.insert(2);
        myBST.insert(1);
        myBST.insert(3);

        /*
               2
              / \
             1   3
        */

        System.out.println( "Root: " + myBST.getRoot().value );
        System.out.println( "Root->Left: " + myBST.getRoot().left.value );
        System.out.println( "Root->Right: " + myBST.getRoot().right.value );


        myBST.deleteNode(2);

        /*
               3
              / \
             1  null
        */


        System.out.println( "\nRoot: " + myBST.getRoot().value );
        System.out.println( "Root->Left: " + myBST.getRoot().left.value );
        System.out.println( "Root->Right: " + myBST.getRoot().right );


        /*
            EXPECTED OUTPUT:
            ----------------
			Root: 2
			Root->Left: 1
			Root->Right: 3

			Root: 3
			Root->Left: 1
			Root->Right: null

        */


    }
}
