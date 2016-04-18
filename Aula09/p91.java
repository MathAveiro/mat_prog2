import static java.lang.System.*;
import java.util.Scanner;

public class p91
{
   public static void main(String[] args)
   {
      NumberArray na = new NumberArray();
      mergeSort(na.array(), 0, na.length());
      na.print();
   }

   static void mergeSort(int[] array, int start, int end)
   {
   		if(end - start > 1) {
   			int middle = (end + start)/2;
   			mergeSort(array, start, middle);
   			mergeSort(array, middle, end);
   			mergeSubarrays(array, start, middle, end);
   		}
   }
   static void mergeSubarrays(int[] array, int start, int middle, int end) {
   		int[] b = new int[end-start];
   		int i1 = start;
   		int i2 = middle;
   		int j = 0;
   		do {
   			if(array[i1] < array[i2]) {
   				b[j] = array[i1];
   				i1++;
   			} else {
   				b[j] = array[i2];
   				i2++;
   			}
   			j++;
   		} while (i1 < middle && i2 < end);
   		while(i1 < middle) {
   			b[j] = array[i1];
   			j++;
   			i1++;
   		}
   		while (i2 < end) {
   			b[j] = array[i2];
   			j++;
   			i2++;
   		}
   		arraycopy(b, 0, array, start, end-start);
   }
}

