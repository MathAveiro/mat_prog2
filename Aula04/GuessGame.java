import java.util.*;
import static java.lang.System.*;

public class GuessGame
{
   static int min, max;
   private int n;
   int secretNumber;
   static private int t=0;
   public GuessGame () {
      this.min=0;
      this.max=20;
      int range = (this.max - this.min) + 1;     
      this.secretNumber = (int)(Math.random() * range) + this.min;
   }
   public GuessGame (int min, int max) {
      if (min<max) {
         this.min=min;
         this.max=max;
         int range = (max - min) + 1;     
         this.secretNumber = (int)(Math.random() * range) + min;
      }
      else {
         out.println("O intervalo não pode ser vazio!"); 
         exit(1);
      }
   }
   public int min() {
      return min;
   }
   public int max() {
      return max;
   }
   public boolean validAttempt(int n) {
      if(n>=min && n<=max) return true;
      else return false;
   }
   public boolean finished() {
      if(n==secretNumber) return true;
      else return false;
   }
   public void play(int n) {
      if (validAttempt(n) && !finished())    this.n=n; t++;
   }
   public boolean attemptIsLower() {
      if(n>=secretNumber) return false;
      else return true;
   }
   public boolean attemptIsHigher() {
      if(n<=secretNumber) return false;
      else return true;
   }
   public int numAttempts() {
      return t;
   }
   public static void main(String[] args)
   {
      out.println("Starting test.");
      GuessGame game = new GuessGame(1,10);
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

