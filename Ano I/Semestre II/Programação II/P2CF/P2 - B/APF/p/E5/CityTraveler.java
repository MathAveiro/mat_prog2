import static java.lang.System.*;
import java.util.Scanner;
import java.io.*;
import exameP2.*;

public class CityTraveler{
 
 public static Scanner xxx = new Scanner (System.in);
 
 public static void main (String [] args){
  
  if(args.length==0){
   out.println("Usage: java -ea CityTraveler <FICH1> ...");
   exit(112);
  }
  
  //criar a estrutura de dados
  AssociativeArray<String> people = new AssociativeArray<String>();
  
  // percorrer cada ficheiro dado como argumento
  for(int i = 0; i<args.length; i++){
   associar(people, args[i]);
  }
  
  imprime(people);
  
 }/// fim da main
 
 // associa o nome de uma pessoa com uma cidade que tenha visitado
 public static void associar(AssociativeArray<String> a, String ficheiro){
  assert a != null;
  assert ficheiro != null;
  
  // criar ficheiro de entrada
  File f = new File (ficheiro);
  if(!f.exists() || f.isDirectory() || !f.canRead()){
   out.println("ERROR in file "+ f.getName() +": read failure!");
   exit(10);
  }
  
  // fazer do ficheiro de entrada o argumento do scanner
  try{
   xxx = new Scanner (f);
  }catch(FileNotFoundException e){
   out.println("ERROR: file \"" + f.getName() + "\" not found!");
   exit(11);
  }
  
  // associar o que esta em cada linha (nome de uma pessoa) com o nome do ficheiro (cidade)
  while(xxx.hasNextLine()){
   String linha = xxx.nextLine();
   
   if(linha.length()==0)
    continue;
   
   // se já existir o nome da pessoa no associative array
   if(a.exists(linha)){
    String aux = a.get(linha);
    aux += " " + f.getName(); // e' acrescentada mais uma cidade as cidades que ja tinha visitado
    
    a.set(linha, aux);
    
    continue;
   }
   a.set(linha, f.getName());
  }
  
  xxx.close();
 }/// fim associar
 
 // imprime o nome das pessoas e as cidades que cada pessoa visitou
 public static void imprime(AssociativeArray<String> array){
  assert array != null;
  
  // transforma todas as chaves (nomes das pessoas) num array de strings
  String [] pessoas = array.keysToArray();
  
  for(int i=0; i < pessoas.length; i++)
   out.printf("%-15s: %s\n", pessoas[i], array.get(pessoas[i]));
  
 }/// fim imprime
}/// fim CityTraveler
