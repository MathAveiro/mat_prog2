import static java.lang.System.*;
import java.lang.*;
import java.util.*;

public class P93
{
   static public void main(String[] args)
   {
      Valores valor = new Valores();
      if (args.length != 1)
      {
         err.println("Test sorting algorithms for a N number array.");
         err.println("Usage: java -ea p83 <N>");
         exit(1);
      }

      out.printf("%-16s | %-14s | %10s   | %10s\n", "Algorithm", "Array", "Dimension", "Time (m:s:ms)");

      int n = Integer.valueOf(args[0]);
      int[] x = randomArray(n, n/2);
      int[] b = newArray(x);
      int[] s = newArray(x);
      int[] i = newArray(x);
      int[] m = newArray(x);

      String tipo = "random";

      funcaoPrint(n, x, b, s, i, m, tipo, valor);
      
      do {
        x = randomArray(n, n/2);
      } while(isSorted(x, 0, x.length));

      mergeSort(x, 0, x.length);

      b = newArray(x);
      s = newArray(x);
      i = newArray(x);
      m = newArray(x);

      tipo = "increasing";

      funcaoPrint(n, x, b, s, i, m, tipo, valor);
      
      do {
        x = randomArray(n, n/2);
      } while(isSorted(x, 0, x.length));

      mergeSort(x, 0, x.length);

      int[] u = new int[x.length];

      for (int r=0; r<x.length ; r++) {

        u[r] = x[x.length-1-r];

      }

      x = u;

      b = newArray(x);
      s = newArray(x);
      i = newArray(x);
      m = newArray(x);

      tipo = "decreasing";

      funcaoPrint(n, x, b, s, i, m, tipo, valor);
      
   }


   /**
    * Creates an integer random array with numbers in the interval [0; max].
    * @param len length of the array.
    * @param max maximum random value.
    * @return the array
    */
   static int[] randomArray(int len, int max)
   {
      assert len >= 0;
      assert max >= 0;

      int[] result = new int[len];
      for (int i = 0; i < len; i++)
         result[i] = (int)(Math.random()*(max+1));
      return result;
   }

   /**
    * Swaps two elements of an integer array.
    * @param a the array
    * @param i index of an element to swap
    * @param j index of the other element to swap
    * {@code i},{@code j} must be valid indexes within array {@code a}
    */
   static void swap(int[] a, int i, int j)
   {
      assert a!=null;
      assert 0<=i && i<a.length;
      assert 0<=j && j<a.length;

      int temp;
      temp = a[i];
      a[i] = a[j];
      a[j] = temp;
   }

   /**
    * Sequential sort ("greed" variation of selection sort).
    * Increasing sorting of integer subarray a[start..end[
    * @param a      the array to be (partially) sorted.
    * @param start  index of the first element to sort.
    * @param end    index of the first element not to be sorted (the last element to sort is {@code end-1}).
    * Requires:   a!=null and 0 <= start <= end <= a.length
    * Ensures:  The elements a[k] with start <= k < end are sorted.  the remaining elements are not changed.
    */
   static Valores sequentialSort(int[] a, int start, int end)
   { 
      Valores valor = new Valores();
      valor.compar = 0;
      valor.swap = 0;
      assert a!=null;
      assert 0<=start && start<=end && end<=a.length;

      for (int i=start; i<end-1; i++) // For each elements (except the last one):
      {
         for (int j=i+1; j<end; j++)
         { 
            //valor.compar++;
            if (a[j] < a[i])  { // compares them
               swap(a, i, j);
               //valor.swap++;
            }
             // if necessary a swap occurs
         }

         
      }

      assert isSorted(a, start, end); // checking for possible incorrections of the algorithm!
      return valor;
   }
   static Valores bubbleSort(int[] a, int start, int end) {
      Valores valor = new Valores();
      valor.compar = 0;
      valor.swap = 0;
     
      boolean swapExists;
      int f = end-1;
      do {
        swapExists = false;
         for(int i = start; i < f; i++) {
          //valor.compar++;
          if (a[i] > a[i+1]) {
            swap(a, i, i+1);
            //valor.swap++;
            swapExists = true;
          }
        }
        f--;
      }
      while(swapExists);
      return valor;
   }

   static Valores insertionSort(int[] a, int start, int end){

      Valores valor = new Valores();
      for(int i=start; i < end; i++) {
        int j;
        int temp = a[i];

        int k = binarySearch(0, i, temp, a);

        arraycopy(a, k, a, k+1, i-k);

        a[k] = temp;

      }
      
      return valor;   


    }

   static int binarySearch (int start, int end, int key, int [] a) {

    if (start < end) {

        int mid = start + (end - start) /2;

        if(key < a[mid]) {

          return binarySearch(start, mid, key,a);

        } else if(key > a[mid]) {

          return binarySearch(mid + 1, end, key, a);
        
        }

        else return mid;
        
      }

      return start;
      
  }  
   
   static Valores mergeSort(int[] a, int start, int end) {
      Valores  valor = new Valores();
      assert a!= null;
      if(end - start > 1) {
          int middle=(start+end)/2;
          mergeSort(a, start, middle);
          mergeSort(a, middle, end);
          valor = mergeSubarray(a, start, middle, end);          
      }
      assert isSorted(a, start, end);
      return valor;
   }
   
   static Valores mergeSubarray(int[] a, int start, int middle, int end) {
      Valores  valor = new Valores();
      int[] b = new int[end-start];
      int i1 = start;
      int i2 = middle;
      int j = 0;
      while(i1 < middle && i2 < end) {
          if(a[i1]<a[i2]) {
            b[j]=a[i1];
            i1++;
          }
          else {
            b[j]=a[i2];
            i2++;
          }
          j++;
      }
      while(i1 < middle) {
        b[j] = a[i1];
        j++;
        i1++;
      }
      while(i2 < end) {
        b[j] = a[i2];
        j++;
        i2++;
      }
      arraycopy(b, 0, a, start, end-start);
      return valor;
   }
 
   /**
    * Checks if a given subarray is sorted (increasing order).
    * @param a[start..end[  the subarray to chack.
    * @return true    if subarray is sorted.
    */
   static boolean isSorted(int [] a, int start, int end)
   {
      assert a!=null;
      assert 0<=start && start<=end && end<=a.length;

      boolean result = true;
      for (int k=start+1; result && k<end; k++) 
         result = (a[k-1]<=a[k]);
      return result;
   }

   static int[] newArray(int[] a) {
      int[] n = new int[a.length];
      for(int i=0; i<a.length; i++) {
        n[i]=a[i];
      }
      return n;
   }

   public static void funcaoPrint(int n, int [] x, int [] b, int [] s, int [] i, int [] m, String tipo, Valores valor){

      out.printf("-----------------|----------------|--------------|---------------\n");

      long time = nanoTime(); // To calculate execution time
      valor = sequentialSort(s, 0, s.length);
      long elapsedTime = nanoTime() - time;
      int seg = (int)(elapsedTime / 1000000000L);
      elapsedTime -= seg * 1000000000L;
      int min = seg / 60;
      seg = seg % 60;
      int mseg = (int)(elapsedTime / 1000000L);
      

      out.printf("%-16s | %-14s | %10d   |     %03d:%02d:%03d\n", "Sequential", tipo, n, min, seg, mseg);
      
      time = nanoTime(); // To calculate execution time
      valor = bubbleSort(b, 0, b.length);
      elapsedTime = nanoTime() - time;
      seg = (int)(elapsedTime / 1000000000L);
      elapsedTime -= seg * 1000000000L;
      min = seg / 60;
      seg = seg % 60;
      mseg = (int)(elapsedTime / 1000000L);

      
      out.printf("%-16s | %-14s | %10d   |     %03d:%02d:%03d\n", "Bubble", tipo, n, min, seg, mseg);

      time = nanoTime(); // To calculate execution time
      valor = insertionSort(i, 0, i.length);
      elapsedTime = nanoTime() - time;
      seg = (int)(elapsedTime / 1000000000L);
      elapsedTime -= seg * 1000000000L;
      min = seg / 60;
      seg = seg % 60;
      mseg = (int)(elapsedTime / 1000000L);

      out.printf("%-16s | %-14s | %10d   |     %03d:%02d:%03d\n", "Insertion", tipo, n, min, seg, mseg);

      time = nanoTime(); // To calculate execution time
      valor = mergeSort(m, 0, m.length);
      elapsedTime = nanoTime() - time;
      seg = (int)(elapsedTime / 1000000000L);
      elapsedTime -= seg * 1000000000L;
      min = seg / 60;
      seg = seg % 60;
      mseg = (int)(elapsedTime / 1000000L);

      out.printf("%-16s | %-14s | %10d   |     %03d:%02d:%03d\n", "Merge", tipo, n, min, seg, mseg);

   }
}

class Valores {
    int swap, compar;
}
