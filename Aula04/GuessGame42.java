import static java.lang.System.*;

public class GuessGame42
{

   private static int  min, max, secretNumber, count=0, numIntroduzido;

  public GuessGame42 () {

      this.min = 0;

      this.max = 20;

      do {

         this.secretNumber = (int)(Math.random()*(100));

         out.println(secretNumber);

      } while (this.secretNumber < this.min || this.secretNumber > this.max);

   }

   public GuessGame42 (int min, int max) {

      this.min = min;

      this.max = max;

      do {

         this.secretNumber = (int)(Math.random()*(100));

         out.println(secretNumber);

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

      return this.count+=1;  

   }

   public boolean validAttempt (int a) {

      if (a < min || a > max) return false;
      
      else return true;

   }

   public void play (int a) {

      if (!finished() && validAttempt(a)) {

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

}

