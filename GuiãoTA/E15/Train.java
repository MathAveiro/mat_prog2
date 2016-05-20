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

public class Train {
	private double wagonCapacity, trainCapacity;
	private double totalCargo;
	private int size = 0;
	private double[] list;
	public Train(double wCapacity, double tCapacity) {
		wagonCapacity = wCapacity;
		trainCapacity = tCapacity;
		list = new double[0];
	}

	public void addWagon(double carga) {
		if(size==list.length) addSize();
		totalCargo = totalCargo + carga;
		list[size] = carga;
		size++;	
	}
	public double removeWagon() {
		totalCargo = totalCargo - list[size-1];
		double temp = list[size-1];
		remSize();
		size--;
		return temp;
	}
	public int unload(double carga) {
		int temp = list.length;
		do {
			if(list[size-1]>carga) {
				list[size-1] = list[size-1] - carga;
				totalCargo = totalCargo - carga;
				carga = 0;
			}
			else {
				carga = carga - list[size-1];
				removeWagon();
			}
		} while (carga > 0); 
		return temp - list.length;
	}
	public boolean acceptsCargo(double carga) {
		if(totalCargo+carga <= trainCapacity) return true;
		else return false;
	}
	public double[] list() {
		return list;
	}
	public int size() {
		return size;
	}
	public double totalCargo() {
		return totalCargo;
	}
	public boolean isEmpty() {
		if(size == 0) return true;
		else return false;
	}
	private void addSize() {
		double[] nlist = new double[list.length+1];
		for (int i=0; i<list.length; i++) {
			nlist[i] = list[i];
		}
		list = nlist;
	}
	private void remSize() {
		double[] nlist = new double[list.length-1];
		for (int i=0; i<list.length-1; i++) {
			nlist[i] = list[i];
		}
		list = nlist;
	}

}
