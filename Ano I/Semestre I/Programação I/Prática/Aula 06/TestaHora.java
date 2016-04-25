import java.util.Scanner;

public class TestaHora {

  static final Scanner sc = new Scanner(System.in);
  
  public static void main(String[] args) {
    
  hora i = new hora();
  hora f = new hora();
    
  System.out.println("Introduza a hora de inicio: ");
  i.hora = sc.nextInt();
  i.minuto = sc.nextInt();
  i.segundo = sc.nextInt();

  System.out.print("Começou às: ");
  printHora(i);
  System.out.println();
  System.out.println("Quando termina?");
  scHora(f);
  System.out.print("Começou às: ");
  printHora(i);
  System.out.print("  Terminou às: ");
  printHora(f);


  }

   public static void printHora(hora i) {

    System.out.printf("%d:%d:%d", i.hora, i.minuto, i.segundo);

  }

  public static void scHora(hora f) {

    System.out.println("Horas? ");
    f.hora = sc.nextInt();
    System.out.println("Minutos? ");
    f.minuto = sc.nextInt();
    System.out.println("Segundos? ");
    f.segundo = sc.nextInt();

  }


}

class hora {

int hora;
int minuto;
int segundo;

}
