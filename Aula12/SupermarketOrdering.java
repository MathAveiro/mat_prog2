<<<<<<< HEAD
import p2utils.*;

class SupermarketOrdering {

	HashTable<Integer> produtos = new HashTable<Integer>(100); 

	Queue<Order> encomendas = new Queue<Order>();

	public void enterOrder(Order encomenda) {
		encomendas.in(encomenda);
		int cont=0;
		if(produtos.contains(encomenda.prodName))
			cont = produtos.get(encomenda.prodName);
		produtos.set(encomenda.prodName, cont + encomenda.quantity);
	}

	public Order serveOrder() {		 

		Order temp = encomendas.peek();
		int cont = produtos.get(temp.prodName);
		if(temp.quantity - cont == 0) produtos.remove(temp.prodName);
		else produtos.set(temp.prodName, cont - temp.quantity);
		encomendas.out();
		
		return temp;

	}

	private int query(String product) {
		
		return produtos.get(product);
	}

	public void displayOrderedProducts() {
		
		String[] temp = produtos.keys();

		System.out.print("Ordered products: ");

		for(int i = 0; i < temp.length; i++) {
			System.out.print(temp[i] + ":" + produtos.get(temp[i]) + " ");
		}

	}
=======
import p2utils.*;	

import static java.lang.System.*;

class SupermarketOrdering {

	HashTable<Integer> encomendas = new HashTable<>(100);

	Queue<Order> fila = new Queue<Order>();

	public int numOrders() {

		return encomendas.size();

	}

	public void enterOrder(Order encomenda) {

		int quantidade = 0;

		if (encomendas.contains(encomenda.prodName)) quantidade = encomendas.get(encomenda.prodName);
	
		encomendas.set(encomenda.prodName, quantidade + encomenda.quantity);

		fila.in(encomenda);

    }

    public Order serveOrder() {

    	Order encomendaAntiga = fila.peek();

    	fila.out();

    	int quantidadeInicial = encomendas.get(encomendaAntiga.prodName);

    	if (quantidadeInicial == encomendaAntiga.quantity) encomendas.remove(encomendaAntiga.prodName);

    	else encomendas.set(encomendaAntiga.prodName, quantidadeInicial - encomendaAntiga.quantity);

    	return encomendaAntiga;


    }

    public int query(String product) {

    	return encomendas.get(product);

    }

    public void displayOrderedProducts() {

    	String [] produtos = encomendas.keys();

    	String str = "Ordered products: ";

    	for (int i = 0; i < produtos.length; i++) {
    		
    		str += produtos[i] + ":" + encomendas.get(produtos[i]) + " ";

    	}

    	out.println(str);

    }
>>>>>>> dde380dedd5c74137ccbd9e3f1185487d355bd13

	public int numOrders() {
		return encomendas.size();
	}
}
