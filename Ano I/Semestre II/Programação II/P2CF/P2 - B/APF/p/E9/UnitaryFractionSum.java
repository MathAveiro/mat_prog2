import static java.lang.System.*;

public class UnitaryFractionSum
{	
	public static void main(String [] args){
	
		if(args.length!=2){
			System.err.println("Uso: java -ea UnitaryFractionSum <Numerador> <Denominador> ");
			System.exit(1);
		}
	
		double num=0, den=0;	
		
		try{                                // tenta converter o argumento para um valor real
			num=Double.parseDouble(args[0]);
		}catch(NumberFormatException localNumberFormatException){       // e caso nao seja um valor inteiro...
			System.err.println("Erro: O argumento introduzido "+ args[0] + " não é um numero inteiro."); // aparece a mensagem de erro
			System.exit(1);
		}
	
		try{
			den=Double.parseDouble(args[1]);   // igual á de cima
		}catch(NumberFormatException localNumberFormatException){
			System.err.println("Erro: O argumento introduzido "+ args[1] + " não é um numero inteiro.");
			System.exit(2);
		}
	
		if(num<=0 || den<=0){   // o valor da fraçao tem de ser positivo, ou seja, maior que 0, caso um dos valores seja negativo, aparece mensagem de erro e o programa termina
			System.err.println("O numero resultante dos dois argumentos (" + num + "/"+ den + ") não é um numero positivo.");
			System.exit(3);
		}
	
		if((num/den)>=1){      // o valor da fraçao nao pode ser maior ou igual a 1
			System.err.println("O numero resultante dos dois argumentos (" + num + "/"+ den + ") é maior que 1.");
			System.exit(4);
		}
	
		out.print((int)num + "/" + (int)den + " = ");     // print apenas para os valores que introduzirmos
	
		for(int i=1; i<=num; i++){           // este for serve para, no caso, de introduzirmos uma fraçao como 6/8, reduzi-la a 3/4, ou sei lá, 420/980, reduzir para 3/7
			 if(num%i==0 && den%i==0){ 
				num=(int)num/i;
				den=(int)den/i;
			}
		}
	 
		// os valores que passo como argumento para a funçao, sao já os valores da fraçao irredutivel
		a("",num, den);
		// chamo a funçao com uma String vazia
	
	}
  
	public static void a(String s, double a, double b){
		// nos argumentos estou a colocar uma String para na funçao recursiva, conseguir colocar um sinal de mais para somar os outros numeros fraccionarios
		
		
		int num =0, den=0, d=0;  // variaveis auxiliares, sendo d, o valor que se fala no enunciado
     
		if(b%a==0)                          // se o resto da divisao do denominador pelo numerador for 0, significa que a funçao é redutivel, por exemplo, a fraçao 2/4 = 1/2, ou seja, 2/4 é redutivel
			out.println(s + "1/" + (int)(b/a)); // se a condiçao do if acontecer, só imprimo a fraçao reduzida (que garantidamente pela condiçao do if já é uma fraçao unitaria) e o programa termina logo
                                         // ou seja, esta é a condiçao de paragem da funçao recursiva que pedem no enunciado
     
		else{                                // so ha duas opçoes, ou acontece o que esta dentro do if, ou o que esta dentro do else.
											// se a fraçao nao for unitaria (como por exemplo 3/7, 3/4, 2/3, etc, etc)...
			for(int i=1; i<=a; i++){
				if(a%i==0 && b%i==0){		 // verifica se o i didide o valor a e o valor b em simultaneo, e que como a funçao ja esta irredutivel, isto vai ser sempre verdade
					d=(int)(b/a) + 1;               // valor pedido no enunciado, que no fundo é o valor inteiro da "divisao do denominador pelo numerador" + 1
					
					num=(int)a*d - (int)b;         // estes dois valores, num e den, sao a subtraçao do 1/d á fraçao que demos como argumento ao programa, ou seja do args[0] e do args[1]
					den=(int)b*d;                  // e sao os novos argumentos para a funçao recursiva
		 
					out.print(s + "1/" + d);       // quando este print é chamado pela segunda vez, ou seja, na funçao recursiva, a String s já é o sinal de " + "
		 
					a(" + ", num, den);             // funçao recursiva com o sinal de mais para adicionar ao print da main 
				} // acaba o if 
			} // acaba o for
		} // fim do else
	}// fim da funçao
		
}//FIM
