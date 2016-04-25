import java.util.*;

public class histograma {

	static Scanner sc = new Scanner (System.in);

	public static void main(String[] args) {
		
		int aluno = 0;
		int nota [] = new int [5];
		int nota0=0, nota1=0, nota2=0, nota3=0, nota4=0, nota5=0;

		for (aluno = 0;aluno < 5;aluno++) {
			
			int n = 0;
			
			System.out.printf("Insira a nota do aluno %d (no intervalo de 0-5)", aluno);
			
			nota[n] = sc.nextInt();

			n++;

		}

		for (int temp = 0;temp < nota.length;temp++) {
			if(nota[temp]==0) nota0++;
			if(nota[temp]==1) nota1++;
			if(nota[temp]==2) nota2++;
			if(nota[temp]==3) nota3++;
			if(nota[temp]==4) nota4++;
			if(nota[temp]==5) nota5++;	
		}

		int mais=0;
		if (nota0>mais)mais=nota0;
		if (nota1>mais)mais=nota1;
		if (nota2>mais)mais=nota2;
		if (nota3>mais)mais=nota3;
		if (nota4>mais)mais=nota4;
		if (nota5>mais)mais=nota5;

		for (int temp=0;temp<5;temp++) {
			for (int temp2=0;temp2<nota.length;temp2++) {
				if(nota[temp2]==temp){
					System.out.printf("*");
				}
			}
		}

	}

}