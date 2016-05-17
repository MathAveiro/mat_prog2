package p2utils;

public class Stack<E> {

   /**
    * Adds a new element to the top of the stack
    */
   public void push(E element) { list.addFirst(element); }

   /**
    * @return  Top element in the stack
    */
   public E top() { return list.first(); }

   /**
    * Removes the top element in the stack
    */
   public void pop() { list.removeFirst(); }

   /**
    * @return Number of elements in the list
    */
   public int size() { return list.size(); }

   public String toString() { 

    String nova = new String();

    

    for (int i = list.toString().length() - 1; i >=0 ; i--) {
      
      nova += list.toString().charAt(i);

    }

    return nova;

  }

   /**
    * Checks if the stack is empty
    * @return  {@code true} if stack empty, otherwise {@code false}.
    */
   public boolean isEmpty() { return list.isEmpty(); }

   private LinkedList<E> list = new LinkedList<E>();
}

