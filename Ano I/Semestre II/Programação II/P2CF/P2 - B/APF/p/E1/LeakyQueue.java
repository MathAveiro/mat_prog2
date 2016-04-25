/**
 * Uma estrutura de dados baseada numa fila, mas em que só ficam
 * armazenados os últimos N números inseridos. Quando a fila está
 * preenchida (N elementos) a inserção de um novo número implica
 * a saída do primeiro (que deixa de existir).
 */

public class LeakyQueue
{
	private double [] array;
	private int pos;
	
	public LeakyQueue(int dim){
		assert dim > 0;
		
		array= new double [dim];
		pos=0;
	}
	
	public void in(double ent){
		
		if(isFull())
			out();
		
		array[pos]=ent;
		pos++;
	}
	
	public void out(){
		assert !isEmpty();
		
		for(int i=0; i<pos-1;i++)
			array[i] = array[i+1];
		
		pos--;
	}
	
	public boolean isEmpty(){
		return pos==0;
	}
	
	public boolean isFull(){
		return pos==array.length;
	}
	
	public int size(){
		return pos;
	}
	
	public double minimum(){
		assert !isEmpty();
		
		double min=array[0];
		
		for(int i=1; i<pos; i++)
			if(array[i]<min)
				min = array[i];
		
		return min;
	}
	
	public void print(){
		
		for(int i=0; i<pos; i++)
			System.out.print("  " + array[i]);
	}
	
	// as funcoes abaixo deste comentario nao sao obrigatorias de fazer porque nao sao usadas no ProgX
	
	public double peek(){
		return array[0];
	}
	
	public void clear(){
		pos=0;
	}
}
