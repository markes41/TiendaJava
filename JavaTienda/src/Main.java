import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.io.BufferedWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		File articles = new File("articulos.txt");
			if(!articles.exists()) {
				articles.createNewFile();
			}
		
			FileWriter write = new FileWriter(articles);
			BufferedWriter bw = new BufferedWriter(write);
			
			System.out.println("Escribi un texto: ");
			bw.write(sc.next());
			bw.close();
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
		sc.close();
	}

}
