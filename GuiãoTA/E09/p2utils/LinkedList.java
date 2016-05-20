package p2utils;

public class LinkedList<E> {

   /**
    * {@code LinkedList} constructor, empty so far.
    */
   public LinkedList() { }

   /**
    * @return Number of elements in the list
    */
   public int size() { return size; }

   public int count (E e) { 
      /*Este método serve para contar o número de vezes que o elemento "e" é repetido na lista.
      Para isso criamos um contador iniciado em 0 e sempre que encontrarmos elementos iguais incrementamos o contador*/
      return count(e, first ,0); 
      /*No programa principal a função apena é chamada com um argumento. 
      No entanto para a conseguirmos fazer precisamos de mais e por isso mesmo criamos um novo método com mais argumentos*/

   }

   private int count (E e, Node first, int count) {

      if (first.next == null){
        /*Assim que o próximo nó for null, que dizer que estamos na ultima posição. 
        Sendo assim verificamo se a ultima posição é igual ao número que estamos a procurar e caso afirmativo incrementamos o cont e retornamo-lo.*/
        if (first.elem.equals(e)) count++;
        return count;
      }  
      /*Para as restantes posições verificamos só se sao iguais ao número que estamos a procurar. 
      Se for voltamos a chamar a função para a proxima posição e incrementamos o cont*/
      else if (first.elem.equals(e)) return count(e, first.next, count+1);
      /*Caso o elemento da posição não seja igual ao elemento que procuramos, avançamos para a próxima posição*/
      else return count(e, first.next, count);
   }

   public int indexOf (E e) {
      /*Este método devolve a posição da primeira ocorrência de um dado elemento na lista, ou -1 caso a lista não contenha o elemento.
      Para isso usamos uma variável index que vai sendo incrementada sempre que nao encontrarmos um elemento igual ao que procuramos*/
      return indexOf(e, first, 1);
      /*No programa principal a função apena é chamada com um argumento. 
      No entanto para a conseguirmos fazer precisamos de mais e por isso mesmo criamos um novo método com mais argumentos*/

   }

   private int indexOf (E e, Node first, int index) {
      /*Assim que chegarmos a ultima posição da lista verificamos se é igual ao elemento que procuramos.
      Caso seja retornamos o indice.
      Caso nao seja significa que nenhum elemento da lista é igual e por isso retornamos -1*/
      if (first == null) {
        if (first.elem.equals(e)) return index;
        else return -1;
      } 
      /*Nas outras posições verificamos se o elemento é igual ao que procuramos, caso seja retornamos o indice.
      Caso nao seja voltamos a chamar a função para a posição seguinte e incrementamos o indice*/
      else {
        if (first.elem.equals(e)) return index;
        else return indexOf (e, first.next, index+1);
      }

   }

   public LinkedList<E> cloneReplace (E x, E y) {
      /*Criamos uma nova lista vazia*/
      /*Este método devolve uma copia da lista em que todas as ocorrencias de x estao substituidas por y.*/
      LinkedList<E> newList = new LinkedList<E>();

      return cloneReplace (x, y, first, newList);
      /*No programa principal a função apena é chamada com um argumento. 
      No entanto para a conseguirmos fazer precisamos de mais e por isso mesmo criamos um novo método com mais argumentos*/

   }

   private LinkedList<E> cloneReplace (E x, E y, Node <E> first, LinkedList<E> newList) {
      /*Assim que chegarmos a ultima posição retornamos a lista*/
      if (first == null) return newList;

      else { 
        /*Caso contrario verificamos se o elemento da lista original é igual ao elemento que queremos substituir*/

        if (first.elem.equals(x)) newList.addLast(y); /*Caso seja adicionamos a nova lista o elemento y que vai substituir o x*/

        else newList.addLast(first.elem); /*Caso nao seja adicionamos a nova lista o elemento da lista original*/

        return cloneReplace(x, y, first.next, newList); /*Voltamos a chamar a funçao para a proxima posição*/

        /*Adicionamos sempre ao final da lista (addLast) para que o proximo elemento seja adicionado depois dos elementos que ja esta na lista e assim nao a inverter*/

      }

   }

   public LinkedList<E> cloneSublist (int x, int y) {
      /*Criamos uma nova lista vazia*/
      LinkedList<E> newList = new LinkedList<E>();
      /*Este método devolve uma nova lista com os elementos nas posições start até end-1.*/
      int cont = 1;
      /*O contador serve para sabermos em que posição da lista estamos*/
      return cloneSublist (x, y, cont, newList, first);
      /*No programa principal a função apena é chamada com um argumento. 
      No entanto para a conseguirmos fazer precisamos de mais e por isso mesmo criamos um novo método com mais argumentos*/

   }

   private LinkedList<E> cloneSublist (int x, int y, int cont, LinkedList<E> newList, Node<E>  first) {
      /*Assim que passarmos a ultima posição do intervalo sabemos que mais nenhum elemento vai ser adicionado a nova lista e por isso mesmo podemos retorna-la*/
      if (cont > y) return newList;
      /*Caso o contador esteja no intervalo [x, y] adicionamos esse elemento a nova lista*/
      else if (cont >= x && cont < y) {

        newList.addLast(first.elem);
        /*Depois de o adicionar chamamos a função para a proxima posição e incremetamos o contador*/
        return cloneSublist (x, y, cont+1, newList, first.next);

      }
      /*Caso o contador nao esteja dentro do intervalo ou seja superior ao intervalo, 
      chamamos a função para a proxima posição e incrementando o contador, até este estiver dentro do intervalo*/
      else return cloneSublist (x, y, cont+1, newList, first.next);
   }
   
   public LinkedList<E> cloneExceptSublist (int x, int y) { //Objetivo: criar uma lista igual à lista original mas sem os elementos entre a casa x (start) e o end-1 (y-1);

      LinkedList<E> newList = new LinkedList<E>(); //Criar a nova lista (lista colone = newList);

      int cont = 1;

      return cloneExceptSublist (x, y, cont, newList, first);

   }

   private LinkedList<E> cloneExceptSublist (int x, int y, int cont, LinkedList<E> newList, Node<E>  first) { 

        if (first == null) return newList; //Caso já não existam elementos na lista original retorna a lista colonada (newList)

        if (cont >= x && cont < y) return cloneExceptSublist(x, y, cont+1, newList, first.next); //Se o contador estiver entre o star e o end-1 avança uma casa;

        else { //Caso o contador esteja fora do intervalo dado vai adicionar à nova lista o elemento correspondente à casa do contador atual;

          newList.addLast(first.elem); 

          return cloneExceptSublist (x, y, cont+1, newList, first.next); //Avança mais uma casa;

        }
   }


   public void removeSublist (int x, int y) {

      removeSublist (x, y, 1,first, size());

   }

   private void removeSublist (int x, int y, int cont, Node<E> n, int size) { //Objetivo: remover da lista os números entre o start e o end;

    if (cont > size) return; //Verifica que o contadore é "real", ou seja, se o contador for maior do que o tamanho da lista não faz nada!

    if (n == null) return; //Caso o nó seja vazio, não faz nada!

      if (cont > x && cont <= y) { //Equanto o contador estiver entre o start (x) e o end (y) vai remover da lista o elemento

        removeFirst();

        removeSublist(x, y, cont+1, n.next, size);
      
      }
      
      else { //Caso o contador esteja antes do start ou depois do end, vai mover o elemento para a última posição e posteriormente remove-lo do ínicio, para que o próximo elemento passe a ser o primeiro;

        addLast(n.elem);

        removeFirst();

        removeSublist (x, y,cont+1, n.next, size);

      }

   }


   /* Explicação para removeSublist(int x, int y) {}
    
    Imaginemos a seguinte lista:

    [2][5][8][1][3]
    Size = 5;
    Queremos remover os elementos entre a "casa" 2(start) e 4(end);
    O contador começa em 1:
        Verificar a primeira condição -> "contador > size": como o contador é menor ou igual do que o size passa para a seguinte condição;
        Verificar a segunda condição -> "a "casa" é vazia": como a "casa" é diferente de vazio então passa para a seguinte condição;
        Verificar se o contador está entre o start (2) e o end-1 (4-1): como o contador está em 1, então seguimos para o else:
        Contador ->    (1)(2)(3)(4)(5)
        "Casa" ->      [2][5][8][1][3]
            Adicionar no fim o elemento da casa correspondente ao contador nº1 --> --> [2][5][8][1][3]"[2]"
            Remover a primeira casa --> --> [5][8][1][3][2];
    Voltamos a repetir o processo, mas aumentamos o contador para 2:
        Verificar a primeira condição -> "contador > size": como o contador é menor ou igual do que o size passa para a seguinte condição;
        Verificar a segunda condição -> "a "casa" é vazia": como a "casa" é diferente de vazio então passa para a seguinte condição;
        Verificar se o contador está entre o start (2) e o end-1 (4-1): como o contador está em 2 (encontra-se no intervalo do start e do end) então:
        Contador ->    (2)(3)(4)(5)(6)
        "Casa" ->      [5][8][1][3][2]
            Remover a primeira casa --> --> [8][1][3][2];
    Voltamos a repetir o processo, mas aumentamos o contador para 3:
        Verificar a primeira condição -> "contador > size": como o contador é menor ou igual do que o size passa para a seguinte condição;
        Verificar a segunda condição -> "a "casa" é vazia": como a "casa" é diferente de vazio então passa para a seguinte condição;
        Verificar se o contador está entre o start (2) e o end-1 (4-1): como o contador está em 3 (encontra-se no intervalo do start e do end) então:
        Contador ->    (3)(4)(5)(6)
        "Casa" ->      [8][1][3][2]
            Remover a primeira casa --> --> [1][3][2];
    Voltamos a repetir o processo, mas aumentamos o contador para 4:
        Verificar a primeira condição -> "contador > size": como o contador é menor ou igual do que o size passa para a seguinte condição;
        Verificar a segunda condição -> "a "casa" é vazia": como a "casa" é diferente de vazio então passa para a seguinte condição;
        Verificar se o contador está entre o start (2) e o end-1 (4-1): como o contador está em 4 (não se encontra no intervalo do start e do end) então:
        Contador ->    (4)(5)(6)
        "Casa" ->      [1][3][2]
            Adicionar a primeira casa ao fim da lista --> --> [1][3][2][1]
            Remover a primeira casa --> --> [3][2][1];
    Voltamos a repetir o processo, mas aumentamos o contador para 5:
        Verificar a primeira condição -> "contador > size": como o contador é menor ou igual do que o size passa para a seguinte condição;
        Verificar a segunda condição -> "a "casa" é vazia": como a "casa" é diferente de vazio então passa para a seguinte condição;
        Verificar se o contador está entre o start (2) e o end-1 (4-1): como o contador está em 5 (não se encontra no intervalo do start e do end) então:
        Contador ->    (5)(6)(7)
        "Casa" ->      [3][2][1]
            Adicionar a primeira casa ao fim da lista --> --> [3][2][1][3]
            Remover a primeira casa --> --> [2][1][3];
    Voltamos a repetir o processo, mas aumentamos o contador para 6:
        Verificar a primeira condição -> "contador > size": como o contador não é menor ou igual do que o size, não faz nada!
        A nossa lista ficou: [2][1][3];


    */

   /**
    * Checks if the list is empty
    * @return  {@code true} if list empty, otherwise {@code false}.
    */
   public boolean isEmpty() { return size == 0; }

   /**
    * @return  First element in the list
    */
   public E first() {
      assert !isEmpty(): "empty!";

      return first.elem;
   }

   /**
    * @return  Last element in the list
    */
   public E last() {
      assert !isEmpty(): "empty!";
 
      return last.elem;
   }

   /**
    * Adds a new element to the start of the list
    */
   public void addFirst(E e) {
      first = new Node<>(e, first);
      if (isEmpty())
         last = first;
      size++;

      assert !isEmpty() && first().equals(e);
   }

   /**
    * Adds a new element to the end of the list
    */
   public void addLast(E e) {
      Node<E> newest = new Node<>(e);
      if (isEmpty())
         first = newest;
      else
         last.next = newest;
      last = newest;
      size++;

      assert !isEmpty() && last().equals(e);
   }

   /**
    * Removes the first element in the list
    */
   public void removeFirst() {
      assert !isEmpty(): "empty!";
      first = first.next;
      size--;
      if (isEmpty())
         last = null;
   }

   public String toString() {
      if (size()==0) 
         return "[ ]";
      String s = "[ " + first.elem.toString();
      if (size()==1) 
         return s + " ]";
      Node<E> n = first.next;
      while (n!=null) {
         s += ("," + n.elem.toString());
         n = n.next;
      }
      return s + " ]";
   }

   private Node<E> first = null;
   private Node<E> last = null;
   private int size = 0;

}


