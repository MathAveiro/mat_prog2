public class Nota {
	static private Data inicio;
	static private Data fim;
	static private String texto;
	public Nota(Data inicio, Data fim, String texto) {
		assert inicio.menorDoQue(fim): "Datas!";
		this.inicio=new Data(inicio.dia(), inicio.mes(), inicio.ano());
		this.fim=new Data(fim.dia(), fim.mes(), fim.ano());
		this.texto=texto;
	}
	public Data getInicio() {
		return this.inicio;
	}
	public Data getFim() {
		return this.fim;
	}
	public String getTexto() {
		return this.texto;
	}
	public Nota getNota() {
		return this;
	}
	public void escreve() {
		System.out.println(inicio.getData()+" <-> "+fim.getData()+": "+texto);
	}
}