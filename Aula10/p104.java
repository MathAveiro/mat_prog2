import java.util.Scanner;
import p2utils.*;
public class p104 {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		Stack<Double> stack = new Stack<Double>();
		for(int i = 0; i < args[0].length(); i++) {
			if(Character.isDigit(args[0].charAt(i))) {
				String string = Character.toString(args[0].charAt(i));
				Double temp = Double.parseDouble(string);
				stack.push(temp);
				System.out.println(stack.toString());
			}
			if(args[0].charAt(i)=='+' || args[0].charAt(i)=='-' ||args[0].charAt(i)=='*' || args[0].charAt(i)=='/') {
				if(stack.size()<2) System.out.println("Error of syntax!");
				Double n1 = stack.top();
				stack.pop();
				Double n2 = stack.top();
				stack.pop();
				Double n3;
				if(args[0].charAt(i)=='+') n3 = n1 + n2;
				else if(args[0].charAt(i)=='-') n3 = n1 - n2;
				else if(args[0].charAt(i)=='*') n3 = n1 * n2;
				else n3 = n1 / n2;
				stack.push(n3);
				System.out.println(stack.toString());
			}
			
		}
	}
}