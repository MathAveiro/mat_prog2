package p2utils;

public class Queue<E> {

   /**
    * Adds the given element to the queue
    * @param e An element
    */
   public void in(E e) { list.addLast(e); }

   /**
    * Returns de first element in the queue
    * @return  First element in the queue
    */
   public E peek() { return list.first(); }

   /**
    * Removes the first element in the queue
    */
   public void out() { list.removeFirst(); }

   /**
    * Returns the number of elements in the queue
    * @return Number of elements in the queue
    */
   public int size() { return list.size(); }

   /**
    * Checks if the queue is empty
    * @return  {@code true} if queue empty, otherwise {@code false}.
    */
   public boolean isEmpty() { return list.isEmpty(); }

   /**
    * Returns a string representing the queue contents
    * @return A string representing the queue contents
    */
   public String toString() { return list.toString(); }

   // private data
   private LinkedList<E> list = new LinkedList<E>();
}


