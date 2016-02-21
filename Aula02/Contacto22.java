public class Contacto22 {
	
	private String nome, telefone, eMail;

	public Contacto22(String n, String t, String e) {
		this.nome = n;
		this.telefone = t;
		this.eMail = e;
	}

	public Contacto22(String n, String t) {
		this.nome = n;
		this.telefone = t;
	}

	public String nome() {
		return this.nome;
	} 

	public String telefone() {
		return this.telefone;
	} 

	public String eMail() {
		return this.eMail;
	}
	
}