/**
 * // Virginia Tech Honor Code Pledge:
 * //
 * // As a Hokie, I will conduct myself with honor and integrity at all times.
 * // I will not lie, cheat, or steal, nor will I accept the actions of those
 * who do.
 * // -- Shreyas Sakhalkar (shreyas7), Travis Wooten (travisw15)
 */
package prj5;

import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import list.ListInterface;

/**
 * This is a basic implementation of a linked list
 *
 * @author Mark Wiggans (mmw125)
 * @version 4/14/2015
 * @author Christina Olk (colk)
 * @version 9.4.15
 * @author Grace Fields
 * @version 10.26.15
 * @author Jamal Ahmad (jamal93)
 * @version 10/15/2016
 * @author Margaret Ellis (maellis1)
 * @version 03/16/2017
 * @author JW Lee (jiayiw6)
 * @version 10/14/2019
 * 
 * @author Tyler Levine (tylerlevine)
 * @author Abishek Satnur (abishek24)
 * @version 2021.11.17
 * 
 * @param <E>
 *            This is the type of object that this class will store
 */

public class SLList<E> implements ListInterface<E>, Iterable<E> {
    private Node<E> head;
    private int size;

    /**
     * Creates the SLList object
     */
    public SLList() {
        head = null;
        size = 0;
    }


    /**
     * Gets the head node of a list
     * 
     * @return the head node
     */
    public Node<E> getHead() {
        return head;
    }


    /**
     * Adds the object to the end of the list.
     *
     * @precondition obj cannot be null
     * @param obj
     *            the object to add
     * @throws IllegalArgumentException
     *             if obj is null
     */
    @Override
    public void add(E obj) {
        if (obj == null) {
            throw new IllegalArgumentException("Object is null");
        }

        Node<E> current = head;

        if (isEmpty()) {
            head = new Node<E>(obj);
        }

        else {
            while (current.next() != null) {
                current = current.next();
            }
            current.setNext(new Node<E>(obj));
        }
        size++;
    }


    /**
     * Adds the object to the position in the list
     *
     * @precondition obj cannot be null
     * @param index
     *            where to add the object
     * @param obj
     *            the object to add
     * @throws IndexOutOfBoundsException
     *             if index is less than zero or greater than size
     * @throws IllegalArgumentException
     *             if obj is null
     */
    @Override
    public void add(int index, E obj) {
        // check if the object is null
        if (obj == null) {
            throw new IllegalArgumentException("Object is null");
        }

        // check if the index is out of bounds
        if ((index < 0) || (index > getLength())) {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }

        Node<E> current = head;

        // empty stack case
        if (isEmpty()) {
            head = new Node<E>(obj);
        }

        // all other cases
        else {
            if (index == 0) {
                Node<E> newNode = new Node<E>(obj);
                newNode.setNext(head);
                head = newNode;
            }
            else {
                int currentIndex = 0;
                while (current != null) {
                    if ((currentIndex + 1) == index) {
                        Node<E> nextNext = current.next();
                        Node<E> newNode = new Node<E>(obj);
                        current.setNext(newNode);
                        newNode.setNext(nextNext);
                    }
                    currentIndex++;
                    current = current.next();
                }
            }
        }
        size++;
    }


    @Override
    public void clear() {
        if (head != null) {
            head.setNext(null);
            head = null;
        }
        size = 0;
    }


    /**
     * Checks if the list contains the given object
     *
     * @param obj
     *            the object to check for
     * @return true if it contains the object
     */
    @Override
    public boolean contains(E obj) {
        Node<E> current = head;
        while (current != null) {
            if (obj.equals(current.getData())) {
                return true;
            }
            current = current.next();
        }

        return false;
    }


    /**
     * Gets the object at the given position
     *
     * @param index
     *            where the object is located
     * @return The object at the given position
     * @throws IndexOutOfBoundsException
     *             if no node at the given index
     */
    @Override
    public E getEntry(int index) {
        Node<E> current = head;
        int currentIndex = 0;
        E data = null;
        while (current != null) {
            if (currentIndex == index) {
                data = current.getData();
            }
            currentIndex++;
            current = current.next();
        }

        if (data == null) {
            throw new IndexOutOfBoundsException("Index exceeds the size. "
                + String.valueOf(currentIndex));
        }
        return data;
    }


    @Override
    public int getLength() {
        return size;
    }


    @Override
    public boolean isEmpty() {
        return (size == 0);
    }


    @Override
    public E remove(int index) {
        if (index < 0 || head == null) {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }

        else if (index == 0) {
            Node<E> oldHead = head;
            head = head.next();
            size--;
            return oldHead.getData();
        }

        else {
            Node<E> oldPos = head;
            Node<E> current = head;
            int currentIndex = 0;

            while (current.next() != null) {
                if ((currentIndex + 1) == index) {
                    oldPos = current.next();
                    Node<E> newNext = current.next().next();
                    current.setNext(newNext);
                    size--;
                    return oldPos.getData();
                }
                current = current.next();
                currentIndex++;
            }

            throw new IndexOutOfBoundsException("Index is out of bounds");
        }
    }


    /**
     * Replaces the entry at a given position in this list.
     * 
     * @param index
     *            The index of the entry to be replaced.
     * @param anEntry
     *            The object that will replace the entry at the index
     * 
     * @return The original entry that was replaced.
     */
    @Override
    public E replace(int index, E anEntry) {
        Node<E> current = head;
        int currentIndex = 0;
        E data = null;
        while (current != null) {
            if (currentIndex == index) {
                data = current.getData();
                current.setData(anEntry);
                break;
            }
            currentIndex++;
            current = current.next();
        }

        if (data == null) {
            throw new IndexOutOfBoundsException("Index exceeds the size.");
        }
        return data;
    }


    /**
     * Returns a string representation of the list If a list contains A, B, and
     * C, the following should be returned "{A, B, C}" (Without the quotations)
     *
     * @return a string representing the list
     */
    @Override
    public String toString() {
        String result = "{";

        Node<E> current = head;
        while (current != null) {
            result += "" + current.getData();
            current = current.next();
            if (current != null) {
                result += ", ";
            }
        }
        result += "}";
        return result;
    }


    /**
     * Returns an array representation of the list If a list contains A, B, and
     * C, the following should be returned {A, B, C}, If a list
     * contains A, B, C, and C the following should be returned {A, B, C, C}
     *
     * @return an array representing the list
     */
    public Object[] toArray() {

        Object[] array = new Object[this.getLength()];

        Node<E> current = head;
        int count = 0;
        while (current != null) {
            array[count] = current.getData();
            current = current.next();
            count++;
        }

        return array;
    }


    /**
     * Returns true if both lists have the exact same contents
     * in the exact same order
     *
     * @return a boolean of whether two lists have the same contents,
     *         item per item and in the same order
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (this.getClass() == obj.getClass()) {
            @SuppressWarnings("unchecked")
            SLList<E> other = (SLList<E>)obj;
            if (other.getLength() == this.getLength()) {
                Node<E> current = head;
                Node<E> otherCurrent = other.head;
                while (current != null) {
                    if (!current.getData().equals(otherCurrent.getData())) {
                        return false;
                    }
                    current = current.next();
                    otherCurrent = otherCurrent.next();
                }
                return true;
            }
        }

        return false;
    }


    /**
     * Sorts the list
     * 
     * @param c
     *            comperator to compare objects
     */
    public void insertionSort(Comparator<E> c) {
        if (size > 1) {
            Node<E> unsortedPart = head.next();
            Node<E> sortedPart = head;
            sortedPart.setNext(null);

            while (unsortedPart != null) {
                Node<E> nodeToInsert = unsortedPart;
                unsortedPart = unsortedPart.next();
                insertIntoSorted(nodeToInsert, c);
            }
        }
    } // end insertionSort


    /**
     * Helper method to insert a node into its proper location in a sorted
     * linked chain.
     * 
     * @param nodeToInsert:
     *            node to add to sorted section of list
     */
    public void insertIntoSorted(Node<E> nodeToInsert, Comparator<E> c) {
        E item = nodeToInsert.getData();
        Node<E> currentNode = head;
        Node<E> previousNode = null;

        while ((currentNode != null) && (c.compare(item, currentNode
            .getData())) > 0) {
            previousNode = currentNode;
            currentNode = currentNode.next();
        }

        if (previousNode != null) {
            previousNode.setNext(nodeToInsert);
            nodeToInsert.setNext(currentNode);
        }

        else {
            nodeToInsert.setNext(head);
            head = nodeToInsert;
        }
    }


    public SLListIterator<E> iterator() {
        return new SLListIterator<E>();
    }

    private class SLListIterator<A> implements Iterator<E> {

        private Node<E> next;
        private boolean calledNext;

        /**
         * Creates a new DLListIterator
         */
        public SLListIterator() {
            next = head;
            calledNext = false;
        }


        /**
         * Checks if there are more elements in the list
         *
         * @return true if there are more elements in the list
         */
        @Override
        public boolean hasNext() {
            return next != null;
        }


        /**
         * Gets the next value in the list
         *
         * @return the next value
         * @throws NoSuchElementException
         *             if there are no nodes left in the list
         */
        @Override
        public E next() {
            if (hasNext()) {
                E currData = next.getData();
                next = next.next();
                calledNext = true;
                return currData;
            }
            throw new NoSuchElementException("No Value Next");
        }


        /**
         * Removes the last object returned with next() from the list
         *
         * @throws IllegalStateException
         *             if next has not been called yet
         *             and if the element has already been removed
         */
        @Override
        public void remove() {
            if (!calledNext) {
                throw new IllegalStateException("invalid remove");
            }

            else {
                if (next == head.next()) {
                    head = head.next();
                }

                else {
                    Node<E> prev = head;
                    while (prev.next().next() != next) {
                        prev = prev.next();
                    }
                    prev.setNext(next);
                }
                size--;
                calledNext = false;
            }
        }
    }
    
    private static class Node<T> {
        private Node<T> next;
        private T data;

        /**
         * Creates a new node with the given data
         *
         * @param d
         *            the data to put inside the node
         */
        public Node(T d) {
            data = d;
        }


        /**
         * Sets the node after this node
         *
         * @param n
         *            the node after this one
         */
        public void setNext(Node<T> n) {
            next = n;
        }

        /**
         * Gets the next node
         *
         * @return the next node
         */
        public Node<T> next() {
            return next;
        }


        /**
         * Gets the data in the node
         *
         * @return the data in the node
         */
        public T getData() {
            return data;
        }
        
        /**
         * Sets the data in the node
         *
         * @return the data in the node
         */
        public void setData(T data) {
            this.data = data;
        }
    }

}
