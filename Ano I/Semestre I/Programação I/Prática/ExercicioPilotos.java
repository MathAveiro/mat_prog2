import java.util.*;
import java.io.*;
import static java.lang.System.*;
public class ExercicioPilotos{
	static Scanner sc=new Scanner (in);
	public static void main(String[]args){
		int n=0,m=0,op=0,temp=0;
		Piloto[]p=new Piloto[10];
		Piloto[]j=new Piloto[10];
		for(n=0;n<10;n++){
			p[n]=new Piloto();
		}
		for(m=0;n<10;m++){
			p[m]=new Piloto();
		}
		do{
			op=funcaoMenu();
			switch(op){
				case 1:
				n=funcaoPiloto(p,n);
				break;
				case 2:
				funcaoListar(p,n);
				break;
				case 3:
				funcaoAlterar(p,n);
				break;
				case 4:
				n=funcaoRemover(p,n);
				break;
				case 5:
				funcaoListarNome(p,n);
				break;
				case 6:
				n=funcaoRemoverNome(p,j,n);
				break;
				case 7:
				break;
				case 8:
				out.println("O programa vai terminar");
				break;
			}
		}while(op!=8);
	}
	public static int funcaoMenu(){
		out.println();
		out.println("1 - Inserir informação dos pilotos");
		out.println("2 - Listar pilotos ordenados pelo número da viatura");
		out.println("3 - Alterar informação de um piloto");
		out.println("4 - Remover piloto com base no número da viatura");
		out.println("5 - Listar pilotos ordenados pelo nome");
		out.println("6 - Remover piloto(s) com base no nome");
		out.println("7 - Validar matriculas");
		out.println("8 - Terminar programa");
		out.println();
		int op=0;
		do{
			out.print("Opção:");
			op=sc.nextInt();
			if(!((op>0&&op<9))){
				out.println("Opção inválida");
			}
		} while(!(op>0&&op<9));
		return op;
	}
	public static int funcaoPiloto(Piloto[]p,int n){
		n=0;
		int k=0;
		do{
			sc.nextLine();
			String[]campos;
			out.println("Introduza o nome do piloto:");
			p[n].nome=sc.nextLine();
			String temp=p[n].nome;
			if(temp.length()==0) break;
			else{
				out.println("Introduza a matricula do veículo (aa-bb-cc):");
				String matricula=sc.next();
				campos=matricula.split("-");
				p[n].aa=campos[0];
				p[n].nn=campos[1];
				p[n].bb=campos[2];
				p[n].nviatura=n+1;
				p[n].cont=k++;
			}
			n++;
		}while(n<10);
		return n;
	}
	public static void funcaoListar(Piloto[]p,int n){
		int i,j;
		for(i=0;i<n;i++){
			for(j=i;j<=n;j++){
				if(p[i].nviatura>p[j].nviatura){
					Piloto temp=p[i];
					p[i]=p[j];
					p[j]=temp;
				}
			}			
		}
		for(i=1;i<=n;i++){
			out.printf("Número da viatura:%d\tNome do piloto:%s\tMatrícula da viatura:%s-%s-%s\n",p[i].nviatura,p[i].nome,p[i].aa,p[i].nn,p[i].bb);
		}
	}
	public static void funcaoAlterar(Piloto[]p,int n){
		out.println("Introduza o nº da viatura à qual pretende alterar a informação do piloto:");
		int i=sc.nextInt();
		int existe=0;
		for(int temp=0;temp<=n;temp++){
			if(i==p[temp].nviatura){
				String[]campos;
				sc.nextLine();
				out.println("Introduza o novo nome do piloto:");
				p[temp].nome=sc.nextLine();
				out.println("Introduza a matricula do veículo (aa-bb-cc):");
				String matricula=sc.next();
				campos=matricula.split("-");
				p[temp].aa=campos[0];
				p[temp].nn=campos[1];
				p[temp].bb=campos[2];
				existe=1;
			}
			if(existe!=1&&temp==n){
				out.println("A viatura selecionada não existe");
			}
		}
	}
	public static int funcaoRemover(Piloto[]p,int n){
		out.println("Introduza o número da viatura que pretende remover:");
		int i=sc.nextInt();
		for(int temp=0;temp<=n;temp++){
			if(i==p[temp].nviatura){
				for(int j=temp;j<=n;j++){
					p[j]=p[j+1];	
				}
			}
		}
		return n-1;
	}
	public static void funcaoListarNome(Piloto[]p,int n){
		int i,j;
		for(i=0;i<n;i++){
			for(j=i;j<=n;j++){
				if(p[i].nome.compareTo(p[j].nome)>0){
					Piloto temp=p[i];
					p[i]=p[j];
					p[j]=temp;
				}
			}			
		}
		for(i=1;i<=n;i++){
			out.printf("Número da viatura:%d\tNome do piloto:%s\tMatrícula da viatura:%s-%s-%s\n",p[i].nviatura,p[i].nome,p[i].aa,p[i].nn,p[i].bb);
		}
	}
	public static int funcaoRemoverNome(Piloto[]p,Piloto[]j,int n){
		out.println("Introduza o nome do piloto que pretende remover:");
		String s1temp=sc.next();
		int op=0,k=0,o=0;
		out.println("Contacto a remover:");
		for(int i=0;i<=n;i++){
			if(p[i].nome.indexOf(s1temp)==0){
				out.printf("%d | Nome: %s\n",k+1,p[i].nome);
				j[k]=p[i];
				k++;
			}
		}
		op=sc.nextInt();
		for(int temp=0;temp<=n;temp++){
			if(j[op-1].nome==p[temp].nome){
				for(int temp2=temp;temp2<=n;temp2++){
					p[temp2]=p[temp2+1];	
				}
			}
		}
		return n-1;
	}
}
class Piloto{
	int nviatura;
	String nome,aa,nn,bb;
	int cont;
}