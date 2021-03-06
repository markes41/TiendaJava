package programa;

import java.util.Scanner;
import leerEscribir.Status;
import menues.MenuLog;
import menues.MenuOp;
import usuariosArticulos.*;
import leerEscribir.Archivo;

public class Main {

	public static void main(String[] args) {

		String rutaUsuarios = "usuarios.dat";
		String rutaArticulos = "articulos.dat";

		Archivo archi = new Archivo();

		Scanner sc = new Scanner(System.in);
		AddUsuarios usuarios;
		AddArticulos articulos;

		if (archi.createFile(rutaUsuarios)) {
			usuarios = new AddUsuarios();
			archi.save(usuarios, rutaUsuarios);
		} else {
			usuarios = (AddUsuarios) archi.load(rutaUsuarios);
		}

		if (archi.createFile(rutaArticulos)) {
			articulos = new AddArticulos();
			archi.save(articulos, rutaArticulos);
		} else {
			articulos = (AddArticulos) archi.load(rutaArticulos);
		}

		MenuOp menuOpciones = new MenuOp();

		MenuLog menuLogueado = new MenuLog();

		boolean fin = false;

		while (!fin) {

			System.out.println("\nQue accion desea realizar?");
			System.out.println("1. Cargar usuarios");
			System.out.println("2. Mostrar usuarios");
			System.out.println("3. Ingresar al sistema");
			System.out.println("0. Salir");

			switch (sc.next()) {
			case "0":
				fin = true;
				System.out.println("\nGracias por utilizar el programa");
				break;

			case "1":
				menuOpciones.cargarUsuario(usuarios, rutaUsuarios);
				break;
			case "2":
				System.out.println("\nSus usuarios son:\n");
				usuarios.mostrarUsuarios();
				break;
			case "3":
				Status.getInstance().setUsuarioLogueado(menuOpciones.ingresar(usuarios));
				if (Status.getInstance().getUsuarioLogueado() != null) {
					System.out.println("\n1. Ingrese como Empleado");
					System.out.println("2. Ingrese como Cliente");
					System.out.println("0. Log out");
					switch (sc.next()) {

					case "1":
						while (Status.getInstance().getUsuarioLogueado() != null) {
							System.out.println("\nIngrese una opcion");
							System.out.println("1. Comprar");
							System.out.println("2. Mostrar stock");
							System.out.println("3. Crear articulos");
							System.out.println("4. Editar articulo");
							System.out.println("5. Editar cantidad articulo");
							System.out.println("6. Eliminar articulo");
							System.out.println("0. Log out\n");

							switch (sc.next()) {

							///////////////////////////////////////////////////////////////////////
							case "1":
								if (articulos.comprarArticulo()) {
									archi.save(articulos, rutaArticulos);
								}
								break;

							///////////////////////////////////////////////////////////////////////

							case "2":
								articulos.mostrarArticulos();
								break;

							//////////////////////////////////////////////////////////////////////

							case "3":
								menuOpciones.cargarArticulo(articulos, rutaArticulos);
								break;

							//////////////////////////////////////////////////////////////////////

							case "4":
								if (articulos.modificarArticulo()) {
									System.out.println("El articulo se edit� correctamente.");
									archi.save(articulos, rutaArticulos);
								} else {
									System.out.println("No fue posible editar el art�culo.");
								}

								break;

							///////////////////////////////////////////////////////////////////////

							case "5":
								articulos.editarCantidadArticulo();
								archi.save(articulos, rutaArticulos);
								break;

							//////////////////////////////////////////////////////////////////////

							case "6":
								articulos.eliminarArticulo();
								archi.save(articulos, rutaArticulos);
								break;

							case "0":
								Status.getInstance().setUsuarioLogueado(null);
								break;

							default:
								System.out.println("Opci�n no v�lida.");
								break;
							}

						}

						break;
					case "2":
						while (Status.getInstance().getUsuarioLogueado() != null) {
							System.out.println("Ingrese una opcion");
							System.out.println("1. Comprar");
							System.out.println("2. Mostrar stock");
							System.out.println("0. Log out");

							switch (sc.next()) {

							///////////////////////////////////////////////////////////////////////
							case "1":
								if (articulos.comprarArticulo()) {
									archi.save(articulos, rutaArticulos);
								}
								break;

							///////////////////////////////////////////////////////////////////////

							case "2":
								articulos.mostrarArticulos();
								break;

							///////////////////////////////////////////////////////////////////////

							case "0":
								Status.getInstance().setUsuarioLogueado(null);
								break;

							default:
								System.out.println("Opci�n no v�lida.");
								break;
							}

						}

						break;

					default:

						System.out.println("Opcion incorrecta");
						break;
					}

				}

			}
		}

	}
}
