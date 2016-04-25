import java.util.Scanner;
import java.io.*;
/*
 * Uso da classe FileWriter, que permite append
 */
public class ficheiros {
    public static void main(String[] args) throws IOException {
        Scanner kb = new Scanner(System.in);

        System.out.print("Ficheiro de entrada: ");
        String nameIn = kb.nextLine();
        File fin = new File(nameIn);

        if (!fin.exists()) {
            System.out.println("ERRO: ficheiro " + nameIn + " não existe!");
            System.exit(2);
        }
        if (fin.isDirectory()) {
            System.out.println("ERRO: ficheiro " + nameIn + " is a directory!");
            System.exit(3);
        }
        if (!fin.canRead()) {
            System.out.println("ERRO: ficheiro " + nameIn+ "não pode ser lido!");
            System.exit(4);
        }

        System.out.println("Ficheiro válido!");


        System.out.print("Ficheiro de saida: ");
        String nameOut = kb.nextLine();
        //~ File fout = new File(nameOut);
        //~ PrintWriter pw = new PrintWriter(fout);
        // Em lugar da classe File pode usar-se a classe FileWriter
        //     que dá para abrir ficheiros em modo append.
        PrintWriter pw = new PrintWriter(new FileWriter(nameOut, true)); // true, abre em modo append

        Scanner scf = new Scanner(fin);
        int cont = 0;
        while(scf.hasNextLine()) {
            cont++;
            scf.nextLine();
        }

        String[] linhas = new String[cont];

        scf.close();
        scf = new Scanner(fin);
        for(int i = 0 ; i < cont ; i++) {
            String s = scf.nextLine();
            linhas[i] = s;
        }
        scf.close();

        for(int i = 0 ; i < cont ; i++) {
            pw.println(linhas[i]);
        }
        pw.close();

    }
}

