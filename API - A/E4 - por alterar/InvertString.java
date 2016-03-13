import static java.lang.System.*;

public class InvertString
{
   public static void main(String[] args)
   {
      for(int i = 0; i < args.length; i++)
         out.println(args[i]+" -> "+invert(args[i]));
   }
}

