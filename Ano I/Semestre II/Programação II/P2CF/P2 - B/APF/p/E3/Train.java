/**
Um objecto da classe Train representa um comboio composto de vários vagões
de mercadorias a granel.
Quando se cria um comboio, é necessário especificar a capacidade de cada
vagão e a capacidade total que o comboio suporta, ambas em toneladas.
Pode acrescentar-se um vagão com certa carga à cauda de um comboio
(addWagon) ou pode retirar-se um vagão da cauda (removeWagon), segundo uma
política LIFO (último a entrar é o primeiro a sair).
Naturalmente, a carga de um vagão não pode superar a sua capacidade e só
se pode acrescentar um vagão que não faça ultrapassar a carga total máxima do
comboio.
Também é possível pedir para descarregar (unload) uma dada quantidade, o que
será feito pela descarga completa e retirada de zero ou mais vagões da cauda
e pela descarga parcial de outro vagão para completar a quantidade pedida.
Em qualquer altura é possível obter uma lista da carga nos vagões do
comboio (list); saber o número de vagões (size) ou a carga total
transportada (totalCargo).

Métodos principais:
addWagon     Acrescenta um vagão com uma certa carga ao fim do comboio.
removeWagon  Retira o vagão do fim do comboio e devolve a sua carga.
unload       Descarrega uma certa quantidade, retirando os vagões que ficarem
             vazios.  Devolve o número de vagões retirados.
acceptsCargo Verifica se o comboio pode aceitar uma carga adicional,
             sem ultrapassar o limite de carga total.
list         Devolve um array com as cargas de cada vagão, do primeiro ao último.
             Não altera nada no comboio.
size         Tamanho (número de vagões) do comboio.
totalCargo   Carga total transportada no comboio.
**/

/*
	Nota: Os senhores do DETI fizeram o MainTrain.jar. Como eles deixaram o jar com um NullPointerException, sempre que testarem
			o jar com argumentos parecidos ou iguais a "java -ea -jar MainTrain.jar 10 100 10 -10" vai aparecer essa excepcao
			que so por acaso nao ajuda a resolver o exercicio.
		  O erro de que falo e' na funcao unload. Neste modulo (Train.java) nao acontece esse erro e o que esta feito e' apenas
			uma proposta de resolucao.
*/

public class Train {
	
	private double [] comboio;
	private int pos;
	private double vagao, pesoTotal;
	//vagao representa o peso limite de cada vagao
	//pesoTotal representa o peso maximo que o comboio pode transportar
	
	//criar comboio
	public Train (double wag, double max){
		comboio = new double [1];// inicia um comboio com espaco para um vagao
		pos=0;
		vagao = wag;
		pesoTotal = max;
	}
	
	// adiciona um novo vagao com uma determinada carga
	public void addWagon(double carga){
		assert carga <= vagao: "ERRO: Sobrecarga de vagão!";
		assert acceptsCargo(carga): "ERRO: Sobrecarga do comboio!";
		
		// criamos novo comboio no caso do antigo nao ter espaco para colocarmos mais vagoes
		if(pos==comboio.length){
			double [] aux = comboio;
			comboio = new double [comboio.length + 1];
			System.arraycopy(aux, 0, comboio, 0, aux.length);
		}

		comboio[pos] = carga;
		pos++;
	}
	
	// diz se ha vagoes no comboio
	public boolean isEmpty(){
		return pos==0;
	}
	
	// retira apenas um vagao
	public double removeWagon(){
		assert !isEmpty();
		return comboio[--pos]; // devolve o valor de toneladas no vagao e retira-o ao mesmo tempo
	}
	
	// diz se o comboio pode aceitar, ou nao, mais carga
	public boolean acceptsCargo(double ent){
		if((totalCargo()+ent) > pesoTotal) 
			return false;	//devolve falso no caso da carga total somada com aquela que queremos inserir for superior ao pesoTotal
		return true;
	}
	
	// devolve a carga total existente no comboio
	public double totalCargo(){
		double cargaTotal=0;
		for(int i = 0; i<pos; i++)
			cargaTotal += comboio[i];
		
		return cargaTotal;
	}
	
	// devolve o numero de vagoes
	public int size(){
		return pos;
	}
	
	// retira uma determinada carga do comboio
	public int unload(double descarga){
		assert descarga <= totalCargo(): "ERRO: Comboio não tem carga suficiente!";
		
		int n = 0;
		
		while(descarga!=0){ // (suposta condicao de paragem) 
			
			// se o que queremos retirar for menor do que aquilo que esta no ultimo vagao, entao, basta retirar a carga
			if(descarga < comboio[pos-1]){
				comboio[pos-1] -= descarga;
				break;
			}
			// se o que queremos retirar for igual ao que esta no ultimo vagao, entao, basta retirar o vagao
			if(descarga == comboio[pos-1]){
				pos--;
				n++;
				break;
			}
			// se o que queremos retirar for maior do que aquilo que esta no ultimo vagao, entao ...
				// ...retiramos o vagao e substraimos a carga desse vagao ao que queriamos retirar
					// e repetimos o ciclo
			if(descarga > comboio[pos-1]){
				descarga -= comboio[pos-1];
				pos--;
				n++;
			}
		}
		return n;
	}
	
	// devolve o array de vagoes existentes
	public double[] list(){
		double [] lista;
		// como ha possibilidade de devolvermos um array com uma ou mais posicoes vazias...
			// ... criamos novo array sem posicoes vazias e devolvemos
		System.arraycopy(comboio, 0, (lista = new double [pos]), 0, pos);
		
		return lista;
	}
	
}
