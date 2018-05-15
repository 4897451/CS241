/*
 * Jonathan Jumper
 * CS241 JAVA II
 * Linked Lists
 * 4-12-18
 */
package edu.wwcc.CS_241.Jumper.Jonathan.SingleLL;

/**
 * NODE CLASS
 */
@SuppressWarnings("WeakerAccess")
public class Node<V> {
    private Node<V> next;
    private V value;

    /**
     * Default value constructor.
     */
    public Node()
    {
        this(null, null);
    }

    /**
     * Value only constructor.
     *
     * @param value
     *     <V>
     */
    public Node(V value)
    {
        this.value = value;
        this.next = null;
    }

    /**
     * Optional all value constructor.
     *
     * @param value
     *     <V>
     * @param next
     *     Node<V>
     */
    public Node(V value, Node<V> next)
    {
        this.value = value;
        this.next = next;
    }
    // Begin Getters and Setters

    /**
     * @return Node<V>
     */
    public Node<V> getNext()
    {
        return this.next;
    }

    /**
     * @param next
     *     Node<V>
     *
     * @return Node<V>
     */
    public Node<V> setNext(Node<V> next)
    {
        this.next = next;
        return this;
    }

    /**
     * @return <V>
     */
    public V getValue()
    {
        return this.value;
    }

    /**
     * @param value V
     *
     * @return Node<V>
     */
    public Node<V> setValue(V value)
    {
        this.value = value;
        return this;
    }
}
