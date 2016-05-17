import static java.lang.System.*;
import java.util.Scanner;
import p2utils.*;

public class P102 {
   
   static Scanner sc = new Scanner (System.in);

   public static void main(String[] args) {
                 
      int n = Integer.parseInt(args[0]);

      Stack<Integer> stackOrigem = new Stack<Integer> ();
      //out.println(queueOrigem.toString());

      int y = n;

      do {

         stackOrigem.push(y);

         y -= 1;

      } while (y > 0);



      /*int size = queueOrigem.size();

      for (int i = 0; i < size; i++) {
         
         out.println(queueOrigem.peek());
         queueOrigem.out();

      }*/
      
      Stack<Integer> stackDestino = new Stack<Integer> ();
      
      Stack<Integer> stackAuxiliar = new Stack<Integer> ();

      out.println("Origem:          " + stackOrigem.toString());

      out.println("Destino:         " + stackDestino.toString());

      out.println("Auxiliar:        " + stackAuxiliar.toString());

      out.println();

      TorresDeHanoi(n, stackOrigem, stackDestino, stackAuxiliar, "origem", "destino", "auxiliar", stackOrigem, stackDestino, stackAuxiliar);

   }

   static void TorresDeHanoi(int n, Stack<Integer> origem, Stack<Integer> destino, Stack<Integer> auxiliar, String Sorigem, String Sdestino, String Sauxiliar, Stack<Integer> origem1, Stack<Integer> destino1, Stack<Integer> auxiliar1) {

      assert n >= 0;


      if (n > 0) {

         TorresDeHanoi(n-1, origem, auxiliar, destino, "origem", "auxiliar", "destino", origem1, destino1, auxiliar1); 

         out.println("Move disco "+ n +" da torre " + Sorigem + " para a torre " + Sdestino);

         destino.push(origem.top());

         origem.pop();

         out.println("Origem:          " + origem1.toString());

         out.println("Destino:         " + destino1.toString());

         out.println("Auxiliar:        " + auxiliar1.toString());

         out.println();

         TorresDeHanoi(n-1, auxiliar, destino, origem, "auxiliar", "destino", "origem", origem1, destino1, auxiliar1); 

      }

   }

}

