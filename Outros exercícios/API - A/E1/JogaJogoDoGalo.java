import static java.lang.System.*;
import java.util.Scanner;
import jogos.*;
    
public class JogaJogoDoGalo {
  public static void main(String[] args) {
    Scanner sin = new Scanner(in);
    char jogador1 = 'X';
    char jogador2 = 'O';
    int lin, col;
    int x=0, y=0, n=0;
    do {
      JogoDoGalo jogo = new JogoDoGalo(jogador1, jogador2);
      jogo.mostraTabuleiro();
      while (!jogo.terminado()) {
        do {
          do {
            out.print("(lin col): ");
            lin = sin.nextInt();
            col = sin.nextInt();
          } while (!jogo.coordValidas(lin, col));
        } while (!jogo.posicaoVazia(lin, col));
        assert lin <= 3 && lin >=1: "Linha inválida!";
        assert col <= 3 && col >=1: "Coluna inválida!";
        assert jogo.posicaoVazia(lin, col): "Posição ocupada!";
        jogo.jogada(lin, col);
        jogo.mostraTabuleiro();
      }
      out.println();
      if (jogo.ultimoJogadorGanhou()) {
        out.println("Jogador "+jogo.ultimoJogador()+" ganhou!");
        if(jogo.ultimoJogador()=='X') x++;
        else y++;
      }
      else
        out.println("Jogo empatado!");
      out.println("Pontuação do jogador X: "+x);
      out.println("Pontuação do jogador 0: "+y);
      n++;
      out.println("Nº de jogos feitos: "+n);
    } while(x<3 || y<3 || n<10);
  } 
}
