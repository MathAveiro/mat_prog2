import static java.lang.System.*;
import java.util.Scanner;
import java.io.*;
//import exameP2.*;

public class PhoneCalls
{
  public static void main (String[]args)
  {
    File f;
    Scanner sc;
    
    for(int i=0; i<args.length; i++)
    {
      f = new File(args[i]);
      
      if(args[i].endsWith("nms"))
      {
         sc = new Scanner(f);
         while(sc.hasNextLine())
         {
           String linha = sc.nextLine();
         }
      }
    }
    
   
  }
}

