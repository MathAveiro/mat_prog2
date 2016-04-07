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
   
   //-----------------------------------//
   
   public LinkedList clone () {   
       
       return clone (first);
       
   }
   
   private LinkedList clone (Node <E> n) {
    
       if (n == null) return new LinkedList <E>();
       
       else {
            
          LinkedList <E> newList = clone (n.next);
           
           newList.addFirst(n.elem); 
           
           return  newList;
           
       }     
           
   }

   public LinkedList reverse () {   
       
       return reverse (first);
       
   }
   
   private LinkedList reverse (Node <E> n) {
    
        
       if (n == null) return new LinkedList <E>();
       
       else {
            
           LinkedList <E> newList = reverse (n.next);
           
           newList.addLast(n.elem); 
           
           return  newList;
           
       }     
           
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
   
   public LinkedList concatenate (LinkedList <E> lst) {   
       
       LinkedList <E> newList = lst.clone();
       
       return concatenate (newList, first);
       
   }
   
   private LinkedList concatenate (LinkedList lst, Node <E> elem) {
        
       if (elem == null) return  lst;
       
       else {
            
           lst = concatenate (lst, elem.next);
           
           lst.addFirst(elem.elem);
           
           return  lst;
           
       }     
           
   }
   
   public boolean contains (E e) {
       
       return contains (first, e);
       
   }
   
   private boolean contains (Node <E> n, E e) {
       
       if (n == null) return false;
       
       if (n.elem.equals(e)) return true;
       
       return contains (n.next, e);
       
   }
   
   public void remove (E e) {
       
       remove(first, e);
       
   }
   
   private void remove (Node <E> n, E e) {
       
       assert contains (e);
       
       if (get(0).equals(e)) {
       
            removeFirst();
           
       } 
       
       else if (n.next.elem.equals(e)) {
              
           n.next = n.next.next;
           
           size--; 
        
           return;
           
       } else {
           
           remove (n.next, e);
            
       }
       
   }

   private Node<E> first = null;
   private Node<E> last = null;
   private int size = 0;
  
}


