import java.util.*;
import java.io.*;
import static java.lang.System.*;
public class P2 {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args)throws IOException {
		File file = new File(args[0]);
		save(args[0]);

	}
	public static String[] save(String dir)throws IOException {
		File file = new File(dir);
		File[] arquivos = file.listFiles();
		int n=0, count=0;
		if(arquivos!=null) {
			int length=arquivos.length;
			for (int i=0; i<length; i++) {
				File f = arquivos[i];
				if(f.isFile()) count++;
				if(f.isDirectory()){
					n++;
					count++;
				}
			}
			out.println(dir+": "+count+" files");
		}
		String[] diretorios = new String[n];
		n=0;
		for(int i=0; i<diretorios.length; i++) {
			diretorios[i]=dir+"/";
		}
		if(arquivos!=null) {
			int length=arquivos.length;
			for (int i=0; i<length; i++) {
				File f = arquivos[i];
				if(f.isDirectory()){
					diretorios[n]=diretorios[n]+f.getName()+"/";
					print(diretorios[n]);
					save(diretorios[n]);
					n++;
				}
			}
		}
		return diretorios;
	}
	public static void print(String dir) {
		File file = new File(dir);
		File[] arquivos = file.listFiles();
		int count=0;
		if(arquivos!=null) {
			int length=arquivos.length;
			for (int i=0; i<length; i++) {
				File f = arquivos[i];
				if(f.isFile()) count++;
				if(f.isDirectory()){
					count++;
				}
			}
		}
	}
}

