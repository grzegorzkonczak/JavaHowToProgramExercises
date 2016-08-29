// Grzegorz Koñczak, 29.08.2016
// Exercise number 21.15 page 948
// Exercise from Java:How to program 10th edition

package com.deitel.datastructures;

public class Queue<T> 
{
   private List<T> queueList;

   // constructor
   public Queue() 
   { 
      queueList = new List<T>("queue"); 
   } 

   // add object to queue
   public void enqueue(T object)
   { 
      queueList.insertAtBack(object); 
   }

   // remove object from queue
   public T dequeue() throws EmptyListException
   { 
      return queueList.removeFromFront(); 
   }
   
   public int size(){
	   return queueList.size();
   }

   // determine if queue is empty
   public boolean isEmpty()
   {
      return queueList.isEmpty();
   }

   // output queue contents
   public void print()
   {
      queueList.print();
   }
} // end class Queue

