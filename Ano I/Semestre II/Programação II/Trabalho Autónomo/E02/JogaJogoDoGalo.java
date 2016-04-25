import jogos.JogoDoGalo;

import static java.lang.System.*;
import java.util.Scanner;
import jogos.*;
    
public class JogaJogoDoGalo {
  public static void main(String[] args) {
    Scanner sin = new Scanner(in);
    char jogador1 = 'X';
    char jogador2 = 'O';
    int campeonatos=0, jogador1p=0, jogador2p=0;
    for (campeonatos = 0 ;campeonatos < 10 ;campeonatos++) {
      if (campeonatos == 9 || jogador1p == 3 || jogador2p ==3) break; 
    JogoDoGalo jogo = new JogoDoGalo(jogador1, jogador2);
    int lin, col;
    jogo.mostraTabuleiro();
    while (!jogo.terminado()) {
      do {
        out.print("(lin col): ");
        lin = sin.nextInt();
        col = sin.nextInt();
      } while (!jogo.jogadaValida(lin, col));
      jogo.jogada(lin, col);
      jogo.mostraTabuleiro();
    }
    out.println();
    if (jogo.ultimoJogadorGanhou()) {
      out.println("Jogador "+jogo.ultimoJogador()+" ganhou!");      

      if (jogador1 == jogo.ultimoJogador()) jogador1p+=1;

      if (jogador2 == jogo.ultimoJogador()) jogador2p+=1;

    }

    else out.println("Jogo empatado!");

    campeonatos++;

    out.printf("Pontuação do jogador x: %d\nPontuação do jogador o: %d", jogador1p, jogador2p);
    }
  }
}
