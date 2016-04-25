/**
 * Uma estrutura de dados de tipo pilha, mas com os métodos alternativos:
 * - popN(n): retira os n elementos de topo da pilha
 * - topMatches(seqChars): verifica se os últimos caracteres na pilha
 *                         coincidem com seqChars
 * - toString(): devolve uma String com todos os caracteres contidos
 *               na pilha (desde o mais antigo até ao mais recente)
 */

/*
 Nota: Os senhores do DETI fizeram o ProgX mas fizeram-no a funcionar apenas com numeros de um digito, ou seja, so funciona com 
  numeros entre [-9;9]. Por isso nao se deve testar o ProgX com numeros maiores do |-9| se nao aparece sempre Bad expression!
*/

public class Stack2X{
 
 private char [] array;
 private int pos;
 
 // Construtor (inicia a pilha)
 public Stack2X(){
  
  array = new char[1];
  pos=0;
 }
 
 //adiciona elemento a' pilha
 public void push(char ent){
  assert Character.toString(ent) != null;
  
  // se a pilha estiver cheia, cria-se uma com mais um espaco
  if(pos==array.length){
   char [] novo = array;
   array = new char [array.length + 1];
   System.arraycopy(novo, 0, array, 0, novo.length);
  }
  
  array[pos]=ent;
  pos++;
 }
 
 //retira elemento a' pilha
 public void pop(){
  assert !isEmpty();
  pos--;
 }
 
 // devolve o ultimo elemento inserido
 public char top(){
  return array[pos-1];
 }
 
 //diz se a pilha esta vazia
 public boolean isEmpty(){
  return pos == 0;
 }
 
 // diz se a pilha esta cheia
 public boolean isFull(){
  return pos == array.length;
 }
 
 //devolve o numero de carateres na pilha
 public int size(){
  return pos;
 }
 
 // retira n elementos da pilha
 public void popN(int n){
  assert array.length>=n;
  
  // se temos de retirar n elementos, temos de executar n vezes a funcao pop()
  for( ; n>0; n--){
   pop();
  }
  
  /* outra forma
  for(int i =0; i<n ; i++)
   out();
   */
 }
 
 //verifica se os ultimos elementos da pilha sao iguais a um determinado padrao
 public boolean topMatches(String pattern){
  assert !isEmpty();
  assert pattern != null;
  
  if(pos < pattern.length())
   return false;
  
  String s = "";
  for(int i = pos-(pattern.length()); i<pos; i++){
   s+=array[i];
  }
  if(s.equals(pattern))
   return true;
  
  return false;
 }
 
 //devolve uma string com todos os elementos da pilha
 public String toString(){
  assert !isEmpty();
  
  String s= "";
  
  for(int i=0; i<pos; i++)
   s += array[i];
  
  return s;
 }
}

