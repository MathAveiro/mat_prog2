import static java.lang.System.*;
import java.io.*;
import p2utils.*;

public class P71
{

   public static void main(String[] args) throws IOException
   {
      LinkedList<Integer> lst = new LinkedList<Integer>();

      for(int i=0; i<10; i++) {
         lst.addFirst(i);
         lst.addLast(100+i);
      }
      out.println(lst.first());

      lst.removeFirst();

      @SuppressWarnings("unchecked")
      
      LinkedList<Integer> cln = lst.clone();

      out.println(cln.first());

      @SuppressWarnings("unchecked")
      
      LinkedList<Integer> rev = cln.reverse();

      out.println(rev.first());
     
      @SuppressWarnings("unchecked")
      
      LinkedList<Integer> conc = lst.concatenate(rev);
     
      out.println(rev.contains(5));
      
      rev.remove(5);
      
      out.println(rev.contains(5));
      
      for(int p=0; p<rev.size(); p++) {
          
          out.println(rev.get(p));
      
      }
      
      /*out.println("Imprimir lista 'lst':");
      
      for(int p=0; p<lst.size(); p++) {
          
          out.println(lst.get(p));
      
      }
      
      out.println("Imprimir lista 'cln':");
      
      for(int p=0; p<cln.size(); p++) {
          
          out.println(cln.get(p));
      
      }
      
      out.println("Imprimir lista 'rev':");
      
      for(int p=0; p<rev.size(); p++) {
          
          out.println(rev.get(p));
      
      }
      
      out.println("Imprimir lista 'con':");
      
      for(int p=0; p<conc.size(); p++) {
          
          out.println(conc.get(p));
      
      }*/
      
   }
   
}


