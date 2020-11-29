package programa;
import java.util.Scanner;

import leerEscribir.Parametros;
import menues.MenuLogueado;
import menues.MenuOpciones;
import leerEscribir.Archivo;


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
					System.out.println("4. Editar articulo");
					System.out.println("0. Log out");
					
					switch (sc.nextInt()) {
						case 1:
							if(articulos.comprarArticulo()) {
								archi.save(articulos, rutaArticulos);
							}
							break;
						
						case 2:
							articulos.mostrarArticulos();
							break;
						case 3:
							menuOpciones.cargarArticulo(articulos, rutaArticulos);
							break;
							
						case 4:
							if(articulos.modificarArticulo()) {
								System.out.println("El articulo se edit� correctamente.");
								archi.save(articulos, rutaArticulos);
							}else {
								System.out.println("No fue posible editar el art�culo.");
							}
							
							break;
							
						case 0:
							Parametros.getInstance().setUsuarioLogueado(null);
							break;
							
						default:
							System.out.println("Opci�n no v�lida.");
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

