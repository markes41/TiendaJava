package usuariosArticulos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import menues.*;
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
		String codeArticle, nuevaCantidad, nuevoPrecio;
		
		mostrarArticulos();
		
		do {
			System.out.println("Seleccione el artículo que quiere editar, escribiendo su codigo: ");
			codeArticle = sc.next();
		}while ((MenuOp.isNumeric(codeArticle) == false) || Integer.parseInt(codeArticle) < 0
					|| existeArticulo(Integer.parseInt(codeArticle)) == false);
		

			System.out.println("Ingrese el nuevo nombre: ");
			String nuevoNombre = sc.next();

			do {
				System.out.println("Ingrese una nueva cantidad: ");
				nuevaCantidad = sc.next();
			}while ((MenuOp.isNumeric(nuevaCantidad) == false) || Integer.parseInt(nuevaCantidad) < 0);
			

			do {
				System.out.println("Ingrese el nuevo precio: ");
				nuevoPrecio = sc.next();
			}while((MenuOp.isNumeric(nuevoPrecio) == false) || Double.parseDouble(nuevoPrecio) < 0);
			
			
			
			Articulo changeArticle = new Articulo(Integer.parseInt(codeArticle), nuevoNombre, Double.parseDouble(nuevoPrecio), Integer.parseInt(nuevaCantidad));
			diccionarioArticulos.replace(Integer.parseInt(codeArticle), changeArticle);

			
		return true;
	}

	public boolean comprarArticulo() {
		Scanner sc = new Scanner(System.in);
		mostrarArticulos();
		String codigo, cantComprar = null;
		int nuevaCant = 0, i = 0;
		double valorCarrito = 0;
		ArrayList<Double> carrito = new ArrayList<Double>();
		ArrayList<Integer> productos = new ArrayList<Integer>();
		ArrayList<Integer> cantidad = new ArrayList<Integer>();

		do {
			System.out.println("Escriba el código del artículo que desea comprar (escriba 0 para terminar de comprar):  ");
			codigo = sc.next();
			if (existeArticulo(Integer.parseInt(codigo))) {
				do {
					if (diccionarioArticulos.get(Integer.parseInt(codigo)).getCantidad() == 0)
						break;

					System.out.println("Seleccione la cantidad que desea comprar que no sea mayor a "
							+ diccionarioArticulos.get(Integer.parseInt(codigo)).getCantidad() + ": ");
					cantComprar = sc.next();

				}while (Integer.parseInt(cantComprar) > diccionarioArticulos.get(Integer.parseInt(codigo)).getCantidad() || Integer.parseInt(cantComprar) < 1
						|| (MenuOp.isNumeric(cantComprar) == false));
				
				nuevaCant = diccionarioArticulos.get(Integer.parseInt(codigo)).getCantidad() - Integer.parseInt(cantComprar);
				diccionarioArticulos.get(Integer.parseInt(codigo)).setCantidad(nuevaCant);
				valorCarrito = Integer.parseInt(cantComprar) * diccionarioArticulos.get(Integer.parseInt(codigo)).getPrecio();
				carrito.add(valorCarrito);
				productos.add(Integer.parseInt(codigo));
				cantidad.add(Integer.parseInt(cantComprar));

			} else {
				System.out.println("El código escrito no corresponde a un artículo existente.");
			}

			if (Integer.parseInt(codigo) == 0) {
				comprarCarrito(carrito, productos, cantidad);
			}

		} while (Integer.parseInt(codigo) != 0);
		return true;

	}

	public void comprarCarrito(ArrayList<Double> valores, ArrayList<Integer> codigos, ArrayList<Integer> cantidad) {
		System.out.println("Carrito de compras: ");
		System.out.println("---------------------------------------");
		double total = 0;
		for (int i = 0; i < valores.size(); i++) {
			if (valores.get(i) <= 0) {

			} else {
				System.out.println((i + 1) + ". " + getArticulo(codigos.get(i)).getNombre() + " (" + cantidad.get(i)
						+ ") = $" + valores.get(i));
			}
			total += valores.get(i);
		}
		System.out.println("Total de la compra: $" + total);
	}

	public void editarCantidadArticulo() {
        Scanner sc = new Scanner(System.in);
        String  codigoArticulo ;
        String cantidadElegida;
        mostrarArticulos();

        do {
            System.out.println("Seleccione el código del artículo que quiere editar (Escriba 0 para terminar): ");
            codigoArticulo = sc.next();

        } while ((MenuOp.isNumeric(codigoArticulo) == false) ||  Integer.parseInt(codigoArticulo) < 0 || existeArticulo(Integer.parseInt(codigoArticulo)) == false);




        do {
             System.out.println("Introduzca la nueva cantidad del artículo #" + codigoArticulo + ": ");
             cantidadElegida = sc.next();

              if (MenuOp.isNumeric(cantidadElegida) == true && Integer.parseInt(cantidadElegida) > 0 ){
              int cantidadNueva = diccionarioArticulos.get(Integer.parseInt(codigoArticulo)).getCantidad() + Integer.parseInt(cantidadElegida);
              diccionarioArticulos.get(Integer.parseInt(codigoArticulo)).setCantidad(cantidadNueva);
              }


        } while ((MenuOp.isNumeric(cantidadElegida) == false) || Integer.parseInt(cantidadElegida) < 0);

    }

	public void eliminarArticulo() {
		Scanner sc = new Scanner(System.in);
		mostrarArticulos();
		String codigoArticulo;

		do {
			do {
				System.out.println("Seleccione el código del artículo que desea borrar (Escriba 0 para salir): ");
				codigoArticulo = sc.next();
				
				if(codigoArticulo.equals("0")) {
					break;
				}
			}while ((MenuOp.isNumeric(codigoArticulo) == false) ||  Integer.parseInt(codigoArticulo) < 0 || existeArticulo(Integer.parseInt(codigoArticulo)) == false);
				
			diccionarioArticulos.remove(Integer.parseInt(codigoArticulo));
			if(codigoArticulo.equals("0")) {
				System.out.println("Finalizo el borrado de articulos.");
			}else
			System.out.println("El artículo con el #"+codigoArticulo+" se borró correctamente.");
				
		} while ((Integer.parseInt(codigoArticulo) != 0));
	
		
	}
}
