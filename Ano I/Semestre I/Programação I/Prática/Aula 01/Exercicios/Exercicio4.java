import java.util.Scanner;

public class Exercicio4
{
  public static void main(String[] args)
  {
  
    Scanner sc = new Scanner(System.in);
    int tempo;
    int hora, minuto, segundo;
    
    System.out.print("Tempo em segundos: ");
    tempo = sc.nextInt();
    
    hora = tempo/3600;
    minuto = (tempo%3600)/60;
    segundo = ((tempo%3600)%60)%60;
    

    System.out.printf("Demorou %2d:%2d:%2d\n", hora, minuto, segundo);
  }  
}

