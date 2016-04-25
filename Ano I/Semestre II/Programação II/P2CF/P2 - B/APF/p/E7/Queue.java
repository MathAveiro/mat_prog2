import exameP2.*;

class Queue{
	
	private Object [] array;
	private int pos;
	
	public Queue(){
		array = new Object[1];
		pos=0;
	}
	
	public void in (Refeicao [] ent){
		assert ent != null;
		
		array [pos] = ent;
		pos++;
	}
	
	public void out(){
		assert !isEmpty();
		pos--;
	}
	
	public boolean isEmpty(){
		return pos==0;
	}
	
	public void printQueue(){
		
		for(int i=0; i<pos; i++)
			System.out.println("Refeicao pendente: " + array[i]);
	}
	
	public boolean podeServir(AssociativeArray a){
		
		
		
		return true;
	}
}
