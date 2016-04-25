import static java.lang.System.*; // nao está acabado
import java.util.Scanner;
import java.io.*;

public class PhoneCalls
{
  public static void main(String[] args) throws FileNotFoundException
  {
    int cont = 0;
    int j = 0;
    String numero="";
    
    ArrayAssociativo<String> aa = new ArrayAssociativo<String>();
    
    
    for(int i=0; i<args.length; i++)
    {
      if(args[i].endsWith(".cls") || args[i].endsWith(".nms"))
        cont++;
    }
    
    File [] files = new File[cont];
    
    for(int i=0; i<args.length; i++)
    {
      if(args[i].endsWith(".cls") || args[i].endsWith(".nms")) // dar o nome ao ficheiro
      {
        files[j] = new File(args[i]);
        j++;
      }
    }    
    
    for(int i=0; i<files.length; i++)
    {
      if(files[i].getName().endsWith(".nms"))
         lerNMS(aa, files[i]);
    }
    
    int linhasTotal=0;
    for(int i=0; i<files.length; i++)
    {
      if(files[i].getName().endsWith(".cls"))
        linhasTotal = linhasTotal + numLinhas(files[i]);
    }
    
    call[] calls= new call[linhasTotal];
    int pos = 0;
    
    for(int i=0; i<files.length; i++)
    {
      if(files[i].getName().endsWith(".cls"))
      {
        Scanner sc = new Scanner(files[i]);
        
        while(sc.hasNextLine())
        {
          String linha = sc.nextLine();
          String num1 = linha.substring(0,9);
          String num2 = linha.substring(10,19);
          String seg = linha.substring(20, linha.length());
          
          calls[pos] = new call(num1, num2, seg);
          
          pos++;
        }
        
        sc.close();
      }
    }
    
    for(int i = 0; i<calls.length; i++)
    {
      String n1 = calls[i].n1;
      String n2 = calls[i].n2;
      
      if(aa.exists(n1))
        n1=(String)aa.get(n1);
      
      if(aa.exists(n2))
        n2=(String)aa.get(n2);
      
      out.println(n1+" to "+n2+" ("+calls[i].seg);
    }
    
  }
  
  public static void lerNMS(ArrayAssociativo<String> aa, File f) throws FileNotFoundException // lê e associa o numero ao nome
  {
    Scanner sc = new Scanner(f);
    
    String linha, numero, nome;
    
    while(sc.hasNextLine())
    {
      linha = sc.nextLine();
      numero = linha.substring(0,9);
      nome = linha.substring(10, linha.length());
      aa.set(numero, nome);
    }
    sc.close();
  }
  
  public static int numLinhas(File f) throws FileNotFoundException
  {
    Scanner sc = new Scanner(f);
    
    int cont=0;
    
    while(sc.hasNextLine())
    {
      cont++;
      sc.nextLine();
    }
    
    sc.close();
    return cont;
  }
  
  
  /*
  public static void main (String[] args) throws FileNotFoundException
  {
    
    int j=0;
    int cont =0;
    String numero="";
    
    ArrayAssociativo<String> aa = new ArrayAssociativo<String>();
    
    
    for(int i=0; i<args.length; i++)
    {
      if(args[i].endsWith(".cls") || args[i].endsWith(".nms"))
        cont++;
    }
    
    File [] files = new File[cont];
    
    for(int i=0; i<args.length; i++)
    {
      if(args[i].endsWith(".nms") || args[i].endsWith(".cls"))
      { 
        files[j]=new File(args[i]);
      }
      
      if(args[i].endsWith(".nms"))
      {        
        lerNMS(aa, files[j]);
        j++;
      }   
      
      if(!args[i].endsWith(".nms") && !args[i].endsWith(".cls"))
      {
        numero = args[i];
      }
    }
    imprimir(files, aa);
    out.println();
    chamadas(numero, aa, files);
  }
  
  public static void lerNMS(ArrayAssociativo<String> aa, File f) throws FileNotFoundException // lê e associa o numero ao nome
  {
    Scanner sc = new Scanner(f);
    
    String linha, numero, nome;
    
    while(sc.hasNextLine())
    {
      linha = sc.nextLine();
      numero = linha.substring(0,9);
      nome = linha.substring(10, linha.length());
      aa.set(numero, nome);
    }
    sc.close();
  }
  
  public static void imprimir(File [] f, ArrayAssociativo<String> aa) throws FileNotFoundException
  {
    String num1, num2, seg;
    
    for(int i=0; i<f.length; i++)
    {
      Scanner sc = new Scanner(f[i]);
      
      if(f[i].getName().endsWith(".cls"))
      {
        while(sc.hasNextLine())
        {
          String linha = sc.nextLine();
          num1 = linha.substring(0,9);
          num2 = linha.substring(10,19);
          seg = linha.substring(20, linha.length());
          
          if(aa.exists(num1))
          {
            out.print(aa.get(num1) + " to ");
            if(aa.exists(num2))
              out.println(aa.get(num2) + "("+seg+" seconds)");
            else
              out.println(num2 + "("+seg+" seconds)");
          }
          
          if(!aa.exists(num1))
          {
            out.print(num1+" to ");
            if(aa.exists(num2))
              out.println(aa.get(num2) + "("+seg+" seconds)");
            else
              out.println(num2 + "("+seg+" seconds)");
          }
        }
      }
      sc.close();
    }
  }
  
  public static void chamadas(String tel, ArrayAssociativo<String> aa, File [] f) throws FileNotFoundException
  {
   // String n1="", n2="", seg="";
    for(int i=0; i<f.length; i++)
    {
      Scanner sc = new Scanner(f[i]);
      
      if(f[i].getName().endsWith(".cls"))
      {
        while(sc.hasNextLine())
        {
          String linha = sc.nextLine();
          n1 = linha.substring(0,9);
          n2 = linha.substring(10,19);
          seg = linha.substring(20, linha.length());
          
          
          if(n1.equals(tel))
          {
            if(aa.exists(n1))
            {
              out.println("Calls made by "+ aa.get(n1) + ":");
              while(sc.hasNextLine())
              {
                if(aa.exists(n2))
                  out.println("         -to phone "+aa.get(n2) + "(" + seg + "seconds)");
                
                if(!aa.exists(n2))
                  out.println("         -to phone "+n2 + "(" + seg + "seconds)");
              }
            }
            
            if(!aa.exists(n1))
            {
              out.println("Calls made by "+ n1 + ":");
              while(sc.hasNextLine())
              {
                if(aa.exists(n2))
                  out.println("         -to phone "+aa.get(n2) + "(" + seg + "seconds)");
                
                if(!aa.exists(n2))
                  out.println("         -to phone "+n2 + "(" + seg + "seconds)");
              }
              
            }
          }
          
          if(n2.equals(tel))
          {
            if(aa.exists(n2))
            {
              out.println("Calls received by "+ aa.get(n2) + ":");
              while(sc.hasNextLine())
              {
                if(aa.exists(n1))
                  out.println("         -from phone "+aa.get(n1) + "(" + seg + "seconds)");
                
                if(!aa.exists(n1))
                  out.println("         -from phone "+n1 + "(" + seg + "seconds)");
              }
            }
            
            if(!aa.exists(n2))
            {
              out.println("Calls received by "+ n2 + ":");
              while(sc.hasNextLine())
              {
                if(aa.exists(n1))
                  out.println("         -from phone "+aa.get(n1) + "(" + seg + "seconds)");
                
                if(!aa.exists(n1))
                  out.println("         -from phone "+n1 + "(" + seg + "seconds)");
              }
            }
          }
        }
      }
      sc.close();
    }
  }
  */
  
  
}

class call
{
    public call(String n1, String n2, String seg)
    {
      this.n1=n1; //this.n1 -> n1 da classe
      this.n2=n2;
      this.seg=seg;
    }
    
    public String n1;
    public String n2;
    public String seg;
}