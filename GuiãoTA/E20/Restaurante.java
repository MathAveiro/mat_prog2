import static java.lang.System.*;
import java.util.Scanner;
import java.io.*;
import p2utils.*;
public class Restaurante
{
   public static void main(String[] args) throws IOException {
	   	HashTable <Integer> storage = new HashTable<>(1000);
	   	Queue<HashTable<Integer>> pedidos = new Queue<HashTable<Integer>>();
		for (int i = 0; i < args.length; i++) {
			File f = new File(args[i]);
			readData(f, storage, pedidos);
		}
		out.println("Comida em stock: ");
		String [] ingr = storage.keys();
		for (int i = 0; i < ingr.length; i++) {
			int quant = storage.get(ingr[i]);
			out.printf("  %s: %d\n", ingr[i], quant);
		}
   }
   public static void readData(File f, HashTable<Integer> storage, Queue<HashTable<Integer>> pedidos) throws IOException {
		Scanner scf = new Scanner(f);
		while(scf.hasNextLine()){
			String line = scf.nextLine();
			String [] partsLine = line.split(" +");
			switch(partsLine[0]) {
				case "entrada:":
				int quant = 0;
				for (int i = 1; i < partsLine.length; i++) {
					String food = partsLine[i];
					if (storage.contains(food)) quant = storage.get(food);
					storage.set(food, quant+1);	
				}
				break;
				case "saida:":
				HashTable <Integer> pedido = new HashTable<Integer>(partsLine.length);
				for (int j = 1; j < partsLine.length; j++) {
					String [] keyPartsLine = partsLine[j].split(":", 2);
					pedido.set(keyPartsLine[0], Integer.parseInt(keyPartsLine[1]));
				}
				pedidos.in(pedido);
				break;
				default:
				err.printf("%s: formato inválido\n", f);
				exit(1);
			}
			processarPedidos(storage, pedidos);				
		}
		scf.close();
   }
   public static void processarPedidos(HashTable<Integer> storage, Queue<HashTable<Integer>> pedidos){
   		HashTable<Integer> pedido;
   		while(!pedidos.isEmpty()){
   			pedido = pedidos.peek();
   			if(gotEnough(storage, pedido)) {
   				pedidos.out();
   				out.printf("Refeição servida: ");
   				String [] ingr = pedido.keys();
   				for (int i = 0; i < ingr.length;i++ ) {
   					int quant = storage.get(ingr[i]);
   					int quantPedida = pedido.get(ingr[i]);
   					storage.set(ingr[i], quant-quantPedida);
   					out.printf("  %s: %d", ingr[i], quantPedida);
   				}
   				out.println();
   			}
   		}
   }
   public static boolean gotEnough(HashTable<Integer> storage, HashTable<Integer> pedido){
   		String [] ingr = pedido.keys();
		for (int i = 0; i < ingr.length;i++ ) {
			int quant = storage.get(ingr[i]);
			int quantPedida = pedido.get(ingr[i]);
			if (quantPedida>quant) return false;
		}
		return true;
   }
}
