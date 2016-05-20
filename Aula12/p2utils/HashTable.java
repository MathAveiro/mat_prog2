package p2utils;

import static java.lang.System.*;

public class HashTable<E>
{
   @SuppressWarnings("unchecked")
   public HashTable(int minCapacity)
   {
      assert minCapacity > 0;
      int len = minCapacity; // should be the nearest prime number
      array = (KeyValueList<E>[])new KeyValueList[len]; 
      clear();
   }

   public void set(String key, E elem)
   {
      int pos = hashFcn(key);
      boolean new_elem = array[pos].set(key,elem);
      if (new_elem) size++;

      assert contains(key) && get(key).equals(elem);
   }

   public E get(String key)
   {
      assert contains(key);

      int pos = hashFcn(key);
      return array[pos].get(key);
   }

   public void remove(String key)
   {
      assert contains(key);

      int pos = hashFcn(key);
      array[pos].remove(key);
      size--;

      assert !contains(key);
   }

   public boolean contains(String key)
   {
      int pos = hashFcn(key);
      return array[pos].contains(key);
   }

   public boolean isEmpty()
   {
      return size() == 0;
   }

   public int size()
   {
      return size;
   }

   public void clear()
   {
      for(int i = 0;i < array.length;i++)
         array[i] = new KeyValueList<E>();
      size = 0;
   }

   // Devolve o índice correspondente à chave str.
   // (É o hashCode da str "enrolado" mod N, onde N=array.length.)
   private int hashFcn(String str)
   {
      int result = str.hashCode() % array.length;
      if (result < 0)
         result += array.length;
      assert 0<=result && result<array.length;  // pós-condição
      return result;
   }

   private KeyValueList<E>[] array;
   private int size = 0;
}

