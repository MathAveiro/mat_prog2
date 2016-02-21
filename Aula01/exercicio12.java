import java.util.*;
import java.io.*;
import static java.lang.System.*;
import static java.lang.Integer.*;

public class exercicio12 {

	static Scanner sc = new Scanner (System.in);

	public static void main(String[] args) {

		double ap1, ap2, atpi, apf;

		out.printf("Introuza as notas do aluno\n");

		do{
			out.printf("Nota AP1: ");
			ap1 = sc.nextInt();
		} while (ap1 < 0 || ap1 > 20);

		do{
			out.printf("Nota AP2: ");
			ap2 = sc.nextInt();
		} while (ap2 < 0 || ap2 > 20);
		
		do{
			out.printf("Nota ATPI: ");
			atpi = sc.nextInt();
		} while (atpi < 0 || atpi > 20);

		do{
			out.printf("Nota APF: ");
			apf = sc.nextInt();
		} while (apf < 0 || apf > 20);

		double media = 0.2*ap1 + 0.2*ap2 + 0.2*atpi + 0.4*apf;

		if(media >= 9.5) out.printf("O aluno foi aprovado com %.1f", media);
		else out.printf("O aluno foi reprovado com %f", media);

	}

}