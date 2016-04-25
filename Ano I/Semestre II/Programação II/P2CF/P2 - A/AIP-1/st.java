import static java.lang.System.*;

public class st
{
  public static void main (String[]args)
  {
    String palavra1=args[0];
    
    String palavra2=args[1];
    
    if(palavra1.compareTo(palavra2)<0)
    {
      out.println(palavra1);
      out.println(palavra2);
    }
    
    else
    {
      out.println(palavra2);
      out.println(palavra1);
    }
  }
}