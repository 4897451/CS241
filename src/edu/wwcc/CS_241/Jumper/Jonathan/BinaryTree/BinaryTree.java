package edu.wwcc.CS_241.Jumper.Jonathan.BinaryTree;
//import org.junit.jupiter.api.Test;

@SuppressWarnings("WeakerAccess")
public class BinaryTree<V extends Comparable<V>>
{
    public int getSize()
    {
        return count;
    }

    /**
     * Public check that a Node value exists.
     *
     * @param value V
     *
     * @return Returns true if exists, else false.
     */
    public boolean hasNode(V value)
    {
        return hasNodeRecursive(root, value);
    }

    /**
     * Public node insertion.
     *
     * @param value V
     *
     * @return Fluent interface
     */
    public BinaryTree<V> insert(V value)
    {
        root = insertRecursive(root, value);
        return this;
    }

    /**
     * Recursively searches for a node by value.
     *
     * @param current Current node to check.
     * @param value   Node value to check for.
     *
     * @return Returns true if a node equal to value exists else false.
     */
    private boolean hasNodeRecursive(Node<V> current, V value)
    {
        if (null == current) {
            return false;
        }
        if (value == current.getValue()) {
            return true;
        }
        // if value < current value go left else go right.
        return (0 < current.getValue().compareTo(value)) ? hasNodeRecursive(current.getLeft(), value) :
               hasNodeRecursive(current.getRight(), value);
    }

    private Node<V> insertRecursive(Node<V> current, V value)
    {
        if (null == current) {
            ++count;
            return new Node<>(value);
        }
        // If value < current node value.
        if (0 > value.compareTo(current.getValue())) {
            current.setLeft(insertRecursive(current.getLeft(), value));
            current.getLeft().setAncestor(current);
            // if value > current node value.
        } else if (0 < value.compareTo(current.getValue())) {
            current.setRight(insertRecursive(current.getRight(), value));
            current.getRight().setAncestor(current);
        }
        return current;
    }

    private int count;
    private Node<V> root;
    //    @Test
    //    public void givenABinaryTree_WhenAddingElements_ThenTreeContainsThoseElements() {
    //        BinaryTree<Integer> bt = new BinaryTree<>();
    //
    //        assertTrue(bt.containsNode(6));
    //        assertTrue(bt.containsNode(4));
    //
    //        assertFalse(bt.containsNode(1));
    //    }
}

