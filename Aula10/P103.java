import static java.lang.System.*;
import java.util.Scanner;
import java.io.*;

public class P103 {
   public static void main(String[] args) throws IOException {
      Scanner sf = new Scanner(new File("temperaturas.txt"));
      Scanner sc = new Scanner(new File("temperaturas.txt"));

      printAverage(sf, 24, sc);
      sf.close();
   }

   public static void printAverage(Scanner sf, int N, Scanner sc) {
      DelayArray<Double> temp = new DelayArray<Double>(N, 0.0);

      DelayLine<Double> temp1 = new DelayLine<Double>(N, 0.0);
      
      out.printf("Temperaturas hora-a-hora e média das últimas %d horas.\n", N);
      out.printf("(As primeiras %d médias não são exatas!)\n", N);
      out.printf("%3s %4s %7s %7s %7s %7s\n", "dia", "hora", "tempArray", "tempLine", "médiaArray", "médiaLine");
      int t = 0;


      do {

//         out.println(sf.nextLine());

         double numero = Double.parseDouble(sf.nextLine());
         double numero1 = Double.parseDouble(sc.nextLine());
         temp1.in(numero);
         temp.in(numero1);
         double somaN = 0.0;
         double somaN1 = 0.0;
         for (int hora = -N; hora < 0; hora++) {
            somaN += temp.get(hora);
            somaN1 += temp1.get(hora);
         }

         out.printf("%3d   %02d %7.1f %7.1f %10.1f %10.1f\n", t/24, t%24, numero, numero1, somaN/N, somaN1/N);
         t++;

      } while (sf.hasNextLine());
/*
      while (sf.hasNextDouble()) {
         double nova = sf.nextDouble();
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
      }
*/
   }

   public static void printAverage1(Scanner sf, int N) {
      DelayLine<Double> temp = new DelayLine<Double>(N, 0.0);

      out.printf("Temperaturas hora-a-hora e média das últimas %d horas.\n", N);
      out.printf("(As primeiras %d médias não são exatas!)\n", N);
      out.printf("%3s %4s %7s %7s\n", "dia", "hora", "temp.", "média");
      int t = 0;


      do {

//         out.println(sf.nextLine());

         double numero = Double.parseDouble(sf.nextLine());
         temp.in(numero);
         double somaN = 0.0;
         for (int hora = -N; hora < 0; hora++) {
            somaN += temp.get(hora);
         }

         out.printf("%3d   %02d %7.1f %7.1f\n", t/24, t%24, numero, somaN/N);
         t++;

      } while (sf.hasNextLine());
/*
      while (sf.hasNextDouble()) {
         double nova = sf.nextDouble();
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
      }
*/
   }

}
