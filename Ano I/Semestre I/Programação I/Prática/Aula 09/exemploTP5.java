-import java.util.Scanner;
import java.io.*;

/* Revisão sobre arrays e introdução aos ficheiros texto.
 * Interação com o utilizador utilizando um menu.
*/
public class exemploTP5{
  static Scanner kb = new Scanner(System.in);
	public static void main(String[] args) throws IOException{
	int op;
  int a[] = new int[10]; // máximo numero de elementos: 10
  int n = 0; // começamos considerando o array vazio
  double med;
  do{
      // mostrar opcoes
      System.out.print("\n1-ler\n2-escrever\n3-media\n4-escrever Fich\n5-ler Fich\n6-histograma"
                    + "\n10-fim\nOpcao: ");
      op = kb.nextInt();
    switch (op)
    {
      case 1:
          n = ler(a);
        break;
      case 2:
          escrever(a, n);
        break;
      case 3:
          med = media(a, n);
          System.out.println("Media = " + med);
        break;
      case 4:
          escreverFich(a, n);
          break;
      case 5:
          n = lerFich(a);
          break;
      case 6:
          histograma(a, n);
      case 10:
        System.out.println("fim do programa");
        break;
      default:
        System.out.println("Opção invalida!");
    }
  }while(op != 10); // termina o programa com a opção 10

  }
  public static int ler(int a[])
  {
    int pos, tmp;
    for(pos = 0 ; pos < a.length ; pos++) // tentamos ler a quantidade maxima de valores
    {
      do{
        System.out.print("nota: ");
        tmp = kb.nextInt();
      }while((tmp < 0 || tmp > 20) && tmp != 99);
      if(tmp == 99) break; // terminamos a leitura com o valor sentinela (99)
      a[pos] = tmp;
    }
    return pos;
  }

  public static void escrever(int a[], int nElem)
  {
    for(int i = 0 ; i < nElem ; i++) // percorremos todos os elementos armazenados no array
    {
      System.out.printf("a[%d] = %d\n", i, a[i]);
    }
  }
  public static double media(int a[], int nElem)
  {
    int soma = 0;
    for(int i = 0 ; i < nElem ; i++)
    {
      soma += a[i];
    }
    return (double)soma / nElem; // media como valor real mas soma e nElem são inteiros
  }

  public static void escreverFich(int a[], int nElem) throws IOException
  {
    // Acesso a ficheiros para escrita: String -> File -> PrintWriter
    String nome = new String();
    System.out.print("Nome do ficheiro escrita: ");
    do
    {
      nome = kb.nextLine();
    }while(nome.length() == 0);
    File f = new File(nome);
    PrintWriter pw = new PrintWriter(f);

    for(int i = 0 ; i < nElem ; i++)
    {
      pw.printf("a[%d] = %d\n", i, a[i]);
    }
    pw.close();
  }

  public static int lerFich(int a[])throws IOException
  {
    // Acesso a ficheiros para leitura: String -> File -> Scanner
    int pos = 0;
    String nome = new String();
    System.out.print("Nome do ficheiro leitura ");
    do
    {
      nome = kb.nextLine();
    }while(nome.length() == 0);
    File f = new File(nome);
    Scanner sc = new Scanner(f);
    while(sc.hasNextInt()) // enquanto houver inteiros para ler
    {
      a[pos] = sc.nextInt(); // lemos mais um inteiro
      pos++;
    }
    sc.close();
    return pos;
  }

  public static void histograma(int a[], int nElem)
  {
    int hist[] = new int[21];
    for(int p = 0 ; p < nElem ; p++)
    {
      int pos = a[p];
      hist[pos]++; // contagem do numero de ocorrências de cada valor
    }

    for(int p = 0 ; p < hist.length ; p++)
    {
      System.out.printf("%2d|", p);
      for(int i = 0 ; i < hist[p] ; i++) // escrita dos '*'
      {
        System.out.print("*");
      }
      System.out.println();
    }
  }
}
