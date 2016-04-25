import java.util.Scanner;

// Complete o programa
public class DoStats {
  static final Scanner sc = new Scanner(System.in);
  
  public static void main(String[] args) {
    // Cria um registo de estatisticas:
    Statistics xstat = new Statistics();
    
    // Enquanto houver um valor para ler:
    while (sc.hasNextDouble()) {
      // Lê um valor:
      double x = sc.nextDouble();
      // Atualiza o registo de estatisticas:
      updateStats(xstat, x);

    }

    System.out.printf("numero de valores = %d\n", xstat.num);

    System.out.printf("soma dos valores = %f\n", xstat.sum);
    
    System.out.printf("soma dos quadrados = %f\n", xstat.sum2);
    
    if (xstat.num > 0) {
    
      System.out.printf("min = %f\n", xstat.min);
    
      System.out.printf("max = %f\n", xstat.max);
    
      System.out.printf("média = %f\n", mean(xstat));
    
      System.out.printf("variancia = %f\n", variance(xstat));
    
    } else {
    
      System.out.printf("Lista vazia!");
    
    }
  
  }

  public static void updateStats (Statistics s, double x) {

    if (x > s.max) s.max = x;

    if (x < s.min) s.min = x;

    s.num++;

    s.sum+=x;

    s.sum2+=Math.pow(x,2);

  }

  public static double mean (Statistics s) {

    return s.sum/s.num;

  }

  public static double variance (Statistics s) {

    double m = mean(s);
    
    return Math.sqrt((Math.pow(s.sum2,2)/s.num) - Math.pow(m,2));

  }
  
}

// Definir classe Statistics

class Statistics {

  double num, sum, sum2, min, max;

}
