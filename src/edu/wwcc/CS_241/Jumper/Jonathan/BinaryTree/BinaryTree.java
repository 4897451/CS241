package edu.wwcc.CS_241.Jumper.Jonathan.BinaryTree;

@SuppressWarnings("WeakerAccess")
public class BinaryTree<V extends Comparable<V>>
{
    public boolean insertAt(int index, Node<V> newNode)
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
        return false;
    }

    /**
     * Prepend new Node to LL.
     *
     * @param newNode New Node to be prepend to LL.
     *
     * @return LinkedList<V>
     */
    public BinaryTree<V> prepend(Node<V> newNode)
    {
        // Checks to see if its the only newNode
        if (null != root) {
            newNode.setLeft(root);
            root.setAncestor(newNode);
            root = newNode;
        } else {
            root = newNode;
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
    public BinaryTree<V> prepend(V value)
    {
        return prepend(new Node<>(value));
    }

    public void printPostOrder()
    {
        printPostOrder(root);
    }

    /**
     * Given a binary tree, print its nodes according to the "bottom-up" post order traversal.
     */
    private void printPostOrder(Node node)
    {
        if (node == null) {
            return;
        }
        // first recur on left subtree
        printPostOrder(node.getLeft());
        // then recur on right subtree
        printPostOrder(node.getRight());
        // now deal with the node
        System.out.print(node.getValue() + " ");
    }

    private int count;
    private Node<V> root;
}
//public class BinaryTree<B> {
//    private Node<B> root = null;
//
//    public BinaryTree()
//    {
//    }
//
//    /**
//     * Insert B value method
//     *
//     * @param value
//     *
//     * @return False
//     */
//    public boolean insert(B value)
//    {
//        return false;
//    }
//
//    public void printBreadthFirst()
//    {
//        while (Stack != isEmpty)
//        {
//            Node<B> node = Stack.dequeues;
//            print(Node);
//            if (Node.left = null)
//            {
//                Stack.push(Node.left);
//                Stack.push(Node.right);
//            }
//        }
//    }
//
//    public void printDepthFirst()
//    {
//        while (Stack != isEmpty)
//        {
//            Node<B> node = Stack, popl;
//            print(Node);
//            if (Node.left = null)
//            {
//                Stack.push(Node.left);
//                Stack.push(Node.reight);
//            }
//        }
//    }
//}
