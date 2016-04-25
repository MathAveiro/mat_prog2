import static java.lang.System.*;
import java.util.Scanner;

public class P92
{
   public static void main(String[] args)
   {
      NumberArray na = new NumberArray();
      insertionSort(na.array(), 0, na.length());
      na.print();
   }

   static void insertionSort(int[] array, int start, int end)
   {
   		for(int i = start + 1; i < end; i++) {
   			int j;
   			int temp = array[i];
   			for(j = i-1; j >= start && array[j] > temp; j--) {
   				array[j+1] = array[j];
   			}
   			array[j+1] = temp;
   		}
   }
}

