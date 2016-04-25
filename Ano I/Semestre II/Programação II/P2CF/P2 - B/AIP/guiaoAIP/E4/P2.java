/*
 * Nome:
 * NMEC:
 */

import static java.lang.System.*;
import java.io.File;

public class P2{
	
	public static void main (String [] args){
		
		if(args.length != 1){
			err.println("Uso: java -ea P2 [<diretorio>]");
			exit(99);
		}
		
		File a = new File(args[0]);
		
		if(!a.exists()){
			err.println("ERRO: O directorio \"" + args[0] + "\" nao existe!");
			exit(90);
		}
		
		imprimePastas(a);
		
	}// fim da main
	
	public static void imprimePastas(File file){
		assert !file.exists() || file != null : "Argumento de entrada invalido!";
		
		if(file.isDirectory() && file.canRead()){				/// outra forma de escrever o if --> if(file.isDirectory() == true)
			File [] listaDeFiles = file.listFiles();
			
			out.println(file.getPath() + " : " + listaDeFiles.length + " file" + (listaDeFiles.length == 1 ? "" : "s"));
			
			///  (listaDeFiles.length == 1 ? "" : "s")    --> isto é um if abreviado
			    /*
			     if(listaDeFiles.length == 1)
					out.print("");
				 else
					out.print("s");
			      */
			
			// este for serve, no fundo para fazer o println (que esta acima) para cada directorio ...
			// ... que estiver dentro directorio passado como argumento (file)
			for(int i=0 ; i<listaDeFiles.length ; i++)
				imprimePastas(listaDeFiles[i]);
		}
		
			
	}// fim de imprimePastas
	
}// fim do programa
	
	
