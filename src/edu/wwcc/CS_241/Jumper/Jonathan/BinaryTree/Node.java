/*
 * Jonathan Jumper
 * CS241 JAVA II
 * Linked Lists
 * 4-12-18
 */
package edu.wwcc.CS_241.Jumper.Jonathan.BinaryTree;

/**
 * Node class.
 */
@SuppressWarnings("WeakerAccess")
public class Node<V extends Comparable<V>> implements Comparable<Node<V>>
{
    /**
     * Default value constructor.
     */
    public Node()
    {
        this.value = null;
        this.left = null;
        this.right = null;
    }

    /**
     * Value only constructor.
     *
     * @param value <V>
     */
    public Node(V value)
    {
        this.ancestor = null;
        this.value = value;
        this.left = null;
        this.right = null;
    }

    /**
     * Full constructor with Nodes.
     *
     * @param value    V
     * @param ancestor Node<V>
     * @param left     Node<V>
     * @param right    Node<V>
     */
    public Node(V value, Node<V> ancestor, Node<V> left, Node<V> right)
    {
        this.ancestor = ancestor;
        this.value = value;
        this.left = left;
        this.right = right;
    }

    /**
     * Full constructor with values.
     *
     * @param value V
     * @param left  V
     * @param right V
     */
    public Node(V value, V left, V right)
    {
        this.ancestor = null;
        this.value = value;
        this.left = new Node<>(left);
        this.right = new Node<>(right);
    }

    /**
     * Optional value and left constructor.
     * <p>
     * If you need this one probably should add one with right as well.
     *
     * @param value <V>
     * @param left  Node<V>
     */
    public Node(V value, Node<V> left)
    {
        this.value = value;
        this.left = left;
    }

    @Override
    public int compareTo(Node<V> other)
    {
        return this.getValue().compareTo(other.getValue());
    }

    /**
     * @return Node<V>
     */
    public Node<V> getAncestor()
    {
        return ancestor;
    }

    /**
     * @return V
     */
    public V getAncestorValue()
    {
        return getAncestor().getValue();
    }

    /**
     * @return Node<V>
     */
    public Node<V> getLeft()
    {
        return left;
    }

    /**
     * @return Node<V>
     */
    public Node<V> getRight()
    {
        return right;
    }

    /**
     * With fluent setters. Node<V> junk = new Node<>(5); T myValue = junk->setLeft(1)->getValue(); print(myValue); //
     * prints 5.
     * <p>
     * Without fluent setters. Node<V> junk = new Node<>(5); junk->setLeft(1); T myValue = junk->getValue();
     * print(myValue); // prints 5.
     *
     * @return <V>
     */
    public V getValue()
    {
        return this.value;
    }

    /**
     * @param value V
     *
     * @return Node<V> Fluent interface.
     */
    public Node<V> setAncestor(V value)
    {
        return setAncestor(new Node<>(value));
    }

    /**
     * @param ancestor Node<V>
     *
     * @return Node<V> Fluent interface.
     */
    public Node<V> setAncestor(Node<V> ancestor)
    {
        this.ancestor = ancestor;
        return this;
    }

    /**
     * Node<Integer> junk; junk is an instance of Node<V>. With fluent interface. junk->setValue(5)->setLeft(1)->setRight(10);
     * <p>
     * Without fluent interface. junk->setValue(5); junk->setLeft(1); junk->setRight(10);
     *
     * @param value V
     *
     * @return Node<V> Fluent interface.
     */
    public Node<V> setLeft(V value)
    {
        return setLeft(new Node<>(value));
    }

    /**
     * @param left Node<V>
     *
     * @return Node<V> Fluent interface.
     */
    public Node<V> setLeft(Node<V> left)
    {
        this.left = left;
        return this;
    }

    /**
     * @param value V
     *
     * @return Node<V> Fluent interface.
     */
    public Node<V> setRight(V value)
    {
        return setRight(new Node<>(value));
    }

    /**
     * @param right Node<V>
     *
     * @return Node<V> Fluent interface.
     */
    public Node<V> setRight(Node<V> right)
    {
        this.right = right;
        return this;
    }

    /**
     * @param value V
     *
     * @return Node<V> Fluent interface.
     */
    public Node<V> setValue(V value)
    {
        this.value = value;
        return this;
    }

    /**
     * Holds reference to the current Node's ancestor Node.
     */
    private Node<V> ancestor;
    /**
     * Holds reference to the current Node's left Node.
     */
    private Node<V> left;
    /**
     * Holds reference to the current Node's right Node.
     */
    private Node<V> right;
    /**
     * Hold the value of the node.
     */
    private V value;
}
