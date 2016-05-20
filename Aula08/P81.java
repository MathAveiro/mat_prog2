import static java.lang.System.*;
import java.io.*;
import java.util.Scanner;
import p2utils.*;

public class P81 {
   
   public static void main(String[] args) throws IOException {

      @SuppressWarnings("unchecked")
       
       SortedList<Integer> number = new SortedList<Integer>();
       
       if(args.length==0) {
           
           out.println("ERROR: no files found");
           
       }

       String [] files = new String [args.length];

       for (int i = 0; i < args.length; i++) {
           
           files[i] = args[i];
           
           File fin = new File(files[i]);
           
            if (!fin.exists())
            {
                System.out.println("ERROR: input file " + files[i] + " does not exist!");
                System.exit(2);
            }
            if (fin.isDirectory())
            {
                System.out.println("ERROR: input file " + files[i] + " is a directory!");
                System.exit(3);
            }
            if (!fin.canRead())
            {
                System.out.println("ERROR: cannot read from input file " + files[i] + "!");
                System.exit(4);
            }
            
            Scanner scf = new Scanner(fin);
           
            do {
                
                String teste = scf.next();
                
                try{
                
                    int testeNumber = Integer.parseInt(teste);
                    
                    //out.println(teste);                              

                    number.insert(testeNumber);
   
                    number.isSorted();
   
                }catch(Exception e){
                
                }
                
            } while(scf.hasNext());
            
            scf.close();
           
       }
        
       int size = number.size();
       
       for(int i = 0; i < size; i++) {
            
            out.println(number.first());   
            
            number.removeFirst();
           
       }
    
   }

}


