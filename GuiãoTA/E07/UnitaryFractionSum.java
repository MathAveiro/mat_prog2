import static java.lang.System.*;

public class UnitaryFractionSum
{
	public static void main(String[] args) {
		int num = Integer.parseInt(args[0]);
		int den = Integer.parseInt(args[1]);
		String frac = new String();
		out.print(num + "/" + den + " = ");
		out.println(unitaryFraction(num, den, frac));
	}
	public static String unitaryFraction(int num, int den, String frac) {
		int d, nnum, nden;
		if(den%num==0) {
			d = (den/num);
			nnum = (num*d) - den;
			nden = den*d;
			frac = frac + "1/" + d;
			return frac;
		}
		else {
			d = (den/num)+1;
			nnum = (num*d) - den;
			nden = den*d;
			frac = frac + "1/"+d;
			frac = frac + " + ";
			return unitaryFraction(nnum, nden, frac);
		}
	}
}

