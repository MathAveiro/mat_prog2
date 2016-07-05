package p2utils;

public class SortedList<E extends Comparable<E>> {

   public SortedList() { }

   /**
    * Returns the first element in the list
    * @return  First element in the list
    */
   public E first() {
      assert !isEmpty(): "empty!";
      return first.elem;
   }

   /**
    * Inserts the given element in the list
    * @param e An element
    */
   public void insert(E e) {
      assert isSorted();

      first = insert(first,e);
      size++;

      assert !isEmpty() && contains(e) && isSorted();
   }
   private Node<E> insert(Node<E> n,E e) {
      if (n==null || e.compareTo(n.elem)<0) {
         Node<E> newnode = new Node<E>(e,n);
         return newnode;
      }
      n.next = insert(n.next,e);
      return n;
   }

   /**
    * Removes the first element in the list
    */
   public void removeFirst() {
      assert !isEmpty() && isSorted();

      first = first.next;
      size--;

      assert isSorted();
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
      if (n.elem.compareTo(prev.elem)<0) return false;
      return isSorted(n,n.next);
   }

   /**
    * Checks if the list contains the given element
    * @param e an element
    * @return {@code true} if list contains {@code e}, {@code false} otherwise
    */
   public boolean contains(E e) { 
      return contains(first,e);
   }
   private boolean contains(Node<E> n,E e) {
      if (n == null || e.compareTo(n.elem)<0) return false;
      if (n.elem.equals(e)) return true; 
      return contains(n.next,e);
   }

   /**
    * Returns the number of elements in the list
    * @return Number of elements in the list
    */
   public int size() { return size; }

   /**
    * Checks if the list is empty
    * @return  {@code true} if list empty, otherwise {@code false}.
    */
   public boolean isEmpty() { return size == 0; }

   /**
    * Returns a string representing the list contents
    * @return A string representing the list contents
    */
   public String toString() {
      if (size()==0) 
         return "[ ]";
      String s = "[ " + first.elem.toString();
      if (size()==1) 
         return s + " ]";
      Node<E> n = first.next;
      while (n!=null) {
         s += ("," + n.elem.toString());
         n = n.next;
      }
      return s + " ]";
   }

   // private data
   private Node<E> first = null;
   private int size = 0;
}


