import static java.lang.System.*;

public class GuessGame41
{

   private static int  min, max, secretNumber, count=0, numIntroduzido;

  public GuessGame41 () {

      this.min = 0;

      this.max = 20;

      do {

         this.secretNumber = (int)(Math.random()*(100));

      } while (this.secretNumber < this.min || this.secretNumber > this.max);

   }

   public GuessGame41 (int min, int max) {

      this.min = min;

      this.max = max;

      do {

         this.secretNumber = (int)(Math.random()*(100));

      } while (this.secretNumber < this.min || this.secretNumber > this.max);

   }

   public int min () {

      return this.min;

   }

   public int max () {

      return this.max;

   }

   public boolean finished () {

      if (this.numIntroduzido == secretNumber) return true;

      else return false;


   }

   public int numAttempts () {

      return this.count;  

   }

   public boolean validAttempt (int a) {

      if (a < min || a > max) return false;
      
      else return true;

   }

   public void play (int a) {

      if (!finished() && validAttempt(a)) {

         this.count++;

         this.numIntroduzido = a; 

      }

   }

   public boolean attemptIsLower () {

      if (numIntroduzido < secretNumber) return true;


      else return false;

   }

   public boolean attemptIsHigher () {

      if (numIntroduzido > secretNumber) return true;

      else return false;

   }

      public static void main(String[] args) {
      out.println("Starting test.");
      GuessGame41 game = new GuessGame41(1,10);
      assert !game.finished();
      assert game.min() == 1;
      assert game.max() == 10;
      assert game.numAttempts() == 0;
      assert !game.validAttempt(0) && !game.validAttempt(11);
      int n = 5;
      if(n == game.secretNumber)
         n++;
      game.play(n);
      assert game.numAttempts() == 1;
      assert n < game.secretNumber == game.attemptIsLower() || n > game.secretNumber && game.attemptIsHigher();
      game.play(game.secretNumber);
      assert game.numAttempts() == 2;
      assert game.finished();
      out.println("No error detected!");
   
   }
}

