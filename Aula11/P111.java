import static java.lang.System.*;
import java.util.Scanner;
import java.io.*;
import p2utils.*;

public class P111 {

   static Scanner sc = new Scanner(System.in);

   public static void main(String[] args) throws IOException {
      
      Scanner sf = new Scanner(new File(args[0]));

      KeyValueList<String> keylist = new KeyValueList<String>();

      do {

         String k = sf.next();

         String e = sf.next();

//       out.println(k + " " + e);

         keylist.set(k, e);

      } while (sf.hasNext());

      sf.close();

      boolean acaba = true;

      String login;

      do {

         do {
            out.print("Login: ");
            login = sc.nextLine();

         } while (!keylist.contains(login));

         out.print("Password: ");
         String pass = sc.nextLine();
      
         if (pass.equals(keylist.get(login))) out.println("Authentication successful");
         else out.println("Authentication failed");
      
      } while (acaba = true);

   }

}