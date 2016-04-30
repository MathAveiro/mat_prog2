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

   public int count (E e) {

      return count(e, first ,0);

   }

   private int count (E e, Node first, int count) {

      if (first.next == null) return count;

      else if (first.elem.equals(e)) return count(e, first.next, count+1);

      else return count(e, first.next, count);

   }

   public int indexOf (E e) {

      return indexOf(e, first, 0);

   }

   private int indexOf (E e, Node first, int index) {

      if (first == null) return index;

      else {

        if (first.elem.equals(e)) return index;
        else return indexOf (e, first.next, index+1);

      }

   }

   public LinkedList<E> cloneReplace (E x, E y) {

      LinkedList<E> newList = new LinkedList<E>();

      return cloneReplace (x, y, first, newList);

   }

   private LinkedList<E> cloneReplace (E x, E y, Node <E> first, LinkedList<E> newList) {

      if (first == null) return newList;

      else {

        if (first.elem.equals(x)) newList.addLast(y);

        else newList.addLast(first.elem);

        return cloneReplace(x, y, first.next, newList);

      }

   }

   public LinkedList<E> cloneSublist (int x, int y) {

      LinkedList<E> newList = new LinkedList<E>();

      int cont = 0;

      return cloneSublist (x, y, cont, newList, first);

   }

   private LinkedList<E> cloneSublist (int x, int y, int cont, LinkedList<E> newList, Node<E>  first) {

      if (cont > y) return newList;

      else if (cont >= x && cont < y) {

        newList.addLast(first.elem);

        return cloneSublist (x, y, cont+1, newList, first.next);

      }

      else return cloneSublist (x, y, cont+1, newList, first.next);
   }


   public LinkedList<E> cloneExceptSublist (int x, int y) {

      LinkedList<E> newList = new LinkedList<E>();

      int cont = 0;

      return cloneExceptSublist (x, y, cont, newList, first);

   }

   private LinkedList<E> cloneExceptSublist (int x, int y, int cont, LinkedList<E> newList, Node<E>  first) {

        if (first == null) return newList;

        if (cont >= x && cont < y) return cloneExceptSublist(x, y, cont+1, newList, first.next);

        else {

          newList.addLast(first.elem);

          return cloneExceptSublist (x, y, cont+1, newList, first.next);

        }
   }


   public void removeSublist (int x, int y) {

      removeSublist (x, y, 1,first, size());

   }

   private void removeSublist (int x, int y, int cont, Node<E> n, int size) {

    if (cont > size) return;

    if (n == null) return;

      if (cont > x && cont <= y) {

        removeFirst();

        removeSublist(x, y, cont+1, n.next, size);
      
      }
      
      else {

        addLast(n.elem);

        removeFirst();

        removeSublist (x, y,cont+1, n.next, size);

      }

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

      assert !isEmpty() && first().equals(e);
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

      assert !isEmpty() && last().equals(e);
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

   private Node<E> first = null;
   private Node<E> last = null;
   private int size = 0;

}


