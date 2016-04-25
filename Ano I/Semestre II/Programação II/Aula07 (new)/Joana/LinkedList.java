public class LinkedList<E> 
{
	/**
	 * {@code LinkedList} construtor, vazio até agora.
     */
	public LinkedList() 
	{ 
	}

	/**
     * @return número de elementos na lista
     */
	public int size() 
	{ 
		return size; 
	}

    /**
     * Verifica se a lista é vazia
     * @return  {@code true} se a lista for vazia, de outra forma {@code false}.
     */
	public boolean isEmpty() 
	{ 
		return size == 0; 
	}

	/**
     * @return  Primeiro elemento na lista
     */
	public E first()
	{
		assert !isEmpty(): "empty!";

		return first.elem;
	}

	/**
     * @return  Último elemento na lista
     */
	public E last() 
	{
		assert !isEmpty(): "empty!";
 
		return last.elem;
	}

	/**
     * Adiciona um novo elemento no início da lista
     */
	public void addFirst(E e) 
	{
		first = new Node<>(e, first);
		if (isEmpty())
			last = first;
		size++;
	}

	/**
     * Adiciona um novo elemento no fim da lista
     */
	public void addLast(E e) 
	{
		Node<E> newest = new Node<>(e);
		if (isEmpty())
			first = newest;
		else
			last.next = newest;
		last = newest;
		size++;
	}

	/**
     * Remove o primeiro elemento na lista
     */
	public void removeFirst() 
	{
		assert !isEmpty(): "empty!";
		first = first.next;
		size--;
		if (isEmpty())
			last = null;
	}
	
	// devolve uma nova lista com a mesma sequência de elementos
	public LinkedList clone()
	{
		return clone(first);
	}
	
	private LinkedList clone (Node<E> n)
	{
		if (n == null) return new LinkedList<E>();
		
		else
		{
			LinkedList<E> newList = clone (n.next);
			newList.addFirst(n.elem);
			return newList;
		}
	}
	
	// devolve uma nova lista com os mesmos elementos por ordem inversa
	public LinkedList reverse()
	{
		return reverse(first);
	}
	
	private LinkedList reverse (Node<E> n)
	{
		if (n == null) return new LinkedList<E>();
		
		else
		{
			LinkedList<E> newList = reverse(n.next);
			newList.addLast(n.elem);
			return newList;
		}
	}
    
	/* devolve o elemento na posição pos da lista, em que pos varia 
	 * entre 0 e size()-1
	 */
	public E get (int pos)
	{
		return get(pos, first, 0);
	}
	
	private E get (int pos, Node<E> n, int i)
	{
		if (pos == i) return n.elem;
		
		else return get(pos, n.next, i+1);
	}
	
	/* devolve uma nova lista com os elementos da lista (em que o método
	 * é chamado) seguidos dos elementos da lista dada no argumento.
	 */
	public LinkedList concatenate (LinkedList<E> lst)
	{
		LinkedList<E> newList = lst.clone();
		
		return concatenate(newList, first);
	}
	
	private LinkedList concatenate (LinkedList<E> lst, Node<E> elem)
	{
		if (elem == null) return lst;
		
		else 
		{
			lst = concatenate(lst, elem.next);
			lst.addFirst(elem.elem);
			return lst;
		}
	}
	
	// devolve true caso o elemento dado exista na lista, e false c.c.
	public boolean contains (E e)
	{
		return contains(first, e);
	}
	
	private boolean contains (Node<E> n, E e) 
	{
		if (n == null) return false;
		
		if (n.elem.equals(e)) return true;
		
		return contains(n.next, e);
	}
	
	// remove da lista a primeira ocorrência do elemento dado no argumento
	public void remove (E e)
	{
		remove(first, e);
	}
	
	private void remove (Node<E> n, E e)
	{
		assert contains(e);
		
		if (get(0).equals(e))
			removeFirst();
			
		else if (n.next.elem.equals(e))
		{
			n.next = n.next.next;
			size--;
			return;
		}
		
		else
			remove(n.next, e);
	}

	private Node<E> first = null;
	private Node<E> last = null;
	private int size = 0;  
}


