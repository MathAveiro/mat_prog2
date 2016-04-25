import static java.lang.System.*;
import java.util.Scanner;
import java.io.*;
import exameP2.*;

public class CityTraveler
{
  
  public static Scanner sc = new Scanner (System.in);
  
  public static void main (String[]args){
  
    if(args.length==0){
   out.println("N ha argumentos!");
   exit(1);
  }
    
    AssociativeArray<String> pessoal = new AssociativeArray<String>();
    
    for(int i=0; i<args.length; i++){
    associar(pessoal, args[i]);
    }
    imprime(pessoal);
    
  } 
  public static void associar ( AssociativeArray<String> p, String a){
    assert p !=null;
    assert a !=null;
    
    File f = new File(a);
    
    if (!f.exists() || f.isDirectory() || !f.canRead()){
    System.out.println(" FODEU");
    exit(8);
    }
    try{ 
    sc = new Scanner(f);
    }
    catch(FileNotFoundException e){
   exit(3); 
    }
    while (sc.hasNextLine()){
      
      String pessoa = sc.nextLine();
      String jah;
      if (p.exists(pessoa)){
        jah=p.get(pessoa)+f.getName();
        p.set(pessoa,jah);
      }else
      p.set(pessoa,f.getName());
    
    }
    sc.close();
  }
  public static void imprime (AssociativeArray<String> r){
  String[] h =r.keysToArray();
  
  for(int i=0; i<h.length; i++){  
    out.println(h[i]+" "+r.get(h[i]));
    
    }
  }
}
 /* 
  assert a != null;
  assert p != null;
  
  // criar ficheiro de entrada
  File f = new File (a);
  if(!f.exists() || f.isDirectory() || !f.canRead()){
   out.println("ERROR in file "+ f.getName() +": read failure!");
   exit(10);
  }
  
  // fazer do ficheiro de entrada o argumento do scanner
  try{
   sc = new Scanner (f);
  }
  catch(FileNotFoundException e){
   out.println("ERROR: file \"" + f.getName() + "\" not found!");
   exit(11);
  }
  
  // associar o que esta em cada linha (nome de uma pessoa) com o nome do ficheiro (cidade)
  while(sc.hasNextLine()){
   String linha = sc.nextLine();
   
   if(linha.length()==0)
    continue;
   
   // se já existir o nome da pessoa no associative array
   if(p.exists(linha)){
    String aux = p.get(linha);
    aux += " " + f.getName(); // e' acrescentada mais uma cidade as cidades que ja tinha visitado
    
    p.set(linha, aux);
    
    continue;
   }
   p.set(linha, f.getName());
  }
  
  sc.close();
 }
    
  }
*/