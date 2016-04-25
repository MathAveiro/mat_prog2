import java.util.Scanner;
import java.io.*;

public class exemplo2{
	public static void main(String[] args) throws IOException{
		Scanner kb = new Scanner(System.in);
    int cont[] = new int[26];

    String frase = new String();

    System.out.print("Nome do ficheiro ");
    String fName = kb.nextLine();

    File f = new File(fName);
    Scanner scFile = new Scanner(f);

    File f2 = new File("out.txt");
    PrintWriter pw = new PrintWriter(f2);

    while(scFile.hasNextLine()){
      frase = scFile.nextLine();
      pw.println("Frase lida do ficheiro: " + frase);
      for(int i = 0 ; i < frase.length() ; i++){
        char letra = frase.charAt(i);
        if(Character.isLetter(letra)){
          letra = Character.toLowerCase(letra);
          int pos = (int)(letra - 'a');
          cont[pos]++;
        }
      }
    }

    for(int i = 0 ; i < cont.length ; i++){
      if(cont[i] > 0){
        char l = (char)('a' + i);
        pw.printf("%c -> %d\n", l, cont[i]);
      }
    }

    pw.close();
    scFile.close();
  }
}
