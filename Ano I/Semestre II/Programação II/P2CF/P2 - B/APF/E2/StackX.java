/**
 * Uma estrutura de dados de tipo pilha, mas com os métodos alternativos:
 * - popN(n): retira os n elementos de topo da pilha
 * - topMatches(seqChars): verifica se os últimos caracteres na pilha
 *                         coincidem com seqChars
 * - toString(): devolve uma String com todos os caracteres contidos
 *               na pilha (desde o mais antigo até ao mais recente)
 */

public class StackX {

 private char[] array;
 private int size;

 public StackX() {
  
  array = new char[1];
  size = 0;
 }
 public void push(char ent){
  assert Character.toString(ent) != null;
  
  // se a pilha estiver cheia, cria-se uma com mais um espaco
  if(size==array.length){
   char [] novo = array;
   array = new char [array.length + 1];
   System.arraycopy(novo, 0, array, 0, novo.length);
  }
  
  array[size]=ent;
  size++;
 }
 
 /*public void push(char e) {
  assert !isFull();
  array[size] = e;
  size++;
  assert !isEmpty() && top() == e;
 }
*/
 public void pop() {
  assert !isEmpty();
  size--;
  assert !isFull();
 }

 public char top() {
  assert !isEmpty();
  return array[size-1];
 }
 
 public boolean isEmpty(){
  return size == 0;
 }
 
 public boolean isFull() {
  return size == array.length;
 }
 
 public int size() {
  return size;
 }
 
 public void clear() {
  size = 0;
 assert isEmpty();
 }
 
 public boolean topMatches (String a){
   String b= "";
   if(size<a.length()){
   return false;
   }
   
   for(int i=size-a.length(); i<size; i++){
   b+=a.charAt(i);
   }
   if(b.equals(a)){
     return true; 
   }
 return false; 
 }
 
 public void popN (int a){
  assert !isEmpty();
  size=size-a;
  assert !isFull();
 }
}

