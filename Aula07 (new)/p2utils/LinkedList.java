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
   
   public LinkedList<E> clone() {
   
    LinkedList<E> newlist = new LinkedList<E>();
   
    return clone(first, newlist);
   
   }

   private LinkedList<E> clone(Node<E> first, LinkedList<E> newlist) {

    if(first==null) return newlist;
   
    else {
   
      newlist.addLast(first.elem);
   
      return clone(first.next, newlist);
   
    }
   
   }

   public LinkedList<E> reverse() {

    LinkedList<E> newlist = new LinkedList<E>();

    return reverse(first, newlist);

   }

   private LinkedList<E> reverse(Node<E> first, LinkedList<E> newlist) {

    if(first==null) return newlist;

    else {
      
      newlist.addFirst(first.elem);

      return reverse(first.next, newlist);
    }

   }

   public E get(int pos) {

    return get(pos, first, 0);
   
   }

   private E get(int pos, Node<E> first, int index) {

    if(pos == index) return first.elem;

    else return get(pos, first.next, index+1);

   }

   public LinkedList<E> concatenate(LinkedList<E> lst) {

    LinkedList<E> newlist = clone();

    return concatenate(lst, lst.first, newlist);

   }

   private LinkedList<E> concatenate(LinkedList<E> lst, Node<E> n, LinkedList<E> newlist) {

    if(n == null) return newlist;

    else {
      
      newlist.addLast(n.elem);

      return concatenate(lst, n.next, newlist);

    }

   }

   public boolean contains(E e) {

    return contains(e, first);

   }

   private boolean contains(E e, Node<E> first) {

    if(first == null) return false;

    else if(first.elem.equals(e)) return true;

    else return contains(e, first.next);

   }

   public void remove(E e) {

    remove(e, null, first);

    size--;
   
   }

   private void remove(E e, Node<E> beforeFirst,Node<E> first) {

    if(first == null) return;

    else if(first.elem.equals(e)) {
     
      beforeFirst.next = first.next;
     
      return;
    
    }

    else remove(e, first, first.next);

   }

   private Node<E> first = null;
   private Node<E> last = null;
   private int size = 0;
  
}


