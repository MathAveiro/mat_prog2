import static java.lang.System.*;
import java.util.Scanner;

public class treinoTeste1p66
{
  public static void main (String[]args)
  {
    Scanner sc = new Scanner(System.in);
    String pal1, pal2;
    
    if(args.length!=2)
    {
      out.println("Insira duas palavras:");
      out.print("Palavra 1: ");
      pal1=sc.nextLine();
      out.print("Palavra 2: ");
      pal2=sc.nextLine();
    }
    
    else
    {
      pal1=args[0];
      pal2=args[1];
    }
    
    out.println("A distância enre "+pal1+" e "+pal2+" é "+distancia(pal1, pal2));
  }
  
  public static int distancia(String pal1, String pal2)
  {
    int d=0;
    String n1, n2;
    int a, b, c;
    
    if(pal2.length()==0)
      return pal1.length();
    
    if(pal1.length()==0)
      return pal2.length();
    
    char[] p1 = pal1.toCharArray();
    char[] p2 = pal2.toCharArray();
    
    if(p1[0]==p2[0])
    {
      n1=pal1.substring(1, pal1.length());
      n2=pal2.substring(1, pal2.length());
      
      d=distancia(n1, n2);
    }
    
    else
    {
      a=distancia(pal1.substring(1, pal1.length()), pal2);
      b=distancia(pal1, pal2.substring(1, pal2.length()));
      c=distancia(pal1.substring(1, pal1.length()), pal2.substring(1, pal2.length()));
      
      if((a<=b && b<=c) || (a<=c && c<=b))
        d=1+a;
      
      if((b<=a && a<=c) || (b<=c && c<=a))
        d=1+b;
      
      if((c<=a && a<=b) || (c<=b && b<=c))
        d=1+c;
    }
    
    return d;
  }
}