package prj5;

import student.TestCase;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Tests the LinkedList class
 * @author Tyler Levine (tylerlevine)
 * @version 11.18.2021
 *
 */
public class LinkedListTest extends TestCase 
{
    private SLList<String> list;
    private Iterator<String> iter;

    /**
     * Sets up all test cases
     */
    public void setUp() 
    {
        list = new SLList<String>();
        iter = list.iterator();
    }

    /**
     * Tests that an IndexOutOfBounds exception is thrown when the index is
     * greater than or equal to getLength and less than zero
     */
    public void testRemoveException() 
    {
        list.add("A");
        Exception e = null;
        try {
            list.remove(2);
        } 
        catch (Exception exception) 
        {
            e = exception;
        }
        assertTrue(e instanceof IndexOutOfBoundsException);
        e = null;
        try {
            list.remove(-1);
        } 
        catch (Exception exception) 
        {
            e = exception;
        }
        assertTrue(e instanceof IndexOutOfBoundsException);
    }

    /**
     * Tests that objects can be removed at the beginning and end and that the
     * getLength is changed
     */
    public void testRemove() 
    {
        list.add("A");
        list.add("B");
        list.add("C");
        assertEquals("C", list.remove(2));
        assertEquals("B", list.remove(1));
        assertEquals(1, list.getLength());
        list.add("B");
        assertEquals("A", list.remove(0));
        assertEquals(1, list.getLength());
    }

    /**
     * Tests the add method. Ensures that it adds the object is added at the end
     * and the getLength is increased
     */
    public void testAdd() 
    {
        assertEquals(0, list.getLength());
        list.add("A");
        assertEquals(1, list.getLength());
        list.add("B");
        assertEquals(2, list.getLength());
        assertEquals("B", list.getEntry(1));

    }

    /**
     * Tests that objects can be added at the beginning and end and that they
     * are placed correctly
     */
    public void testAddIndex() 
    {
        list.add(0, "B");
        list.add(0, "A");
        assertEquals("A", list.getEntry(0));
        assertEquals(2, list.getLength());
        list.add(2, "D");
        assertEquals("D", list.getEntry(2));
        list.add(2, "C");
        assertEquals("C", list.getEntry(2));
    }

    /**
     * This tests that the add method throws a null pointer exception when
     * adding null data to the list
     */
    public void testAddNullException() 
    {
        Exception e = null;
        try {
            list.add(null);
        } 
        catch (Exception exception) 
        {
            e = exception;
        }
        assertTrue(e instanceof IllegalArgumentException);
    }

    /**
     * This tests that the add method throws a Invalid argument when adding null
     * data to the list
     */
    public void testAddIndexNullException() 
    {
        Exception e = null;
        try {
            list.add(0, null);
        } 
        catch (Exception exception) 
        {
            e = exception;
        }
        assertTrue(e instanceof IllegalArgumentException);
    }

    /**
     * This tests when the add method is called and the index is greater than
     * getLength or less than zero
     */
    public void testAddException() 
    {
        list.add("A");
        Exception e = null;
        try {
            list.add(2, "B");
        } 
        catch (Exception exception) 
        {
            e = exception;
        }
        assertTrue(e instanceof IndexOutOfBoundsException);
        e = null;
        try {
            list.add(-1, "B");
        } 
        catch (Exception exception) 
        {
            e = exception;
        }
        assertTrue( e instanceof IndexOutOfBoundsException);
    }


    /**
     * Tests get when the index is greater than or equal to getLength and when the
     * index is less than zero
     */
    public void testGetEntryException() 
    {
        Exception exception = null;
        try 
        {
            list.getEntry(-1);
        } 
        catch (Exception e) 
        {
            exception = e;
        }
        assertTrue(exception instanceof IndexOutOfBoundsException);
        exception = null;
        list.add("A");
        try 
        {
            list.getEntry(1);
        } 
        catch (IndexOutOfBoundsException e) 
        {
            exception = e;
        }
        assertTrue(exception instanceof IndexOutOfBoundsException);
    }

    /**
     * Test contains when it does and does not contain the object
     */
    public void testContains() {
        assertFalse( list.contains("A"));
        list.add("A");
        assertTrue(list.contains("A"));
        assertFalse(list.contains("B"));
        list.add("B");
        assertTrue(list.contains("B"));
    }

    /**
     * Tests isEmpty when empty and full
     */
    public void testIsEmpty() {
        assertTrue( list.isEmpty());
        list.add("A");
        assertFalse(list.isEmpty());
    }

    /**
     * Ensures that all of the objects are cleared and the getLength is changed
     */
    public void testClear() {
        list.clear();
        list.add("A");
        list.clear();
        assertEquals(0, list.getLength());
        assertFalse(
                list.contains("A"));
    }

    /**
     * Tests the toString when there are 0, 1, and 2 objects in the list
     */
    public void testToString() {
        assertEquals("{}",
                list.toString());
        list.add("A");
        assertEquals("{A}",
                list.toString());
        list.add("B");
        assertEquals("{A, B}",
                list.toString());
    }

    /**
     * Tests removing from an empty list
     */
    public void testRemoveFromEmpty() 
    {
        list.add("dance");
        list.add(0, "safety");
        list.clear();
        Exception exception;
        exception = null;
        try 
        {
            list.remove(0);
        } 
        catch (IndexOutOfBoundsException e) 
        {
            exception = e;
        }
        assertTrue(  exception instanceof IndexOutOfBoundsException);

        SLList<String> emptyList = new SLList<String>();
        exception = null;
        try 
        {
            emptyList.remove(0);
        } 
        catch (IndexOutOfBoundsException e) 
        {
            exception = e;
        }
        assertTrue( exception instanceof IndexOutOfBoundsException);
    }
    
    /**
     * Tests the Iterator's 
     * hasNext() method when it
     * should return true
     */
    public void testHasNext1()
    {
        list.add("A");
        list.add("B");
        iter = list.iterator();
        assertTrue(iter.hasNext());
        assertEquals(2, list.getLength());
    }
    
    /**
     * Tests the Iterator's 
     * hasNext() method when it
     * should return false
     */
    public void testHasNext2()
    {
        assertFalse(iter.hasNext());
    }
    /**
     * Tests the Iterator's
     * next() method
     */
    public void testIterNext()
    {
        list.add("A");
        list.add("B");
        iter = list.iterator();
        assertEquals("A", iter.next());
    }
    
    /**
     * Tests the Iterator's
     * next() method's exception
     */
    public void testIterNextException()
    {
        Exception exception = null;
        try
        {
            iter.next();
            fail("next() is not throwing an exception when it should");
        }
        catch (Exception e)
        {
            exception = e;
        }
        assertTrue("next() is throwing the wrong type of exceptions",
                   exception instanceof NoSuchElementException);
    }
    
    /**
     * Tests the Iterator's
     * remove() method
     */
    public void testIterRemove()
    {
        list.add("a");
        list.add("B");
        iter = list.iterator();
        iter.next();
        iter.remove();
        assertEquals(1, list.getLength());
        assertEquals("B", list.getEntry(0));
        list.add("b");
        list.add("c");
        iter.next();
        iter.next();
        iter.remove();
        assertEquals(2, list.getLength());
        assertEquals("B", list.getEntry(0));
        assertEquals("c", list.getEntry(1));
    }
    
    /**
     * Tests the Iterator's
     * remove() method's exception
     */
    public void testIterRemoveException()
    {
        Exception exception = null;
        try
        {
            iter.remove();
            fail("remove() is not throwing an exception when it should");
        }
        catch (Exception e)
        {
            exception = e;
        }
        assertTrue("remove() is throwing the wrong type of exceptions",
                   exception instanceof IllegalStateException);
    }
    
    /**
     * Tests the getHead() method
     */
    public void testGetHead()
    {
        list.add("a");
        assertEquals("a", list.getHead().getData());
    }
    
    /**
     * Tests the replace() method
     */
    public void testReplace()
    {
        list.add("A");
        list.add("B");
        assertEquals("A", list.replace(0, "C"));
        assertEquals("C", list.getHead().getData());
    }
    
    /**
     * Tests the replace() method's 
     * exception
     */
    public void testReplaceException()
    {
        Exception exception = null;
        try
        {
            list.replace(0, "C");
            fail("replace() is not throwing an exception when it should");
        }
        catch (Exception e)
        {
            exception = e;
        }
        assertTrue("replace() is throwing the wrong type of exceptions",
                   exception instanceof IndexOutOfBoundsException);
    }
    
    /**
     * Tests the toArray() method
     */
    public void testToArray()
    {
        list.add("A");
        list.add("B");
        list.add("C");
        assertEquals("A", list.toArray()[0]);
        assertEquals("B", list.toArray()[1]);
        assertEquals("C", list.toArray()[2]);
    }
    
    /**
     * Tests equals() method
     */
    public void testEquals()
    {
        assertTrue(list.equals(list));
        SLList<String> list2 = new SLList<String>();
        list.add("A");
        list.add("B");
        list2.add("A");
        list2.add("B");
        assertTrue(list.equals(list2));
        list2.add("C");
        assertFalse(list.equals(list2));
        assertFalse(list.equals(null));
        Object obj = new Object();
        assertFalse(list.equals(obj));
    }
    
    /**
     * Tests insertionSort() method
     */
    public void testInsertionSort()
    {
        CompareAlpha comp = new CompareAlpha();
        SLList<Race>list2 = new SLList<Race>();
        list2.add(new Race("White", 12, 10));
        list2.add(new Race("Black", 3, 1));
        list2.add(new Race("Latinx", 7, 6));
        list2.add(new Race("Asian", 24, 15));
        list2.add(new Race("Other", 74, 30));
        list2.insertionSort(comp);
        assertEquals("{[Asian, 24, 15], [Black, 3, 1], [Latinx, 7, 6], [Other, 74, 30], [White, 12, 10]}", list2.toString());
    }
    
    /**
     * Tests insertIntoSorted() method
     */
    public void testInsertIntoSorter()
    {
        CompareAlpha comp = new CompareAlpha();
        SLList<Race>list2 = new SLList<Race>();
        list2.add(new Race("White", 12, 10));
        list2.add(new Race("Black", 3, 1));
        list2.add(new Race("Latinx", 7, 6));
        list2.add(new Race("Asian", 24, 15));
        list2.add(new Race("Other", 74, 30));
        list2.insertionSort(comp);
        SLList<Race>list3 = new SLList<Race>();
        list3.add(new Race("Native American", 64, 12));
        list2.insertIntoSorted(list3.getHead(), comp);
        assertEquals("{[Asian, 24, 15], [Black, 3, 1], [Latinx, 7, 6], [Native American, 64, 12], "
            + "[Other, 74, 30], [White, 12, 10]}", list2.toString());
    }
}
