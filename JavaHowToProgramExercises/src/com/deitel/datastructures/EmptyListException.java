// Grzegorz Koñczak, 27.08.2016
// Exercise number 21.6 page 946
// Exercise from Java:How to program 10th edition

package com.deitel.datastructures;

public class EmptyListException extends RuntimeException 
{
   // constructor
   public EmptyListException()
   {
      this("List"); // call other EmptyListException constructor
   } 

   // constructor
   public EmptyListException(String name)
   {
      super(name + " is empty"); // call superclass constructor
   } 
} // end class EmptyListException