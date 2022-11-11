package model;
import java.util.*;
import java.io.Serializable;


/**
 * BinaryTree partially implements a binary tree.
 *
 * @author Dr. Lewis
 * @author Dr. Chase
 * @modified code from a text book
 */
public class BinaryTree<T> 
{
    private BTNode<T> root;

    /**
     * Creates an empty binary tree.
     */
    public BinaryTree()
    {
        root = null;
    }

    /**
     * Creates a binary tree with the specified element as its root.
     * @param element the object to store in the root node
     */ 
    public BinaryTree (T element)
    {
        root = new BTNode<T>(element);
    }

    /**
     * Creates a binary tree with the two specified subtrees.
     * @param element the object to store in the root node
     * @param left the left subtree that should come off the root node
     * @param right the right subtree that should come off the root node
     */ 
    public BinaryTree (T element, BinaryTree<T> left, BinaryTree<T> right)
    {
        root = new BTNode<T>(element);
        root.setLeft(left.root);
        root.setRight(right.root);
    }

    /**
     * Returns the element stored in the root of the tree.
     * 
     * @return the element stored in the root of the tree
     * @throws RuntimeException if the tree is empty
     */
    public T getRootElement()
    {
        if (root == null)
            throw new RuntimeException ("Get root operation "
                + "failed. The tree is empty.");

        return root.getElement();
    }

    /**
     * Sets the element stored in the root of the tree.
     * 
     * @param value the object to store in the root
     * @throws RuntimeException if the tree is empty
     */
    public void setRootElement(T value)
    {
        if (root == null)
            throw new RuntimeException ("Get root operation "
                + "failed. The tree is empty.");

        root.setElement(value);
    }


    /**
     * Returns the left subtree of the root of this tree.
     * 
     * @return the left subtree of the root of this tree.
     * @throws RuntimeException if the tree is empty
     */
    public BinaryTree<T> getLeft()
    {
        if (root == null)
            throw new RuntimeException ("Get left operation "
                + "failed. The tree is empty.");

        BinaryTree<T> result = new BinaryTree<T>();
        result.root = root.getLeft();

        return result;
    }

    /**
     * Sets left subtree of the root of the tree.
     * 
     * @param newLeft the tree which is to become the left subtree of the root
     * @throws RuntimeException if the tree is empty
     */
    public void setLeft(BinaryTree<T> newLeft)
    {
        if (root == null)
            throw new RuntimeException ("Get left operation "
                + "failed. The tree is empty.");

        root.setLeft(newLeft.root);
    }

    /**
     * Returns the right subtree of the root of this tree.
     * 
     * @return the right subtree of the root of this tree.
     * @throws RuntimeException if the tree is empty
     */
    public BinaryTree<T> getRight()
    {
        if (root == null)
            throw new RuntimeException ("Get right operation "
                + "failed. The tree is empty.");

        BinaryTree<T> result = new BinaryTree<T>();
        result.root = root.getRight();

        return result;
    }

    /**
     * Sets the right subtree of the root of the tree.
     * 
     * @param newRight the tree which is to become the right subtree of the root
     * @throws RuntimeException if the tree is empty
     */
     public void setRight(BinaryTree<T> newRight)
    {
        if (root == null)
            throw new RuntimeException ("Get left operation "
                + "failed. The tree is empty.");

        root.setRight(newRight.root);
    }

   /**
    * Returns the number of elements in this binary tree.
    * 
    * @return the number of elements in this binary tree
    */ 
    public int size()
    {
        int result = 0;

        if (root != null)
            result = root.count();

        return result;
    }
    
   /**
    * Determines if tree contains any nodes
    * 
    * @return true if no nodes in tree, else false
    */
   public boolean isEmpty()
   {
        return size() == 0;
    }

    /**
    * Determines if tree is simply a leaf
    * 
    * @return true if no nodes in tree, else false
    */
   public boolean isLeaf()
   {
        if (root == null)
            throw new RuntimeException ("isLeaf operation "
                + "failed. The tree is empty.");
        return root.getLeft()==null && root.getLeft()==null;
    }

    //-----------------------------------------------------------------
    //  Populates and returns an iterator containing the elements in
    //  this binary tree using an inorder traversal.
    //-----------------------------------------------------------------
    private Iterator<T> inorder()
    {
        ArrayIterator<T> iter = new ArrayIterator<T>();

        if (root != null)
            root.inorder (iter);

        return iter;
    }

    /**
     * Satisfies the Iterable interface using an inorder traversal.
     * 
     */
    public Iterator<T> iterator()
    {
        return inorder();
    }
    /*
    //-----------------------------------------------------------------
    //   Returns the element in this binary tree that matches the specified target.
    //   Throws a RuntimeException if the
    //  target is not found.
    //-----------------------------------------------------------------
    public T find (T target)
    {
        BTNode<T> node = null;

        if (root != null)
            node = root.find(target);

        if (node == null)
            throw new RuntimeException("Find operation failed. "
                + "No such element in tree.");

        return node.getElement();
    }

    //-----------------------------------------------------------------
    //  Populates and returns an iterator containing the elements in
    //  this binary tree using a levelorder traversal.
    //-----------------------------------------------------------------
    public Iterator<T> levelorder()
    {
    LinkedQueue<BTNode<T>> queue = new LinkedQueue<BTNode<T>>();
    ArrayIterator<T> iter = new ArrayIterator<T>();

    if (root != null)
    {
    queue.enqueue(root);
    while (!queue.isEmpty())
    {
    BTNode<T> current = queue.dequeue();

    iter.add (current.getElement());

    if (current.getLeft() != null)
    queue.enqueue(current.getLeft());
    if (current.getRight() != null)
    queue.enqueue(current.getRight());
    }
    }

    return iter;
    }

    //-----------------------------------------------------------------
    //  The following methods are left as programming projects.
    //-----------------------------------------------------------------

    // public boolean contains (T target) { }
    // public String toString() { }
    // public Iterator<T> preorder() { }
    // public Iterator<T> postorder() { }
     */
    //*******************************************************************
    //  BTNode.java       Java Foundations
    //
    //  Represents a node in a binary tree with a left and right child.
    //  Therefore this class also represents the root of a subtree.
    //*******************************************************************

    private class BTNode<T> implements Serializable
    {
        protected T element;
        protected BTNode<T> left, right;

        //-----------------------------------------------------------------
        //  Creates a new tree node with the specified data.
        //-----------------------------------------------------------------
        public BTNode (T element)
        {
            this.element = element;
            left = right = null;
        }

        //-----------------------------------------------------------------
        //  Returns the element stored in this node.
        //-----------------------------------------------------------------
        public T getElement()
        {
            return element;
        }

        //-----------------------------------------------------------------
        //  Sets the element stored in this node.
        //-----------------------------------------------------------------
        public void setElement (T element)
        {
            this.element = element;
        }

        //-----------------------------------------------------------------
        //  Returns the left subtree of this node.
        //-----------------------------------------------------------------
        public BTNode<T> getLeft()
        {
            return left;
        }

        //-----------------------------------------------------------------
        //  Sets the left child of this node.
        //-----------------------------------------------------------------
        public void setLeft (BTNode<T> left)
        {
            this.left = left;
        }

        //-----------------------------------------------------------------
        //  Returns the right subtree of this node.
        //-----------------------------------------------------------------
        public BTNode<T> getRight()
        {
            return right;
        }

        //-----------------------------------------------------------------
        //  Sets the right child of this node.
        //-----------------------------------------------------------------
        public void setRight (BTNode<T> right)
        {
            this.right = right;
        }

        //-----------------------------------------------------------------
        //  Returns the element in this subtree that matches the
        //  specified target. Returns null if the target is not found.
        //-----------------------------------------------------------------
        public BTNode<T> find (T target)
        {
            BTNode<T> result = null;

            if (element.equals(target))
                result = this;
            else
            {
                if (left != null)
                    result = left.find(target);
                if (result == null && right != null)
                    result = right.find(target);
            }

            return result;
        }

        //-----------------------------------------------------------------
        //  Returns the number of nodes in this subtree.
        //-----------------------------------------------------------------
        public int count()
        {
            int result = 1;

            if (left != null)
                result += left.count();

            if (right != null)
                result += right.count();

            return result;
        }

        //-----------------------------------------------------------------
        //  Performs an inorder traversal on this subtree, updating the
        //  specified iterator.
        //-----------------------------------------------------------------
        public void inorder (ArrayIterator<T> iter)
        {
            if (left != null)
                left.inorder (iter);

            iter.add (element);

            if (right != null)
                right.inorder (iter);
        }

        //-----------------------------------------------------------------
        //  The following methods are left as programming projects.
        //-----------------------------------------------------------------
        // public void preorder (ArrayIterator<T> iter) { }
        // public void postorder (ArrayIterator<T> iter) { }
    }
    private class ArrayIterator<T> implements Iterator<T>
    {
        private int DEFAULT_CAPACITY = 10;   
        private int count;    // the number of elements in the collection
        private int current;  // the current position in the iteration 
        private ArrayList<T> items; 

        /**
         * Sets up this iterator using the specified items.
         * 
         * @param collection  the collection to create the iterator for
         * @param size        the size of the collection
         */
        public ArrayIterator ()
        {
            items = new ArrayList<T>(DEFAULT_CAPACITY);
            count = 0;
            current = 0;
        }

        /**
         * Returns true if this iterator has at least one more element
         * to deliver in the iteration.
         *
         * @return  true of this iterator has at least one more element to deliver
         *          in the iteration
         */
        public boolean hasNext()
        {
            return (current < count);
        }

        /**
         * Returns the next element in the iteration. If there are no
         * more elements in this iteration, a NoSuchElementException is
         * thrown.
         *
         * @return  the next element in the iteration
         * @throws NoSuchElementException  if an element not found exception occurs
         */
        public T next()
        {
            if (! hasNext())
                throw new RuntimeException ("There are no more elements available to the iterator");

            current++;

            return items.get(current - 1);
        }

        /**
         * The remove operation is not supported in this collection.
         * 
         * @throws UnsupportedOperationException  if an unsupported operation
         *                                        exception occurs
         */
        public void remove() throws UnsupportedOperationException
        {
            throw new UnsupportedOperationException();
        }

        public void add (T item)
        {
            items.add(item);
            count++;
        }
    }

}
