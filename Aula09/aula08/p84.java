import static java.lang.System.*;
import java.io.File;
import java.util.Scanner;
import java.io.IOException;

public class p84
{
   public static void main(String[] args) throws IOException // Note that the Program is not robust!
   {
      if (args.length != 1)
         exit(1);
      File fin = new File(args[0]);
      String[] words = extractsWords(fin);
      for(int i = 0;i < words.length;i++)
         out.printf("[%05d] %s\n",i+1,words[i]);
   }

   static String[] extractsWords(File fin) throws IOException
   {
      assert fin != null;
      assert !fin.isDirectory(); // Note that this precondition does not 100% ensure this kind of assertion!
      assert fin.canRead();      // Note that this precondition does not 100% ensure this kind of assertion!

      // count the words
      int n = 0;
      Scanner scf = new Scanner(fin).useDelimiter("[\\p{Punct}\\p{Space}]+");
      while(scf.hasNext())
      {
         scf.next();
         n++;
      }
      scf.close();

      String[] result = new String[n];

      // read the words
      int i = 0;
      scf = new Scanner(fin).useDelimiter("[\\p{Punct}\\p{Space}]+");
      while(scf.hasNext())
      {
         result[i] = scf.next();
         i++;
      }
      scf.close();

      return result;
   }
}

