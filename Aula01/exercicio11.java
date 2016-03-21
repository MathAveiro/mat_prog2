import java.util.*;
import java.io.*;
import static java.lang.System.*;
import static java.lang.Integer.*;

public class exercicio11 {

	static Scanner sc = new Scanner (System.in);

	public static void main(String[] args) {

		String[]campos;
        
		int resultado=0;

		out.printf("Introduza a operação matemática");
		String operacao = sc.nextLine();
		campos = operacao.split(" ");

		int op1 = parseInt(campos[0]);
        
		int op2 = parseInt(campos[2]);

		if(campos[1].compareTo("+")==0) resultado=op1+op2;

		if(campos[1].compareTo("-")==0) resultado=op1-op2;

		if(campos[1].compareTo("*")==0) resultado=op1*op2;

		if(campos[1].compareTo("/")==0) resultado=op1/op2;

		if(campos[1].compareTo("+")==0 || campos[1].compareTo("-")==0 || campos[1].compareTo("*")==0 || campos[1].compareTo("/")==0) out.printf("Resultado final %d",resultado);

		else out.println("Operação inválida");

	}

}