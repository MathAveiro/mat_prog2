import java.util.*;

public class Exem5 {
	
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		double pagamentomensalidade=0, pagamentodesconto=0, inscricao;

		inscricao p = new inscricao();

		p = introducao();

		if (p.primeira == 's' || p.primeira == 'S') {

			System.out.println("Nova inscrição para o Clube de Natação"); 
			System.out.println("Primeira vez");
		
		}

		else {

			System.out.println("Nova inscrição para o Clube de Natação"); 
			System.out.println("Já inscrinto anteriormente");

		}

		System.out.printf("%d horas de aperfeiçoamento\n", p.horas);

		System.out.printf("%d familiares\n", p.familia);

		if (p.primeira == 'S' || p.primeira == 's') {

			inscricao = 50;

		}

		else {

			inscricao = 30;

		}

		if (p.modalidade == 1) {

			pagamentomensalidade = p.mensalidades * ((p.horas * 4) * 4);

			if (p.familia == 1) {

				pagamentodesconto = pagamentomensalidade * 0.9;

			}

			if (p.familia > 1) {

				pagamentodesconto = pagamentomensalidade * 0.75;

			}

			if (p.familia == 0) {

				pagamentodesconto = pagamentomensalidade;

			}

		}

		if (p.modalidade == 2) {

			pagamentomensalidade = p.mensalidades * ((p.horas * 4) * 6);

			if (p.familia == 1) {

				pagamentodesconto = pagamentomensalidade * 0.9;

			}

			if (p.familia > 1) {

				pagamentodesconto = pagamentomensalidade * 0.75;

			}

			if (p.familia == 0) {

				pagamentodesconto = pagamentomensalidade;

			}

		}

		System.out.printf("------------------------------------------------------------------------------------------------\n");
		System.out.printf("Item                    Quantidade           Valor\n");
		System.out.printf("Inscrição:              1                    %.2f\n", inscricao);
		System.out.printf("Mensalidades:           %d                   %.2f\n", p.mensalidades, pagamentodesconto);
		System.out.printf("------------------------------------------------------------------------------------------------\n");
		System.out.printf("Total                                        %.2f\n", inscricao + pagamentodesconto);

	}

	public static inscricao introducao() {

		inscricao p = new inscricao();

		do {

			System.out.println("Qual a modalidade a frequentar? (1 - iniciação ou 2 - aperfeiçoamento)");
			p.modalidade = sc.nextInt();

		} while (p.modalidade != 1 && p.modalidade != 2);

		do {

			System.out.println("Qual o número de horas semanais? (de 1 a 10)");
			p.horas = sc.nextInt();

		} while (p.horas > 10 && p.horas < 1);

		System.out.println("Tem familiares a frequentar o clube? (0 para indicar que não tem)");
		p.familia = sc.nextInt();

		do {

			System.out.println("É a primeira vez que frequenta o clube? (sim ou não)");
			p.primeira = sc.next().charAt(0);

		} while (p.primeira != 's' && p.primeira != 'S' && p.primeira != 'n' && p.primeira != 'N');

		do {

		System.out.println("Quantas mensalidades pretende pagar?");
		p.mensalidades=sc.nextInt();

		} while (p.mensalidades <1);

		return p;
	
	}

}

class inscricao {

	int modalidade, horas, familia, mensalidades;
	char primeira;

}