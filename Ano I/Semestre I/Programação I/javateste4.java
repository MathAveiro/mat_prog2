/*
(manipulação de arrays, registos e ficheiros)

1 - Compilar e executar;
2 - Ler N notas do ficheiro source.txt e gravá-los no array notes;
3 - Chamar funções e gravar dados noutro ficheiro;

Aula 4 - Funções
Aula 5 - Arrays
Aula 6 - Registos (classes - criação de novos tipos de dados)
Aula 9 - Ficheiros: escrita; leitura; verificação;
Aula 10 - Ordenação (Deve estar apto de escrever uma função para executar pelo menos um algoritmo de ordenação. Não é permitido utilizar funções de biblioteca, por exemplo, Arrays.sort)
(Matéria de outras aulas também pode ser usada, por exemplo, ciclos, estruturas de controlo (if-else, swithc-case))

Erros mais frequentes:
	Utilização de ponto e vírgula;
	Declarações incorretas;
	Faltas de reserva da memória;
	Utilização de variáveis dentro de funções (variável declarada dentro duma função não pode ser usada fora da função);
	Descrição de uma classe nova dentro da classe principal sem palavra static. Recomendo declarar classes novas fora de qualquer classe;
	Utilização correta de tipos e instruções de conversão (cast) se necessário.

Recomendações:
	Pode escrever o programa a partir de início, mas é significativamente mais simples abrir o ficheiro fornecido (ExemploAjuda.java), gravar este ficheiro com o próprio nome (por exemplo, A12345) e adicionar o código;
	O ficheiro ExemploAjuda.java tem a descrição da função para verificação de ficheiros, declarações de classes, instruções do tipo throws IOException, instruções do tipo import java.io.*; cabeçalhos de funções necessárias, por exemplo,
		static double media(int[]){
			return 0;
		}
		etc;
	Quando acabar o problema A pode gravar o código como o código inicial para o problema B e continuar. No primeiro passo deve alterar alguns nomes propriamente;
	Não deve de tentar implementar o código completo a partit de início. Implemente e verifique o código passo a passo.;
	Pode utulizar intruções System.out.println... para verificar resultados intermédios;
	Pode utilizar comentários para bloquear alguma parte de código (Ctrl+e);
	Pode abrir ficheiros gerados inicialmente e ficheiros com resultados no mesmo editor Geany;
	Deve ler a descrição da tarefa a partir de início até ao final antes de programar.
*/

import java.util.*;
import java.io.*;
public class javateste4 {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) throws IOException {
		int op = 0;
		Aluno[] p = new Aluno[10];
		for(int n=0;n<10;n++){
			p[n]=new Aluno();
		}
		do {
            System.out.println("1 - Ler ficheiro com números mec. e pedir informação de notas");
            System.out.println("2 - Imprimir no terminal a informação da disciplina");      
            System.out.println("3 - Calcular estatísticas das notas finais");           
            System.out.println("4 - Alterar as notas de um aluno");           
            System.out.println("5 - Imprimir um histograma de notas");           
            System.out.println("6 - Gravar num ficheiro a informação da disciplina (ordenada)");           
            System.out.println("7 - Terminar o programa");      
            System.out.print("Opção: ");     
            op = sc.nextInt();
            switch (op) {
            	case 1:
            	lerFicheiro(p);
            	break;
            	case 2:
            	imprimirTabela(p);
            	break;
            	case 3:
            	imprimirResultados(p);
            	break;
            	case 4:
            	alterarAluno(p);
            	break;
            	case 5:
            	histogramaNotas(p);
            	break;
            	case 6:
            	gravarFile(p);
            	break;
            	default:
            }      
     	} while (op != 7);
	}
	public static void lerFicheiro (Aluno[] p) throws IOException {
		String nomeFile = new String();
		System.out.print("Nome do ficheiro leitura: ");        
		do {
            nomeFile = sc.nextLine();
        } while(nomeFile.length() == 0);
        File fin = new File(nomeFile);
		if (!fin.exists())
		{
			System.out.println("ERROR: input file " + nomeFile + " does not exist!");
			System.exit(2);
		}
		if (fin.isDirectory())
		{
			System.out.println("ERROR: input file " + nomeFile + " is a directory!");
			System.exit(3);
		}
		if (!fin.canRead())
		{
			System.out.println("ERROR: cannot read from input file " + nomeFile+ "!");
			System.exit(4);
		}
		Scanner scf = new Scanner(fin);
		int temp = 0;
		String detalhes = new String();
		do {
			detalhes = scf.nextLine();
			p[temp].nmec = detalhes;
			temp++;
		} while(scf.hasNextLine());
		scf.close();
		for (int n=0;n<temp;n++) {
			do {
				System.out.printf("Introduza a nota obtida em época normal pelo aluno com nº mec %s: ", p[n].nmec);
				p[n].t1 = sc.nextInt(); 
			} while (p[n].t1 < 0 || p[n].t1 > 20 && p[n].t1!=77);
			do {
				System.out.printf("Introduza a nota obtida em época de recurso pelo aluno com nº mec %s: ", p[n].nmec);
				p[n].t2 = sc.nextInt(); 
			} while (p[n].t2 < 0 || p[n].t2 > 20 && p[n].t2!=77);
		}	
	}
	public static void imprimirTabela (Aluno[] p) {
		int n=0;
		p[n].tmaior = 0;
		for (n=0;n<p.length;n++) {
			if(p[n].t1 > p[n].tmaior) 
				if(p[n].t1 != 77)
					p[n].tmaior = p[n].t1;
		}
		for (n=0;n<p.length;n++) {
			if(p[n].t2 > p[n].tmaior) 
				if(p[n].t2 != 77)
					p[n].tmaior = p[n].t2;
		}
		for (n=0;n<p.length;n++) {
			if (p[n].t1 == 77 && p[n].t2 == 77) p[n].tmaior = 77;	
		}
		System.out.println("Pauta da disciplina");
		System.out.println("---------------------------------");
		for (n=0;n<p.length;n++) {		
			System.out.printf("|%s\t|%.0f\t|%.0f\t|%.0f\t|\n", p[n].nmec, p[n].t1, p[n].t2, p[n].tmaior);
		}
		System.out.println("---------------------------------");
	}
	public static void imprimirResultados (Aluno[] p) {
		int n, reprovado=0, aprovado=0, melhorAluno=0, nalunos=0;
		double soma=0, media=0;
		for (n=0;n<p.length;n++) {
			if(p[n].tmaior != 77) soma += p[n].tmaior;
			if(p[n].tmaior > p[melhorAluno].tmaior) if(p[n].tmaior != 77) melhorAluno = n;
			if(p[n].tmaior < 10 || p[n].tmaior == 77) reprovado++;
			if(p[n].tmaior >= 10) if(p[n].tmaior != 77) aprovado++;
			if(p[n].tmaior !=77) nalunos++;
		}
		media = soma/nalunos;
		System.out.printf("A nota final média de todos os alunos é de: %.0f\n", media);
		System.out.printf("Informações do melhor aluno: NºMecanográfico: %s\tNota obtida em época normal: %.0f\tNota obtida em época de recurso: %.0f\tNota final: %.0f\n",p[melhorAluno].nmec,p[melhorAluno].t1,p[melhorAluno].t2,p[melhorAluno].tmaior);
		System.out.printf("Nº alunos reprovados: %d\tNº alunos aprovados: %d\n", reprovado, aprovado);
	}
	public static void alterarAluno (Aluno[] p) {
		boolean existe = false;
		String temp = new String ();
		System.out.print("Introduza o nº mecanográfico do aluno que pretende alterar: ");
		temp = sc.next();
		for (int i=0;i<p.length;i++) {
			String compare = new String();
			compare = p[i].nmec;
			if (compare.equals(temp)) {
				existe = true;
				System.out.printf("Introduza a nota obtida em época normal pelo aluno com nº mec %s: ", p[i].nmec);
				p[i].t1 = sc.nextInt();
				System.out.printf("Introduza a nota obtida em época de recurso pelo aluno com nº mec %s: ", p[i].nmec);
				p[i].t2 = sc.nextInt();
			}
		}
		if (existe==false) System.out.println("O aluno não existe");
	}
	public static void histogramaNotas (Aluno[] p) {
		for (int temp=0;temp<=20;temp++) {
			System.out.print("Nota "+temp+": ");
			for (int i=0;i<p.length;i++) {
				if(p[i].tmaior == temp) {
					System.out.print("*");
				}
			}
			System.out.println();
		}
	}
	public static void gravarFile (Aluno []p) throws IOException {
		String nome = new String();
        System.out.print("Nome do ficheiro(.txt): ");
        do {
            nome = sc.nextLine();
        } while(nome.length() == 0);
        File f = new File(nome);
        PrintWriter pw = new PrintWriter(f);
       	for (int temp=0;temp<p.length;temp++) {
			if (p[temp].tmaior >= 10 && p[temp].tmaior <= 20) pw.printf("Informações do aluno aprovado: NºMecanográfico: %s\tNota obtida em época normal: %.0f\tNota obtida em época de recurso: %.0f\tNota final: %.0f\n",p[temp].nmec,p[temp].t1,p[temp].t2,p[temp].tmaior); 
		}
        pw.close();
	}
}
class Aluno {
	String nmec;
	double t1, t2, tmaior;
	String nome; 
}