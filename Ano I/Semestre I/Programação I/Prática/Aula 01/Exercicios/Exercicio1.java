import java.util.Scanner;

public class Exercicio1
{
  public static void main(String[] args)
  {

    Scanner sc = new Scanner(System.in);
    double dim1, dim2;
    double perimetro, area;

    System.out.print("Dimensao 1: ");
    dim1 = sc.nextDouble();
    System.out.print("Dimensao 2: ");
    dim2 = sc.nextDouble();

    perimetro = 2*(dim1 + dim2);
    area = dim1 * dim2;

    System.out.printf("Perimetro = %4.1f, Area = %4.1f\n", perimetro, area);
  }
}