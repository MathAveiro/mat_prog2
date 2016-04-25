public class Programa{

	public static void main(String [] args){
	
		Mod p= new Mod("abc", false);
		
		Mod.v= -5;
		
		int j= p.yup(true, new Mod(false));
		
	}

	static class Mod{
		
		
		public Mod(String s, boolean b){
		}
	
		public static int v;
	
		Mod(boolean x){
		}
	
		public int yup (boolean a, Mod cd){
			return v;  // nao esta no exercicio mas é preciso um return
		}
	}
}
