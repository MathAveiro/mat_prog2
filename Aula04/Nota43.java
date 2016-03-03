import java.util.*;
import java.io.*;
import static java.lang.System.*;
import static java.lang.Integer.*;

class Nota43 {

	private Data43 inicio;
	private Data43 fim;
	private String texto;

	public Nota43 (Data43 inicio, Data43 fim, String texto) {

		assert inicio.menorDoQue(fim): "Data de início maior do que data de fim";

		this.inicio = new Data43 (inicio.getDia(), inicio.getMes(), inicio.getAno());

		this.fim = new Data43 (fim.getDia(), fim.getMes(), fim.getAno());

		this.texto = texto;

	}

	public Data43 getInicio () {

		return this.inicio;

	}


	public Data43 getFim () {

		return this.fim;

	}


	public String getTexto () {

		return this.texto;

	}

	public void funcaoEscrever () {

		inicio.funcaoEscrever(); out.printf(" <-> "); fim.funcaoEscrever(); out.printf(": ");out.printf("%s\n",texto);

	}

	public Nota43 getNota(){
    
    	return this;
  
  	}

}