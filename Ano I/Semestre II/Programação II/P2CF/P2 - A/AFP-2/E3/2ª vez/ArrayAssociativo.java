public class ArrayAssociativo<T>{

  public ArrayAssociativo(int t){
  assert t >0;
    tamanho = t;
    array = (Node<T>[]) new Node[tamanho];
  }

  
  public ArrayAssociativo(){
    tamanho = 1024;
    array = (Node<T>[]) new Node[tamanho];
  }
  
  private int hashFunction(String key){
  int cod = key.hashCode();
 cod = Math.abs(cod)%tamanho;
 return cod;
  }
  
  public void delete(String key){
    assert validKey(key);
    assert !isEmpty();
    int cod = hashFunction(key);
    if(exists(key)){
      if(array[cod]==actual){//se for o primeiro
         array[cod]=null;
      }else{
         anterior.next = actual.next;
      }
    size--;
    }
    
  }
  
  public void set(String key, T ele){
  Node<T> novo = new Node<T>();
  novo.key=key;
  novo.elemento = ele;
  
   //buscar codigo
    int cod = hashFunction(key);
    if(array[cod]==null){
     array[cod]=novo;
    }else{
    novo.next=array[cod];
    array[cod]=novo;
    }
    size++;
  }
  
  public Object get(String key){
  assert exists(key);
     return actual.elemento;
   }
  
  public String[] keysToArray(){
  String[] palavras = new String[size];
  int k =0;
  for(int i =0; i<tamanho; i++){
    while(array[i]==null){
    i++;
    if(i>=tamanho){
    return palavras;
    }
    }
  //ja estou nul k nao e nulo
  Node p = array[i];
  while(p!=null){
  palavras[k]=p.key;
  p=p.next;
  k++;
  }
  }
   return palavras; 
  }
  
  public boolean isEmpty(){
  return size ==0;
  }
  
  public void clear(){
  
    for(int i =0; i<array.length; i++)
    array[i]=null;
    
    size=0;
  }
  
  public int size(){
  return size;
  }
  
  public boolean exists(String key){
  
  assert validKey(key);  
  int cod = hashFunction(key);
  Node p = new Node<T>();
  p= array[cod];
  while(p!=null && !p.key.equalsIgnoreCase(key)){
  anterior =p;
    p=p.next;
  }
  actual =p;
  return p!=null;
  
  }
  
  public boolean validKey(String key){
  return key!=null;
  }
  
  private class Node<T>{
  Node next;
  String key;
  T elemento;  
  }
  private int size=0;
  private int tamanho;
  private Node[] array;
  private Node actual, anterior;
}
  
  