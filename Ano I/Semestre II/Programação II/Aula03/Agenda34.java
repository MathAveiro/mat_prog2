import java.util.*;
import java.io.*;
import static java.lang.System.*;
import static java.lang.Integer.*;

public class Agenda34 {

	private static int n = 0;
	private Nota34 nota [] = new Nota34[5];

	public void novaNota (Nota34 a) {

		nota [n] = new Nota34 (a.getInicio(), a.getFim(), a.getTexto());

		for (int vtemp = 0; vtemp < n ; vtemp++) {

			if(nota[n].getInicio().maiorDoQue(nota[vtemp].getInicio())) {

				Nota34 temp = nota[vtemp].getNota();

				nota[vtemp]=nota[n].getNota();

				nota[n]=temp.getNota();

			}

		}

		n++;

	}

	public Nota34[] compromissos (Data34 a, Data34 b) {

		int n = 0;

		Nota34 [] todo = new Nota34 [this.n];

		for(int i=0; i<nota.length; i++) {

			if (nota[i].getInicio().maiorDoQue(a) && nota[i].getInicio().menorDoQue(b) || nota[i].getFim().maiorDoQue(a) && nota[i].getFim().menorDoQue(b) || nota[i].getInicio().igualA(b) || nota[i].getFim().igualA(a) || nota[i].getFim().igualA(b)) {

				todo[n] = new Nota34(nota[i].getInicio(), nota[i].getFim(), nota[i].getTexto());

				n++;

			}
				
		}

		Nota34 temp1 [] = new Nota34[n];

		for(int i=0; i<n; i++) {

			temp1 [i] = todo [i]; 

		}

		return temp1;
		
	}

	public void funcaoEscrever () {

		out.printf("Agenda:\n");
		
		for (int temp = 0; temp<nota.length ; temp++) {
		
			nota[temp].funcaoEscrever();
		
		}

	}

}