import java.util.*;
import java.io.*;
import static java.lang.System.*;
import static java.lang.Integer.*;

public class Data25 {

	private int dia, mes, ano;

	public void defineData() {

		out.printf("%02d-%02d-%02d\n", dia, mes, ano);
	
	}

	private static boolean anoBissexto (int a) {
		if(a%400==0 || (a%4==0 && a%100!=0)) return true;
		else return false;

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

	private static boolean ternoInteiro (int d, int m, int a) {

		if (d > ndiasMes(m, a)) return false;
		else if (a < 1) return false;
		else if (m > 12 || m < 1) return false;
		else return true;

	}

	public boolean ternoInteiro() {

		if (dia > ndiasMes(mes, ano)) return false;
		else if (ano < 1) return false;
		else if (mes > 12 || mes < 1) return false;
		else return true; 
	}

	public Data25() {

		Calendar hoje = Calendar.getInstance();
        this.dia = hoje.get(Calendar.DAY_OF_MONTH);
        this.mes = hoje.get(Calendar.MONTH) + 1;
        this.ano = hoje.get(Calendar.YEAR);

	}

	public Data25(int d, int m, int a) {

		this.dia = d;
		this.mes = m;
		this.ano = a;

	}

	public String nomeMes (int m) {

		String mes[] = {"Janeiro","Fevereiro","Março","Abril","Maio","Junho","Julho","Agosto","Setembro","Outubro","Novembro","Dezembro"};
		return mes[m-1];

	}

	public String dataExtenso () {

		return this.dia + " de " + nomeMes(this.mes) + " de " + this.ano;

	}

	public void vaiParaAmanha () {

		dia++;
		if(ternoInteiro(dia, mes, ano)) return;
		else {
			dia = 1;
			mes++;
		}
		if(ternoInteiro(dia, mes, ano)) return;
		else {
			mes = 1;
			ano++;
		}

	}

	public void vaiParaOntem () {

		dia--;
		if(ternoInteiro(dia, mes, ano)) return;
		else {
			mes--;
			ndiasMes(dia, mes);
		}
		if(ternoInteiro(dia, mes, ano)) return;
		else {
			ano--;
			mes=12;	
		}

	}

}