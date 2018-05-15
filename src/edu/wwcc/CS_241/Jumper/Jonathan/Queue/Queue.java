/*
 * Jonathan Jumper
 * CS241 JAVA II
 * edu.wwcc.CS_241.Jumper.Jonathan.Queue
 * 5/10/2018
 */
package edu.wwcc.CS_241.Jumper.Jonathan.Queue;

import edu.wwcc.CS_241.Jumper.Jonathan.SingleLL.LinkedList;
import edu.wwcc.CS_241.Jumper.Jonathan.SingleLL.Node;

/**
 * Queue class.
 * <p>
 * Have to use LinkedList<V> or Java bitches about unchecked types.
 * I ran into an error with my *public V dequeue()* method , Inside, I called my return removeFirst() method from my LL
 * Class,
 * Every bit of my code worked except for this one method call from the Queue class to the LL Class,
 * I checked the removeFirst() method in the LL Class and everything was fine.
 * It was giving me the error "uses unchecked or unsafe operations." . It was saying I wasn't returning the
 * right type (V) , but I was.
 * I decided to cast the type and it worked! However, after some research on Stack Overflow,
 * (https://stackoverflow.com/questions/197986/what-causes-javac-to-issue-the-uses-unchecked-or-unsafe-operations-warning),
 * I realized that "public class Queue<V>  insert V "extends LinkedList<V> {"
 */
@SuppressWarnings("WeakerAccess")
public class Queue<V> extends LinkedList<V> {
    //Since I am now extending LL class, This is duplicating of head in LL.
    //"extends" did that for me.
    //todo: this will be commented out as "list" will be replaced with "head"
//    private edu.wwcc.CS_241.Jumper.Jonathan.edu.wwcc.CS_241.Jumper.Jonathan.BinaryTree.BinaryTree.LinkedList<T> list;

    public Queue()
    {
        this.head = null;
    }

    public Queue(Node<V> list)
    {
        this.head = list;
    }

    public V dequeue()
    {
        return removeFirst();
    }

    public void enqueue(V value)
    {
        this.append(value);
    }

}
