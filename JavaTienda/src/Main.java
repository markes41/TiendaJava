import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.io.BufferedWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		FileWriter write = null;
		BufferedWriter bw = null;
		
		
		Window ventana = new Window();
		ventana.setVisible(true); //VENTANA VISIBLE
		

		 File articles = new File("articulos.txt");
			if(!articles.exists()) {
				articles.createNewFile();
			}
			
			//Seteamos estos 2 parámetros, no se sobreescriba en lo que ya está en el .txt
			write = new FileWriter(articles.getAbsoluteFile(), true); 
			bw = new BufferedWriter(write);
			
			
			bw.write(ventana.getTexto());
			
			
			if(bw != null)
				bw.close();
			if(write != null)
				bw.close();
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
		sc.close();
	}

}
