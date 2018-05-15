/*
 * Jonathan Jumper
 * CS241 JAVA II
 * Linked Lists
 * 4-11-18
 */
package edu.wwcc.CS_241.Jumper.Jonathan.BinaryTree;

/**
 * linkedlist class
 * <p>
 * Jonathan, This should be a T for type because it is a type
 * but I understand you chose L because it makes sense to you at this point
 * If Anything, for the future, use S Since this is a "second"
 * and this would keep better in naming conventions
 * comment requested by me for elucidation on Generic Types - good form
 *
 * Remember you are always just working with instances of a class not
 * the class itself.
 * The `head` property just points to the first instance of a edu.wwcc.CS_241.Jumper.Jonathan.edu.wwcc.CS_241.Jumper.Jonathan.BinaryTree.BinaryTree.Node class.
 */
//@SuppressWarnings("WeakerAccess")
//public class LinkedList<L> {
//    // changed permission to protected so I can extend LL class to edu.wwcc.CS_241.Jumper.Jonathan.edu.wwcc.CS_241.Jumper.Jonathan.BinaryTree.BinaryTree.Queue
//    // "head;" is the 1st instance of the "edu.wwcc.CS_241.Jumper.Jonathan.edu.wwcc.CS_241.Jumper.Jonathan.BinaryTree.BinaryTree.Node<L>" class.
//    protected Node<L> head;
//
//    /**
//     * Constructor
//     */
//    public LinkedList()
//    {
//        this.head = null;
//    }
//
//    /**
//     * @param value
//     *     <L> Passes (Value) into append method | edu.wwcc.CS_241.Jumper.Jonathan.BinaryTree.Main property.
//     */
//    public void append(L value)
//    {
//
//        /*
//         * If the list is empty set the head to new mode
//         */
//        if (this.head == null)
//        {
//            // Creates a new node and stuffs Value into it
//            this.head = new Node<>(value);
//            return;
//        }
//        Node<L> traveler = getLast();
//
//        /*
//         * At this point, traveler points to last node
//         */
//        traveler.setNext(new Node<>(value));
//    }
//
//    /**
//     * Got last linked node.
//     *
//     * @return edu.wwcc.CS_241.Jumper.Jonathan.edu.wwcc.CS_241.Jumper.Jonathan.BinaryTree.BinaryTree.Node<L>|null Returns edu.wwcc.CS_241.Jumper.Jonathan.edu.wwcc.CS_241.Jumper.Jonathan.BinaryTree.BinaryTree.Node or NULL.
//     */
//    public Node<L> getLast()
//    {
//
//        /*
//         * Finds the last edu.wwcc.CS_241.Jumper.Jonathan.edu.wwcc.CS_241.Jumper.Jonathan.BinaryTree.BinaryTree.Node
//         */
//        Node<L> last = this.head;
//        while (last.getNext() != null)
//        {
//            last = last.getNext();
//        }
//        return last;
//    }
//
//    /**
//     * Insert new value at index.
//     *
//     * @param value
//     *     int
//     * @param index
//     *     int
//     */
//    public void insertAt(L value, int index)
//    {
//        int length = this.length();
//        // Check for invalid conditions.
//        if (0 == length && 0 != index)
//        {
//            throw new IndexOutOfBoundsException(" ** Linked list is empty ** ");
//        }
//        if (index < 0)
//        {
//            throw new IndexOutOfBoundsException(" ** Index is < 0 ** ");
//        }
//        if (length < index)
//        {
//            throw new IndexOutOfBoundsException(" ** Index is > list length ** ");
//        }
//        // Handle special case of index = 0.
//        if (0 != index) // I was taught to reverse so if I just put = it will flag me first
//        {
//            // Needs to find the Parent edu.wwcc.CS_241.Jumper.Jonathan.edu.wwcc.CS_241.Jumper.Jonathan.BinaryTree.BinaryTree.Node before the index
//            // so new edu.wwcc.CS_241.Jumper.Jonathan.edu.wwcc.CS_241.Jumper.Jonathan.BinaryTree.BinaryTree.Node can be added to parent's next pointer.
//            --index; // This gets the value of the NODE AT THE INDEX of the node just before this index number
//            // I want the new node to be at.
//            // Initialization of vars for while loop.
//            Node<L> parentNode = this.head; //Initially it starts with the 1st node in LL and stuffs it's head value into var parentNode
//            Node<L> nextNode = this.head.getNext(); // "" takes the ".next" value of parentNode and stuffs it into nextNode
//            int position = 0;
//            // Loop until just before insert point.
//            while (position < index)
//            {
//                parentNode = nextNode;
//                nextNode = nextNode.getNext();
//                ++position;
//            }
//            // Inserts new edu.wwcc.CS_241.Jumper.Jonathan.edu.wwcc.CS_241.Jumper.Jonathan.BinaryTree.BinaryTree.Node value and link it with the old node
//            // that was at this position.
//            parentNode.setNext(new Node<>(value, nextNode));
//        } else
//        {
//            // This calls my prepend method to create a LL if index == null
//            this.prepend(value);
//        }
//    }
//
//    /**
//     * Finds length of list.
//     *
//     * @return int
//     */
//    public int length()
//    {
//        /*
//        Creates new variable count to store value of next
//         */
//        int count = 0;
//        if (this.head != null)
//        {
//            Node<L> left = this.head;
//            do
//            {
//                left = left.getLeft();
//                // ++ before because we're not using the value of count at this point
//                // we're only returning the value of count when the condition is false
//                ++count;
//            } while (left != null);
//        }
//        return count;
//    }
//
//    /**
//     * Looks at head of LL
//     *
//     * @return edu.wwcc.CS_241.Jumper.Jonathan.edu.wwcc.CS_241.Jumper.Jonathan.BinaryTree.BinaryTree.Node<L> Returns the head of list.
//     */
//    public L peek()
//    {
//        return head.getValue();
//    }
//
//    /**
//     * PREPEND METHOD
//     *
//     * @param value
//     *     <L> Value for the node.
//     */
//    public void prepend(L value)
//    {
//        if (this.head == null) // Checks to see if its the only node
//        {
//            this.append(value);
//        } else
//        {
//            // This is a way to increase efficiency of my code.
//            // Instead of create a temporary local variable to assign to the new
//            // node's next you can do it in a single step by using the other node constructor.
//            // Instead I didn't need to create an empty node
//            // and assign the value of head to next and then discard
//            // the temporary pointer to the old node.
////            edu.wwcc.CS_241.Jumper.Jonathan.edu.wwcc.CS_241.Jumper.Jonathan.BinaryTree.BinaryTree.Node<L> temp = this.head; *Deprecated*
//            this.head = new Node<>(value, this.head);
////            this.head.setNext(temp); *Deprecated*
//        }
//    }
//
//    /**
//     * Print edu.wwcc.CS_241.Jumper.Jonathan.edu.wwcc.CS_241.Jumper.Jonathan.BinaryTree.BinaryTree.LinkedList Method
//     */
//    public void print()
//    {
//        Node<L> traveler = this.head;
//        while (traveler != null)
//        {
//            System.out.print("Value(" + traveler.getValue() + ")--->");
//            //System.out.print(traveler); //*test* <-Traveler at this point
//            System.out.print("");
//            traveler = traveler.getNext();
//            //System.out.print(traveler); //*test* <-Traveler at this point
//        }
//        //System.out.print(traveler.getValue());
//        System.out.println();
//    }
//
//    /**
//     * @param index
//     *     int
//     *
//     * @return <L>
//     */
//    public L removeAt(int index)
//    {
//        if (this.head == null)
//        {
//            throw new IndexOutOfBoundsException();
//        }
//        if (index < 0)
//        {
//            throw new IndexOutOfBoundsException();
//        }
//        Node<L> trailer = null;
//        Node<L> traveler = this.head;
//        int position = 0;
//        while (traveler != null && position != index)
//        {
//            trailer = traveler;
//            traveler = traveler.getNext();
//            ++position;
//        }
//        if (traveler == null)
//        {
//            throw new IndexOutOfBoundsException(" * NO LIST * ");
//        }
//        if (trailer == null)
//        {
//            L value = this.head.getValue();
//            this.head = this.head.getNext();
//            return value;
//            // return this.removeFirst();
//        }
//        L value = traveler.getValue();
//        trailer.setNext(traveler.getNext());
//        return value;
//    }
//
//    /**
//     * @return <L>
//     */
//    public L removeFirst()
//    {
//        if (this.head == null)
//        {
//            throw new IndexOutOfBoundsException();
//        }
//        /*
//         * this will create a new local var
//         * of the edu.wwcc.CS_241.Jumper.Jonathan.edu.wwcc.CS_241.Jumper.Jonathan.BinaryTree.BinaryTree.Node type
//         * this.head passes the value of the "next"
//         * from the first edu.wwcc.CS_241.Jumper.Jonathan.edu.wwcc.CS_241.Jumper.Jonathan.BinaryTree.BinaryTree.Node to removedNode local var
//         */
//        Node<L> removedNode = this.head;
//        /*
//         * this takes the value of head from the 2nd edu.wwcc.CS_241.Jumper.Jonathan.edu.wwcc.CS_241.Jumper.Jonathan.BinaryTree.BinaryTree.Node
//         * and makes it the value of Head for the Second edu.wwcc.CS_241.Jumper.Jonathan.edu.wwcc.CS_241.Jumper.Jonathan.BinaryTree.BinaryTree.Node?
//         */
//        this.head = this.head.getNext();
//        /*
//         * this takes the value of Next from the First node
//         * and makes its Next Null
//         * thus severing it completely from the Linked List
//         */
//        removedNode.setNext(null);
//        /* return removedNode;
//        edu.wwcc.CS_241.Jumper.Jonathan.edu.wwcc.CS_241.Jumper.Jonathan.BinaryTree.BinaryTree.Node removedNode = this.head;
//        int value = this.head.getValue();
//        this.head = this.head.getNext();
//        */
//        return removedNode.getValue();
//        //return value;
//    }
//
//    /**
//     * @return <L>
//     */
//    public L removeLast()
//    {
//        if (this.head == null)
//        {
//            throw new IndexOutOfBoundsException(" * edu.wwcc.CS_241.Jumper.Jonathan.edu.wwcc.CS_241.Jumper.Jonathan.BinaryTree.BinaryTree.LinkedList Empty * ");
//        }
//        if (this.head.getNext() == null)
//        {
//            return this.removeFirst();
//        }
//        // Find second to last edu.wwcc.CS_241.Jumper.Jonathan.edu.wwcc.CS_241.Jumper.Jonathan.BinaryTree.BinaryTree.Node
//        Node<L> traveller = this.head;
//        while (traveller.getNext().getNext() != null)
//        {
//            traveller = traveller.getNext();
//        }
//        Node<L> secondToLastNode = traveller;
//        Node<L> lastNode = traveller.getNext();
//
//        /*
//         Remove pointer from second to last edu.wwcc.CS_241.Jumper.Jonathan.edu.wwcc.CS_241.Jumper.Jonathan.BinaryTree.BinaryTree.Node,
//         to last edu.wwcc.CS_241.Jumper.Jonathan.edu.wwcc.CS_241.Jumper.Jonathan.BinaryTree.BinaryTree.Node
//         */
//        L value = lastNode.getValue();
//        secondToLastNode.setNext(null);
//        return value;
//    }
//}
