import static java.lang.System.*;
import java.io.*;
import p2utils.*;

public class P85
{
    
   public static void main(String[] args) throws IOException
   {
      SortedArray<Integer> lst = new SortedArray<Integer>(5);

      for(int i=0; i<args.length; i++) {
         lst.insert(Integer.parseInt(args[i]));
      }
      
      out.println(lst.isFull());
      
   }
}