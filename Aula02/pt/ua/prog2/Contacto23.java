package pt.ua.prog2;

public class Contacto23 {

	private String nome, telefone, eMail;

	public Contacto23(String n, String t, String e) {
		this.nome = n;
		this.telefone = t;
		this.eMail = e;
	}

	public Contacto23(String n, String t) {
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