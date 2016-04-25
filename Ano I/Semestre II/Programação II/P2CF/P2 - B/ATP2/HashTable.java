public class HashTable{

	public boolean exists(int key){
		///contrato e implementacao omitidos!
		return true;
	}

	public void insert (int key, char elem){
		assert !exists(key); // certo
		
		int pos = hashFunction(key); // certo
		Node n = new Node(); // certo
		n.key= key;
		n.elem=elem;
		n.next = arr[pos]; // certo
		arr[pos]= n;	// certo
		siz++; // certo
	}

	public void delete (int key){
		// contrato e implementacao omitidos!
	}

	public char get (int key){
		assert exists(key); // certo
		
		int pos= hashFunction(key); // certo
		Node n = arr[pos]; // certo
		while(n!=null && n.key!=key)
			n = n.next; // certo
			
		return n.elem; // certo
	}

	public String join(int [] keys){
		assert keys!=null; // certo

		String r = ""; // certo
		for(int i = 0; i < keys.length; i++) // certo
			if(exists(keys[i])) // certo
				r += get(keys[i]); // certo
				
		return r; // certo
	}

	private int hashFunction(int key){
		// contrato e implementacao omitidos!
		return key%10;
	}
	
	Node [] arr;
	private int siz;

	private class Node{
		int key;
		char elem;
		Node next;
	}
}
