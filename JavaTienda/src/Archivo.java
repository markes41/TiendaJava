import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import javax.swing.JOptionPane;

public class Archivo{
	
	private boolean existe = false;
	String texto = null;
	BufferedReader br = null;
	BufferedWriter bw = null;
	
	public void leerFichero(String data1, String data2) {
		try {
			FileReader usuario = new FileReader("usuarios.txt");
			br = new BufferedReader(usuario);
			String texto = br.readLine();
			
			while(texto != null) {
				String [] word = texto.split(" ");
				if(word[2].equals(data1) && word[3].equals(data2)) {
					existe = true;
					setExiste(existe);
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
				if(bw != null)
					bw.close();
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

			fichero = new FileWriter("usuarios.txt", true);
			bw = new BufferedWriter(fichero);
			fichero.write("\n");
			
			for (String linea : lineas) {
				fichero.write(linea + " ");
			}
			fichero.close();

		} catch (Exception ex) {
			System.out.println("Mensaje de la excepcion: " + ex.getMessage());
		}
}


	
	public boolean isExiste() {
		return existe;
	}


	public void setExiste(boolean existe) {
		this.existe = existe;
	}
	
	
}




