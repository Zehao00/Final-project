import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

// -------------------------------------------------------------------------
/**
 *  This class contains the methods of Doubly Linked List.
 *
 *  @author  
 *  @version 09/10/18 11:13:22
 */


/**
 * Class DoublyLinkedList: implements a *generic* Doubly Linked List.
 * @param <T> This is a type parameter. T is used as a class name in the
 * definition of this class.
 *
 * When creating a new DoublyLinkedList, T should be instantiated with an
 * actual class name that extends the class Comparable.
 * Such classes include String and Integer.
 *
 * For example to create a new DoublyLinkedList class containing String data: 
 *    DoublyLinkedList<String> myStringList = new DoublyLinkedList<String>();
 *
 * The class offers a toString() method which returns a comma-separated sting of
 * all elements in the data structure.
 * 
 * This is a bare minimum class you would need to completely implement.
 * You can add additional methods to support your code. Each method will need
 * to be tested by your jUnit tests -- for simplicity in jUnit testing
 * introduce only public methods.
 */
class DoublyLinkedList<T extends Comparable<T>>
{

    /**
     * private class DLLNode: implements a *generic* Doubly Linked List node.
     */
    private class DLLNode
    {
        public final T data; // this field should never be updated. It gets its
                             // value once from the constructor DLLNode.
        public DLLNode next;
        public DLLNode prev;
    
        /**
         * Constructor
         * @param theData : data of type T, to be stored in the node
         * @param prevNode : the previous Node in the Doubly Linked List
         * @param nextNode : the next Node in the Doubly Linked List
         * @return DLLNode
         */
        public DLLNode(T theData, DLLNode prevNode, DLLNode nextNode) 
        {
          data = theData;
          prev = prevNode;
          next = nextNode;
        }
    }

    // Fields head and tail point to the first and last nodes of the list.
    private DLLNode head, tail;

    
    /**
     * Constructor of an empty DLL
     * @return DoublyLinkedList
     */
    public DoublyLinkedList() 
    {
      head = null;
      tail = null;
    }

    
    
    /**
     * Tests if the doubly linked list is empty
     * @return true if list is empty, and false otherwise
     *
     * Worst-case asymptotic running time cost: Theta(1)
     *
     * Justification:
     *  line 2 ！ line 6 : executed Theta(1) times, each execution takes Theta(1) time
     *  So the Worst-case asymptotic running time cost of isEmpty() is Theta(1).
     */
    public boolean isEmpty()
    {
    	
      if(head==null)
      {
    	return true;  
      }
      
      else return false;
      
    }

    
    /**
     * Inserts an element in the doubly linked list
     * @param pos : The integer location at which the new data should be
     *      inserted in the list. We assume that the first position in the list
     *      is 0 (zero). If pos is less than 0 then add to the head of the list.
     *      If pos is greater or equal to the size of the list then add the
     *      element at the end of the list.
     * @param data : The new data of class T that needs to be added to the list
     * @return none
     *
     * Worst-case asymptotic running time cost: Theta(N)
     *
     * Justification:
     *  line 2 : executed Theta(1) times, execution takes Theta(1) time
     *  line 3 : executed Theta(1) times, execution takes Theta(1) time
     *  line 4 ！ line 8 : executed Theta(N) times, each execution takes Theta(1) time
     *  line 9 : executed Theta(1) times, execution takes Theta(1) time
     *  line 10 ！ line 20 : executed Theta(1) times, each execution takes Theta(1) time
     *  line 21 ！ line 44 : executed Theta(1) times  ->  line 21 ！ line 24 : executed Theta(N) times, each execution takes Theta(1) time
     *                                                   line 25 ！ line 28 : each execution takes Theta(1) time
     *                                                   line 29 ！ line 44 : each execution takes Theta(1) time
     *  line 45 ！ line 49 : executed Theta(N) times, each execution takes Theta(1) time
     *  line 50 ！ line 56 : executed Theta(1) times, each execution takes Theta(1) time
     *  Therefore, the Worst-case asymptotic running time cost of insertBefore is Theta(1) + Theta(1) + Theta(N) * Theta(1) + Theta(1) + Theta(1) +Theta(1) * (Theta(N) + Theta(1) +Theta(1) + Theta(1)) + Theta(N) * Theta(1) + Theta(1)= Theta(N)
     */
    public void insertBefore( int pos, T data ) 
    {
    
    	int listLength = 0;
    	DLLNode point = head;
    	
    	while(point != null)
    	{
    		point = point.next;
    		listLength++;
    	}
    	
    	listLength--;
    	
    	if(pos > listLength)
    	{
    		
    	  DLLNode input = new DLLNode(data, null, null);
    	  input.next = null;
    	  DLLNode theEnd = head;
    	  
    	  if(head == null)
    	 {
    		 input.prev = null;
    		 head = input;
    		 return;
    	 }		
    		  
    	  while(theEnd.next != null)
    	 {
    		theEnd = theEnd.next;
    	 }
    	  
    		input.prev = theEnd;
    		theEnd.next = input;
    	    return;
    	}
    	
    	else if(pos <= 0)
    	{	
    		
      	    DLLNode input = new DLLNode(data, null, null);
      	    input.next = head;
      	    
      	    if(head != null)
      	    {
      		   head.prev = input;
      	    }
      	       head = input;
      	       return;
      	       
      	}
    	
    	else 
    	{
    		DLLNode point2 = head;
    		int index = 0;
    		pos = pos - 1;
    		
    		while(index != pos)
    		{
    			point2 = point2.next;
    			index++;
    		}
    		
    		DLLNode input = new DLLNode(data, null, null);
    		input.next = point2.next;
    		point2.next.prev = input;
    		point2.next = input;
    		input.prev = point2;
    		return;
    		
    	}
    }

    
    /**
     * Returns the data stored at a particular position
     * @param pos : the position
     * @return the data at pos, if pos is within the bounds of the list, and null otherwise.
     *
     * Worst-case asymptotic running time cost: Theta(N)
     *
     * Justification:
     * line 2 ！ line 5 : executed Theta(1) times, each execution takes Theta(1) time
     * line 6 : executed Theta(1) times, execution takes Theta(1) time
     * line 7 : executed Theta(1) times, execution takes Theta(1) time
     * line 8 ！ line 12 : executed Theta(N) times, each execution takes Theta(1) time
     * line 13 : executed Theta(1) times, execution takes Theta(1) time
     * line 14 ！ line 17 : executed Theta(1) times, each execution takes Theta(1) time
     * line 18 ！ line 22 : executed Theta(N) times, each execution takes Theta(1) time
     * line 23 ！ line 28 : executed Theta(1) times, execution takes Theta(1) time
     * Therefore, the Worst-case asymptotic running time cost of get() is Theta(1) + Theta(1) + Theta(1) + Theta(1) * Theta(N) + Theta(1) + Theta(1) * Theta(N)  + Theta(1) + Theta(1)= Theta(N)
     *
     */
    public T get(int pos) 
    {
    	if(isEmpty()) 
        {
         return null;
        }
    	
    	int listLength = 0;
    	DLLNode point = head;
    	
    	while(point != null)
    	{
    		point = point.next;
    		listLength++;
    	}
    	
    	listLength--;
    	
    	if(pos >= 0 && pos <= listLength)
    	{
    		
    		DLLNode point2 = head;
    		int index = 0;
    		
    		while(index != pos)
    		{
    			point2 = point2.next;
    			index++;
    		}
    		
    		return point2.data;
    		
    	}
    	
    	else
    	{
    		return null;
    	}
    }

    
    
    /**
     * Deletes the element of the list at position pos.
     * First element in the list has position 0. If pos points outside the
     * elements of the list then no modification happens to the list.
     * @param pos : the position to delete in the list.
     * @return true : on successful deletion, false : list has not been modified. 
     *
     * Worst-case asymptotic running time cost: Theta(N)
     *
     * Justification:
     * line 2 ！ line 5 :  executed Theta(1) times, each execution takes Theta(1) time
     * line 6 : executed Theta(1) times, execution takes Theta(1) time
     * line 7 : executed Theta(1) times, execution takes Theta(1) time
     * line 8 ！ line 12 : executed Theta(N) times, each execution takes Theta(1) time
     * line 13 : executed Theta(1) times, execution takes Theta(1) time
     * line 14 : executed Theta(1) times, execution takes Theta(1) time
     * line 15 ！ line 19 : executed Theta(N) times, each execution takes Theta(1) time
     * line 20 ！ line 38 : executed Theta(1) times, each execution takes Theta(1) time
     * Therefore, the worst-case asymptotic running time cost is Theta(1) * Theta(1) + Theta(1) + Theta(1) + Theta(1) * Theta(N) + Theta(1) + Theta(1) + Theta(1) * Theta(N) + Theta(1) * Theta(1)
     *                                                           = Theta(N)
     */
    public boolean deleteAt(int pos) 
    {
    	
      if(isEmpty()) 
     {
      return false;
     }
      
    int listLength = 0;
  	DLLNode point = head;
  	
  	while(point != null)
  	{
  		point = point.next;
  		listLength++;
  	}
  	
        DLLNode point2 = head;
        int index = 0;
        
		while(index != pos && point2.next != null)
		{
			point2 = point2.next;
			index++;
		}
		
		if(0 <= pos && pos < listLength)
	   {
			
			
    	 if(point2 == head)
    	 {  
    		 DLLNode start = head.next;
    		 head = start;
    	 }
    	 
    	 else if(pos == (listLength-1))
    	 {
    		 point2.prev.next = null;
    	 }
    	 
    	 else 
    	 { 
    	     point2.prev.next = point2.next;     
    	     point2.next.prev = point2.prev;
    	 }
    	 
    	 return true;
    	 
	   }
		
     return false;
     
    }
    
    
    
    /**
     * Reverses the list.
     * If the list contains "A", "B", "C", "D" before the method is called
     * Then it should contain "D", "C", "B", "A" after it returns.
     *
     * Worst-case asymptotic running time cost: Theta(N)
     *
     * Justification:
     * line 4 : executed Theta(1) times, execution takes Theta(1) time
     * line 5 : executed Theta(1) times, execution takes Theta(1) time
     * line 6 ！ line 10 : executed Theta(N) times, each execution takes Theta(1) time
     * line 11 : executed Theta(1) times, execution takes Theta(1) time
     * line 12 : executed Theta(1) times, execution takes Theta(1) time
     * line 13 : executed Theta(1) times, execution takes Theta(1) time
     * line 14 ！ line 24 : executed Theta(N) times, each execution takes Theta(1) time
     * Therefore, the worst-case asymptotic running time cost is Theta(1) + Theta(1) + Theta(1) * Theta(N) + Theta(1) + Theta(1) + Theta(1) + Theta(1) * Theta(N) = Theta(N)
     */
    public void reverse()
    {
    	
     if(!isEmpty()) 
     {
    	 
      int listLength = 0;
      DLLNode point = head;
     
      while(point != null)
      {
    	  
       point = point.next;
       listLength++;
       
      }
      
       listLength = listLength - 1;
       
       int index2 = 0;
       int index = listLength;
       
      while(index2 <= (index/2)) 
     {
    	  
       int index3 = index - index2;
       T data1 = get(index2);
       T data2 = get(index3);
       
       deleteAt(index3);
       insertBefore(index3, data1);
       
       deleteAt(index2);
       insertBefore(index2, data2);
       index2++; 
       
     }
      
    }
}

    
    /**
     * Removes all duplicate elements from the list.
     * The method should remove the _least_number_ of elements to make all elements uniqueue.
     * If the list contains "A", "B", "C", "B", "D", "A" before the method is called
     * Then it should contain "A", "B", "C", "D" after it returns.
     * The relative order of elements in the resulting list should be the same as the starting list.
     *
     * Worst-case asymptotic running time cost: Theta(N^2)
     *
     * Justification:
     * line 4 : executed Theta(1) times, execution takes Theta(1) time
     * line 5 : executed Theta(1) times, execution takes Theta(1) time
     * line 6 ！ line 10 : executed Theta(N) times, each execution takes Theta(1) time
     * line 11 : executed Theta(1) times, execution takes Theta(1) time
     * line 12 ！ line 25 : executed Theta(N) times -> line 13 : executed Theta(1) times, execution takes Theta(1) time
     *                                                line 14 ！ line 23 : executed Theta(N) times, each execution takes Theta(1) time
     * Therefore, the worst-case asymptotic running time cost is Theta(1) + Theta(1) + Theta(1) * Theta(N) + Theta(1) + Theta(N) * (Theta(1) + Theta(N))
     *                                                           = Theta(N^2)                                 
     */
     public void makeUnique()
    {
    	 if(!isEmpty())  
	     {
    		 
	    	int listLength = 0;
	     	DLLNode point = head;
	     	
	     	while(point != null)
	     	{
	     		point = point.next;
	     		listLength++;
	     	}
	     	
	     	listLength = listLength - 1;
	     	
	     	for(int index = 0; index <= listLength; index++)
	     	{
	     		T value1 = get(index);
	     		
	     		for(int index2 = 0; index2 <= listLength; index2++)
	     		{
	     			T value2 = get(index2);
	     			
	     			if(value1 == value2 && index != index2)
	     			{
	     				listLength--;
	     				deleteAt(index2);
	     				index2--;
	     			}
	     			
	     		}
	     		
	     	}
	     	
	     }
     }


    /*----------------------- STACK API 
     * If only the push and pop methods are called the data structure should behave like a stack.
     */

     
     
    /**
     * This method adds an element to the data structure.
     * How exactly this will be represented in the Doubly Linked List is up to the programmer.
     * @param item : the item to push on the stack
     *
     * Worst-case asymptotic running time cost: Theta(N)
     *
     * Justification:
     * line 2 ！ line 5 : executed Theta(1) times -> line 4 : execution takes Theta(N) time
     * Therefore, the worst-case asymptotic running time cost is Theta(N) * Theta(1) = Theta(N)
     */
    public void push(T item) 
    {
    	
      if(item != null)
      {
    	  insertBefore(0, item);
      }
      
    }

    
    
    /**
     * This method returns and removes the element that was most recently added by the push method.
     * @return the last item inserted with a push; or null when the list is empty.
     *
     * Worst-case asymptotic running time cost: Theta(N)
     *
     * Justification:
     * line 2 ！ line 5 : executed Theta(1) times, each execution takes Theta(1) time
     * line 6 ！ line 11 : executed Theta(1) times -> line 8 : execution takes Theta(1) time
     *                                               line 9 : execution takes Theta(N) time
     *                                               line 10 : execution takes Theta(1) time
     * Therefore, the worst-case asymptotic running time cost is Theta(1) + Theta(1) * (Theta(1) + Theta(1) + Theta(N)) = Theta(N)   
     */
    public T pop() 
    {
    	
    	if(isEmpty()) 
        {
    		
         return null;
         
        }
    	
    	else
    	{
    		
    	 T value = get(0);
    	 deleteAt(0);
    	 return value;
    	
    	}
   
    }

    /*----------------------- QUEUE API
     * If only the enqueue and dequeue methods are called the data structure should behave like a FIFO queue.
     */
 
    
    
    /**
     * This method adds an element to the data structure.
     * How exactly this will be represented in the Doubly Linked List is up to the programmer.
     * @param item : the item to be enqueued to the stack
     *
     * Worst-case asymptotic running time cost: Theta(N)
     *
     * Justification:
     * line 2 ！ line 12 : executed Theta(1) times  ->  line 4 : execution takes Theta(1) time
     *                                                 line 5 : execution takes Theta(1) time
     *                                                 line 6 ！ line 10 : executed Theta(N) times, execution takes Theta(1) time   
     *                                                 line 11 : execution takes Theta(N) time
     * Therefore, the worst-case asymptotic running time cost is Theta(1) * (Theta(1) + Theta(1) + Theta(1) * Theta(N) + Theta(N)) = Theta(N)
     */
    public void enqueue(T item) 
    {
    	if(item != null)
        {
    		
      	    int listLength = 0;
            DLLNode point = head;
            
            while(point != null)
            {
             point = point.next;
             listLength++;
            }
            
      	  insertBefore(listLength, item);
      	  
        }
    }

    
    
     /**
     * This method returns and removes the element that was least recently added by the enqueue method.
     * @return the earliest item inserted with an equeue; or null when the list is empty.
     *
     * Worst-case asymptotic running time cost: Theta(1)
     *
     * Justification:
     * line 2 ！ line 5 : executed Theta(1) times, execution takes Theta(1) time
     * line 6 ！ line 12 : executed Theta(1) times  ->  line 8 : execution takes Theta(1) time
     *                                                 line 9 : execution takes Theta(1) time
     *                                                 line 10 : execution takes Theta(1) time
     *                                                 line 11 : execution takes Theta(1) time
     * Therefore, the worst-case asymptotic running time cost is Theta(1) + Theta(1) * (Theta(1) + Theta(1) + Theta(1) + Theta(1)) = Theta(1)
     */
    public T dequeue() 
    {
      
    	if(isEmpty()) 
        {
         return null;
        }
    	
    	else
    	{
    		 DLLNode newHead = head;
        	 head = head.next;
        	 newHead.next = null;
        	 return newHead.data;
    	}
    	
    }
 

    
    /**
     * @return a string with the elements of the list as a comma-separated
     * list, from beginning to end
     *
     * Worst-case asymptotic running time cost:   Theta(n)
     *
     * Justification:
     *  We know from the Java documentation that StringBuilder's append() method runs in Theta(1) asymptotic time.
     *  We assume all other method calls here (e.g., the iterator methods above, and the toString method) will execute in Theta(1) time.
     *  Thus, every one iteration of the for-loop will have cost Theta(1).
     *  Suppose the doubly-linked list has 'n' elements.
     *  The for-loop will always iterate over all n elements of the list, and therefore the total cost of this method will be n*Theta(1) = Theta(n).
     */
    public String toString() 
    {
      StringBuilder s = new StringBuilder();
      boolean isFirst = true; 

      // iterate over the list, starting from the head
      for (DLLNode iter = head; iter != null; iter = iter.next)
      {
        if (!isFirst)
        {
          s.append(",");
        } else {
          isFirst = false;
        }
        s.append(iter.data.toString());
      }

      return s.toString();
    }


}



