package p2utils;

public class Stack<E> {

   /**
    * Adds a new element to the top of the stack
    * @param e An element
    */
   public void push(E e) { list.addFirst(e); }

   /**
    * Returns the top element in the stack
    * @return  Top element in the stack
    */
   public E top() { return list.first(); }

   /**
    * Removes the top element in the stack
    */
   public void pop() { list.removeFirst(); }

   /**
    * Returns the number of elements in the stack
    * @return Number of elements in the stack
    */
   public int size() { return list.size(); }

   /**
    * Checks if the stack is empty
    * @return  {@code true} if stack empty, otherwise {@code false}.
    */
   public boolean isEmpty() { return list.isEmpty(); }

   /**
    * Returns a string representing the stack contents.
    * (Top value first).
    * @return A string representing the stack contents
    */
   public String toString() { return list.toString(); }

   // private data
   private LinkedList<E> list = new LinkedList<E>();
}

