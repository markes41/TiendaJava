package usuariosArticulos;

import java.io.Serializable;
import java.util.ArrayList;
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
			if (nuevaCantidad < 0) {
				do {
					System.out.println("Por favor ingrese una cantidad que no sea negativa: ");
					nuevaCantidad = sc.nextInt();
				} while (nuevaCantidad < 0);
			}

			System.out.println("Ingrese el nuevo precio: ");
			double nuevoPrecio = sc.nextDouble();
			if (nuevoPrecio < 0) {
				do {
					System.out.println("Ingrese un precio que no sea negativo: ");
					nuevoPrecio = sc.nextDouble();
				} while (nuevoPrecio < 0);
			}

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
		int codigo = 0, nuevaCant = 0, cantComprar = 0, i = 0;
		double valorCarrito = 0;
		ArrayList<Double> carrito = new ArrayList<Double>();
		ArrayList<Integer> productos = new ArrayList<Integer>();
		ArrayList<Integer> cantidad = new ArrayList<Integer>();
		
		do {
			System.out.println("Escriba el código del artículo que desea comprar (escriba 0 para terminar de comprar):  ");
			codigo = sc.nextInt();
			if(existeArticulo(codigo)){
				cantComprar = 0;
				
				do{
					if(diccionarioArticulos.get(codigo).getCantidad() == 0)
						break;
					
					System.out.println("Seleccione la cantidad que desea comprar que no sea mayor a "+diccionarioArticulos.get(codigo).getCantidad()+": ");
					cantComprar = sc.nextInt();

				}while(cantComprar > diccionarioArticulos.get(codigo).getCantidad() || cantComprar < 1);
				//SETEAMOS NUEVA CANTIDAD
				nuevaCant = diccionarioArticulos.get(codigo).getCantidad() - cantComprar;
				//SE LA ASIGNAMOS A LA KEY QUE ELEJIMOS
				diccionarioArticulos.get(codigo).setCantidad(nuevaCant);
				//CALCULAMOS EL TOTAL
				valorCarrito = cantComprar * diccionarioArticulos.get(codigo).getPrecio();
				//SE LO AGREGAMOS AL ARRAYLIST
				carrito.add(valorCarrito);
				//AGREGAMOS EL CÓDIGO PARA TENER LA REFERENCIA
				productos.add(codigo);
				//AGREGAMOS LA CANTIDAD PARA TENER LA REFERENCIA
				cantidad.add(cantComprar);
				
				
			}else {
				System.out.println("El código escrito no corresponde a un artículo existente.");
			}
			
			if(codigo == 0) {
				comprarCarrito(carrito, productos, cantidad);
			}
			
		}while(codigo != 0);
		return true;
		
		
	}
	
	public void comprarCarrito(ArrayList<Double> valores, ArrayList<Integer> codigos, ArrayList<Integer> cantidad) {
		System.out.println("Carrito de compras: ");
		System.out.println("---------------------------------------");
		double total = 0;
		for(int i = 0; i < valores.size(); i++) {
			if(valores.get(i) <= 0) {
				
			}else {
				System.out.println((i+1)+". "+getArticulo(codigos.get(i)).getNombre()+" ("+cantidad.get(i)+") = $"+
						valores.get(i));
			}
			total += valores.get(i);
		}
		System.out.println("Total de la compra: $"+total);
	}

	public void editarCantidadArticulo() {
		Scanner sc = new Scanner(System.in);
		int cantidadElegida = 0, codigoArticulo = 0;
		mostrarArticulos();
		
		do {
			System.out.println("Seleccione el código del artículo que quiere editar (Escriba 0 para terminar): ");
			codigoArticulo = sc.nextInt();
			
			if(existeArticulo(codigoArticulo)) {
				System.out.println("Introduzca la nueva cantidad del artículo #"+codigoArticulo+": ");
				cantidadElegida = sc.nextInt();
				if (cantidadElegida < 0) {
					do {
						System.out.println("Por favor ingrese una cantidad que no sea negativa: ");
						cantidadElegida = sc.nextInt();
					} while (cantidadElegida < 0);
				}
				
				int cantidadNueva = diccionarioArticulos.get(codigoArticulo).getCantidad() + cantidadElegida;
				diccionarioArticulos.get(codigoArticulo).setCantidad(cantidadNueva);
				
			}else {
				System.out.println("El código "+codigoArticulo+" no corresponde a un artículo existente. Vuelva a intentarlo.");
			}
		}while(codigoArticulo != 0);
		
		
	}
}
