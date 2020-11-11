import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.io.BufferedWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		/*
		Window ventana = new Window();
		ventana.setVisible(true); //VENTANA VISIBLE
		*/

		 File articles = new File("articulos.txt");
			if(!articles.exists()) {
				articles.createNewFile();
			}
		
			FileWriter write = new FileWriter(articles);
			BufferedWriter bw = new BufferedWriter(write);
			
			

			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
		sc.close();
	}

}
