import static java.lang.System.*;

public class ArraySorting
{
   static public void main(String[] args)
   {
      if (args.length != 1)
      {
         err.println("Test sorting algorithms for a N number array.");
         err.println("Usage: java -ea p83 <N>");
         exit(1);
      }

      int[] a;
      int n = Integer.valueOf(args[0]);

      a = randomArray(n, n/2);
      sequentialSort(a, 0, a.length);
      a = randomArray(n, n/2);
      bubbleSort(a, 0, a.length);
      a = randomArray(n, n/2);
      insertionSort(a, 0, a.length);
      a = randomArray(n, n/2);
      mergeSort(a, 0, a.length);

      out.println("No assertions violated or assertion checking disabled");
   }

   static void sequentialSort(int[] a, int start, int end)
   {
      assert a!=null;
      assert 0<=start && start<=end && end<=a.length;

      for (int i=start; i<end; i++)
      {
         for (int j=i+1; j<end; j++)
         { 
            if (a[j] < a[i])
            {
               swap(a, i, j);
            }
         }
      }

      assert isSorted(a, start, end);
   }

   static void bubbleSort(int[] a, int start, int end)
   {
      assert a!=null;
      assert 0<=start && start<=end && end<=a.length;

      int f = end;
      boolean existsSwap;
      do
      {
         existsSwap = true;
         for(int i=start; i<f; i++)
         {
            if (a[i] > a[i+1])
            {
               swap(a, i, i-1);
               existsSwap=false;
            }
         }
         f--;
      } while (f>start+1 && existsSwap);

      assert isSorted(a, start, end);
   }

   static void insertionSort(int[] a, int start, int end)
   {
      assert a!=null;
      assert 0<=start && start<=end && end<=a.length;

      int i;
      for (i=start; i<end-1; i++)
      {
         int v = a[i];
         inserePorOrdem(v, a, start, i);
      }

      assert isSorted(a, start, end);
   }

   static void mergeSort(int[] a, int start, int end)
   {
      assert a!=null;
      assert 0<=start && start<=end && end<=a.length;

      int n = end-start;
      if (n > 1)
      {
         int meio = start + n/2;
         mergeSort(a, start, meio);
         mergeSort(a, meio+1, end);
         merge(a, start, meio, end);
      }

      assert isSorted(a, start, end);
   }

   static void merge(int[] a, int start, int meio, int end)
   {
      assert a!=null;
      assert 0<=start && start<=meio && meio<=end && end<=a.length;

      int n = end-start;
      int[] tmp = new int[n];
      int i1=start, i2=meio;
      int k = 0;

      while (i1<meio && i2<end)
      {
         if (a[i1]<a[i2])
         {
            tmp[k] = a[i1];
         }
         else
         {
            tmp[k] = a[i2];
         }
      }
      while (i1<meio)
      {
         tmp[k] = a[i1];
      }
      while (i2<end)
      {
         tmp[k] = a[i2];
      }

      arraycopy(tmp, 0, a, start, n);
   }

   static void inserePorOrdem(int valor, int[] a, int start, int end)
   {
      assert end < a.length;
      int k = binarySearch(valor, a, start, end);
      deslocarUm(a, k, end);
      a[k] = valor;
   }

   static void deslocarUm(int[] a, int k, int end)
   {
      arraycopy(a, k, a, k+1, end-k);
   }

   static int binarySearch(int x, int[] a, int start, int end)
   {
      int i = start; int j = end; int m;
      while (i<j)
      {
         m = (i+j-1)/2;
         if (x > a[m])
            i=m+1;
         else
            j=m;
      }
      assert i==j;
      return j;
   }

   static boolean isSorted(int [] a, int start, int end)
   {
      assert a!=null;
      assert 0<=start && start<=end && end<=a.length;

      boolean result = true;
      for (int k=start+1; result && k<end; k++) 
         result = (a[k-1]<=a[k]);
      return result;
   }

   static int[] randomArray(int len, int max)
   {
      assert len >= 0;
      assert max >= 0;

      int[] result = new int[len];
      for (int i = 0; i < len; i++)
         result[i] = (int)(Math.random()*(max+1));
      return result;
   }

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
}

