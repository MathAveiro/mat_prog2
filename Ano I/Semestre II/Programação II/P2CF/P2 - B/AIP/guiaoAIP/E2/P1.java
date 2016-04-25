import static java.lang.System.*;
import java.util.Scanner;
import java.util.*;
import game.*;

public class P1{
	private static final Scanner input = new Scanner(in);

	public static void main(String[] args){
		
		if(args.length ==1){
			err.println("Uso: java -ea P1 [<NUM_LINES> <NUM_COLUMNS> player1 ...]");
			exit(1);
		}
		
		int numLines = 3;
		int numColumns = 3;
		
		String [] players;
		if(args.length == 2 || args.length ==0)
			players = new String [1];
		else players = new String [args.length-2];
		 //ou
		///String [] players = new String[args.length==2 || args.length ==0 ? 1 : args.length-2];
		
		if (args.length > 2){
			try{
				numLines = Integer.parseInt(args[0]);
				numColumns = Integer.parseInt(args[1]);
				
				if(numLines <=0 || numLines >=10 || numColumns <=0 || numColumns >=10){
					out.println("ERROR: invalid board dimensions!");
					exit(55);
				}
			}catch(NumberFormatException e){
				err.println("ERROR: invalid arguments!");
				exit(2);
			}
			
			for(int i=2; i<args.length; i++)
				players[i-2]= args[i];
		}
		else players[0] = "Smith";
			
		int [] sucessos = new int [players.length];
		boolean fim [] = new boolean [players.length];
		int [] nrRondas = new int [players.length];
		
		// criar jogos diferentes para diferentes jogadores
		Board [] jogos = new Board [players.length];
		for(int i = 0; i < jogos.length; i++){
			jogos[i] = new Board(players[i], numLines, numColumns);
		}
		
		int a = 0, rondas=1;
		
		// jogo propriamente dito
		while(a==0){
			
			boolean endgame=true;
			for(int finish=0; finish < players.length; finish++)
				if(!jogos[finish].finished()) endgame=false;
				
				if (endgame) break;
				
			//vai alternando entre jogadores
			for(int r = 0; r<players.length; r++){
				
				if(jogos[r].finished())
					continue;
					
				out.printf("\n\n-----------------  ROUND #%d -----------------\n\n", rondas);
				
				jogos[r].print();
				nrRondas[r]++;
				String word, pos2;
				do{
					do{
						a = 1;
						out.println();
						out.println("Commands:");
						out.println("   position1 position2 -> attempt to uncover a pair in two positions (ex: A1 A2)");
						out.println("   stop    -> stops game");
						out.println();
						out.print("Command: ");
         
						word = input.next();
         
						// erro semantico, basta retirar o !
						if (word.equals("stop")){
							err.println("Game stopped!");
							exit(2);
						}
			
						pos2 = input.next();
			
						// se a posicao for invalida
						if(!jogos[r].validPosition(word) || !jogos[r].validPosition(pos2))
							err.println("ERROR: invalid position");
						else if(jogos[r].uncovered(word) || jogos[r].uncovered(pos2))
							err.println("ERROR: invalid move");
						
					}while(!jogos[r].validPosition(word) || !jogos[r].validPosition(pos2) || jogos[r].uncovered(word) || jogos[r].uncovered(pos2));
				
					a=0;
					
					if(jogos[r].tryUncover(word, pos2)){
						
						out.println("Success!");
						sucessos[r]++;
						jogos[r].pairsFound(sucessos[r]);
            
						if (jogos[r].finished()){
							out.println();
							out.println("================ Player's "+players[r]+" game completed! ================");
							out.println();
						}
					}
					else out.println("Wrong!");
				}while(a!=0);
			}// fim do for
				rondas++;
		}// fim do while
		/////////////////////////////////////
		
		out.println("FINAL RESULTS:	");
		for(int i1=0 ; i1<players.length; i1++)
			out.printf("    Player %s: %d\n", players[i1], nrRondas[i1]);
		
		out.println();
		out.println("That's all folks!");
	}// fim da main	
}// fim do programa
