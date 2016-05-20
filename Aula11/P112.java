import static java.lang.System.*;
import java.util.Scanner;
import java.io.*;
import p2utils.*;

public class P112 {

   static Scanner sc = new Scanner(System.in);

   public static void main(String[] args) throws IOException {
      
      Scanner sf = new Scanner(new File(args[0]));

      KeyValueList<Integer> keylist = new KeyValueList<Integer>();

      String frase = "";

      String frase1 [];

      int cont1 = 0;

      do {

         if (frase.equals("")) frase += sf.next();

         else frase += " " + sf.next();

      } while (sf.hasNext());

      String frasei = new String();

      for (int i = 0; i < frase.length(); i++) {
         
         frasei += Character.toLowerCase(frase.charAt(i));

      }

      frase1 = frasei.split("[ˆ\\P{Alnum}]+");

      for (int i = 0; i < frase1.length;i++ ) {

         if (keylist.contains(frase1[i])) {

            int cont = keylist.get(frase1[i]);

            keylist.set(frase1[i], cont+1);

         } else {

            keylist.set(frase1[i], 1);

         }

      }

      sf.close();

      String [] array = new String [keylist.size()]; 

      array =  keylist.keys();

      Double total = 0.0;

      for (int i = 0; i < array.length ; i++) {

         total += keylist.get(array[i]);        

      }

      for (int i = 0; i < array.length ; i++) {

         double freq = keylist.get(array[i])/total;

         out.printf("%15s:  %5d [%.2f]\n", array[i], keylist.get(array[i]), (keylist.get(array[i]).doubleValue())/(total)*100);

      }

   }

}