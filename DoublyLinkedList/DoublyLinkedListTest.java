import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

//-------------------------------------------------------------------------
/**
 *  Test class for Doubly Linked List
 *
 *  @author  Zehao Yu
 *  @version 13/10/16 18:15
 */
@RunWith(JUnit4.class)
public class DoublyLinkedListTest
{
    //~ Constructor ........................................................
    @Test
    public void testConstructor()
    {
      new DoublyLinkedList<Integer>();
    }

    //~ Public Methods ........................................................

    // ----------------------------------------------------------
    /**
     * Check if the insertBefore works
     */
    
    @Test
    public void testisEmpty()
    {
    	DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
    	assertEquals( "Checking isEmpty to an empty list", true, testDLL.isEmpty() );
    }
    
    @Test
    public void testInsertBefore()
    {
        // test non-empty list
        DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertBefore(0,7);
        testDLL.insertBefore(1,2);
        testDLL.insertBefore(2,3);

        testDLL.insertBefore(0,4);
        assertEquals( "Checking insertBefore to a list containing 3 elements at position 0", "4,1,2,3", testDLL.toString() );
        testDLL.insertBefore(1,5);
        assertEquals( "Checking insertBefore to a list containing 4 elements at position 1", "4,5,1,2,3", testDLL.toString() );
        testDLL.insertBefore(2,6);       
        assertEquals( "Checking insertBefore to a list containing 5 elements at position 2", "4,5,6,1,2,3", testDLL.toString() );
        testDLL.insertBefore(-1,7);        
        assertEquals( "Checking insertBefore to a list containing 6 elements at position -1 - expected the element at the head of the list", "7,4,5,6,1,2,3", testDLL.toString() );
        testDLL.insertBefore(7,8);        
        assertEquals( "Checking insertBefore to a list containing 7 elemenets at position 8 - expected the element at the tail of the list", "7,4,5,6,1,2,3,8", testDLL.toString() );
        testDLL.insertBefore(700,9);        
        assertEquals( "Checking insertBefore to a list containing 8 elements at position 700 - expected the element at the tail of the list", "7,4,5,6,1,2,3,8,9", testDLL.toString() );

        // test empty list
        testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertBefore(0,1);        
        assertEquals( "Checking insertBefore to an empty list at position 0 - expected the element at the head of the list", "1", testDLL.toString() );
        testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertBefore(10,1);        
        assertEquals( "Checking insertBefore to an empty list at position 10 - expected the element at the head of the list", "1", testDLL.toString() );
        testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertBefore(-10,1);        
        assertEquals( "Checking insertBefore to an empty list at position -10 - expected the element at the head of the list", "1", testDLL.toString() );
     }

    // TODO: add more tests here. Each line of code in DoublyLinkedList.java should
    // be executed at least once from at least one test.

    @Test
    public void testGet()
    {
        DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertBefore(0,1);
        testDLL.insertBefore(1,4);
        testDLL.insertBefore(2,7);
        testDLL.insertBefore(3,12);
        testDLL.insertBefore(4,20);
        assertEquals( "Checking get to a list containing 5 elements at position 3 - expected the element at position 3", "12", testDLL.get(3).toString());
       
        //test list contains one element
        DoublyLinkedList<Integer> testDLL2 = new DoublyLinkedList<Integer>();
        testDLL2.insertBefore(0,1);        
        assertEquals( "Checking get to a list containing 1 elements at position 0 - expected the element at position 0", "1", testDLL2.get(0).toString());
        assertEquals( "Checking get to a list containing 1 elements at position 5 - expected the element at position 5", null, testDLL2.get(5));
        assertEquals( "Checking get to a list containing 1 elements at position -5 - expected the element at position 5", null, testDLL2.get(-5));
        
        // test empty list
        DoublyLinkedList<Integer> EmptyDLL = new DoublyLinkedList<Integer>();
        assertEquals( "Checking get to an empty list at position 3 - expected null", null, EmptyDLL.get(3));
        
    }
    
    
    
    @Test
    public void testDeleteAt()
    {
    	
        DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertBefore(0,1);
        testDLL.insertBefore(1,6);
        testDLL.insertBefore(2,8);
        testDLL.insertBefore(3,13);
        testDLL.insertBefore(4,22);
        assertEquals( "Checking insertBefore to a list containing 5 elements ", "1,6,8,13,22", testDLL.toString() );
        
        //test list with 5 element
        testDLL.deleteAt(3);        
        assertEquals( "Checking deleteAt to a list containing 5 elements at position 1", "1,6,8,22", testDLL.toString());
        
        //test list with very large/small pos
        assertEquals( "Checking deleteAt to a list containing 5 elements at position 12 - expected false", false, testDLL.deleteAt(12));
        assertEquals( "Checking deleteAt to a list containing 5 elements at position -12 - expected false", false, testDLL.deleteAt(-12));
        
        //test list with one element
        DoublyLinkedList<Integer> testDLL2 = new DoublyLinkedList<Integer>();
        testDLL2.insertBefore(0,122);
        assertEquals( "Checking insertBefore to a list containing 5 elements", "122", testDLL2.toString() );
        assertEquals( "Checking deleteAt to a list containing 1 elements at position 0", true, testDLL2.deleteAt(0) );
        assertEquals( "Checking deleteAt to a list containing 1 elements at position 0", "", testDLL2.toString() );
        
        //test empty
        DoublyLinkedList<Integer> testDLL3 = new DoublyLinkedList<Integer>();
        assertEquals( "Checking deleteAt to an empty list at position 3 - expected false", false, testDLL3.deleteAt(3));
        
        //test list by deleting element one by one
        DoublyLinkedList<Integer> testDLL4 = new DoublyLinkedList<Integer>();
        testDLL4.insertBefore(0,1);
        testDLL4.insertBefore(1,5);
        testDLL4.insertBefore(3,9);
        assertEquals( "Checking deleteAt to a list by deleting element one by one", "1,5,9", testDLL4.toString());
        testDLL4.deleteAt(0);
        assertEquals( "Checking deleteAt to a list by deleting element one by one", "5,9", testDLL4.toString());
        testDLL4.deleteAt(0);
        assertEquals( "Checking deleteAt to a list by deleting element one by one", "9", testDLL4.toString());
    }
    
    
   
    @Test
    public void testReverse()
    {
    	// test list that has 5 element
        DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertBefore(0,1);
        testDLL.insertBefore(1,3);
        testDLL.insertBefore(2,9);
        testDLL.insertBefore(3,22);
        testDLL.insertBefore(4,152);
        assertEquals( "Checking insertBefore to a list containing 5 elements", "1,3,9,22,152", testDLL.toString());
        testDLL.reverse();
        assertEquals( "Checking reverse a list order containing 5 elements", "152,22,9,3,1", testDLL.toString());
    
        // test list that has one element
        DoublyLinkedList<Integer> testDLL2 = new DoublyLinkedList<Integer>();
        testDLL2.insertBefore(0,122);
        testDLL2.reverse();
        assertEquals( "Checking reverse when the list has just one element", "122", testDLL2.toString());

    	// test empty list
        DoublyLinkedList<Integer> testDLL3 = new DoublyLinkedList<Integer>();
        testDLL3.reverse();
        assertEquals( "Checking reverse to an empty list at position 2 - expected false", "", testDLL3.toString());
   
    }
    
    
    
    @Test
    public void testMakeUnique()
    {
    	//test non-empty list
        DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertBefore(0,1);
        testDLL.insertBefore(1,4);
        testDLL.insertBefore(2,9);
        testDLL.insertBefore(3,12);
        testDLL.insertBefore(4,9);
        assertEquals( "Checking insertBefore to a list ", "1,4,9,12,9", testDLL.toString() );
        testDLL.makeUnique();        
        assertEquals( "Checking makeUnique to delete the same element", "1,4,9,12", testDLL.toString());
        
        
        DoublyLinkedList<Integer> testDLL2 = new DoublyLinkedList<Integer>();
        testDLL2.insertBefore(0,5);
        testDLL2.insertBefore(1,9);
        testDLL2.insertBefore(3,5);
        testDLL2.insertBefore(4,9);
        assertEquals( "Checking insertBefore to a list", "5,9,5,9", testDLL2.toString() );
        testDLL2.makeUnique();
        assertEquals( "Checking makeUnique to delete two pair of elements", "5,9", testDLL2.toString() );
        
        DoublyLinkedList<Integer> testDLL3 = new DoublyLinkedList<Integer>();
        testDLL3.insertBefore(0,5);
        testDLL3.insertBefore(1,5);
        testDLL3.insertBefore(2,5);
        testDLL3.insertBefore(3,7);
        testDLL3.insertBefore(4,7);
        testDLL3.insertBefore(5,7);
        assertEquals( "Checking insertBefore to a list", "5,5,5,7,7,7", testDLL3.toString());
        testDLL3.makeUnique();
        assertEquals( "Checking makeUnique to delete several elements", "5,7", testDLL3.toString() );
        
    	//test empty list
        DoublyLinkedList<Integer> testDLL4 = new DoublyLinkedList<Integer>();
        testDLL4.makeUnique();
        assertEquals( "Checking makeUnique to an empty list - expected false","", testDLL4.toString());   
    }
    
    
    
    @Test
    public void testPush()
    {
        DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
        testDLL.push(1);
        testDLL.push(3);
        testDLL.push(22);
        testDLL.push(7);
        testDLL.push(13);
        assertEquals( "Checking push to a list", "13,7,22,3,1", testDLL.toString());
    }
    
    
    
    @Test
    public void testPop(){
        DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
        testDLL.push(3);
        testDLL.push(4);
        assertEquals( "Checking push to a list", "4,3", testDLL.toString());
    	String test = testDLL.pop().toString();
    	assertEquals( "Checking pop to a list containing 2 elements", "4", test );
    	testDLL.pop();
    	testDLL.pop();
    	assertEquals( "Checking pop to a list containing no elements", null, testDLL.pop() );
                
  }
    
    @Test
    public void testEnqueue()
    {
        DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
        testDLL.enqueue(9);
        testDLL.enqueue(123);
        testDLL.enqueue(55);
        testDLL.enqueue(8);      
        assertEquals( "Checking Enqueue to a list", "9,123,55,8", testDLL.toString());
    }
    
    
    @Test
    public void testDequeue()
    {
        DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
        testDLL.enqueue(7);
        testDLL.enqueue(99);
    	assertEquals( "Checking Dequeue to a list containing 2 elements", "7,99", testDLL.toString() );
    	assertEquals( "Checking Dequeue to a list containing 1 element", "7", testDLL.dequeue().toString());
    	testDLL.dequeue();
    	testDLL.dequeue();
    	assertEquals( "Checking Dequeue to a list containing no elements", null, testDLL.dequeue() );
   }
    
}

 