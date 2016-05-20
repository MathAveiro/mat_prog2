public class Pessoa implements Comparable<Pessoa> {
	public Pessoa(Data data, String nome) {
		this.nome = nome;
		this.data = data;
	}
	public String nome() {
		return  nome;
	}
	public Data data() {
		return  data;
	}
	public String toString() {
		String temp = nome + " - "+data.dia()+"/"+data.mes();
		return temp;
	}
	public int compareTo(Pessoa p) {
		if(data().mes()<p.data().mes()) 
			return -1;
		else {
			if(data().mes()>p.data().mes())
				return 1;
			else {
				if(data().dia()<p.data().dia())
					return -1;
				else {
					if(data().dia()>p.data().dia())
						return 1;
					else {
						return 0;
					}
				}
			}
		}
	}
	private String nome;
	private Data data;
}