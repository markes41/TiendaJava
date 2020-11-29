package programa;
import java.util.Scanner;

import Menues.MenuLogueado;
import Menues.MenuOpciones;
import interfaz.VentanaLogin;
import leerEscribir.*;
import programa.*;
import leerEscribir.Parametros;
import leerEscribir.Archivo;

import interfaz.*;


public class Main {
	
	
	public static void main(String[] args) {
		
		String rutaUsuarios = "usuarios.dat";
		String rutaArticulos = "articulos.dat";

		Archivo archi = new Archivo();

		Scanner sc = new Scanner(System.in);
		Usuarios usuarios;
		AddArticulos articulos;

		if (archi.createFile(rutaUsuarios)) {
			usuarios = new Usuarios();
			archi.save(usuarios, rutaUsuarios);
		} else {
			usuarios = (Usuarios) archi.load(rutaUsuarios);
		}
		
		if (archi.createFile(rutaArticulos)) {
			articulos = new AddArticulos();
			archi.save(usuarios, rutaUsuarios);
		} else {
			articulos = (AddArticulos) archi.load(rutaArticulos);
		}

		MenuOpciones menuOpciones = new MenuOpciones();

		MenuLogueado menuLogueado = new MenuLogueado();


		boolean fin = false;

		while (!fin) {

			System.out.println("Que accion desea realizar?");
			System.out.println("1. Cargar usuarios");
			System.out.println("2. Ingresar al sistema");
			System.out.println("3. Mostrar usuarios");

			System.out.println("0. Salir");

			switch (sc.next()) {
			case "1":
				menuOpciones.cargarUsuario(usuarios,rutaUsuarios);
				break;
			case "2":
				Parametros.getInstance().setUsuarioLogueado( menuOpciones.ingresar(usuarios));
				
				while(Parametros.getInstance().getUsuarioLogueado() != null) {
					System.out.println("Ingrese una opcion");
					System.out.println("1. Comprar");
					System.out.println("2. Mostrar stock");
					System.out.println("3. Crear articulos");
					System.out.println("0. Log out");
					
					switch (sc.next()) {
						case "2":
							articulos.mostrarArticulos();
							break;
						case "3":
							menuOpciones.cargarArticulo(articulos, rutaArticulos);
							break;
							
					}
					
				}

				break;
			case "3":
				usuarios.mostrarUsuarios();
				break;

			case "0":
				fin = true;
				System.out.println("Gracias por utilizar el programa");
				break;
			default:

				System.out.println("Opcion incorrecta");
				break;
			}

		}

	}
	}

