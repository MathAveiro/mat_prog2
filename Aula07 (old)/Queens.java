import static java.lang.System.*;
import pt.ua.gboard.*;
import pt.ua.gboard.games.*;

/**
 * Esta classe implementa um tabuleiro de NxN onde se pode colocar
 * ou retirar até N rainhas.
 *
 * Neste tipo de tabuleiro não é possível colocar duas rainhas na mesma coluna
 * e só podemos colocar uma rainha se já houver rainhas em todas as colunas à
 * esquerda. (Ver pré-condições de putQueen.)
 * Também se pode retirar uma rainha, mas apenas se for a da última coluna.
 * (Ver pré-condições de removeQueen.)
 *
 * Qualquer solução do problema das N rainhas tem de satisfazer estas
 * restrições e, ao impô-las:
 *  - simplificamos a estrutura de dados e
 *  - reduzimos os espaço de procura, melhorando o desempenho.
 *
 * findSolution é o método que tenta colocar rainhas que não se ataquem
 * mutuamente (resolve o problema das N rainhas).
 *
 * A classe pode ser executada diretamente: tem um método main que invoca 
 * findSolution para resolver o problema das N rainhas.
 *
 * O tabuleiro tem uma representação gráfica usando o módulo gboard.
 * Para compilar e executar, recomenda-se:
 *   export CLASSPATH=.:/path/to/package/pt.ua.gboard.jar
 *   javac Queens
 *   java -ea Queens 8       # (para tabuleiro 8x8)
 *
 * Some of the comments are in English, others in Portuguese.
 * Sorry for the inconvenience.
 *
 * Try the exercises at the bottom.
 *
 * @author JMR@ua.pt 2015
 */

public class Queens
{
	// Representação interna do tabuleiro:
	// tab[3] = 2 significa que há uma rainha na linha 2, coluna 3, i.e. (2,3)
	private int[] tab;

	// Dimensão do tabuleiro:
	public final int size;	// (This may be public because it cannot be modified.)

	// número de rainhas já colocadas (em posiçoes válidas):
	private int queens;	// it is also the number of occupied columns (from the left side)
	
	// Representação gráfica do tabuleiro:
	private ChessBoard cboard;
	private int delay;	// time (ms) to wait after each movement.

	public Queens(int N) {
		assert N > 0;
		size = N;
		tab = new int[size];
		queens = 0;	// board starts empty
		cboard = new ChessBoard( size );
		delay = 100;	// change to make it faster or slower...
	}

	// is position (l,c) inside the board?
	public boolean inside(int l, int c) {
		return 0<=l && l<size && 0<=c && c<size;
	}

	// is there a queen in (l,c)?
	public boolean queenIn(int l, int c) {
		return inside(l,c) && tab[c] == l;
	}

	// is (l,c) under attack by any queen in previous columns?
	private boolean underAttack(int l, int c) {
		assert inside(l,c)	: String.format("(%d,%d) should be inside board!", l, c);

		for (int k = 0; k < c; k++) {
			if (queenIn(l,k) || l-tab[k]==c-k || l-tab[k]==k-c) return true;
		}
		return false;
	}

	// put a queen in (l,c).
	public void putQueen(int l, int c) {
		assert inside(l,c)	: String.format("(%d,%d) should be inside board!", l, c);
		assert c == queens	: String.format("There should be %d queens, but only %d found", c, queens);
		assert !underAttack(l,c)	: String.format("Position (%d,%d) should not be under attack!", l, c);

		tab[c] = l;	// queen in column c is in line l!
		queens++;	// one more queen!
		cboard.put( ChessPieceType.WHITE_QUEEN, l , c );
		GBoard.sleep(delay);	// slow things down
	}

	// remove a queen from (l,c).
	public void removeQueen(int l, int c) {
		assert queenIn(l,c)	: String.format("There should be a queen in (%d,%d)!", l, c);
		assert c == queens-1	: String.format("Can only remove queen from last column (%d,%d)", l, c);

		tab[c] = -1;	// not required, but mark it as unused
		queens--;	// one less queen!
		cboard.remove(l, c);
		GBoard.sleep(delay);	// slow things down
	}

	/**
	 * Tenta colocar rainhas a partir da coluna c,
	 * sabendo que tabuleiro já tem primeiras c colunas preenchidas.
	 * 
	 * Implementa o algoritmo que resolve o problema.
	 *
	 * @return true se achou solução, false se não.
	 * Deixa o tabuleiro com a solução encontrada, ou vazio.
	 */
	public boolean findSolution(int c) {
		assert 0<=c && c < size;
		assert c == queens;

		boolean solved = false;	// have we found a solution yet?
		for (int l = 0; l < size; l++) {
			if ( !underAttack(l, c) ) {
				putQueen(l, c);
				if (c == size-1) {	// if that was the last queen, it's solved!
					solved = true;
				} else {		// otherwise, try to put remaining queens...
					solved = findSolution(c+1);
				}
				if (solved) break;	// if solved, stop.
				removeQueen(l, c);
			}
		}
		return solved;
	}

	// print the current positions
	public void print() {
		for (int c = 0; c < queens; c++) {
			System.out.printf("(%d,%d) ", tab[c], c);
		}
		out.printf("\n");
	}

	public static void main ( String[] args )
	{
		if (args.length != 1) {
			err.println("Usage: java -ea Queens N\n  Solves the N-queen problem.\n");
			exit(1);
		}
		int N = Integer.parseInt(args[0]);

		Queens board = new Queens(N);
		if ( board.findSolution(0) )
			board.print();
		else
			out.println("No solution!");
	}

	// Exercises:

	// - Add a method to change the speed of display.
	//   Call it in main if a second argument is given to the program.

	// - Create a new 8x8 board and find out if there is a solution
	//   that includes the queens (5,0) and (2,1).
	//   Hint: call putQueen twice before calling findSolution.

	// - How many put and remove operations are necessary to find a solution?
	//   To find out, add a couple of attributes to the class,
	//   and increment them in the proper places.
	//   Getter methods and a resetCounters method will be useful, too.

	// - Does findSolution really need parameter c,
	//   or is it redundant, given the attributes of the class?
	//   Can you rewrite it with no parameters?

	// - Are there other functions with redundant parameters?

	// - Modify findSolution so that it finds (and prints) all solutions,
	//   pausing a bit on each one.
	//   How many put/remove operations are needed to find all solutions
	//   for N queens?
	//   How does that number grow with N?

	// - More difficult: Transform findSolution into a method that you
	//   can call repeatedly to find all solutions.
	//   Change main to call it like this:
	//	Queens board = new Queens(N);
	//	while (board.nextSolution()) {
	//		board.print();
	//	}
	//	out.println("No (more) solution(s)!");

	// - Have fun!

}
