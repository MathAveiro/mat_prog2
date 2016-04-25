import java.util.*;
import java.io.*;

public class Exercicio1 {

	static Scanner sc = new Scanner (System.in);

	public static void main(String[] args) throws IOException {

	int op, line=0;

	int a[] = new int[31];

	int n = a.length;
	
		 do {
            
            System.out.println("1- Ler ficheiro de dados");

            System.out.println("2- Acresentar medida");

			System.out.println("3- Listar valores de temperatura e humidade");

			System.out.println("4- Listar medidas ordenadas por temperatura");

			System.out.println("5- Listar medidas ordenadas por humidade");

			System.out.println("6- Calcular valores médios de temperatura e humidade");

			System.out.println("7- Calcular valor máximos e mínimos de temperatura e humidade");

			System.out.println("8- Calcular histograma de temperatura e humidade");

			System.out.println("9- Terminar programa");

			System.out.print("Opção -> ");

            op = sc.nextInt();

            switch (op) {

            case 1:

				line = lerFich(a);

				System.out.println(line);	

                break;

            case 2:

            	escreverFich(line, n);
               
                break;

            case 3:
               
                break;

            case 4:
                
                break;

            case 5:
               	
               	break;

            case 6:
                
                break;

            case 7:
                
                break;

            case 8:
                
                break;

            case 9:
                
                break;

            default:

                System.out.println("Opção invalida!");

            }

        } while(op != 0);

	}

	public static int lerFich(int a[])throws IOException {

		int line = 0;

       	String nameIn = new String();

       	System.out.print("Ficheiro de entrada: ");

       	do {

	       	nameIn = sc.nextLine();

		} while (nameIn.length() == 0);

		File fin = new File(nameIn);

		if (!fin.exists()) {
		
			System.out.println("ERROR: input file " + nameIn + " does not exist!");
		
			System.exit(2);
		
		}
		
		if (fin.isDirectory()) {
		
			System.out.println("ERROR: input file " + nameIn + " is a directory!");
		
			System.exit(3);
		
		}
		
		if (!fin.canRead()) {
		
			System.out.println("ERROR: cannot read from input file " + nameIn+ "!");
			
			System.exit(4);
			
		}

    	File f = new File(nameIn);

    	Scanner sc = new Scanner(f);

    	while(sc.hasNextLine()) {

    		sc.nextLine();

      		line++;
    				
    	}
   					
   		sc.close();

   		return line;

  	}

  	public static void escreverFich(int nEleminicial, int length) throws IOException {

    	String nameIn = new String();

    	int temp = 0;

    	int hum = 0;

    	System.out.print("Nome do ficheiro escrita: ");
    
    	do {
      
    	  nameIn = sc.nextLine();

    	} while(nameIn.length() == 0);

    	File f = new File(nameIn);
    
    	FileWriter pw = new FileWriter(f, true);

    	BufferedWriter bw = new BufferedWriter(pw);

  		System.out.print("Temperatura: ");
   	
  		String temperatura = sc.nextLine();

  		System.out.print("Humidade: ");
    	
   		String humidade = sc.nextLine();

   		String data = "Temperatura: " + temperatura + "		" + "Humidade: " + humidade + "\n";

   		bw.write(data);

   		bw.close();

  	}

}