import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Archivo{
	FileWriter escribir;
	{

	try
	{
	
		File archivo = new File("articulos.txt");
		escribir = new FileWriter(archivo,true);
	
		
		
	}catch(Exception e){
		System.out.println("Error al escribir");
	}
}


	public void escribir(String text) throws IOException {
		escribir.write(text);
		escribir.close();
	}
}

