import java.io.*;
import java.util.Scanner;

public class Archivo{
	
	private boolean existe = false;
	private boolean emptyEmployee = false;
	private String username;
	String texto = null;
	BufferedReader br = null;
	BufferedWriter bw = null;
	BufferedReader bra = null;
	BufferedWriter bwa = null;
	
	// USUARIO
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
	
	//ARCHIVO
	public void leerFicheroArchivo() {
		File fichero = new File("Articulos.txt");
		Scanner s = null;

		try {
			System.out.println("Leer el fichero");
			s = new Scanner(fichero);

			while(s.hasNextLine()){
				String linea = s.nextLine();
				System.out.println(linea);
			}
		} catch (Exception ex){
			System.out.println("Mensaje:" + ex.getMessage());
		}
		finally {
			try {
				if (s != null)
						s.close();
			} catch (Exception ex2){
				System.out.println("mensaje 2:" + ex2.getMessage());
			}
		}
	}

	//USUARIO
	public void escribirFichero(String nombre, String apellido, String username, String password) {

		String[] lineas = {nombre, apellido, username, password};

		FileWriter fichero = null;
		try {

			fichero = new FileWriter("usuarios.txt", true);
			bw = new BufferedWriter(fichero);					
			
			if(nombre.equals("") || apellido.equals("") || username.equals("") || password.equals("")) {
				fichero.close();
			}else {
				for (String linea : lineas) {
					fichero.write(linea + " ");
				}
				fichero.write("\n");
			}
			fichero.close();

		} catch (Exception ex) {
			System.out.println("Mensaje de la excepcion: " + ex.getMessage());
		}
}
	
	//ARCHIVO
	public void escribirFicheroA(String codigo, String nombre, String descripcion, String precio) {

		String[] lineas = {codigo, nombre, descripcion, precio};

		FileWriter fichero = null;
		try {

			fichero = new FileWriter("articulos.txt", true);
			bwa = new BufferedWriter(fichero);

				
				if(codigo.equals("") || nombre.equals("") || descripcion.equals("") || precio.equals("")) {
					fichero.close();
				}else {
					for (String linea : lineas) {
						fichero.write(linea + " ");	
					}
					fichero.write("\n");
				}
				
				fichero.close();

		} catch (Exception ex) {
			System.out.println("Mensaje de la excepcion: " + ex.getMessage());
		}
}
	
	//Empleado

	public void buscarEmpleado(String data1) {
		try {
			FileReader empleado = new FileReader("empleados.txt");
			br = new BufferedReader(empleado);
			String texto = br.readLine();
			
			while(texto != null) {
				String [] word = texto.split(" ");
				if(word[0].equals(data1)) {
					emptyEmployee = true;
					setEmptyEmployee(emptyEmployee);
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
	
	
	public boolean isExiste() {
		return existe;
	}
	
	
	public void setExiste(boolean existe) {
		this.existe = existe;
	}
	
	public boolean isEmptyEmployee() {
		return emptyEmployee;
	}

	public void setEmptyEmployee(boolean emptyEmployee) {
		this.emptyEmployee = emptyEmployee;
	}

	
	public String getUsername() {
		return username;
	}

	
	public void setUsername(String username) {
		this.username = username;
	}
	
	
}




