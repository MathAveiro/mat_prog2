package p2utils;


public class SortedList<E extends Comparable<E>> {

   public SortedList() { }

   /**
    * @return Number of elements in the list
    */
   public int size() { return size; }

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
      first = insert(first,e);
      size++;
   }
   private Node insert(Node<E> n, E e) {
      if (n==null || e.compareTo(n.elem)==-1)
         return new Node<>(e,n);
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
   private boolean isSorted(Node <E> prev,Node <E> n) {
      if (n == null) return true;
      if (n.elem.compareTo(prev.elem)==-1) return false;
      return isSorted(n,n.next);
   }
   public boolean contains(E e) {
      if(first==null) return false;
      if(e.compareTo(first.elem)==1) {
        return false;
      }
      else return contains(e, first);
   }
   private boolean contains(E e, Node<E> first) {
        if(first==null) return false;
        if(e.compareTo(first.elem)==-1) {
          return false;
        }
        else if(e.equals(first.elem)){
          return true;
        }
        else return contains(e, first.next);
   }

   public String toString() {
      String temp="[ ";
      return toString(temp, first);
   }
   private String toString(String temp, Node<E> first) {
      if(first==null) return temp+"]";
      else {
        if(first.next==null) temp = temp +first.elem+" ";
        else temp = temp +first.elem+" , ";
        return toString(temp, first.next);
      }
   }
   public SortedList<E> merge(SortedList lst) {
      SortedList<E> lista = new SortedList <E>();
      return merge(first, lst, lista);
   }
   private SortedList<E> merge(Node<E> first, SortedList lst, SortedList lista) {
      if(first==null && lst.first==null) return lista;
      if(first!=null) {
        lista.insert(first.elem);
        first = first.next;
      }
      if(lst.first!=null) {
        lista.insert(lst.first());
        lst.removeFirst();
      }
      lista.isSorted();
      return merge(first, lst, lista);
   }

   // private attributes
   private Node<E> first = null;
   private int size = 0;

}
