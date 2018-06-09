/*
 * Jonathan Jumper
 * CS241 JAVA II
 * Queues Stacks and Generics (Single LL)
 * 4-12-18
 */
package edu.wwcc.CS_241.Jumper.Jonathan.BinaryTree;

public class Main {
    public static void main(String[] args)
    {
        //TODO
        try {
            LinkedList<Integer> ll = new LinkedList<>();
            System.out.println();
            System.out.println("Appending 555 and 777");
            ll.append(555).append(777);
            System.out.println(ll);
            System.out.println("LinkedList length = " + ll.size());
            System.out.println();
            System.out.println("Prepending 888");
            // ll.prepend(888);
            System.out.println(ll);
            System.out.println("LinkedList length = " + ll.size());
            System.out.println();
            System.out.println("Removing Node at index 1");
            //System.out.println("Removed Node value = " + ll.removeAt(1));
            System.out.println(ll);
            System.out.println("LinkedList length = " + ll.size());
            System.out.println();
            System.out.println("Inserting 444 at index = 1");
            //ll.insertAt(1, 444);
            System.out.println(ll);
            System.out.println("LinkedList length = " + ll.size());
            System.out.println();
            //System.out.println("Replace " + ll.replaceAt(1, 333) + " at index = 1 with 333");
            System.out.println(ll);
            System.out.println("LinkedList length = " + ll.size());
            System.out.println();
            // System.out.println("Removing first (" + ll.removeFirst() + ")");
            System.out.println(ll);
            System.out.println("LinkedList length = " + ll.size());
            System.out.println();
            //  System.out.println("Removing last (" + ll.removeLast() + ")");
            System.out.println(ll);
            System.out.println("LinkedList length = " + ll.size());
            System.out.println();
        } catch (Exception e) {
            System.out.println("Caught unexpected exception:");
            e.printStackTrace();
        }
    }
}
