import java.util.*;

public class temp {
	
	static Scanner sc = new Scanner (System.in);

	public static void main (String[] args) {
	
	}
	
	public static tempmaxmin temperatura(){
		
		tempmaxmin p = new tempmaxmin();
		
		do {
		
			System.out.println("Introduza a temperatura mínima: ");
			p.min = sc.nextDouble();
			
			System.out.println("Introduza a temperatura máxima: ");
			p.max = sc.nextDouble();
		
		} while (p.max < p.min);
		
		return p;
		
	}
	
}

class tempmaxmin {

	double min, max;
	
}
