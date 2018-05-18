package edu.wwcc.CS_241.Jumper.Jonathan.DoubleLL;
/*
 * Jonathan Jumper
 * CS241 JAVA II
 * edu.wwcc.cs241.Jumper.Jonathan
 * 5/2/2018
 */

/**
 * Linked list of Nodes.
 * <p>
 * Needs basic CRUD (Create, Read, Update, Delete) methods.
 * <p>
 * Create: constructors, Read: getters, Updates: setters, Delete: out of scope for LL itself.
 * <p>
 * Not changing my LinkedList I'm changing my Nodes, except the initial Node.
 */
@SuppressWarnings("WeakerAccess")
public class LinkedList<V>
{
    /**
     * Constructor
     */
    public LinkedList()
    {
        node = null;
        count = 0;
    }

    /**
     * Constructor with Node param.
     * <p>
     * Jonathan speak.
     *
     * @param newNode Node<V>
     */
    public LinkedList(Node<V> newNode)
    {
        node = newNode;
        count = length();
    }

    /**
     * Append generic value as new Node to LL.
     *
     * @param value Generic value for new Node.
     *
     * @return LinkedList<V> Fluent interface.
     */
    public LinkedList<V> append(V value)
    {
        return append(new Node<>(value)); //creates new node and call other append() method
        // when 1st append() method is called
        // this uses node constructor from Node(class)
        // so, the new node has the value and the pointers are both null at this point.
    }

    /**
     * Append new Node to LL.
     *
     * @param newNode New Node to be prepend to LL.
     *
     * @return LinkedList<V> Fluent interface.
     */
    public LinkedList<V> append(Node<V> newNode)
    {
        if (null != this.node) {
            //find the end of the ll and append to it.
            Node<V> last = getLast(); //used to be Traveler (last)
            last.setNext(newNode);
            newNode.setPrev(last);
        } else {
            this.node = newNode;
        }
        ++this.count;
        return this;
    }

    /**
     * Get first node of LL.
     *
     * @return Node<V>
     */
    public Node<V> getFirst()
    {
        return node;
    }

    /**
     * Got last linked node.
     *
     * @return Node<L>|null Returns Node or NULL.
     * @throws IndexOutOfBoundsException Throws IndexOutOfBoundsException when LL is empty.
     */
    public Node<V> getLast()
    {
        if (null != this.node) {
            // Start with first Node.
            Node<V> last = this.node;
            while (null != last.getNext()) { // replaces Next pointer value in LL
                last = last.getNext();
            }
            return last;
        } else {
            throw new IndexOutOfBoundsException(" * Linked list is empty * ");
        }
    }

    /**
     * Insert a new node at the given index.
     *
     * @param index   Where to insert new node.
     * @param newNode Node to be inserted.
     *
     * @return LinkedList<V> Fluent interface.
     */
    public LinkedList<V> insertAt(int index, Node<V> newNode)
    {
        // Handle inserting at start of LL.
        if (0 == index) {
            return prepend(newNode);
        }
        // Handle inserting at end of LL.
        if (count == index) {
            return append(newNode);
        }
        // Find the middle insertion point.
        Node<V> located = findAt(index);
        // Set new node to point to prev node.
        newNode.setPrev(located.getPrev());
        // Point prev node to new node.
        newNode.getPrev().setNext(newNode);
        // Point located node to new node.
        located.setPrev(newNode);
        // Point new node to located node.
        newNode.setNext(located);
        ++count;
        return this;
    }

    /**
     * Insert a new value at the given index.
     *
     * @param index Where to insert new value.
     * @param value Value to be inserted.
     *
     * @return LinkedList<V> Fluent interface.
     */
    public LinkedList<V> insertAt(int index, V value)
    {
        return insertAt(index, new Node<>(value));
    }

    /**
     * @return int Returns length of LL.
     */
    public int length()
    {
        int count = 0;
        Node<V> current = node;
        while (null != current) {
            current = current.getNext();
            ++count;
        }
        return count;
    }

    /**
     * Prepend new Node to LL.
     *
     * @param newNode New Node to be prepend to LL.
     *
     * @return LinkedList<V>
     */
    public LinkedList<V> prepend(Node<V> newNode)
    {
        // Checks to see if its the only newNode
        if (null != node) {
            newNode.setNext(node);
            node.setPrev(newNode);
            node = newNode;
        } else {
            node = newNode;
        }
        ++count;
        return this;
    }

    /**
     * Prepend new value to LL.
     *
     * @param value New value to be prepend to LL.
     *
     * @return LinkedList<V>
     */
    public LinkedList<V> prepend(V value)
    {
        return prepend(new Node<>(value));
    }

    /**
     * @param index int
     *
     * @return V
     */
    public V removeAt(int index)
    {
        // Handle removing at start of LL.
        if (0 == index) {
            return removeFirst();
        }
        // Find Node to be removed.
        Node<V> remove = findAt(index);
        // Only need to update prev if it is not null.
        if (null != remove.getPrev()) {
            // Update prev Node's next with next Node of Node being removed.
            // Could be Node or null it does not matter.
            remove.getPrev().setNext(remove.getNext());
        }
        // Only need to update prev if next is a Node.
        // Can't update if it is null.
        if (null != remove.getNext()) {
            // Update next Node's prev with prev Node of Node being removed.
            remove.getNext().setPrev(remove.getPrev());
        }
        --count;
        // Assist garbage collection by clearing prev and next before returning value.
        return remove.setPrev(null).setNext(null).getValue();
    }

    /**
     * @return V
     */
    public V removeFirst()
    {
        if (null == node) {
            throw new IndexOutOfBoundsException(" * LinkedList is empty * ");
        }
        V value = node.getValue();
        node = node.getNext();
        if (null != node) {
            node.setPrev(null);
        }
        --count;
        return value;
    }

    /**
     * @return <L>
     */
    public V removeLast()
    {
        return removeAt(count - 1);
    }

    /**
     * Replace node at the given index.
     *
     * @param index   Where to insert new node.
     * @param newNode Node to replace with.
     *
     * @return Node<V> Returns the replaced node.
     */
    public Node<V> replaceAt(int index, Node<V> newNode)
    {
        // Find the replacement point.
        Node<V> located = findAt(index);
        // Set new node to point to prev node.
        newNode.setPrev(located.getPrev());
        // Point new node to next node.
        newNode.setNext(located.getNext());
        // Only update when a prev node.
        if (null != located.getPrev()) {
            // Point prev node to new node.
            located.getPrev().setNext(newNode);
        }
        // Only update when a next node.
        if (null != located.getNext()) {
            // Point next node back to new node.
            located.getNext().setPrev(newNode);
        }
        // Break prev and next links before returning.
        return located.setPrev(null).setNext(null);
    }

    /**
     * Replace value at the given index.
     *
     * @param index Where to insert new node.
     * @param value Value to replace with.
     *
     * @return V Returns the replaced value.
     */
    public V replaceAt(int index, V value)
    {
        return replaceAt(index, new Node<>(value)).getValue();
    }

    /**
     * Setter for node property.
     *
     * @param newNode Node to use as start of LL.
     *
     * @return LinkedList<V>
     */
    public LinkedList<V> setNode(Node<V> newNode)
    {
        node = newNode;
        count = length();
        return this;
    }

    /**
     * This just returns the value of count property (method in jonathan speak)
     *
     * @return int
     */
    public int size()
    {
        return count;
    }

    /**
     * @return String
     */
    public String toString()
    {
        String output = "";
        Node<V> traveler = node;
        while (null != traveler) {
            output = output.concat("Value(" + traveler.getValue() + ")--->");
            // Can use this to print the next, or the prev, and etc.
            traveler = traveler.getNext();
            if (null == traveler) {
                output = output.concat("null");
            }
        }
        return output;
    }

    /**
     * Find the node at given index.
     * <p>
     * Used by other *At() methods to find their Node of interest.
     *
     * @param index Position of node to find.
     *
     * @return Node<V> Returns the found Node.
     * @throws IndexOutOfBoundsException Throws IndexOutOfBoundsException when index is negative, or index beyond end of
     *                                   list.
     */
    protected Node<V> findAt(int index)
    {
        if (0 > index) {
            throw new IndexOutOfBoundsException(" * Index can not be negative * ");
        }
        if (index >= count) {
            throw new IndexOutOfBoundsException(" * Index beyond end of list * ");
        }
        int position = 0;
        // Start at first node and walk until correct node found.
        Node<V> current = node;
        while (position != index) {
            current = current.getNext();
            ++position;
        }
        return current;
    }

    /**
     * Used to track number of nodes.
     */
    private int count;
    /**
     * Holds the first node in the linked list.
     */
    private Node<V> node;
}
