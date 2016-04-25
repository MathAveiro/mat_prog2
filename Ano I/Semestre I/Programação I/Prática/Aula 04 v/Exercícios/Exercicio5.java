import java.util.*;

public class Exercicio5
{
	
	public static void main (String []args)
	{

		double a,b,c;

		for(a=1;a<100;a++){

			for(b=1;b<100;b++){

				if(b>a){

					c=Math.sqrt(Math.pow(a,2)+Math.pow(b,2));

					if(c%1==0){

					System.out.printf("%.0f  %.0f  %.0f\n",a,b,c);

					}
					
				}
				
			}			

		}

	}

}