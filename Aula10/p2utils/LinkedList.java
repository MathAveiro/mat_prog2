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

   public String toString() {
    String final1 = "";
    String s = toString(size(), 0, final1);
/*System.out.println("ksdfhksdhgk"+s);
System.out.println(size());*/
    return s;
      //return toString(size(), 0);

   }

   private String toString(int size, int cont, String final1) {



    if (cont < size) {

      //System.out.println(first.elem);

      final1 = final1 + first.elem.toString();

      addLast(first.elem);

      removeFirst();

      return toString(size, cont+1, final1);

    }

    else return final1;

   }

   
   public E get (int pos) {   
       
       return get(pos, first, 0);
       
   }
   
   private E get (int pos ,Node <E> n, int i) {
    
       if (pos == i) return n.elem;
       
       else {
            
           return  get(pos, n.next, i+1);
           
       }     
           
   }

   private Node<E> first = null;
   private Node<E> last = null;
   private int size = 0;

   // Acrescente as funções adicionais pedidas no guião:

}

