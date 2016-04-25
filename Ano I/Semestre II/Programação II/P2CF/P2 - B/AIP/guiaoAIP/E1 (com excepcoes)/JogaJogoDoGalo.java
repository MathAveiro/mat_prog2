import static java.lang.System.*;
import java.util.Scanner;
import jogos.*;
import java.util.*;
    
public class JogaJogoDoGalo {
  public static void main(String[] args) {
    Scanner sin = new Scanner(in);
    char jogador1 = 'X';
    char jogador2 = 'O';
    
    int nrjogos=0, vitoriasJogador1=0 , vitoriasJogador2 =0, empates =0;
    
    // questao e1, alinea d)
    while(nrjogos!=10 || vitoriasJogador1!=3 || vitoriasJogador2!=3){
		
		JogoDoGalo jogo = new JogoDoGalo(jogador1, jogador2);
		out.printf("Jogo #%d\n", nrjogos+1);
		jogo.mostraTabuleiro();
		
		while(!jogo.terminado()){
			
			int lin=0, col=0;
			out.println("Escrever end para terminar");
			out.print("(lin col): ");
			
			//Introduzir um argumento por linha
			String linha = sin.next();
			sin.nextLine();
			String coluna = sin.next();
			sin.nextLine();
			
			if(linha.equals("end") || coluna.equals("end"))
				exit(99);
			
			/// a alinea c) diz que nao é necessario usar excepçoes mas é melhor usar, nem que seja para treinar
			
			try{	// tentar ...
				lin = Integer.parseInt(linha);  // ... converter 'uma string que contem apenas um numero' em apenas 'um numero'
			}catch(NumberFormatException e){
				err.println("Argumento introduzido para a linha não é um numero!");
				continue;
			}
			
			try{
				col = Integer.parseInt(coluna);
			}catch(NumberFormatException e){
				err.println("Argumento introduzido para a coluna não é um numero!");
				continue;
			}
			
			// se a posicao nao for valida (ou nao vazia), o programa  mostra o erro ...
			//  ... o continue faz com o programa volte ao inicio do ciclo, neste caso, o while(!jogo.terminado()) ...
			//  ... e temos de inserir de novo as cordenadas
			if(!jogo.coordValidas(lin, col)){   /// outra maneira de escrever o if --> if(jogo.coordValidas(lin, col)== false)
				err.println("ERRO: jogada invalida!");
				continue;
			}
			
			// se a posicao estiver ocupada (ou nao vazia) ...
			if(!jogo.posicaoVazia(lin, col)){  /// outra maneira de escrever o if --> if(jogo.posicaoVazia(lin, col) == false)
				err.println("ERRO: jogada invalida!");
				continue;
			}
			
			// os dois if's acima resolvem a alinea c)
			
			jogo.jogada(lin, col);
			jogo.mostraTabuleiro();
		}
		out.println();
		// alinea b) O erro semantico estava neste if, basta retirar o !
		if (jogo.ultimoJogadorGanhou()){
			out.println("Jogador "+jogo.ultimoJogador()+" ganhou!");
		
			if(jogo.ultimoJogador() == 'X')
				vitoriasJogador1++;
			else if(jogo.ultimoJogador() == 'O')
				vitoriasJogador2++;
			else
				empates++;
		}
		else
			out.println("Jogo empatado!");
      
		out.println("Jogador | Vitórias | Derrotas | Empates");
		out.printf("   X    |     %d   |     %d   |     %d\n", vitoriasJogador1, vitoriasJogador2, empates);
		out.printf("   O    |     %d   |     %d   |     %d\n\n", vitoriasJogador2, vitoriasJogador1, empates);
		
		nrjogos++;
	}
  }// fim da main	
}
