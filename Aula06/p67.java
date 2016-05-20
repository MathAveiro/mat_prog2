import java.util.*;
import java.io.*;
import static java.lang.System.*;
public class p67 {
	public static void main(String[] args)throws IOException {
		String file, encontra;
		if(args.length==0) {
			file = "dir1";
			encontra = "f2.txt";
		}
		else {
			file = args[0];
			encontra = args[1];
		}
		printDir(file, encontra);
	}
	public static void printDir(String file, String encontra)throws IOException {
		File f = new File(file);
		File[] paths = f.listFiles();
		if (paths==null) {
			System.out.println("The directory is empty");
			exit(1);
		}
		for(int i=0; i < paths.length; i++) {
			String temp = paths[i].getPath();
			if (paths[i].isFile()) {
				if(!(paths[i].getPath().indexOf(encontra)==-1)) {
					out.println(paths[i].getPath());
				}
			}
		}
		for(int i=0; i < paths.length; i++) {
			if (paths[i].isDirectory() && paths[i].canRead()) {
				printDir(paths[i].getPath(), encontra);
			}
		}
	}
}