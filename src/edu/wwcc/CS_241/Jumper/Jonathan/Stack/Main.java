/*
 * Jonathan Jumper
 * CS241 JAVA II
 * edu.wwcc.CS_241.Jumper.Jonathan.Stack
 * 5/10/2018
 */
package edu.wwcc.CS_241.Jumper.Jonathan.Stack;

import java.util.Random;

public class Main {
    public static void main(String[] args)
    {
        Stack<Integer> stack = new Stack<>();

        /*
         * Random for insertAt() method
         */
        System.out.println("\n* STARTING RANDOM INSERT AT INDEX *\n");
        Random r = new Random();
        int i = 0, num = 5;
        do
        {
            stack.print();
            System.out.println("LinkedList length = " + stack.length() + "\n");
            int value = r.nextInt(10);
            int position = r.nextInt(6);
            System.out.println("Inserting value: " + "*" + value * 111 + "*" + " at index: " + position);
            /*
             * Calling insertAt() method
             */
            try
            {
                stack.insertAt(value * 111, position);
            } catch (IndexOutOfBoundsException e)
            {
                //TODO: whatever. Exception is held with a try/catch
                // (will continue until random has legal index value)
                continue;
            }
            ++i;
        } while (i < num);
        System.out.println();
        System.out.println("*** Stack methods testing ***");
        System.out.println();
        System.out.println(stack);
        System.out.println("LinkedList size = " + stack.size());
        System.out.println();
        System.out.println("Pushing 1001");
        stack.push(1001);
        System.out.println(stack);
        System.out.println("LinkedList size = " + stack.size());
        System.out.println();
        System.out.println("Popping " + stack.pop());
        System.out.println(stack);
        System.out.println("LinkedList size = " + stack.size());
        System.out.println();
        System.out.println("Peeking at top value = " + stack.peek());
        System.out.println(stack);
    }
}
