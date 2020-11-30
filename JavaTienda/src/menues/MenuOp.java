package menues;

import java.util.Scanner;

import leerEscribir.Archivo;
import usuariosArticulos.AddArticulos;
import usuariosArticulos.Usuario;
import usuariosArticulos.AddUsuarios;
import leerEscribir.Archivo;

public class MenuOp {

	private static boolean isNumeric(String cadena) {
		try {
			Integer.parseInt(cadena);
			return true;
		} catch (NumberFormatException nfe) {
			return false;
		}
	}

	public void cargarUsuario(AddUsuarios usuarios, String rutaUsuarios) {
		Archivo archi = new Archivo();
		Scanner sc = new Scanner(System.in);

		System.out.println("\nIngrese el nombre del usuario a ingresar (0 para salir)");
		String username = sc.next();

		if (username.equals("0")) {
			return;
		}

		System.out.println("Ingrese la contraseña del usuario a ingresar");
		String password = sc.next();

		System.out.println("Ingrese el nick del usuario a ingresar");
		String nick = sc.next();

		if (usuarios.addUsuario(username, password, nick)) {
			System.out.println("\nEl usuario se creó perfectamente");
			archi.save(usuarios, rutaUsuarios);
		} else {
			System.err.println("\nYa existe un usuario con ese nombre");
		}
	}

	public void cargarArticulo(AddArticulos articulo, String rutaArticulos) {
		Archivo archi = new Archivo();
		Scanner sc = new Scanner(System.in);

		String codigo;

		do {

			System.out.println("Ingrese el código del articulo (solo se admiten numeros - Apretá 0 para terminar): ");
			codigo = sc.next();

		} while ((isNumeric(codigo) == false));

		if (codigo.equals("0")) {
			return;
		}

		System.out.println("Ingrese el nombre del artículo  ");
		String nombre = sc.next();

		System.out.println("Ingrese el precio del artículo: ");
		double precio = sc.nextDouble();

		if (precio < 0) {
			do {
				System.err.println("El precio no puede ser menor a 0: ");
				precio = sc.nextDouble();
			} while (precio < 0);
		}

		System.out.println("Ingrese la cantidad del artículo: ");
		int cantidad = sc.nextInt();

		if (cantidad < 0) {
			do {
				System.err.println("La cantidad no puede ser menor a 0: ");
				cantidad = sc.nextInt();
			} while (cantidad < 0);
		}

		if (articulo.addArticulos(Integer.parseInt(codigo), nombre, precio, cantidad)) {
			System.out.println("\nEl artículo con el nombre " + nombre + " se creó correctamente");
			archi.save(articulo, rutaArticulos);
		} else {
			System.out.println("\nEl artículo con el nombre " + nombre + " ya existe. Intente con otro.");
		}
	}

	public Usuario ingresar(AddUsuarios usuarios) {
		Scanner sc = new Scanner(System.in);

		String username;
		do {
			System.out.println("\nIngrese el nombre de usuario (ingresar 0 para cancelar)");
			username = sc.next();

			if (username.equals("0")) {
				return null;

			}
			if (!usuarios.existeUsuario(username)) {
				System.err.println("No existe el usuario\n");

			}

		} while (!usuarios.existeUsuario(username));

		Usuario usu = usuarios.getUsuario(username);

		int cantintentos = 3;

		do {

			System.out.println("Ingrese la clave de usuario. Te quedan " + cantintentos + " intentos.");
			String password = sc.next();

			if (usu.isClave(password)) {
				return usu;
			}

			cantintentos--;

		} while (cantintentos > 0);

		System.err.println("Has superado el limite de intentos.\n");
		return null;

	}

}
