import java.util.*;
import java.io.*;
public class microrato{
	public static Scanner sc=new Scanner(System.in);
	public static void main(String[]args)throws IOException{
		int op=0,nrobot=0;
		Robot p[]=new Robot[100];
		do{	
			op=menu();
			switch(op){
				case 1:nrobot=addRobot(p,nrobot);break;
				case 2:imprimirRobot(p,nrobot);break;
				case 3:vencedorRobot(p,nrobot);break;
				case 4:mediaEquipa(p,nrobot);break;
				case 5:nomeMaiuscula(p,nrobot);break;
				case 6:alterarRobot(p,nrobot);break;
				case 7:nrobot=removerRobot(p,nrobot);break;
				case 8:gravarFicheiro(p,nrobot);break;
				case 9:System.out.println("O programa vai terminar");break;
				default:
			}
		}while(op!=9);
	}
	public static int menu(){
		int op=0;
		System.out.printf("Introduza uma opção\n1:Adicionar informação relativa a um robo\n2:Imprimir informação dos robots em prova\n3:Vencedor da prova e tempos médios de prova\n4:Média do número de elementos por equipa\n5:Mostrar o nome dos robos em maiúscula\n6:Alterar informação de um robo\n7:Remover robos da competição\n8:Gravar informação da prova num ficheiro\n9:Terminar o programa\n");
		do{
			System.out.print("Opção:");
			op=sc.nextInt();
			if(op<0||op>9)System.out.println("Opção inválida");
		}while(op<0||op>9);
		return op;
	}
	public static int addRobot(Robot[]p,int nrobot){
		p[nrobot]=new Robot();
		System.out.print("Introduza o nome do robot:");
		p[nrobot].nome=sc.next();
		System.out.println();
		System.out.print("Tempo de prova (em segundos):");
		p[nrobot].tempo=sc.nextInt();
		p[nrobot].hora=p[nrobot].tempo/3600;
		p[nrobot].minuto=(p[nrobot].tempo%3600)/60;
		p[nrobot].segundo=((p[nrobot].tempo%3600)%3600)%60;
		System.out.println();
		System.out.print("Número de elementos da equipa:");
		p[nrobot].elementos=sc.nextInt();
		System.out.println();
		nrobot++;
		return nrobot;
	}
	public static void imprimirRobot(Robot[]p,int nrobot){
		for(int temp=0;temp<nrobot;temp++){
			System.out.printf("Nome do robot:%s\tTempo do robot:%d:%d:%d\tNº de elementos da equipa:%d\n",p[temp].nome,p[temp].hora,p[temp].minuto,p[temp].segundo,p[temp].elementos);
		}
	}
	public static void vencedorRobot(Robot[]p,int nrobot){
		int temp,temp2=0,maior=p[1].tempo,tempototal=0;
		double media;
		for(temp=0;temp<nrobot;temp++){
			if(p[temp].tempo<maior){
				maior=p[temp].tempo;
				temp2=temp;
			}
			tempototal+=p[temp].tempo;
		}
		media=tempototal/temp;
		double mediahora=media/3600;
		double mediaminuto=(media%3600)/60;
		double mediasegundo=((media%3600)%3600)%60;
		System.out.printf("Detalhes do robot vencedor:\nNome do robot:%s\tTempo do robot:%d:%d:%d\tNº de elementos da equipa:%d\n",p[temp2].nome,p[temp2].hora,p[temp2].minuto,p[temp2].segundo,p[temp2].elementos);
		System.out.printf("O tempo médio dos robots são:%.0f:%.0f:%.0f\n",mediahora,mediaminuto,mediasegundo);
	}
	public static void mediaEquipa(Robot[]p,int nrobot){
		int temp=0,elementosTotal=0;
		double elementosMedio=0;
		for(temp=0;temp<nrobot;temp++){
			elementosTotal+=p[temp].elementos;
		}
		elementosMedio=elementosTotal/temp;
		System.out.printf("Número de elementos médio por equipa:%.2f\n",elementosMedio);
	}
	public static void nomeMaiuscula(Robot[]p,int nrobot){
		for(int temp=0;temp<nrobot;temp++){
			String temp2=p[temp].nome.toUpperCase();
			p[temp].nome=temp2;
			System.out.println(temp2);
		}
	}
	public static void alterarRobot(Robot[]p,int nrobot){
		String temp,temp3;
		System.out.print("Nome do robot que pretende alterar:");
		do{
			temp=sc.nextLine();
			temp3=temp.toUpperCase();
		}while(temp.length()==0);
		System.out.println();
		int ver=0;
		for(int temp2=0;temp2<nrobot;temp2++){
			if(p[temp2].nome.equals(temp3)){
				System.out.print("Introduza o nome do robot:");
				p[temp2].nome=sc.next();
				System.out.println();
				System.out.print("Tempo de prova (em segundos):");
				p[temp2].tempo=sc.nextInt();
				p[temp2].hora=p[temp2].tempo/3600;
				p[temp2].minuto=(p[temp2].tempo%3600)/60;
				p[temp2].segundo=((p[temp2].tempo%3600)%3600)%60;
				System.out.println();
				System.out.print("Número de elementos da equipa:");
				p[temp2].elementos=sc.nextInt();
				System.out.println();
				ver=1;
			}
		}
		if(ver==0)System.out.println("Este robo não existe");
	}
	public static int removerRobot(Robot[]p,int nrobot){
		System.out.print("Introduza o tempo mínimo para remover o robot (em segundos):");
		int temp=sc.nextInt();
		int temp2,cont=0;
		for(temp2=0;temp2<nrobot;temp2++){
			if(p[temp2].tempo>temp){
				for(int temp3=temp2+1;temp3<nrobot;temp3++){
					p[temp2]=p[temp3];
				}
			cont++;
			}
		}
		return nrobot-cont;
	}
	public static void gravarFicheiro(Robot[]p,int nrobot)throws IOException{
		String save=new String();
		System.out.print("Introduza o nome do ficheiro a guardar:");
		do{
			save=sc.nextLine();
		}while(save.length()==0);
		File fin=new File(save);
		PrintWriter pw=new PrintWriter(fin);
		for(int temp=0;temp<nrobot;temp++){
			pw.printf("Detalhes do robot vencedor:\nNome do robot:%s\tTempo do robot:%d:%d:%d\tNº de elementos da equipa:%d\n",p[temp].nome,p[temp].hora,p[temp].minuto,p[temp].segundo,p[temp].elementos);
		}
		pw.close();
	}
}
class Robot{
	String nome;
	int tempo,elementos,hora,minuto,segundo;
}