package programa;

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
		int codigo = 0, cantComprar = 0, nuevaCant = 0;
		ArrayList<Double> carrito = new ArrayList<Double>();
		ArrayList<Integer> productos = new ArrayList<Integer>();
		//ArrayList<Integer> cantidad = new ArrayList<Integer>();
		
		do {
			System.out.println("Escriba el código del artículo que desea comprar (escriba 0 para terminar):  ");
			codigo = sc.nextInt();
			if(existeArticulo(codigo)){
				
				do{
					System.out.println("Seleccione la cantidad que desea comprar que no sea mayor a "+diccionarioArticulos.get(codigo).getCantidad()+": ");
					cantComprar = sc.nextInt();
				}while(cantComprar > diccionarioArticulos.get(codigo).getCantidad());
				
				nuevaCant = diccionarioArticulos.get(codigo).getCantidad() - cantComprar;
				diccionarioArticulos.get(codigo).setCantidad(nuevaCant);
				double valorCarrito = cantComprar * diccionarioArticulos.get(codigo).getPrecio();
				carrito.add(valorCarrito);
				productos.add(codigo);
				//cantidad.add(cantComprar);
				
			}else {
				System.out.println("El código escrito no corresponde a un artículo existente.");
			}
			
			if(codigo == 0) {
				comprarCarrito(carrito, productos);
			}
				
				
			
		}while(codigo != 0);
		return true;
		
		
	}
	
	public void comprarCarrito(ArrayList<Double> valores, ArrayList<Integer> codigos) {
		
		for(int i = 0; i < valores.size(); i++) {
			//int cantidadNueva = 0;
			System.out.println("Compraste "+getArticulo(codigos.get(i)).getNombre()+
					" por un valor de = $"+valores.get(i));
			/*cantidadNueva = diccionarioArticulos.get(codigos.get(i)).getCantidad() - cantidad.get(i); 
			diccionarioArticulos.get(codigos.get(i)).setCantidad(cantidadNueva);*/
		}
	}

}
