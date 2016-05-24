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

	public int numOrders() {
		return encomendas.size();
	}
}
