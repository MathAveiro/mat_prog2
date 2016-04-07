import java.util.*;
import java.io.*;
import static java.lang.System.*;
import static java.lang.Integer.*;

public class p72 {
   
    public static void main(String[] args) {

        if(args.length!=2) {
            out.println("USO: java -ea p72 <a> <b>");
            exit(0);
                   
        }

        else {
            
            String sA = args[0];
            int a = parseInt(sA);
               
            String sB = args[1];   
            int b = parseInt(sB);
            
            out.printf("mdc(%d, %d) = %d\n", a, b, mdc(a, b));
        }
	}
    
    public static int mdc(int a, int b) {
        
        if (b == 0) return a;
        
        else {
            
            return mdc (b, a % b);
            
        } 
                
    }
    
}