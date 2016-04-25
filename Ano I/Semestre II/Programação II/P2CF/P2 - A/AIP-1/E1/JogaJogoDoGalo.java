import static java.lang.System.*;
import java.util.Scanner;
import jogos.*;

public class JogaJogoDoGalo {
  public static void main(String[] args) {
    
    int vj1=0;
    int vj2=0;
    int numJogos=0;
    int lin=0;
    int col=0;
    
    jogar(lin, col, vj1, vj2, numJogos);
  }
  
  public static int jogar(int lin, int col, int vj1, int vj2, int numJogos)
  {
    JogoDoGalo jogo = new JogoDoGalo('X', 'O');
    
    jogo.mostraTabuleiro();
    
    while (!jogo.terminado()) {
      lin = linha();
      col = coluna();
      
      if(!jogo.posicaoVazia(lin,col))
      {
        do{
          lin=linha();
          col=coluna();
        }while(!jogo.posicaoVazia(lin,col));
      }
      
      jogo.jogada(lin, col);
      jogo.mostraTabuleiro();
    }
    
    out.println();
    
    
    numJogos++;
    
    if(numJogos==10)
      exit(0);
    
    if (jogo.ultimoJogadorGanhou())   ///(ALTERAÇAO)
    {
      out.println("Jogador "+jogo.ultimoJogador()+" ganhou!");
      if (jogo.ultimoJogador()=='X')
      {
        vj1++;
        out.println("Nº de vitórias do jogador 'X': "+vj1);
        
        if(vj1==3)
          exit(1);
        
        jogar(lin, col, vj1, vj2, numJogos);
        return vj1;
      }
      
      if (jogo.ultimoJogador()=='O')
      {
        vj2++;
        out.println("Nº de vitórias do jogador 'O': "+vj2);
        
        if(vj2==3)
          exit(2);
        
        jogar(lin, col, vj1, vj2, numJogos);
        return vj2;
      }
    }
    
    else
    {
      out.println("Jogo empatado!");
      jogar(lin, col, vj1, vj2, numJogos);
    }
    
    return numJogos;
  }
  
  public static int linha()
  {
    Scanner sin = new Scanner(System.in);
    /*char jogador1 = 'X';
    char jogador2 = 'O';*/
    int lin;
    //JogoDoGalo jogo = new JogoDoGalo(jogador1, jogador2);
    
    //while (true/*!jogo.terminado()*/) {
      
      do
      {
        out.print("(lin): ");
        lin = sin.nextInt();
      }while(lin<=0 || lin >=4);
        
        return lin;
    //}
    //return 0;
  }   
  
  public static int coluna()
  {
    Scanner sin = new Scanner(System.in);
  //  char jogador1 = 'X';
  //  char jogador2 = 'O';
    int col;
    
   // JogoDoGalo jogo = new JogoDoGalo(jogador1, jogador2);
    
    //while (true /*!jogo.terminado()*/) {
     
      do{
        out.print("(col): ");
        col = sin.nextInt();
      }while(col<=0 || col >=4);
      
      return col;
    //}
    //return 0;
  }
}