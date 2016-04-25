import java.util.*;
import java.io.*;

public class Exercicio2 {

	static Scanner sc = new Scanner (System.in);
	
	public static void main(String[] args) throws IOException {

		Statistics xstat = new Statistics();

		System.out.print("Ficheiro de entrada: ");

		String nameIn = sc.nextLine();

		File fin = new File(nameIn);

		Scanner read = new Scanner (fin);

		double x = read.nextDouble();

		xstat.min = x;

		xstat.max = x;

		updateStats(xstat, x);

			do {

				x = read.nextDouble();

				updateStats(xstat, x);

			} while (read.hasNextDouble());

			read.close();

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

class Statistics {

	double num, sum, sum2, min, max;

}