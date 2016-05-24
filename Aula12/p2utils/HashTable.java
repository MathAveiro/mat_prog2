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

   public String [] keys () {

      int cont = 0;

      for (int i = 0; i < array.length ; i++) {

         String [] lista = array[i].keys();

         for (int k = 0; k < lista.length; k++) {
            
            cont += 1;

         }

      }

      String [] keys = new String [cont];

      int j = 0;

      for (int i = 0; i < array.length ; i++) {

         String [] a = array[i].keys();

         arraycopy(a, 0, keys, j, a.length);

         j += a.length;

      }

      return keys;

   }

   public String toString1() {

      String elemento = "{ ";

      String [] lista = keys();

      for (int j = 0; j < lista.length; j++) {

         elemento += "(" + lista[j] + "," + get(lista[j]) + ")";

         if (j == lista.length-1) elemento += " }";

         else elemento += ",";
         
      }

      return elemento;

   }

   private KeyValueList<E>[] array;
   private int size = 0;
}

