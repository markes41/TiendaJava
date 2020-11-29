package programa;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Scanner;

import javax.swing.table.DefaultTableModel;

public class AddArticulos implements Serializable {

	private static final long serialVersionUID = -2737834430344017259L;
	private HashMap<Integer, Articulo> diccionarioArticulos = new HashMap<Integer, Articulo>();
	Articulo res;

	public boolean addArticulos(int codigo, String nombre, double precio, int cantidad) {

		if (existeArticulo(codigo)) {
			return false;
		}

		Articulo art = new Articulo(codigo, nombre, precio, cantidad);

		this.diccionarioArticulos.put(codigo, art);

		return true;
	}

	public boolean existeArticulo(int codigo) {
		return this.diccionarioArticulos.containsKey(codigo);
	}

	public Articulo getArticulo(int codigo) {
		return this.diccionarioArticulos.get(codigo);
	}

	public void mostrarArticulos() {

		for (int clave : this.diccionarioArticulos.keySet()) {
			System.out.println("Clave del artículo: " + clave + "\n" + this.getArticulo(clave) + "\n");
		}

	}

	public boolean modificarArticulo() {
		Scanner sc = new Scanner(System.in);
		mostrarArticulos();
		System.out.println("Seleccione el artículo que quiere editar, escribiendo su codigo: ");
		int codeArticle = sc.nextInt();
		if (existeArticulo(codeArticle)) {

			System.out.println("Ingrese el nuevo nombre: ");
			String nuevoNombre = sc.next();

			System.out.println("Ingresa la nueva cantidad: ");
			int nuevaCantidad = sc.nextInt();

			System.out.println("Ingrese el nuevo precio: ");
			double nuevoPrecio = sc.nextDouble();

			Articulo changeArticle = new Articulo(codeArticle, nuevoNombre, nuevoPrecio, nuevaCantidad);
			diccionarioArticulos.replace(codeArticle, changeArticle);

			return true;
		} else {
			return false;
		}

	}

	public boolean comprarArticulo() {
		Scanner sc = new Scanner(System.in);
		mostrarArticulos();

		System.out.println("Escriba el código del artículo que desea comprar: ");
		int codigo = sc.nextInt();

		if (existeArticulo(codigo)) {
			int cantComprar;
			do {
				System.out.println(
						"Seleccione la cantidad que desea comprar (que no supere la cantidad que existe del articulo): ");
				cantComprar = sc.nextInt();
				if (diccionarioArticulos.get(codigo).getCantidad() == 0) {
					System.out.println("La cantidad del articulo es 0 necesita agregar stock");
					return false;
				}
			} while (cantComprar > diccionarioArticulos.get(codigo).getCantidad());
			if (cantComprar <= 0) {
				System.out.println("Por favor ingrese un valor mayor a 0");

			} else {
				double precioArticulo = diccionarioArticulos.get(codigo).getPrecio();
				double total = cantComprar * precioArticulo;
				System.out.println("Realizaste una compra por: $" + total);
				diccionarioArticulos.get(codigo)
						.setCantidad(diccionarioArticulos.get(codigo).getCantidad() - cantComprar);

				return true;
			}
		}
		System.out.println("No se pudo realizar la compra correctamente.");
		return false;
	}

}
