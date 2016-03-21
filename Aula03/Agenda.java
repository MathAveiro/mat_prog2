public class Agenda {
	private Nota[] x=new Nota[5];
	private Data incio, fim;
	private String texto;
	static int i=0, p=0;
	public void novaNota(Nota a) {
		x[i]=new Nota(a.getInicio(), a.getFim(), a.getTexto());
		i++;
		ordena(x, i);
	}
	public void ordena(Nota[] x, int y){
		for(int i=0; i<y; i++) {
			for(int j=i; j<y; j++) {
				if(x[i].getInicio().maiorDoQue(x[j].getInicio())) {
					Nota temp = x[i];
					x[i]=x[j];
					x[j]=temp;
				}
			}
		}
	}
	public void escreve(){
		System.out.println("Agenda: ");
		for(int j=0; j<x.length; j++) {
			x[j].escreve();
		}
	}
	public Nota[] compromissos(Data d1, Data d2) {
		Nota todo[]=new Nota[5];
		for(int k=0; k<x.length; k++){
			if(x[k].getInicio().maiorDoQue(d1) && x[k].getInicio().menorDoQue(d2) || x[k].getFim().maiorDoQue(d1) && x[k].getFim().menorDoQue(d2) || x[k].getInicio().igualA(d1) || x[k].getInicio().igualA(d2) || x[k].getFim().igualA(d1) || x[k].getFim().igualA(d2)) {
				todo[p]=new Nota(x[k].getInicio(), x[k].getFim(), x[k].getTexto());
				p++;
			}
		}
		Nota novotodo[]= new Nota[p];
		for(int i=0; i<p; i++){
			novotodo[i]=todo[i];
		}	
		return novotodo;
	}
}