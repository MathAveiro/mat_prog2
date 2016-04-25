import java.util.Scanner;

public class Exercicio3
{
  public static void main(String[] args)
  {
  
    Scanner sc = new Scanner(System.in);
    double dolar, taxa;
    double euro;
    
    System.out.print("Introduza a quantia em dolares: ");
    dolar = sc.nextDouble();
    System.out.print("Introduza a taxa de conversão: ");
    taxa = sc.nextDouble();

    euro = dolar*taxa;

    System.out.printf("%4.1f dolares corresponde a %4.0f euros\n", dolar, euro);
  }  
}

