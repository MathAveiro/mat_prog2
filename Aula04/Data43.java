import java.util.*;
import java.io.*;
import static java.lang.System.*;
import static java.lang.Integer.*;

class Data43 {

	private int dia, mes, ano;


	public Data43 (int d, int m, int a) {

		assert ternoInteiro(d, m, a): "Data inválida";

		this.dia = d;
		this.mes = m;
		this.ano = a;

	}

	private static boolean ternoInteiro (int d, int m, int a) {

		if (d > ndiasMes(m, a)) return false;
		else if (a < 1) return false;
		else if (m > 12 || m < 1) return false;
		else return true;

	}

	private static int ndiasMes (int m, int a) {
		switch(m){
			case 1: return 31;
			case 2:
				if(anoBissexto(a)) return 29;
				else return 28;
			case 3: return 31;
			case 4: return 30;
			case 5: return 31;
			case 6: return 30;
			case 7: return 31;
			case 8: return 31;
			case 9: return 30;
			case 10: return 31;
			case 11: return 30;
			case 12: return 31;
		}
		return 0;
	}

	private static boolean anoBissexto (int a) {
		if(a%400==0 || (a%4==0 && a%100!=0)) return true;
		else return false;

	}

	public int getDia () {

		return dia;

	}

	public int getMes () {

		return mes;

	}

	public int getAno () {

		return ano;

	}

	public boolean igualA (Data43 a) {

		if (a.dia == dia && a.mes==mes && a.ano==ano) return true;

		else return false;

	}

	public boolean menorDoQue (Data43 a) {

		if (ano > a.ano) return false;

		else if (ano < a.ano) return true;

		else {

			if (mes > a.mes) return false;

			else if (mes < a.mes) return true;

			else {

				if (dia < a.dia) return true;

				else return false;

			}

		}

	}

	public boolean maiorDoQue (Data43 a) {

		if (ano < a.ano) return false;

		else if (ano > a.ano) return true;

		else {

			if (mes < a.mes) return false;

			else if (mes > a.mes) return true;

			else {

				if (dia > a.dia) return true;

				else return false;
			}

		}

	}

	public void funcaoEscrever () {

		out.printf("%02d-%02d-%04d", this.dia, this.mes, this.ano);
	
	}

}