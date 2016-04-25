package game;

import static java.lang.System.*;

/*
 * A representação interna do módulo está descrita na declaração dos respectivos
 * atributos no fim da classe.
 */

public class BullsAndCowsGame
{
   /*
    * alfabeto válido?
    */
   public static boolean validAlphabet(String alphabet)
   {
      return alphabet != null && alphabet.length() > 0;
   }

   /*
    * novo jogo com um alfabeto e o número de símbolos a descobrir
    */
   public BullsAndCowsGame(String alphabet, int gameNumSimbols, String playerName)
   {
      assert validAlphabet(alphabet);
      assert gameNumSimbols > 0;
      assert playerName != null && playerName.length() > 0;

      this.alphabet = alphabet;
      this.playerName = playerName;
      randomSecret(gameNumSimbols);
      this.numAttempts = 0;
      this.guess = null;
   }

   /*
    * texto da tentativa válido?
    *
    * (Uma tentativa é válida se tiver o número de caracteres correcto (igual ao do segredo)
    * e se só contiver símbolos do alfabeto definido.)
    */
   public boolean validGuess(String guess)
   {
      boolean result = guess != null && guess.length() == secret.length();

      for(int i = 0; result && i < guess.length(); i++)
         result = alphabet.indexOf(guess.charAt(i)) >= 0;
      return result;
   }

   /*
    * nova jogada
    */
   public void play(String guess)
   {
      this.guess = guess;
      numAttempts++;
      determinePlayOutcome();
      show();
   }

   /*
    * jogo terminado?
    */
   public boolean finished()
   {
      return guess != null && guess.equals(secret);
   }

   /*
    * nome do jogador
    */
   public String playerName()
   {
      return playerName;
   }

   /*
    * número de tentativas até ao momento
    */
   public int numAttempts()
   {
      return numAttempts;
   }

   /*
    * escreve última jogada
    */
   public void show()
   {
      out.printf("\nAttempt %02d: %s - %d in-place, %d out-of-place\n", numAttempts, guess, symbolsInPlace, symbolsOutOfPlace);
   }

   /*
    * calcula o resultado da última jogada
    */
   private void determinePlayOutcome()
   {
      boolean[] used = new boolean[secret.length()]; // inicializa a false

      // symbols in place:
      symbolsInPlace = 0;
      for(int i = 0; i < guess.length(); i++)
         if (guess.charAt(i) == secret.charAt(i))
         {
            symbolsInPlace++;
            used[i] = true;
         }

      // symbols out of place:
      symbolsOutOfPlace = 0;
      for(int i = 0; i < guess.length(); i++)
         if (secret.charAt(i) != guess.charAt(i))
         {
            boolean found = false;
            for(int j = 0; !found && j < secret.length(); j++)
               if (!used[j] && secret.charAt(j) == guess.charAt(i))
               {
                  used[j] = true;
                  symbolsOutOfPlace++;
                  found = true;
               }
         }
   }

   /*
    * escolhe um segredo aleatório utilizando símbolos do alfabeto
    */
   private void randomSecret(int gameNumSimbols)
   {
      secret = "";
      for(int i = 0; i < gameNumSimbols; i++)
         secret += alphabet.charAt((int)(Math.random()*alphabet.length())); // simbolo aleatório (repetições permitidas)
   }

   private final String alphabet;     // conjunto de símbolos possíveis
   private static String playerName;  // nome do jogador
   public String secret;              // combinação secreta a descobrir 
   private String guess;              // última tentativa
   private int numAttempts;           // número de tentativas até ao momento
   private int symbolsInPlace = 0;    // número de símbolos certos no sítio certo da última tentativa
   private int symbolsOutOfPlace = 0; // número de símbolos certos no sítio errado da última tentativa
}

