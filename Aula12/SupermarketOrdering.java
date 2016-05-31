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

}
