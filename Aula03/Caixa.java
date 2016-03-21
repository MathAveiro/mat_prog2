public class Caixa {
	private long[] moedas;
	private static int n=0;

	public void addMoeda(long moeda) {
		moedas=Retorno(moeda);
	}
	private long[] Retorno (long moeda) {
		long b[] = new long[n+1];
		for(int i=0; i<n; i++) {
			b[i]=moedas[i];
		}
		b[n++]=moeda;
		return b;
	}
	public long[] delMoeda(long valor) {
		long totalRetirado=0;
		int l=0;
		long sum=0;
		long nv=valor;
		for(int i=0; i<moedas.length; i++) {
			sum=sum+moedas[i];
		}
		if (sum<valor) {
			System.out.println("ERRO! Não há dinheiro suficiente!");
			long[] removidas = {-1};
			return removidas;
		}
		for (int i=0; i<moedas.length; i++) {
			for (int j=i; j<moedas.length; j++) {
				if(moedas[j]<moedas[i]) {
					long temp = moedas[i];
					moedas[i]=moedas[j];
					moedas[j]=temp;
				}
			}
		}
		for(int i=0; i<moedas.length; i++) {
			if(totalRetirado<valor) {
				totalRetirado = totalRetirado + moedas[i];
				l++;
			}
		}
		long[] retirado = new long[l];
		long[] b = new long[moedas.length-l];
		totalRetirado=0;
		int p=0, r=0;
		for(int i=0; i<moedas.length; i++) {
			if(totalRetirado<valor) {
				totalRetirado = totalRetirado + moedas[i];
				retirado[r]=moedas[i];
				r++;
			}
			else {
				b[p]=moedas[i];
				p++;
			}
		}
		moedas=b;
		return retirado;
	}
	public long total() {
		long carteira=0;
		for(int i=0; i<moedas.length; i++) {
			carteira=carteira+moedas[i];
		}
		return carteira;
	}
	public long[] moedas() {
		return moedas;
	}
}