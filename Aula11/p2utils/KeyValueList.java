package p2utils;

public class KeyValueList<E> {

   /**
    * {@code LinkedList} constructor
    */
   public KeyValueList() { }

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
    * Updates the element associated to the given key, if the
    * key already exists; otherwise, inserts a new pair with
    * the given key and element
    * @param  k a key
    * @param  e an element
    * @return  {@code true} if the key was added (size increased), 
    *          otherwise {@code false}.
    */
   public boolean set(String k,E e) {
      int prev_size = size;
      first = set(first,k,e);
      assert contains(k) && get(k).equals(e);
      return size>prev_size;
   }
   private KeyValueNode<E> set(KeyValueNode<E> n,String k,E e) {
      if (n==null) {
         KeyValueNode<E> newnode = new KeyValueNode<E>(k,e);
         size++;
         return newnode;
      }
      if (n.key.equals(k)) {
         n.elem = e;
      }
      else n.next = set(n.next,k,e);
      return n;
   }

   /**
    * @param  A key
    * @return Returns the element associated to the given key
    */
   public E get(String k) {
      assert contains(k) : "Key does not exist";
      return get(first,k);
   }
   private E get(KeyValueNode<E> n,String k) {
      if (n.key.equals(k)) return n.elem;
      return get(n.next,k);
   }

   /**
    * Removes the given key and associated element
    * @param  A key
    */
   public void remove(String k) {
      assert contains(k) : "Key does not exist";
      first = remove(first,k);
      size--;
      assert !contains(k) : "Key still exists";
   }
   private KeyValueNode<E> remove(KeyValueNode<E> n,String k) {
      if (n.key.equals(k)) return n.next;
      n.next = remove(n.next,k);
      return n;
   }

   /**
    * @return Returns an array with all keys in the list
    */
   public String[] keys() {
      String[] keys = new String[size];
      keys(first,0,keys);
      return keys;
   }
   private void keys(KeyValueNode<E> n,int i,String[] keys) {
      if (n==null) return;
      keys[i] = n.key;
      keys(n.next,i+1,keys);
      return;      
   }

   /**
    * Checks if the given key exists in the list
    * @param k a key
    * @return {@code true} if the key exists and {@code false} otherwise
    */
   public boolean contains(String k) { 
      return contains(first,k);
   }
   private boolean contains(KeyValueNode<E> n,String k) {
      if (n == null) return false;
      if (n.key.equals(k)) return true; 
      return contains(n.next,k);
   }

   private KeyValueNode<E> first = null;
   private int size = 0;
}


