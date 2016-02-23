public class Nota {
	private Data inicio;
	private Data fim;
	private String texto;
	public Nota(Data inicio, Data fim, String texto) {
		this.inicio=new Data(inicio.dia(), inicio.mes(), inicio.ano());
		this.fim=new Data(fim.dia(), fim.mes(), fim.ano());
		this.texto=texto;
	}
	public void escreve() {
		System.out.print("Data de inicio:"); inicio.escreve(); System.out.print("Data de fim:"); inicio.escreve(); System.out.println("Texto associado: "+texto);
	}
}