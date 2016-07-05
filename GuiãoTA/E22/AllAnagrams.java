import static java.lang.System.*;
import java.util.Scanner;
import java.util.Arrays;
import java.io.*;
import p2utils.*;

public class AllAnagrams
{
   public static void main(String[] args) throws IOException
   {
      if (args.length != 1)
      {
         err.println("Uso: java -ea AllAnagrams <Ficheiro>");
         exit(1);
      }
      long time = nanoTime();
      LinkedList<LinkedList<String>> anagrams = findAnagrams(args[0]);
      time = nanoTime() - time;
      out.println(anagrams);
      out.printf("Found %d anagram groups", anagrams.size());
      out.printf(" in %.3f seconds\n", time/1e9);
   }

   // A sorted version of the string str:
   //   sortedString("isentas") -> "aeinsst".
   //   sortedString("sinetas") -> "aeinsst".
   static String sortedString(String str)
   {
      char[] a = str.toCharArray();
      Arrays.sort(a);
      return new String(a);
   }

   // complete this function
   static LinkedList<LinkedList<String>> findAnagrams(String FileName) 
      throws IOException 
   {
      File fin = new File(FileName);
      Scanner scin = new Scanner(fin);
      LinkedList<LinkedList<String>> anagrams = new LinkedList<>();
      int expectedNumWords = (int)(fin.length()/10.0); //assuming 10 bytes per word
      HashTable<LinkedList<String>> words = new HashTable<>(expectedNumWords);

      //...

      while(scin.hasNext())
      {
         String word = scin.next();

         String key = sortedString(word);

         if(words.contains(key)) {
            LinkedList temp = words.get(key);
            temp.addFirst(word);
            words.set(key, temp);
         }
         else {
            LinkedList<String> temp = new LinkedList<>();
            temp.addFirst(word);
            words.set(key, temp);
         }

         //...

      }
      scin.close();

      String[] temp = words.keys();

      for(int i = 0; i < temp.length; i++) {
         LinkedList<String> newTemp = words.get(temp[i]);
         if(!(newTemp.size()<=1)) anagrams.addFirst(newTemp);
      }

      //...

      return anagrams;
   }
}

