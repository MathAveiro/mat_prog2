package pt.ua.prog2;

public class Contacto24 {

	private String nome, telefone, eMail;
	private static int contador=0;

	public Contacto24(String n, String t, String e) {
		this.nome = n;
		this.telefone = t;
		this.eMail = e;
		contador++;
		funcaoValidar(this.nome);
	}

	private void funcaoValidar(String n) {
		if (n==null || n.length()==0) {
			System.err.println("Contacto inválido!");
			System.exit(0);
		}

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

	public static int contador() {
		return contador;
	}
	
}