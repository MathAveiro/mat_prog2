import java.util.*;

public class Exercicio2
{

    public static void main(String[] args) 
    {

        Scanner sc = new Scanner(System.in);
		
		    int numeros[] = new int[100]; 
        
        int n, i=0, c=0, prim;
      
        if (i<100) 
        {
          
          do 
          {

            System.out.print("Introduza um número inteiro positivo: ");
            n = sc.nextInt();.

            numeros[i]=n;

            i++;

          } while (n>=0);

        }

        System.out.print("Qual o número a verificar: ");
        prim = sc.nextInt();

        for (i=0;i<100;i++) 
        {
          
          if (numeros[i]==prim)
          {

            c++;

          }

        }

        System.out.printf("Foi repetido o número %d %d vezes.", prim, c);
        
    }

}