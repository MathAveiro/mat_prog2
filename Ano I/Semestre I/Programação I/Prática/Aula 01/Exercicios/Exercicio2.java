import java.util.Scanner;

public class Exercicio2
{
  public static void main(String[] args)
  {
  
    Scanner sc = new Scanner(System.in);
    double celsius;
    double fahrenheit;
    
    System.out.print("Temperatura em Celsius: ");
    celsius = sc.nextDouble();

    fahrenheit = 1.8*(celsius)+32;

    System.out.printf("%4.1fº Celsius é equivalente a %4.1fº Fahrenheit\n", celsius, fahrenheit);
  }  
}
