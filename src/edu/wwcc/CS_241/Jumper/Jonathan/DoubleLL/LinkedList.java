package edu.wwcc.CS_241.Jumper.Jonathan.DoubleLL;
/*
 * Jonathan Jumper
 * CS241 JAVA II
 * edu.wwcc.cs241.Jumper.Jonathan
 * 5/2/2018
 */

/**
 * @brief List of Nodes.
 * <p>
 * Needs basic CRUD (Create, Read, Update, Delete) methods.
 * <p>
 * Create: constructors Read: getters Updates: setters Delete: out of scope (destroy var or node)
 * <p>
 * Not changing my LinkedList I'm changing my Nodes, except the intial Node.
 */
@SuppressWarnings("WeakerAccess")
public class LinkedList<V>
{
    private Node<V> node;

    /**
     * Constructor
     */
    public LinkedList()
    {
        this.node = null;
    }

    /**
     * Constructor with Node param.
     *
     * @param node Node<V>
     */
    public LinkedList(Node<V> node)
    {
        this.node = node;
    }

    /**
     * Append generic value as new Node to LL.
     *
     * @param value Generic value for new Node.
     */
    public void append(V value)
    {
        Node<V> node = new Node<>(value);
        if (null != this.node) {
            node.setNext(this.node);
        }
        this.node = node;
    }

    /**
     * Append new Node to LL.
     *
     * @param node New node to be prepend to LL.
     */
    public void append(Node<V> node)
    {
        if (null == this.node) {
            this.node = node;
            return;
        }
        //find the end of the ll and append to it.
        Node<V> last = this.node.getLast();
        last.setNext(node);
        node.setPrev(last);
    }

    /**
     * @return int Returns length of LL.
     */
    public int length()
    {
        int count = 0;
        Node<V> current = this.node;
        while (current != null) {
            current = current.getNext();
            ++count;
        }
        return count;
    }

    /**
     * Prepend new Node to LL.
     *
     * @param node New node to be prepend to LL.
     */
    public void prepend(Node<V> node)
    {
        if (null != node.getNext()) {
            throw new IllegalArgumentException("Can not Prepend node with prev property set (has a value)");
        }
        if (null != this.node) {
        }
    }

    /**
     * Setter for node property.
     *
     * @param node Node to use as start of LL.
     */
    public void setNode(Node<V> node)
    {
        this.node = node;
    }

    /**
     * @return String
     */
    public String toString()
    {
        return node.toString();
    }
}
