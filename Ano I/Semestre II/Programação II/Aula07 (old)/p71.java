import java.util.*;
import java.io.*;
import static java.lang.System.*;
import static java.lang.Integer.*;

public class p71 {
   
    public static void main(String[] args) {

        if(args.length!=2) {
            out.println("USO: java -ea <palavra1> <palavra2>");
            exit(0);
                   
        }

        else System.out.printf("\"%s\" <-> \"%s\" = %d\n", args[0], args[1], d(args[0], args[1]));
        
	}
    
    public static int d(String p1, String p2) {
        
        assert p1.length() >= 0;
        assert p2.length() >= 0;
        
        int d = 0;
        
        if (p1.length() == 0) return p2.length();
        
        else if (p2.length() == 0) return p1.length();
        
        else if (p2.charAt(0) == p1.charAt(0)) return d(p1.substring(1), p2.substring(1));
        
        else {
            
           int r = Math.min(d(p1.substring(1), p2), d(p1, p2.substring(1)));
            
            d = 1 + Math.min(r, d(p1.substring(1), p2.substring(1)));
            
        } 
        
        assert d >= 0;
        
        return d;
        
    }
    
}