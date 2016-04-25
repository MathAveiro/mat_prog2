import java.util.*;
import java.io.*;
import static java.lang.System.*;
import static java.lang.Integer.*;

class Nota34 {

	private Data34 inicio;
	private Data34 fim;
	private String texto;

	public Nota34 (Data34 inicio, Data34 fim, String texto) {

		this.inicio = new Data34 (inicio.getDia(), inicio.getMes(), inicio.getAno());

		this.fim = new Data34 (fim.getDia(), fim.getMes(), fim.getAno());

		this.texto = texto;

	}

	public Data34 getInicio () {

		return this.inicio;

	}


	public Data34 getFim () {

		return this.fim;

	}


	public String getTexto () {

		return this.texto;

	}

	public void funcaoEscrever () {

		inicio.funcaoEscrever(); out.printf(" <-> "); fim.funcaoEscrever(); out.printf(": ");out.printf("%s\n",texto);

	}

	public Nota34 getNota(){
    
    	return this;
  
  	}

}