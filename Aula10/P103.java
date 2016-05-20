import static java.lang.System.*;
import java.util.Scanner;
import java.io.*;

public class P103 {
   public static void main(String[] args) throws IOException {
      Scanner sf = new Scanner(new File("temperaturas.txt"));
      Scanner sf1 = new Scanner(new File("temperaturas.txt"));
      printAverage(sf,sf1, 24);
      sf.close();
      sf1.close();
      
   }

   public static void printAverage(Scanner sf, Scanner sf1, int N) {
      DelayArray<Double> temp = new DelayArray<Double>(N, 0.0);
      DelayLine<Double> temp1 = new DelayLine<Double>(N, 0.0);
      out.printf("Temperaturas hora-a-hora e média das últimas %d horas.\n", N);
      out.printf("(As primeiras %d médias não são exatas!)\n", N);
      out.printf("%3s %4s %7s %7s\n", "dia", "hora", "temp.", "média");
      int t = 0;
      do {
         double nova = Double.parseDouble(sf.nextLine());
         // Calcula soma das últimas N horas:
         // (Há uma forma de fazer isto só com uma adição e uma subtração.
         // Pense nisso!)
         temp.in(nova);
         double somaN = 0.0;
         for (int hora = -N; hora < 0; hora++) {
            somaN += temp.get(hora);
         }
         out.printf("%3d   %02d %7.1f %7.1f\n", t/24, t%24, nova, somaN/N);
         t++;
      }  while (sf.hasNextLine());
      sf.close();

      out.println("-------------------------");

      do {
         double nova = Double.parseDouble(sf1.nextLine());
         // Calcula soma das últimas N horas:
         // (Há uma forma de fazer isto só com uma adição e uma subtração.
         // Pense nisso!)
         temp1.in(nova);
         double somaN = 0.0;
         for (int hora = -N; hora < 0; hora++) {
            somaN += temp1.get(hora);
         }
         out.printf("%3d   %02d %7.1f %7.1f\n", t/24, t%24, nova, somaN/N);
         t++;
      }  while (sf1.hasNextLine());
   }

}
