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
    private Node<V> next;
    private Node<V> prev;
    private V value;

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
     * @param node Node<V>
     */
    public void setNext(Node<V> node)
    {
        this.next = node;
    }

    /**
     * @return Node<V>
     */
    public Node<V> getPrev()
    {
        return prev;
    }

    /**
     * @param node Node<V>
     */
    public void setPrev(Node<V> node)
    {
        this.prev = node;
    }

    /**
     * @return V
     */
    public V getValue()
    {
        return value;
    }

    /**
     * @return String
     */
    public String toString()
    {
        String result = "Value(" + value + ")--->";
        if (null != next) {
            result += next.toString();
        }
        return result;
    }
}
