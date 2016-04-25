import static java.lang.System.*;
import java.util.Scanner;
import jogos.*;
    
public class JogaJogoDoGalo {
  public static void main(String[] args) {
    Scanner sin = new Scanner(in);
    char jogador1 = 'X';
    char jogador2 = 'O';
    
    int nrjogos=0, vitoriasJogador1=0 , vitoriasJogador2 =0, empates =0;
    
    int lin, col;
    
    // questao e1, alinea d)
    while(nrjogos!=10 || vitoriasJogador1!=3 || vitoriasJogador2!=3){
		
		JogoDoGalo jogo = new JogoDoGalo(jogador1, jogador2);
		out.printf("Jogo #%d\n", nrjogos+1);
		jogo.mostraTabuleiro();
		
		while(!jogo.terminado()){
			out.print("(lin col): ");
			lin = sin.nextInt();
			col = sin.nextInt();
			
			// se a posicao nao for valida (ou nao vazia), o programa  mostra o erro ...
			//  ... o continue faz com o programa volte ao inicio do ciclo, neste caso, o while(!jogo.terminado()) ...
			//  ... e temos de inserir de novo as cordenadas
			if(!jogo.coordValidas(lin, col)){   /// outra maneira de escrever o if --> if(jogo.coordValidas(lin, col)== false)
				err.println("ERRO: jogada invalida!");
				continue;
			}
			
			// se a posicao estiver ocupada (ou nao vazia), o programa  mostra o erro ...
			//  ... o continue faz com o programa volte ao inicio do ciclo, neste caso, o while(!jogo.terminado()) ...
			//  ... e temos de inserir de novo as cordenadas
			if(!jogo.posicaoVazia(lin, col)){  /// outra maneira de escrever o if --> if(jogo.posicaoVazia(lin, col) == false)
				err.println("ERRO: jogada invalida!");
				continue;
			}
			
			jogo.jogada(lin, col);
			jogo.mostraTabuleiro();
		}
		out.println();
		// alinea b) O erro semantico estava neste if, basta retirar o !
		if (jogo.ultimoJogadorGanhou()){
			out.println("Jogador "+jogo.ultimoJogador()+" ganhou!");
		
			if(jogo.ultimoJogador()== 'X')
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
