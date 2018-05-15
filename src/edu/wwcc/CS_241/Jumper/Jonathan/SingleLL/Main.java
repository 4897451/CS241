/*
 * Jonathan Jumper
 * CS241 JAVA II
 * Linked Lists
 * 4-12-18
 */
package edu.wwcc.CS_241.Jumper.Jonathan.SingleLL;
/*
 * <CREDITS>
 * This is the prepend method I build with inspiration
 * used by the resources below and some code by Nick Ferraro
 * and modified by Jonathan Jumper
 *
 *<SOURCES>
 * used prepend tutorial @
 * LinkedList in Java for Beginners Part 3 : Prepend Method
 * https://www.youtube.com/watch?v=jnc4BgWwW1M
 */

/*
 * These are here to remind me of some of the libraries
 * we may use
 *
 * import java.util.ArrayList;
 * import java.lang.reflect.Method;
 */

/*
 * MAIN METHOD
 */

import java.util.Random;

/**
 * Project main class.
 */
public class Main {
    public static void main(String[] args)
    {
        LinkedList<Integer> ll = new LinkedList<>();
        System.out.println("\nLinkedList length = " + ll.length());
        ll.print();
        ll.append(111);
        System.out.println("* CREATED FIRST NODE *");
        System.out.println("\nLinkedList length = " + ll.length());
        ll.print();
        System.out.println();
        ll.append(222);
        ll.append(333);
        System.out.println("* Finished appending and creating the LinkedList. 111,222,333 *");
        System.out.println("\nLinkedList length = " + ll.length());
        ll.print();
        System.out.println();
        System.out.println("* Prepend Method (added 444 to beginning) *");
        ll.prepend(444);
        System.out.println("\nLinkedList length = " + ll.length());
        ll.print();
        System.out.println();
        System.out.println("* REMOVE AT INDEX 0 *");
        ll.removeAt(0);
        System.out.println("\nLinkedList length = " + ll.length());
        ll.print();
        System.out.println();
        System.out.println("* REMOVE FIRST *");
        ll.removeFirst();
        System.out.println("\nLinkedList length = " + ll.length());
        ll.print();
        System.out.println();
        System.out.println("* REMOVE LAST *");
        ll.removeLast();
        System.out.println("\nLinkedList length = " + ll.length());
        ll.print();

        /*
         * Random for insertAt() method
         */
        System.out.println("\n* STARTING RANDOM INSERT AT INDEX *\n");
        Random r = new Random();
        int i = 0, num = 5;
        do
        {
            ll.print();
            System.out.println("LinkedList length = " + ll.length() + "\n");
            int value = r.nextInt(10);
            int position = r.nextInt(6);
            System.out.println("Inserting value: " + "*" + value * 111 + "*" + " at index: " + position);
            /*
             * Calling insertAt() method
             */
            try
            {
                ll.insertAt(value * 111, position);
            } catch (IndexOutOfBoundsException e)
            {
                //TODO: whatever. Exception is held with a try/catch
                // (will continue until random has legal index value)
                continue;
            }
            ++i;
        } while (i < num);
        ll.print();
        System.out.println("Final LinkedList length = " + ll.length());
      /*  for (int i = 0; i < 5; i++)
        {
            ll.print();
            System.out.println("LinkedList length = " + ll.length() + "\n");
            int value = r.nextInt(10);
            int position = r.nextInt(6);
            System.out.println("Inserting value: " + "*" + value + "*" + " at index: " + position);
            /*
             * Calling insertAt() method
             */
          /*  try
            {
                ll.insertAt(value, position);
            } catch (Exception e)
            {
                //TODO: whatever. Converted this for loop to do/while loop with try catch
            }
        }*/
        // System.out.println("Final LinkedList length = " + ll.length());
    }
}
