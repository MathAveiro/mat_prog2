import java.util.*;
import java.io.*;
import static java.lang.System.*;
import static java.lang.Integer.*;

class Data34 {

	private int dia, mes, ano;


	public Data34 (int d, int m, int a) {

		dia = d;
		mes = m;
		ano = a;

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

	public boolean igualA (Data34 a) {

		if (a.dia == dia && a.mes==mes && a.ano==ano) return true;

		else return false;

	}

	public boolean menorDoQue (Data34 a) {

		if (getAno() > a.getAno()) return false;

		else if (getAno() < a.getAno()) return true;

		else {

			if (getMes() > a.getMes()) return false;

			else if (getMes() < a.getMes()) return true;

			else {

				if (getDia() < a.getDia()) return true;

				else return false;

			}

		}

	}

	public boolean maiorDoQue (Data34 a) {

		if (getAno() < a.getAno()) return false;

		else if (getAno() > a.getAno()) return true;

		else {

			if (getMes() < a.getMes()) return false;

			else if (getMes() > a.getMes()) return true;

			else {

				if (getDia() > a.getDia()) return true;

				else return false;
			}

		}

	}

	public void funcaoEscrever () {

		out.printf("%02d-%02d-%04d", getDia(), getMes(), getAno());
	
	}

}