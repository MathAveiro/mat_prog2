import java.util.*;
import java.io.*;
import static java.lang.System.*;
import static java.lang.Integer.*;

public class exercicio32 {
	public static void main(String[] args) {

		Data32[] datas = new Data32[args.length / 3];
		
		for(int i = 0; i < datas.length; i++) {
			int dia = Integer.parseInt(args[i*3]);
			int mes = Integer.parseInt(args[i*3+1]);
			int ano = Integer.parseInt(args[i*3+2]);
			datas[i] = new Data32(dia, mes, ano);
		}

		boolean ordenado = true;
		for(int i = 1; ordenado && i < datas.length; i++) ordenado = datas[i].igualA(datas[i-1]) || datas[i].maiorDoQue(datas[i-1]);

		if (!ordenado) sort(datas);

		for(int i = 0; i < datas.length; i++) {

			out.printf("%02d - ", i+1);
			datas[i].funcaoEscrever();

		}

	}

	static void sort(Data32[] datas) {
		for(int i = 0; i < datas.length; i++)
		for(int j = i+1; j < datas.length; j++)
		if (datas[j].menorDoQue(datas[i])) {
			Data32 tmp = datas[j];
			datas[j] = datas[i];
			datas[i] = tmp;
		}

	}

}

