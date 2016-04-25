import static java.lang.System.*;

public class pe4
{
  public static void main (String [] args)
  {
    String palavra;
    
    for (int i=0; i<args.length; i++)
    {
      palavra = args[i];
      inverteBonito(palavra);
      imprimir(palavra);
    }
    
    
  }
  public static String inverte(String palavra)
  {  
    if(palavra.length()==1 || palavra.length()==0)
    {
      return palavra;
    }
    
    else
    {
      String h="";
      String inv="";
      String j;
      inv=inv+palavra.charAt(palavra.length()-1);
      
      for(int i=0; i<palavra.length()-1; i++)
      {
        h=h+palavra.charAt(i);
      }
        j=inverte(h);
      
      return (inv+j);
    }
    
  }
  
  public static String inverteBonito(String palavra)
  {
    if(palavra.length()==0)
      return palavra;
    else
    {
      return(inverteBonito(palavra.substring(1))+palavra.charAt(0));
    }
  }
  
  public static void imprimir(String palavra)
  {
    out.println(palavra+" -> "+ inverte(palavra));
  }
  
  public static char[] StringtoArray(String s) // = a toCharArray()
  {
    char[] c = new char[s.length()];
    for(int i=0; i<s.length(); i++)
    {
      c[i]=s.charAt(i);
    }
    return c;
  }
}
