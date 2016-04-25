import java.util.*;
import java.io.*;
import static java.lang.System.*;
import static java.lang.Integer.*;

class Nota33 {

	private Data33 inicio;
	private Data33 fim;
	private String texto;

	public Nota33 (Data33 inicio, Data33 fim, String texto) {

		this.inicio = new Data33 (inicio.getDia(), inicio.getMes(), inicio.getAno());

		this.fim = new Data33 (fim.getDia(), fim.getMes(), fim.getAno());

		this.texto = texto;

	}

	public void funcaoEscrever () {

		out.printf("%02d-%02d-%04d <-> %02d-%02d-%04d %s\n", inicio.getDia(), inicio.getMes(), inicio.getAno(), fim.getDia(), fim.getMes(), fim.getAno(), texto);

	}		

}