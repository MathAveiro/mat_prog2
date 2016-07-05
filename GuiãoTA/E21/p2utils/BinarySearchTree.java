package p2utils;

import static java.lang.System.*;

public class BinarySearchTree<E>
{
   /**
    * {@code BinarySearchTree} constructor
    */
   public BinarySearchTree() { }

   /**
    * Updates the element associated to the given key, if the
    * key already exists; otherwise, inserts a new pair with
    * the given key and element
    * @param  key a key
    * @param  elem an element
    */
   public void set(String key,E elem)
   {
      assert key != null;

      AASNode<E> n = (root != null ? root.search(key) : null);
      if (n != null)
         n.elem = elem;
      else
      {
         n = new AASNode<E>(key,elem);
         root = n.insertAsLeaf(root);
         aSize++;
      }

      assert contains(key);
      assert get(key) == elem;
   }

   /**
    * Returns the element associated to the given key
    * @param  key a key
    * @return the element associated to the given key
    */
   public E get(String key)
   {
      assert key != null;
      assert contains(key);

      return root.search(key).elem;
   }

   /**
    * Removes the given key and associated element
    * @param  key a key
    */
   public void remove(String key)
   {
      assert key != null;
      assert contains(key);

      //root = root.removeUsingSearchMin(key);
      root = root.removeUsingInsert(key);
      aSize--;

      assert !contains(key);
   }

   /**
    * Checks if the given key exists in the tree
    * @param key a key
    * @return {@code true} if the key exists and {@code false} otherwise
    */
   public boolean contains(String key)
   {
      assert key != null;

      return root != null && root.contains(key);
   }

   /**
    * Checks if the tree is empty
    * @return  {@code true} if tree empty, otherwise {@code false}.
    */
   public boolean isEmpty()
   {
      return size() == 0;
   }

   /**
    * Returns number of elements in the tree
    * @return Number of elements in the tree
    */
   public int size()
   {
      return aSize;
   }

   /**
    * Remove all entries from the tree
    */
   public void clear()
   {
      root = null;
      aSize = 0;
   }

   /**
    * Returns an array with all keys in the tree
    * @return An array of keys
    */
   public String[] keys()
   {
      String[] result = new String[aSize];
      if (root != null)
         root.setArray(result,0);
      return result;
   }

   /**
    * Returns a string representing the contents of the tree
    * @return A string representing the contents of the tree
    */
   public String toString()
   {
      return root != null ? root.toString() : "";
   }

   private AASNode<E> root = null;
   private int aSize = 0;
}

class AASNode<E>
{
   AASNode(String key,E elem)
   {
      this.key = key;
      this.elem = elem;
   }

   // this == root
   AASNode<E> search(String key)
   {
      AASNode<E> result = null;
      int c = key.compareTo(this.key);
      if (c == 0)
         result = this;
      else if (c < 0 && left != null)
         result = left.search(key);
      else if (c > 0 && right != null)
         result = right.search(key);
      return result;
   }

   // this == root
   boolean contains(String key)
   {
      return search(key) != null;
   }

   // this == new node
   // returns new root
   AASNode<E> insertAsLeaf(AASNode<E> root)
   {
      AASNode<E> result = root;

      if (root == null)
         result = this; // insert!
      else if (key.compareTo(root.key) < 0)
         root.left = insertAsLeaf(root.left);
      else
         root.right = insertAsLeaf(root.right);

      return result;
   }

   // this == root
   AASNode<E> removeUsingSearchMin(String key)
   {
      assert contains(key);

      AASNode<E> result = this;

      int c = key.compareTo(this.key);
      if (c == 0)
      {
         if (left == null)
            result = right;
         else if (right == null)
            result = left;
         else
         {
            result = right.leftmostNode();
            right = right.removeUsingSearchMin(result.key);
            result.left = left;
            result.right = right;
         }
      }
      else if (c < 0)
         left = left.removeUsingSearchMin(key);
      else
         right = right.removeUsingSearchMin(key);

      return result;
   }

   // this == root
   AASNode<E> removeUsingInsert(String key)
   {
      assert contains(key);

      AASNode<E> result = this;

      int c = key.compareTo(this.key);
      if (c == 0)
      {
         if (right == null)
            result = left;
         else
            result = right.insertAsLeaf(left);
      }
      else if (c < 0)
         left = left.removeUsingInsert(key);
      else
         right = right.removeUsingInsert(key);

      return result;
   }

   // this == root
   AASNode<E> leftmostNode()
   {
      return (left != null) ? left.leftmostNode() : this;
   }

   int setArray(String[] keys,int i)
   {
      int result = i;
      if (left != null)
         result = left.setArray(keys,result);
      keys[result++] = key;
      if (right != null)
         result = right.setArray(keys,result);
      return result;
   }

   public String toString()
   {
      return key + (left != null ? " "+left.toString() : "") + (right != null ? " "+right.toString() : ""); 
   }

   String key;
   E elem;
   AASNode<E> left = null;
   AASNode<E> right = null;
}

