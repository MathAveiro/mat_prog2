import static java.lang.System.*;

	public class GuessGame51 {

	private static int  min, max, secretNumber, count=0, numIntroduzido;

	public GuessGame51 () {

		this.min = 0;

		this.max = 20;

		do {

			this.secretNumber = (int)(Math.random()*(100));

		} while (this.secretNumber < this.min || this.secretNumber > this.max);

	}

	public GuessGame51 (int min, int max) {

		assert min > 0: "Número inválido.";
		assert max > 0: "Número inválido.";

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

		assert a > 0: "Número inválido.";

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

}