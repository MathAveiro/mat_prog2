package p2utils;

public class SortedArray<E extends Comparable<E>> {

    private int arrayLength;        

   public SortedArray(int arrayLength) { 
       
       this.arrayLength = arrayLength;
       
   }

   /**
    * @return Number of elements in the list
    */
   public int size() { return size; }

   public int arrayLength () { 
       
       return this.arrayLength;
   
   }

   /**
    * Checks if the list is empty
    * @return  {@code true} if list empty, otherwise {@code false}.
    */
   public boolean isEmpty() { return size == 0; }

   /**
    * @return  First element in the list
    */
   public E first() {
      assert !isEmpty(): "empty!";
      return first.elem;
   }

   /**
    * Inserts a new element in the list
    * @param e the element to be inserted
    */
   public void insert(E e) {
      
      if (!isFull()) {
          
        first = insert(first,e);
        size++;    
          
      } else return;
      
   }
   private Node insert(Node<E> n,E e) {
       
      if (n==null || e.compareTo(n.elem)==-1)
         return new Node<E>(e,n);
      n.next = insert(n.next,e);
      return n;
   }

   /**
    * Removes the first element in the list
    */
   public void removeFirst() {
      assert !isEmpty(): "empty!";
      first = first.next;
      size--;
   }

   /**
    * Checks if the list is sorted
    * @return {@code true} if sorted, {@code false} otherwise
    */
   public boolean isSorted() { 
      if (size < 2)
         return true;
      return isSorted(first,first.next);
   }
   private boolean isSorted(Node<E> prev,Node<E> n) {
      if (n == null) return true;
      if ((n.elem).compareTo(prev.elem)==-1) return false;
      return isSorted(n,n.next);
   }
   
   //------------------------------------------//
   
   public boolean contains (E e) {
       
       if (e.compareTo(first.elem)==-1) return false;

       return contains (first, e);
       
   }
   
   private boolean contains (Node<E> n, E e) {
    
       if (n == null || e.compareTo(n.elem)==-1) return false;

       if (n.elem.equals(e)) return true;

       return contains (n.next, e);
       
   }
   
   public boolean isFull() {
       
       if (size == arrayLength) return true;
       
       else return false;
       
   }

   // private attributes
   private Node<E> first = null;
   private int size = 0;

}
