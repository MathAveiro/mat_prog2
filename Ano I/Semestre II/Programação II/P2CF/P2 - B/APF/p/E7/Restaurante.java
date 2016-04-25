import static java.lang.System.*;
import java.util.Scanner;
import java.io.*;
import exameP2.*;

@SuppressWarnings(value = "unchecked")
public class Restaurante{
 
 public static Scanner xxx = new Scanner (System.in);
 
 public static void main(String[] args){
  
  //criar estruturas de dados
  AssociativeArray stock = new AssociativeArray();
  Queue ref = new Queue();
  
  //percorrer todos os ficheiros dados como argumento
  for(int i=0; i<args.length;i++)
  verFicheiro(stock, ref, args[i]);
  
  out.println("Comida em stock: ");
  printStock(stock);
  
  ref.printQueue();
 }
 
 public static void verFicheiro(AssociativeArray s, Queue r, String ficheiro){
  assert s!= null;
  assert ficheiro!=null;
  
  // "criar" ficheiro de entrada
  File f = new File (ficheiro);
  
  // validar ficheiro de entrada
  if(!f.exists()){
   out.println("Ficheiro desconhecido: java.io.FileNotFoundException: "+ f.getName() + " (Ficheiro ou directoria inexistente)");
   exit(10);
  }
  if(f.isDirectory()){
   out.println("Ficheiro desconhecido: java.io.FileNotFoundException: "+ f.getName() + " (É uma directoria)");
   exit(11);
  }
  if(!f.exists()){
   out.println("Ficheiro desconhecido: java.io.FileNotFoundException: "+ f.getName() + " (Ficheiro não pode ser lido)");
   exit(12);
  }
  
  //fazer o ficheiro de entrada o argumento do scanner
  try{
   xxx = new Scanner(f);
   
   //percorrer cada linha do scanner
   while(xxx.hasNextLine()){
    String line = xxx.nextLine();
    
    if(line.startsWith("entrada: "))
     associar(s, line);
    else if(line.startsWith("saida: "))
     adicionaRefeicao(r, line, s);
    else
     out.println("Linha de ficheiro ignorada: "+ "\"" + line+"\"");
   }
   
   xxx.close();
  }catch(IOException e){
   out.println("ERRO: IOException while reading "+ f.getName());
   exit(13);
  }
  
  return;
 }///fim de verFicheiro
 
 //associa uma entrada com uma quantidade
 public static void associar(AssociativeArray a, String linha){
  assert a!= null;
  assert linha != null;
  
  String [] aux = linha.split(" ");
  
  for(int i=1; i<aux.length; i++){
   if(a.exists(aux[i])){
    int quantidade = Integer.parseInt(a.get(aux[i]).toString());
    
    a.set(aux[i], quantidade+1);
    continue;
   }
   a.set(aux[i], 1);
  }
  
  return;
 }/// fim de associar
 
 //"adiciona" refeicoes para serem servidas
 public static void adicionaRefeicao(Queue q, String linha, AssociativeArray aa){
  assert q!= null;
  assert linha != null;
  
  String [] str = linha.split("saida: ");
  String f = "";
  
  for(int i = 0; i<str[1].length(); i++){
   if(!Character.isLetterOrDigit(str[1].charAt(i)))
    f+=" ";
   else
    f+=str[1].charAt(i);
  }
  
  String [] a = f.split(" ");
  
  for(int i = 0; i<a.length-2; i=i+2){
   
   for(int j=2; j<a.length; i=i+2 ){
    
    if(a[i].equals(a[j])){
     out.println("Erro no formato da refeição: alimento "+ a[i] +" repetido!");
     exit(40);
    }
   }
   
  }
  
  if(q.podeServir(aa)){
   
   
   
  }
  
 }/// fim de adicionaRefeicao
 
 //imprime o stock existente
 public static void printStock(AssociativeArray p){  
  assert p != null;
  
  String [] ingredientes = p.keysToArray();
  
  for(int i=0; i<ingredientes.length; i++)
   out.printf("  %s: %d\n", ingredientes[i], (Integer.parseInt(p.get(ingredientes[i]).toString())));
  
 }/// fim de printStock
 
}// FIM

class Refeicao{
 String p;
 int q;
}
