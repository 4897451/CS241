/*
 * Jonathan Jumper
 * CS241 JAVA II
 * Linked Lists
 * 4-11-18
 */
package edu.wwcc.CS_241.Jumper.Jonathan.SingleLL;

/**
 * linkedlist class
 * <p>
 * Jonathan, This should be a T for type because it is a type but I understand you chose L because it makes sense to you
 * at this point If Anything, for the future, use S Since this is a "second" and this would keep better in naming
 * conventions * comment requested by me for elucidation on Generic Types - good form *
 */
@SuppressWarnings("WeakerAccess")
public class LinkedList<V>
{
    protected Node<V> head;

    /**
     * Constructor
     */
    public LinkedList()
    {
        this.head = null;
    }

    /**
     * @param value <L> Passes (Value) into append method | Main property.
     */
    public void append(V value)
    {

        /*
         * If the list is empty set the head to new mode
         */
        if (null == this.head) {
            // Creates a new node and stuffs Value into it
            this.head = new Node<>(value);
            return;
        }
        Node<V> traveler = getLast();

        /*
         * At this point, traveler points to last node
         */
        traveler.setNext(new Node<>(value));
    }

    /**
     * Got last linked node.
     *
     * @return Node<L>|null Returns Node or NULL.
     */
    public Node<V> getLast()
    {

        /*
         * Finds the last Node
         */
        Node<V> last = this.head;
        while (null != last.getNext()) {
            last = last.getNext();
        }
        return last;
    }

    /**
     * Insert new value at index.
     *
     * @param value int
     * @param index int
     */
    public void insertAt(V value, int index)
    {
        int length = this.length();
        // Check for invalid conditions.
        if (0 == length && 0 != index) {
            throw new IndexOutOfBoundsException(" ** Linked list is empty ** ");
        }
        if (index < 0) {
            throw new IndexOutOfBoundsException(" ** Index is < 0 ** ");
        }
        if (length < index) {
            throw new IndexOutOfBoundsException(" ** Index is > list length ** ");
        }
        // Handle special case of index = 0.
        if (0 != index) // I was taught to reverse so if I just put = it will flag me first
        {
            // Needs to find the Parent Node before the index
            // so new Node can be added to parent's next pointer.
            --index; // This gets the value of the NODE AT THE INDEX of the node just before this index number
            // I want the new node to be at.
            // Initialization of vars for while loop.
            Node<V> parentNode = this.head; //Initially it starts with the 1st node in LL and stuffs it's head value into var parentNode
            Node<V> nextNode = this.head.getNext(); // "" takes the ".next" value of parentNode and stuffs it into nextNode
            int position = 0;
            // Loop until just before insert point.
            while (position < index) {
                parentNode = nextNode;
                nextNode = nextNode.getNext();
                ++position;
            }
            // Inserts new Node value and link it with the old node
            // that was at this position.
            parentNode.setNext(new Node<>(value, nextNode));
        } else {
            // This calls my prepend method to create a LL if index == null
            this.prepend(value);
        }
    }

    /**
     * Finds length of list.
     *
     * @return int
     */
    public int length()
    {
        // Creates new variable count to store value of next.
        int count = 0;
        if (this.head != null) {
            Node<V> current = this.head;
            do {
                current = current.getNext();
                // ++ before because we're not using the value of count at this point
                // we're only returning the value of count when the condition is false
                ++count;
            } while (current != null);
        }
        return count;
    }

    /**
     * @return L
     */
    public V peek()
    {
        return head.getValue();
    }

    /**
     * PREPEND METHOD
     *
     * @param value <L> Value for the node.
     */
    public void prepend(V value)
    {
        if (null != this.head) // Checks to see if its the only node
        {
            // Least common scenario is having an empty list (null).
            // So, flipping the if so the most common is in the then part
            // and less common null == this.head is in else.            //
            // This is a way to increase efficiency of my code.
            // Instead of create a temporary local variable to assign to the new
            // node's next you can do it in a single step by using the other node constructor.
            // Instead I didn't need to create an empty node
            // and assign the value of head to next and then discard
            // the temporary pointer to the old node.
            this.head = new Node<>(value, this.head);
        } else {
            this.head = new Node<>(value);
        }
    }

    /**
     * Print LinkedList Method
     */
    public void print()
    {
        Node<V> traveler = this.head;
        while (null != traveler) {
            System.out.print("Value(" + traveler.getValue() + ")--->");
            traveler = traveler.getNext();
            if (null == traveler) {
                // Should just use string of "null" here it is more efficient.
                System.out.print(traveler);
            }
        }
        System.out.println();
    }

    /**
     * Prints the current LL.
     * <p>
     * Made this so that it will be called to return a string It is now a string so any place I want to call then print
     * method I can print whatever type I am using in that instance.
     * <p>
     * Overloaded print method for this class.
     * <p>
     * Print LinkedList Method
     */
    public String toString()
    {
        String output = "";
        Node<V> traveler = this.head;
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
     * @param index int
     *
     * @return <L>
     */
    public V removeAt(int index)
    {
        if (this.head == null) {
            throw new IndexOutOfBoundsException();
        }
        if (index < 0) {
            throw new IndexOutOfBoundsException();
        }
        Node<V> trailer = null;
        Node<V> traveler = this.head;
        int position = 0;
        while (traveler != null && position != index) {
            trailer = traveler;
            traveler = traveler.getNext();
            ++position;
        }
        if (traveler == null) {
            throw new IndexOutOfBoundsException();
        }
        if (trailer == null) {
            V value = this.head.getValue();
            this.head = this.head.getNext();
            return value;
            // return this.removeFirst();
        }
        V value = traveler.getValue();
        trailer.setNext(traveler.getNext());
        return value;
    }

    /**
     * @return <L>
     */
    public V removeFirst()
    {
        if (null == this.head) {
            throw new IndexOutOfBoundsException();
        }
        /*
         * this will create a new local var
         * of the Node type
         * this.head passes the value of the "next"
         * from the first Node to removedNode local var
         */
        Node<V> removedNode = this.head;
        /*
         * this takes the value of head from the 2nd Node
         * and makes it the value of Head for the Second Node?
         */
        this.head = this.head.getNext();
        /*
         * this takes the value of Next from the First node
         * and makes its Next Null
         * thus severing it completely from the Linked List
         */
        removedNode.setNext(null);
        /* return removedNode;
        Node removedNode = this.head;
        int value = this.head.value;
        this.head = this.head.next;
        */
        return removedNode.getValue();
        //return value;
    }

    /**
     * @return <L>
     */
    public V removeLast()
    {
        if (this.head == null) {
            throw new IndexOutOfBoundsException(" * LinkedList Empty * ");
        }
        if (null == this.head.getNext()) {
            return this.removeFirst();
        }
        // Find second to last Node
        Node<V> traveller = this.head;
        while (traveller.getNext().getNext() != null) {
            traveller = traveller.getNext();
        }
        Node<V> secondToLastNode = traveller;
        Node<V> lastNode = traveller.getNext();

        /*
         Remove pointer from second to last Node,
         to last Node
         */
        V value = lastNode.getValue();
        secondToLastNode.setNext(null);
        return value;
    }

    /**
     * @return int
     */
    public int size()
    {
        return length();
    }
}
