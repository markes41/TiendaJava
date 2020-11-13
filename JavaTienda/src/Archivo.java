import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import javax.swing.JOptionPane;

public class Archivo{
	
	boolean existe = false;
	String texto = null;
	BufferedReader br = null;
	BufferedWriter bw = null;
	
	public void leerFichero(String data1, String data2) {
		try {
			FileReader usuario = new FileReader("usuarios.txt");
			br = new BufferedReader(usuario);
			
			while((texto = br.readLine()) != null) {
				String [] word = texto.split(" ");
				if(word[0].equals(data1) && word[1].equals(data2)) {
					System.out.println("Usuario encontrado");
					existe = true;
				}else {
					JOptionPane.showMessageDialog(null, "No se encontró el usuario y/o contraseña.", "Credenciales erróneas", JOptionPane.WARNING_MESSAGE);
				}
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
				fichero.write(linea + " ");
			}
			fichero.close();

		} catch (Exception ex) {
			System.out.println("Mensaje de la excepción: " + ex.getMessage());
		}
}
}
