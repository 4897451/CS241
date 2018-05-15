/*
 * Jonathan Jumper
 * CS241 JAVA II
 * Linked Lists
 * 4-12-18
 */
package edu.wwcc.CS_241.Jumper.Jonathan.BinaryTree;
/**
 * NODE CLASS
 */
@SuppressWarnings("WeakerAccess")
public class Node<T> {
    private Node<T> left;
    private Node<T> right;
    private T value;

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
     * @param value
     *     <T>
     */
    public Node(T value)
    {
        this.value = value;
        this.left = null;
        this.right = null;
    }

    /**
     * Full constructor with Nodes.
     *
     * @param value
     * @param left
     * @param right
     */
    public Node(T value, Node<T> left, Node<T> right)
    {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    /**
     * Full constructor with values.
     *
     * @param value
     * @param left
     * @param right
     */
    public Node(T value, T left, T right)
    {
        this.value = value;
        this.left = new Node<>(left);
        this.right = new Node<>(right);
    }

    /**
     * Optional value and left constructor.
     *
     * If you need this one probably should add one with right as well.
     *
     * @param value
     *     <T>
     * @param left
     *     edu.wwcc.CS_241.Jumper.Jonathan.edu.wwcc.CS_241.Jumper.Jonathan.BinaryTree.BinaryTree.Node<T>
     */
    public Node(T value, Node<T> left)
    {
        this.value = value;
        this.left = left;
    }
    // Begin Getters and Setters

    /**
     * @return edu.wwcc.CS_241.Jumper.Jonathan.edu.wwcc.CS_241.Jumper.Jonathan.BinaryTree.BinaryTree.Node<T>
     */
    public Node<T> getLeft()
    {
        return left;
    }

    /**
     * @param value
     *     T
     */
    public Node<T> setRight(T value)
    {
        this.right = new Node<>(value);
        return this;
    }

    /**
     * edu.wwcc.CS_241.Jumper.Jonathan.edu.wwcc.CS_241.Jumper.Jonathan.BinaryTree.BinaryTree.Node<Integer> junk;
     * junk is an instance of edu.wwcc.CS_241.Jumper.Jonathan.edu.wwcc.CS_241.Jumper.Jonathan.BinaryTree.BinaryTree.Node<T>.
     * With fluent interface.
     * junk->setValue(5)->setLeft(1)->setRight(10);
     * <p>
     * Without fluent interface.
     * junk->setValue(5);
     * junk->setLeft(1);
     * junk->setRight(10);
     *
     * @param value
     *     T
     */
    public Node<T> setLeft(T value)
    {
        this.left = new Node<>(value);
        return this;
    }

    /**
     * @return edu.wwcc.CS_241.Jumper.Jonathan.edu.wwcc.CS_241.Jumper.Jonathan.BinaryTree.BinaryTree.Node<T>
     */
    public Node<T> getRight()
    {
        return right;
    }

    /**
     * @param right
     *     edu.wwcc.CS_241.Jumper.Jonathan.edu.wwcc.CS_241.Jumper.Jonathan.BinaryTree.BinaryTree.Node<T>
     */
    public Node<T> setRight(Node<T> right)
    {
        this.right = right;
        return this;
    }

    /**
     *
     * With fluent setters.
     * edu.wwcc.CS_241.Jumper.Jonathan.edu.wwcc.CS_241.Jumper.Jonathan.BinaryTree.BinaryTree.Node<T> junk = new edu.wwcc.CS_241.Jumper.Jonathan.edu.wwcc.CS_241.Jumper.Jonathan.BinaryTree.BinaryTree.Node<>(5);
     * T myValue = junk->setLeft(1)->getValue();
     * print(myValue); // prints 5.
     *
     * Without fluent setters.
     * edu.wwcc.CS_241.Jumper.Jonathan.edu.wwcc.CS_241.Jumper.Jonathan.BinaryTree.BinaryTree.Node<T> junk = new edu.wwcc.CS_241.Jumper.Jonathan.edu.wwcc.CS_241.Jumper.Jonathan.BinaryTree.BinaryTree.Node<>(5);
     * junk->setLeft(1);
     * T myValue = junk->getValue();
     * print(myValue); // prints 5.
     *
     * @return <T>
     */
    public T getValue()
    {
        return this.value;
    }

    /**
     * @param left
     *     edu.wwcc.CS_241.Jumper.Jonathan.edu.wwcc.CS_241.Jumper.Jonathan.BinaryTree.BinaryTree.Node<T>
     */
    public Node<T> setLeft(Node<T> left)
    {
        this.left = left;
        return this;
    }

    /**
     * @param value
     *     T
     */
    public Node<T> setValue(T value)
    {
        this.value = value;
        return this;
    }
}
