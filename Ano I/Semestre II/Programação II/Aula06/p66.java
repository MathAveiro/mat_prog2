import java.util.*;
import java.io.*;
import static java.lang.System.*;
import static java.lang.Integer.*;

public class p66 {
    
    private static double quantiaEuros, taxaJuro, prestacaoEuro;
    private static int  meses;
    	
    public static void main(String[] args) {
        
        if(args.length==0) {
			out.println("USO: java -ea p62 <n> <M> <T> <P>");
			exit(0);
		}
		else {
            
            String sMeses = args [0];
			String squantiaEuros = args [1];
	        String staxaJuro = args[2];
            String sprestacaoEuro = args[3];
        
			meses = parseInt(sMeses);
			quantiaEuros = parseInt(squantiaEuros);
            taxaJuro = parseInt(staxaJuro);
            prestacaoEuro = parseInt(sprestacaoEuro);
         
            out.println("(iterativo) d("+args[0]+") = " + metodoInterativo());
            out.println("(recursivo) d("+args[0]+") = " + metodoRecursivo(meses));
        
        }
        
	}
    
    private static double metodoInterativo () {
        
        double montanteDivida = quantiaEuros;

        for (int i = 1; i <= meses; i++) {
                
            montanteDivida = (((taxaJuro + 100) * montanteDivida)/100) - prestacaoEuro;
            
        }
        
        return montanteDivida;
        
    }
    
    private static double metodoRecursivo (int meses) {
        
        return ((meses==0) ? quantiaEuros : ((((100+taxaJuro)*metodoRecursivo(meses-1))/100)-prestacaoEuro));
        
    }
    
}