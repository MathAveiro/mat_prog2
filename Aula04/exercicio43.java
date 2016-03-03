import static java.lang.System.*;

public class exercicio43 {
	public static void main(String[] args) {
	
		Nota43[] notas = new Nota43[args.length / 7]; // argumentos em grupos de sete (data-inicio data-fim texto)
	
		assert args.length % 7 == 0: "Introduza um texto associado às datas referidas";

		for(int i = 0; i < notas.length; i++) {
			int dia, mes, ano;
			dia = Integer.parseInt(args[i*7]);
			mes = Integer.parseInt(args[i*7+1]);
			ano = Integer.parseInt(args[i*7+2]);
			Data43 inicio = new Data43(dia, mes, ano);
			dia = Integer.parseInt(args[i*7+3]);
			mes = Integer.parseInt(args[i*7+4]);
			ano = Integer.parseInt(args[i*7+5]);
			Data43 fim = new Data43(dia, mes, ano);
			String texto = args[i*7+6];
			notas[i] = new Nota43(inicio, fim, texto);
		}
		
		for(int i = 0; i < notas.length; i++) notas[i].funcaoEscrever();

	}
}

