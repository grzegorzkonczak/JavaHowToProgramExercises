// Grzegorz Koñczak, 28.08.2016
// Exercise number 21.10 page 946
// Exercise from Java:How to program 10th edition

package com.deitel.datastructures;

public class Stack<T>
{
   private List<T> stackList;

   // constructor
   public Stack() 
   { 
      stackList = new List<T>("stack"); 
   } 

   // add object to stack
   public void push(T object)
   { 
      stackList.insertAtFront(object); 
   } 

   // remove object from stack
   public T pop() throws EmptyListException
   { 
      return stackList.removeFromFront(); 
   } 

   // determine if stack is empty
   public boolean isEmpty() 
   { 
      return stackList.isEmpty(); 
   } 

   // output stack contents
   public void print() 
   { 
      stackList.print(); 
   } 
} // end class Stack
