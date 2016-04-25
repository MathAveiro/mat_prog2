import static java.lang.System.*;

public class AllDivisors
{
  public static void main(String[] paramArrayOfString)
  {
    if (paramArrayOfString.length != 1)
    {
      System.err.println("Usage: java -ea AllDivisors <NUM>");
      System.exit(1);
    }
    int i = 0;
    try
    {
      i = Integer.parseInt(paramArrayOfString[0]);
    }catch(NumberFormatException localNumberFormatException){
      System.err.println("ERROR: argument " + paramArrayOfString[0] + " is not an integer number!");
      System.exit(2);
    }
    if (i <= 0)
    {
      System.err.println("ERROR: argument " + paramArrayOfString[0] + " is not a positive number!");
      System.exit(3);
    }
    a("", Integer.parseInt(paramArrayOfString[0]));
  }

  private static void a(String paramString, int paramInt)
  {
    assert paramString != null;
    System.out.println(paramString + paramInt);
    for (int i = paramInt - 1; i >= 2; i--)
    {
      if (paramInt % i != 0)
        continue;
      a("   "+paramString, i);
    }
  }

}


