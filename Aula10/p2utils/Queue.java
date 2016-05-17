package p2utils;

public class Queue<E> {

   /**
    * Adds a new element to the queue
    */
   public void in(E element) { list.addLast(element); }

   /**
    * @return  First element in the queue
    */
   public E peek() { return list.first(); }

   /**
    * Removes the first element in the queue
    */
   public void out() { list.removeFirst(); }

   /**
    * @return Number of elements in the queue
    */
   public int size() { return list.size(); }

   public String toString() { return list.toString(); }

   public String toStringReverse () {

    String nova = new String();

    for (int i = 0; ; ) {
      
    }

   }

   /**
    * Checks if the queue is empty
    * @return  {@code true} if queue empty, otherwise {@code false}.
    */
   public boolean isEmpty() { return list.isEmpty(); }

   private LinkedList<E> list = new LinkedList<E>();
}


