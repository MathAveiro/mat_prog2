package p2utils;

public class LinkedList<E> {

   /**
    * {@code LinkedList} constructor, empty so far.
    */
   public LinkedList() { }

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
    * @return  Last element in the list
    */
   public E last() {
      assert !isEmpty(): "empty!";
 
      return last.elem;
   }

   /**
    * Adds a new element to the start of the list
    */
   public void addFirst(E e) {
      first = new Node<>(e, first);
      if (isEmpty())
         last = first;
      size++;

      assert !isEmpty(): "empty!";
      assert first().equals(e) : "wrong element";
   }

   /**
    * Adds a new element to the end of the list
    */
   public void addLast(E e) {
      Node<E> newest = new Node<>(e);
      if (isEmpty())
         first = newest;
      else
         last.next = newest;
      last = newest;
      size++;

      assert !isEmpty(): "empty!";
      assert last().equals(e) : "wrong element";
   }

   /**
    * Removes the first element in the list
    */
   public void removeFirst() {
      assert !isEmpty(): "empty!";
      first = first.next;
      size--;
      if (isEmpty())
         last = null;
   }

   /**
    * Removes all elements
    */
   public void clear() {
      first = last = null;
      size = 0;
   }

   private Node<E> first = null;
   private Node<E> last = null;
   private int size = 0;

   // Acrescente as funções adicionais pedidas no guião:
   //HIDE
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

   /**
    * @return A new list with the same elements in the same sequence
    */
   public LinkedList<E> clone() { 
      return clone(first); 
   }
   private LinkedList<E> clone(Node<E> n) {
      if (n==null) return new LinkedList<>();
      LinkedList<E> cl = clone(n.next);
      cl.addFirst(n.elem);
      return cl;
   }

   /**
    * @return A new list with the same elements in reverse sequence
    */
   public LinkedList<E> reverse() { 
      return reverse(first); 
   }
   private LinkedList<E> reverse(Node<E> n) {
      if (n==null) return new LinkedList<>();
      LinkedList<E> rev = reverse(n.next);
      rev.addLast(n.elem);
      return rev;
   }

   // get: Problema 7.1 e 10.3
   /**
    * Finds and returns the element in the given position
    * @param  pos the position of the element, an integer i
    *             between {@code 0} and {@code size()-1}
    * @return the element in the given position
    */
   public E get(int pos) {
      assert pos<size;
      return get(first,pos);
   }
   private E get(Node<E> n,int pos) {
      if (pos==0) return n.elem;
      return get(n.next, pos-1);
   }

   /**
    * Concatenates itself with the given list producing a new list
    * @param lst a list
    * @return the concatenation
    */
   public LinkedList<E> concatenate(LinkedList<E> lst) { 
      return concatenate(first,lst);
   }
   private LinkedList<E> concatenate(Node<E> n, LinkedList<E> lst) { 
      if (n==null) return lst.clone();
      LinkedList<E> conc = concatenate(n.next,lst);
      conc.addFirst(n.elem);
      return conc;
   }

   /**
    * Checks if the given element exists in the list
    * @param e an element
    * @return {@code true} if the element exists and {@code false} otherwise
    */
   public boolean contains(E e) { 
      return contains(first,e); 
   }
   private boolean contains(Node<E> n,E e) {
      if (n == null) return false;
      if (n.elem==null) return e==null; //dispensável, se impedirmos elem==null
      if (n.elem.equals(e)) return true; 
      return contains(n.next,e);
   }

   /**
    * Removes the given element from the list. Assumes the element exists.
    * @param e an element
    */
   public void remove(E e) {
      assert contains(e) : "Element does not exist";
      first = remove(first,e);
      size--;
      if (isEmpty())
         last = null;
   }
   private Node<E> remove(Node<E> n,E e) {
      if (n.elem.equals(e)) return n.next;
      n.next = remove(n.next,e);
      if (n.next==null) last=n;
      return n;
   }
   //SHOW

}

