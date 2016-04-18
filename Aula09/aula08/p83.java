import static java.lang.System.*;

public class p83
{
   static public void main(String[] args)
   {
      if (args.length != 1)
      {
         err.println("Test sorting algorithms for a N number array.");
         err.println("Usage: java -ea p83 <N>");
         exit(1);
      }

      int n = Integer.valueOf(args[0]);
      int[] x = randomArray(n, n/2);

      long time = nanoTime(); // To calculate execution time
      sequentialSort(x, 0, x.length);
      long elapsedTime = nanoTime() - time;

      out.println("Elapsed time = "+elapsedTime);

      int seg = (int)(elapsedTime / 1000000000L);
      elapsedTime -= seg * 1000000000L;
      int min = seg / 60;
      seg = seg % 60;
      int mseg = (int)(elapsedTime / 1000000L);

      out.printf("%-16s | %-14s | %10s | %10s\n", "Algorithm", "Array", "Dimension", "Time (m:s:ms)");
      out.printf("-----------------|----------------|------------|---------------\n");
      out.printf("%-16s | %-14s | %10d |     %03d:%02d:%03d\n", "Sequential", "random", n, min, seg, mseg);
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
   static void sequentialSort(int[] a, int start, int end)
   {
      assert a!=null;
      assert 0<=start && start<=end && end<=a.length;

      for (int i=start; i<end-1; i++) // For each elements (except the last one):
      {
         for (int j=i+1; j<end; j++)
         { 
            if (a[j] < a[i])               // compares them
               swap(a, i, j);              // if necessary a swap occurs
         }
      }

      assert isSorted(a, start, end); // checking for possible incorrections of the algorithm!
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
}
