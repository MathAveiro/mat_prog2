import static java.lang.System.*;
import java.io.*;

public class e3
{
  public static void main(String[]args)
  {
    File f = new File(args[0]);
    listarDirectorios(f);
  }
  
  public static void listarDirectorios(File f)
  {
    File[] lista = f.listFiles();
    int cont=0;
    
    if(f.isDirectory())
    {
      cont=lista.length;
      
      if(cont!=1)
        out.println(f.getPath()+": "+cont+" files");
      
      else
        out.println(f.getPath()+": "+cont+" file");
      
      for(int i=0; i<lista.length; i++)
      {
        listarDirectorios(lista[i]);
      }
    }
  }
}
