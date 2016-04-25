import java.io.*;
import static java.lang.System.*;

public class treinoTeste1p62
{
  public static void main (String [] args)
  {
    File f;
    
    if(args.length>0)
    {
      f = new File(args[0]);
    }
    
    else
    {
      f=new File("./");
    }
    
    listarDirectorios(f);
  }
  
  public static void listarDirectorios(File f)
  {
    File lista[] = f.listFiles();
    out.println(f.getPath());
    
    for(int i=0; i<lista.length; i++)
    {
      if(lista[i].isDirectory())
        listarDirectorios(lista[i]);
      
      if(lista[i].isFile())
      {
        out.println(lista[i]);
        return;
      }
    }
  }
}