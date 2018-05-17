package edu.wwcc.CS_241.Jumper.Jonathan.DoubleLL;/*
 * Jonathan Jumper
 * CS241 JAVA II
 * edu.wwcc.cs241.Jumper.Jonathan
 * 5/1/2018
 */

// Using V for generic value instead of N to follow normal conventions.
@SuppressWarnings("WeakerAccess")
public class Node<V>
{
    /**
     * Default value constructor.
     */
    public Node()
    {
        this.value = null;
        this.prev = null;
        this.next = null;
    }

    /**
     * All properties Constructor.
     *
     * @param value V
     * @param prev  Node<V>
     * @param next  Node<V>
     */
    public Node(V value, Node<V> prev, Node<V> next)
    {
        this.value = value;
        this.prev = prev;
        this.next = next;
    }

    /**
     * Value only Constructor.
     *
     * @param value V
     */
    public Node(V value)
    {
        this.value = value;
        this.prev = null;
        this.next = null;
    }

    /**
     * @return Node<V>
     */
    public Node<V> getNext()
    {
        return this.next;
    }

    /**
     * @return Node<V>
     */
    public Node<V> getPrev()
    {
        return prev;
    }

    /**
     * @return V
     */
    public V getValue()
    {
        return value;
    }

    /**
     * @param node Node<V>
     *
     * @return Node<V> Fluent interface.
     */
    public Node<V> setNext(Node<V> node)
    {
        this.next = node;
        return this;
    }

    /**
     * @param node Node<V>
     *
     * @return Node<V> Fluent interface.
     */
    public Node<V> setPrev(Node<V> node)
    {
        this.prev = node;
        return this;
    }

    /**
     * Holds reference to next node.
     */
    private Node<V> next;
    /**
     * Holds reference to prev node.
     */
    private Node<V> prev;
    /**
     * Holds the value that makes the node special.
     */
    private V value;
}
