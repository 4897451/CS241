/*
 * Jonathan Jumper
 * CS241 JAVA II
 * edu.wwcc.CS_241.Jumper.Jonathan.Stack
 * 5/10/2018
 */
package edu.wwcc.CS_241.Jumper.Jonathan.Stack;

import edu.wwcc.CS_241.Jumper.Jonathan.SingleLL.LinkedList;
import edu.wwcc.CS_241.Jumper.Jonathan.SingleLL.Node;

/**
 * Stack class.
 * <p>
 * Have to use LinkedList<V> or Java bitches about unchecked types.
 * I ran into an error with my *public V dequeue()* method , Inside, I called my return removeFirst() method from my LL
 * Class,
 * Every bit of my code worked except for this one method call from the Stack class to the LL Class,
 * I checked the removeFirst() method in the LL Class and everything was fine.
 * It was giving me the error "uses unchecked or unsafe operations." . It was saying I wasn't returning the
 * right type (V) , but I was.
 * I decided to cast the type and it worked! However, after some research on Stack Overflow,
 * (https://stackoverflow.com/questions/197986/what-causes-javac-to-issue-the-uses-unchecked-or-unsafe-operations-warning),
 * I realized that "public class Stack<V>  insert V "extends LinkedList<V> {"
 */
@SuppressWarnings("WeakerAccess")
public class Stack<V> extends LinkedList<V> {
    //Since I am now extending LL class, This is duplicating of head in LL.
    //"extends" did that for me.
    //todo: this will be commented out as "list" will be replaced with "head"
//    private edu.wwcc.CS_241.Jumper.Jonathan.edu.wwcc.CS_241.Jumper.Jonathan.BinaryTree.BinaryTree.LinkedList<T> list;

    public Stack()
    {
        this.head = null;
    }

    public Stack(Node<V> list)
    {
        this.head = list;
    }

    public V pop()
    {
        return removeFirst();
    }

    public void push(V value)
    {
        this.prepend(value);
    }

    /**
     * @return
     */
    public int size()
    {
        return length();
    }
}
