package datastructures.stack;

public class Main {

    /**
     * LEETCODE QUESTION
     * Reverse a string using a stack
     * @param str - string to reverse
     * @return reversed string
     */
    public static String reverseString(String str) {
        GenericStack<Character> reversedStack = new GenericStack<>();
        for(int i=0;i<str.length();i++) {
            reversedStack.push(str.charAt(i));
        }
        String reversedString = "";
        while(!reversedStack.isEmpty()) {
            reversedString += reversedStack.pop();
        }
        return reversedString;
    }

    /**
     * LEETCODE QUESTION
     * Check if the parentheses in a string are balanced
     * @param parentheses - string to check
     * @return true if balanced, false otherwise
     */
    public static boolean isBalancedParentheses(String parentheses) {
        // Brute force solution
//        GenericStack<Character> myStack = new GenericStack<>();
//
//        for (int i = 0; i< parentheses.length(); i++) {
//            myStack.push(parentheses.charAt(i));
//        }
//        int count = 0;
//        while(!myStack.isEmpty()) {
//            Character currentChar = myStack.pop();
//            if(count < 0) {
//                return false;
//            } else if(count == 0 && currentChar == '(') {
//                return false;
//            } else if (currentChar == ')') {
//                count++;
//            } else if (currentChar == '(') {
//                count--;
//            }
//        }
//        return count == 0;

        // Optimized solution
        GenericStack<Character> stack = new GenericStack<>();
        for (char p : parentheses.toCharArray()) {
            if (p == '(') {
                stack.push(p);
            } else if (p == ')') {
                if (stack.isEmpty() || stack.pop() != '(') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    /**
     * Helper function to test and print the result of the isBalancedParentheses function
     * @param testStr - string to test
     * @param expected - expected result
     */
    public static void testAndPrint(String testStr, boolean expected) {
        // Run the test and store the result
        boolean result = isBalancedParentheses(testStr);

        // Print the test string, expected result, and actual result
        System.out.println("Test String: " + testStr);
        System.out.println("EXPECTED: " + expected);
        System.out.println("RESULT: " + result);

        // Check if the test passed or failed
        if (result == expected) {
            System.out.println("STATUS: PASS");
        } else {
            System.out.println("STATUS: FAIL");
        }

        // Print a separator for better readability
        System.out.println("--------------");
    }


    /**
     * LEETCODE QUESTION
     * Sort a stack using an additional stack
     * @param stack - the stack to sort
     */
    public static void sortStack(GenericStack<Integer> stack) {
        GenericStack<Integer> additionalStack = new GenericStack<>();

        while (!stack.isEmpty()) {
            int temp = stack.pop();

            // using for loop instead of while loop
//            int initialSize = additionalStack.size();
//            for (int i = 0;i<initialSize ;i++ ) {
//                if(additionalStack.isEmpty() || temp > additionalStack.peek()) {
//                    break;
//                }
//                stack.push(additionalStack.pop());
//            }

            while (!additionalStack.isEmpty() && additionalStack.peek() > temp) {
                stack.push(additionalStack.pop());
            }

            additionalStack.push(temp);
        }

        while (!additionalStack.isEmpty()) {
            stack.push(additionalStack.pop());
        }
    }


    public static void main(String[] args) {
        Stack myStack = new Stack(2);
        myStack.push(1);
        myStack.printStack();
        System.out.println("Pop: "+myStack.pop().value);


        //--------------------------------------------------------------------------------
        // Test cases for reverse string
//        String myString = "hello";
//        String reversedString = reverseString(myString);
//        System.out.println(reversedString);

        /*
            EXPECTED OUTPUT:
            ----------------
            olleh
        */

        //--------------------------------------------------------------------------------
        // Test cases for balanced parentheses
//        testAndPrint("()", true);
//        testAndPrint("()()", true);
//        testAndPrint("(())", true);
//        testAndPrint("()()()", true);
//        testAndPrint("(()())", true);
//        testAndPrint(")()(", false);
//        testAndPrint(")(", false);
//        testAndPrint("(()", false);
//        testAndPrint("))", false);
//        testAndPrint("(", false);
//        testAndPrint(")", false);
        //--------------------------------------------------------------------------------


        // Test cases for sorting a stack
        GenericStack<Integer> stack = new GenericStack<>();
        stack.push(3);
        stack.push(1);
        stack.push(4);
        stack.push(2);

        System.out.println("Before sorting:");
        stack.printStack();

        sortStack(stack);

        System.out.println("\nAfter sorting:");
        stack.printStack();


    }
}
