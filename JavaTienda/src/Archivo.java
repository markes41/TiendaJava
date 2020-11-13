import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Archivo{
	
	BufferedReader br = null;
	BufferedWriter bw = null;
	
	public void leerFichero(String data) {
		try {
			FileReader usuario = new FileReader("usuarios.txt");
			br = new BufferedReader(usuario);
			String texto = br.readLine();
			
			while(texto != null) {
				if(data.equals(texto)) {
					System.out.println(data+" y "+texto+" son iguales.");
				}else {
					System.out.println("No se encontró lo que buscabas.");
				}
				texto = br.readLine();
			}
		}catch(Exception e) {
			 System.out.println("Error: Fichero no encontrado");
	         System.out.println(e.getMessage());
		} finally {
			try {
				if(br != null)
					br.close();
			}catch(Exception e) {
				System.out.println("Error al cerrar el fichero");
	            System.out.println(e.getMessage());
			}
		}
	}
	
	public void escribirFichero(String nombre, String apellido, String username, String password) {

		String[] lineas = {nombre, apellido, username, password};

		FileWriter fichero = null;
		try {

			fichero = new FileWriter("usuarios.txt");

			for (String linea : lineas) {
				fichero.write(linea + "\n");
			}
			fichero.close();

		} catch (Exception ex) {
			System.out.println("Mensaje de la excepción: " + ex.getMessage());
		}
}
}
